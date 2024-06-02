/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author karas
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class MazeSaver {

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void saveToFile(LinkedList<MazeElement> pathList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("savedPath.txt"))) {
            writer.write("START\n");
            if (pathList.size() > 1) {
                Direction currentDirection = determineDirection(pathList.get(0), pathList.get(1));
                //System.out.println(currentDirection);
                int steps = 1;

                for (int i = 1; i < pathList.size() - 1; i++) {
                    Direction nextDirection = determineDirection(pathList.get(i), pathList.get(i + 1));
                    System.out.println(nextDirection);
                    if (nextDirection == currentDirection) {
                        steps++;
                    } else {
                        writer.write("FORWARD " + steps + "\n");
                        writer.write(determineTurn(currentDirection, nextDirection) + "\n");
                        currentDirection = nextDirection;
                        steps = 1;
                    }
                }
                writer.write("FORWARD " + steps + "\n");
            }
            writer.write("STOP\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Direction determineDirection(MazeElement from, MazeElement to) {
        //System.out.println("from:(" + from.getRow() + ", " + from.getCol() + " to:(" + to.getRow() + ", " + to.getCol());
        if (from.getRow() - 1 == to.getRow()) {
            return Direction.UP;
        } else if (from.getRow() + 1 == to.getRow()) {
            return Direction.DOWN;
        } else if (from.getCol() - 1 == to.getCol()) {
            return Direction.LEFT;
        } else if (from.getCol() + 1 == to.getCol()) {
            return Direction.RIGHT;
        }
        throw new IllegalArgumentException("Invalid path: non-adjacent elements");
    }

    private String determineTurn(Direction current, Direction next) {
        switch (current) {
            case UP:
                return next == Direction.LEFT ? "TURNLEFT" : "TURNRIGHT";
            case DOWN:
                return next == Direction.RIGHT ? "TURNLEFT" : "TURNRIGHT";
            case LEFT:
                return next == Direction.DOWN ? "TURNLEFT" : "TURNRIGHT";
            case RIGHT:
                return next == Direction.UP ? "TURNLEFT" : "TURNRIGHT";
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}
