/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.io.IOException;

public class PathFinder {
    
    public void findPath(MazeData mazeData, PathData pathData) throws IOException {
        
        MazeElement nextElement, currentElement;
        pathData.add(mazeData.getStartElement());
        mazeData.getStartElement().setIsVisited(true);
        while (!pathData.getLast().equals(mazeData.getEndElement())) { 
            currentElement = pathData.getLast();
            int row = currentElement.getRow();
            int col = currentElement.getCol();
           
            boolean validNextElementFound = false;
            for (Direction direction : Direction.values()) {
                nextElement = getNextElement(mazeData, row, col, direction);
                
                if (isValid(nextElement)) {
                    nextElement.setIsVisited(true);
                    pathData.add(nextElement);
                    System.out.println("ADD: (" + nextElement.getRow() + ", " + nextElement.getCol() + ")");
                    validNextElementFound = true;
                    
                    break;
                }
            }
            if (validNextElementFound == false) {
                System.out.println("REMOVE: (" + currentElement.getRow() + ", " + currentElement.getCol() + ")");
                pathData.removeLast();
            }            
        }
        for (int i = 0; i < pathData.size(); i++) {
            MazeElement p = pathData.get(i);
            if (p.getMazeElementType() == MazeElementType.PATH)
                mazeData.getArrayElement(p.getRow(), p.getCol()).setMazeCellType(MazeElementType.FOUND_PATH);
        }
        
        mazeData.manager.notifyObservers(mazeData);
    }
    
    public boolean isValid(MazeElement mazeElement) {
        return mazeElement != null && mazeElement.getMazeElementType() != MazeElementType.WALL && !mazeElement.getIsVisited();
    }

    private MazeElement getNextElement(MazeData mazeData, int row, int col, Direction direction) {
       switch (direction) {
            case DOWN:
                return mazeData.getArrayElement(row + 1, col);
            case RIGHT:
                return mazeData.getArrayElement(row, col + 1);
            case UP:
                return mazeData.getArrayElement(row - 1, col);
            case LEFT:
                return mazeData.getArrayElement(row, col - 1);
            default:
                return null;
        }
    }

    private enum Direction {
        DOWN, RIGHT, UP, LEFT;
    }
}


