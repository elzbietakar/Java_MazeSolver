/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.LinkedList;

public class PathFinder {
    
    public void findPath(MazeData mazeData, LinkedList<MazeElement> pathList) {
        MazeElement nextElement, currentElement;
        pathList.add(mazeData.getStartElement());
        mazeData.getStartElement().setIsVisited(true);
        
        while (!pathList.getLast().equals(mazeData.getEndElement())) { 
            currentElement = pathList.getLast();
            int row = currentElement.getRow();
            int col = currentElement.getCol();
           
            boolean validNextElementFound = false;
            for (Direction direction : Direction.values()) {
                nextElement = getNextElement(mazeData, row, col, direction);
                
                if (isValid(nextElement)) {
                    nextElement.setIsVisited(true);
                    pathList.add(nextElement);
                    System.out.println("ADD: (" + nextElement.getRow() + ", " + nextElement.getCol() + ")");
                    validNextElementFound = true;
                    
                    break;
                }
            }
            if (validNextElementFound == false) {
                System.out.println("REMOVE: (" + currentElement.getRow() + ", " + currentElement.getCol() + ")");
                pathList.removeLast();
            }
            for (MazeElement p : pathList) {
            System.out.print("(" + p.getRow() + ", " + p.getCol() + ") -> ");
        }
        System.out.println();
            
        }
        for (MazeElement p : pathList) {
                if (p.getMazeElementType() == MazeElementType.PATH)
                    mazeData.getArrayElement(p.getRow(), p.getCol()).setMazeCellType(MazeElementType.FOUND_PATH);
            }
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


