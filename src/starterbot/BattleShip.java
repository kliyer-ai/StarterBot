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
public enum BattleShip {
    CARRIER(5, 1), BATTLESHIP(4, 2), CRUISER(3, 3), DESTROYER(2, 4);
    
    private int length;
    private int amount;
    
    private BattleShip(int size, int amount){
        this.length = size;
        this.amount = amount;
    }
    
    public int getSize(){
        return length;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public static BattleShip fromInt(int length){
        switch(length){
            case 5:
                return CARRIER;
            case 4:
                return BATTLESHIP;
            case 3:
                return CRUISER;
            case 2:
                return DESTROYER;
            default:
                System.out.println("Error: Wrong ship size");
                return null;
        }
    }
}
