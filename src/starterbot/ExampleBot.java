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
public class ExampleBot implements Bot{
    
    private Coordinate nextIsland = new Coordinate(0,0);

    @Override
    public Coordinate placeIsland(GameState state) {
        Coordinate current = nextIsland;
        nextIsland = new Coordinate(nextIsland.getX() + 1, 0);
        return current;
    }

    @Override
    public Coordinate[] placeShip(GameState state) {
        BattleShip b = state.getShipsToPlace()[0];
        Coordinate[] coords = findShipCoordinates(state.getMyBoard(), b);
        return coords;
    }
    
    private Coordinate[] findShipCoordinates(Board myBoard, BattleShip b){
        for(int y = 0; y < myBoard.BOARD_SIZE; y++)
            for(int x = 0; x < myBoard.BOARD_SIZE; x++){
                if(myBoard.emptyRow(new Coordinate(x, y), b.getSize()))
                    return new Coordinate[]{new Coordinate(x, y), new Coordinate(x + b.getSize() - 1, y)};
            }
        return null;                
    }

    @Override
    public Coordinate placeShot(GameState state) {
        return new Coordinate(0, 0);
    }
    
}
