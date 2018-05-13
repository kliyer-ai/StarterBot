/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starterbot;

import java.util.Arrays;

/**
 *
 * @author nick
 */
public class Board {
    
        
    public static final int BOARD_SIZE = 10;
    private Tile[][] board = new Tile[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        for(Tile[] row : board)
            Arrays.fill(row, Tile.EMPTY);    
    }
    
    private Board(Tile[][] board){
        Tile[][] copy = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int row = 0; row < BOARD_SIZE; row++)
            copy[row] = board[row].clone();
        this.board = copy;
    }
    
    private static int coordinateToRow(Coordinate c){
        return BOARD_SIZE - 1 - c.getY();
    }
    
    private static int coordinateToCol(Coordinate c){
        return c.getX();
    }
    
    public void setTile(Coordinate c, Tile t){
        board[coordinateToRow(c)][coordinateToCol(c)] = t;
    }
    
    public Tile getTile(Coordinate c){
        return board[coordinateToRow(c)][coordinateToCol(c)];
    }

    public Board copy() {
        return new Board(board);            
    }

    @Override
    public String toString() {
        String s = "";
        for(Tile[] row : board){
            for(Tile t : row)
                s += t + ", ";
            s += "\n";
        }
        return s;
    }
    
    public boolean emptyRow(Coordinate start, int length){
        for(int i = 0; i < length; i++)
            if(start.getX() + i >= BOARD_SIZE || start.getX() + i < 0 || board[coordinateToRow(start)][coordinateToCol(start) + i] != Tile.EMPTY)
                return false;
        return true;        
    }
    
    public boolean emptyCol(Coordinate start, int length){
        for(int i = 0; i < length; i++)
            if(start.getY() + i >= BOARD_SIZE || start.getY() + i < 0 || board[coordinateToRow(start) + i][coordinateToCol(start)] != Tile.EMPTY)
                return false;
        return true;        
    }
    
    
        
}
