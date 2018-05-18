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
public interface Bot {
    
    /**
     * This methods gets called when you bot is required to place an island on
     * the enemy board.
     * @param Gamestate the current game state
     * @return A coordinate that indicates the position of the island.
     */
    Coordinate placeIsland(GameState state);

    /**
     * This methods gets called when your bot is required to position on of your
     * ships on your board.
     * @param Gamestate the current game state
     * @return A coordinate pair indicating the beginning and the end of your
     * ship.
     */
    CoordinatePair placeShip(GameState state);

    /**
     * This methods gets called when your bot is required to shoot an enemy tile.
     * @param Gamestate the current game state
     * @return A coordinate that indicates the position of the shot.
     */
    Coordinate placeShot(GameState state);
    
    /**
     * This method can be implemented if you want to react on your ship getting
     * shot. However, you cannot really react to it. Hence, you will most likely
     * not have to implement this method
     * @param Coordinate 
     */
    default void gotShot(Coordinate c){
    
    };
    
}
