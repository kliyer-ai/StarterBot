/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starterbot;

/**
 *
 * @author nick
 */
public class Coordinate {
    
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public static Coordinate parseCoordinate(String coords){
        coords = coords.replace("(", "");
        coords = coords.replace(")", "");
        String[] xy = coords.split(",");
        return new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    
    
    
    
}
