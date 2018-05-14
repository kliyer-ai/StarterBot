/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starterbot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nick
 */
public class GameState {
    
    private Board enemyBoard;
    private Board myBoard;
    private List<BattleShip> sunkShips;
    private List<BattleShip> shipsToPlace;

    public GameState() {
        enemyBoard = new Board();
        myBoard = new Board();
        sunkShips = new ArrayList<>();
        shipsToPlace = new ArrayList<>();
        
        for(BattleShip b : BattleShip.values()){
            for(int i = 0; i < b.getAmount(); i++)
                shipsToPlace.add(b);
        }
    }
    
    private GameState(Board myBoard, Board enemyBoard, BattleShip[] sunkShips, BattleShip[] shipsToPlace){
        this.myBoard = myBoard;
        this.enemyBoard = enemyBoard;
        this.sunkShips = Arrays.asList(sunkShips);
        this.shipsToPlace = Arrays.asList(shipsToPlace);
    }
    
    public void setEnemyTile(Coordinate c, Tile t){
        this.enemyBoard.setTile(c, t);
    }
    
    public void setOwnTile(Coordinate c, Tile t){
        this.myBoard.setTile(c, t);
    }
    
    public void sunkShip(BattleShip b){
        sunkShips.add(b);
    }

    public Board getEnemyBoard() {
        return enemyBoard.copy(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Board getMyBoard() {
        return myBoard.copy(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void placeShip(Coordinate start, Coordinate end){
        int dx = Math.abs(start.getX() - end.getX());
        int dy = Math.abs(start.getY() - end.getY());
        
        if(!(dx == 0 || dy == 0))
            return;
        
        int length = dx + dy + 1;        
        BattleShip b = BattleShip.fromInt(length);        
        if(!shipsToPlace.remove(b))
            return;
        
        for(int x = start.getX(); x <= end.getX(); x++)
            for(int y = start.getY(); y <= end.getY(); y++){
                if(myBoard.getTile(new Coordinate(x, y)) == Tile.ISLAND || myBoard.getTile(new Coordinate(x, y)) == Tile.SHIP){
                    System.out.println("Error: Tile is not empty!");
                    break;
                }
                myBoard.setTile(new Coordinate(x, y), Tile.SHIP);
            }
    }
      
       
    public BattleShip[] getShipsToPlace(){
        return shipsToPlace.toArray(new BattleShip[shipsToPlace.size()]);
    }
    
    public BattleShip[] getSunkShips(){
        return sunkShips.toArray(new BattleShip[sunkShips.size()]);
    }
    
    public GameState copy(){
        return new GameState(getMyBoard(), getEnemyBoard(), getSunkShips(), getShipsToPlace());
    }
    
}
