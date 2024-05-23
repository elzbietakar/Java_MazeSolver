/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author karas
 */
public class MazeElement {
    
    public MazeElement(int row, int col, char type) {
        this.row = row;
        this.col = col;
        
        switch (type) {
            case 'X':
                this.type = MazeCellType.WALL;
                break;
            case ' ':
                this.type = MazeCellType.PATH;
                break;
            case 'P':
                this.type = MazeCellType.START;
                break;
            case 'K':
                this.type = MazeCellType.STOP;
                break;
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
    
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public MazeCellType getMazeCellType() {
        return type;
    }
  
    public void changeMazeCellType(MazeCellType type) {
        this.type = type;
    }
    
    private int row;
    private int col;
    private MazeCellType type;

}
