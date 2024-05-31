package mazesolver;

import java.io.FileInputStream;
import java.io.IOException;

public class BinaryMazeReader extends MazeReader {

    public BinaryMazeReader(String filePath) {
        super(filePath);
    }

    @Override
    public void read(MazeData mazeData) throws IOException {
        try (FileInputStream fis = new FileInputStream(super.filePath)) {
            // Read file header
            int fileId = readInt(fis);
            System.out.printf("Read File ID: %d (0x%08X)\n", fileId, fileId);
            if (fileId != 0x52524243) {
                throw new IOException("Invalid file ID");
            }

            int escape = fis.read();
            System.out.printf("Read File ID: %d (0x%08X)\n", escape, escape);
            if (escape != 0x1B) {
                throw new IOException("Invalid escape character");
            }
            
            int cols = readShort(fis);
             System.out.printf("Read File ID: %d (0x%08X)\n", cols, cols);
            int rows = readShort(fis);
            int entryX = readShort(fis) - 1;
            int entryY = readShort(fis) - 1;
            int exitX = readShort(fis) - 1;
            int exitY = readShort(fis) - 1;

            // Skip reserved 96 bits (12 bytes)
            fis.skip(12);

            int counter = readInt(fis);
            int solutionOffset = readInt(fis);

            int separator = fis.read();
            int wall = fis.read();
            int path = fis.read();

            mazeData.setRows(rows);
            mazeData.setCols(cols);
            mazeData.setElementsArray(new MazeElement[rows][cols]);

            // Read coding section
            int currentRow = 0;
            int currentCol = 0;
            for (int i = 0; i < counter; i++) {
                int wordSeparator = fis.read();
                if (wordSeparator != separator) {
                    throw new IOException("Invalid word separator");
                }
                int value = fis.read();
                int count = fis.read()+1;

                char symbol = (value == wall) ? 'X' : ' ';
                for (int j = 0; j < count; j++) {
                    mazeData.setArrayElement(currentRow, currentCol, new MazeElement(currentRow, currentCol, symbol));
                    currentCol++;
                    if (currentCol == cols) {
                        currentCol = 0;
                        currentRow++;
                    }
                }
            }

            // Set start and end elements
        MazeElement startElement = new MazeElement(entryX, entryY, 'P');
        MazeElement endElement = new MazeElement(exitX, exitY, 'K');
        mazeData.setStartElement(startElement);
        mazeData.setEndElement(endElement);
        mazeData.setArrayElement(entryX, entryY, startElement);
        mazeData.setArrayElement(exitX, exitY, endElement);
        }
    }

    private int readInt(FileInputStream fis) throws IOException {
        byte[] buffer = new byte[4];
        if (fis.read(buffer) != 4) {
            throw new IOException("Failed to read integer from binary file.");
        }
        return ((buffer[3] & 0xFF) << 24) | ((buffer[2] & 0xFF) << 16) | ((buffer[1] & 0xFF) << 8) | (buffer[0] & 0xFF);
    }

    private int readShort(FileInputStream fis) throws IOException {
        byte[] buffer = new byte[2];
        if (fis.read(buffer) != 2) {
            throw new IOException("Failed to read short from binary file.");
        }
        return ((buffer[1] & 0xFF) << 8) | (buffer[0] & 0xFF);
    }
}
