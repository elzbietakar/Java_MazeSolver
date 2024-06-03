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
        this.isVisited = false;
        
        switch (type) {
            case 'X':
                this.type = MazeElementType.WALL;
                break;
            case ' ':
                this.type = MazeElementType.PATH;
                break;
            case 'P':
                this.type = MazeElementType.START;
                break;
            case 'K':
                this.type = MazeElementType.END;
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
    public MazeElementType getMazeElementType() {
        return type;
    }
  
    public void setMazeCellType(MazeElementType type) {
        this.type = type;
    }
    
     public void setIsVisited (boolean isVisited) {
        this.isVisited = isVisited;
    }
     
     public boolean getIsVisited () {
        return isVisited;
    }
    
    private int row;
    private int col;
    private MazeElementType type;
    private boolean isVisited;
}
