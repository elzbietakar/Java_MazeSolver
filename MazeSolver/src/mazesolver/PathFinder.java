/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.LinkedList;

public class PathFinder {
    
    public void findPath(MazeData mazeData, LinkedList<MazeElement> pathList) {
        MazeElement nextElement, currentElement;
        //System.out.println(1);
        pathList.add(mazeData.getStartElement());
        mazeData.getStartElement().visit();
        //System.out.println(2);
        
        while (!pathList.getLast().equals(mazeData.getEndElement())) { 
            currentElement = pathList.getLast();
            //System.out.println(3.1);
            int row = currentElement.getRow();
            int col = currentElement.getCol();
            //System.out.println(3.2);
           

            boolean validNextElementFound = false;
            for (Direction direction : Direction.values()) {
                nextElement = getNextElement(mazeData, row, col, direction);
                
                if (isValid(nextElement)) {
                    nextElement.visit();
                    pathList.add(nextElement);
                    System.out.println("ADD: (" + nextElement.getRow() + ", " + nextElement.getCol() + ")");
                    validNextElementFound = true;
                    
                    break;
                }
            }
            //System.out.println(3.3);
            if (validNextElementFound == false) {
                System.out.println("REMOVE: (" + currentElement.getRow() + ", " + currentElement.getCol() + ")");
                pathList.removeLast();
            }
            //System.out.println(3.4);
            for (MazeElement p : pathList) {
            System.out.print("(" + p.getRow() + ", " + p.getCol() + ") -> ");
        }
        System.out.println();
            
        }
        //System.out.println(4);
        for (MazeElement p : pathList) {
                if (p.getMazeElementType() == MazeElementType.PATH)
                    mazeData.getArrayElement(p.getRow(), p.getCol()).setMazeCellType(MazeElementType.FOUND_PATH);
            }
    }
    
    public boolean isValid(MazeElement mazeElement) {
        return mazeElement != null && mazeElement.getMazeElementType() != MazeElementType.WALL && !mazeElement.isVisited();
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


