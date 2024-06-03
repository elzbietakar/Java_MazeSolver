/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.LinkedList;

/**
 *
 * @author karas
 */
public class PathData {
    public PathData () {
        this.pathList = new LinkedList<>();
    }
    
    public int size() {
        return pathList.size(); 
    }
    
    public void clear() {
        pathList.clear();
    }
    
    public MazeElement get (int idx) {
        return pathList.get(idx);
    }
   
    public void add(MazeElement mazeElement) {
        pathList.add(mazeElement);
    } 
    
    public MazeElement getLast() {
        return pathList.getLast();
    }

    void removeLast() {
        pathList.removeLast();
    }
    
    private LinkedList<MazeElement> pathList;   
}
