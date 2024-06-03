/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karas
 */
public class MazeDataObserverManager {
    private List<MazeDataObserver> observers;

    public MazeDataObserverManager() {
        observers = new ArrayList<>();
    }

    public void addObserver(MazeDataObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MazeDataObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(MazeData mazeData) {
        for (MazeDataObserver observer : observers) {
            observer.dataChanged(mazeData);
        }
    }
}

interface MazeDataObserver {
    void dataChanged(MazeData mazeData);
}