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
    
    Coordinate placeIsland(GameState state);

    Coordinate[] placeShip(GameState state);

    Coordinate placeShot(GameState state);
    
    void handleGotShot(Coordinate c);
    
}
