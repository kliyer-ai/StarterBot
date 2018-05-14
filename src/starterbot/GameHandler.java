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
public class GameHandler {
    
    private Coordinate lastShot;
    private GameState state;
    private Bot bot;
    
    
    public GameHandler(Bot bot){
        state = new GameState();
        this.bot = bot;
    }
    
    public void performAction(String actionType){
        switch(actionType){
            case "ISLAND":
                Coordinate island = bot.placeIsland(state.copy());
                sendIsland(island);
                break;
            case "SHIP":
                Coordinate[] ship = bot.placeShip(state.copy());
                sendShip(ship);
                break;
            case "SHOT":
                Coordinate shot = bot.placeShot(state.copy());
                sendShot(shot);
                break;
            default:
                System.out.println("Wrong action type");
        }
    }
    
    public void handleActionResult(String type){
        state.setEnemyTile(lastShot, Tile.valueOf(type));
    }
    public void handleActionResult(String type, String shipType){
        handleActionResult(type);
        state.sunkShip(BattleShip.valueOf(shipType));
    }
    
    public void handleUpdate(String type, String coords){
        Coordinate c = Coordinate.parseCoordinate(coords);
        
        if(type.equals("GOTISLAND"))
            state.setOwnTile(c, Tile.ISLAND);
        else if(type.equals("GOTSHOT"))
            bot.gotShot(c);
        else
            System.out.println("Wrong Operation");
    }
    
    public void handleGameResult(String type){
        if(type.equals("WON"))
            System.out.println("Congratulations, you won!");
        else if(type.equals("LOST"))
            System.out.println("You lost!");
    }
    public void handleGameResult(String type, String[] reason){
        System.out.println("You were probably disqualified and lost");
        System.out.println("Reason:");
        for(String word : reason)
            System.out.print(word + " ");
    }
       
    protected void sendIsland(Coordinate c){
        state.setEnemyTile(c, Tile.ISLAND);
        System.out.println("PLACE ISLAND " + c);
    }
    
    protected void sendShip(Coordinate[] ship){
        if(ship.length != 2){
            System.out.println("Error: Ship must have exactly two coordinates");
            return;
        }
        Coordinate start = ship[0];
        Coordinate end = ship[1];
        state.placeShip(start, end);
        System.out.println("PLACE SHIP " + start + " " + end);
    }
    
    protected void sendShot(Coordinate c){
        lastShot = c;
        System.out.println("SHOOT " + c);
    }
       
}
