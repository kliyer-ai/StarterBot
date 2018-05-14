/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starterbot;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nick
 */
public class Parser {
    
    private GameHandler handler;
    private Scanner input;

    public Parser(GameHandler handler) {
        this.handler = handler;
        input = new Scanner(System.in);
    }
    
    public void run(){
        boolean done = false;        
        String[] commands;
        
        while(!done){            
            commands = input.nextLine().split(" "); 
            
            switch(commands[0]){
                case "REQUEST":
                    parseRequest(commands);
                    break;
                case "RESULT":
                    parseResult(commands);
                    break;
                case "UPDATE":
                    parseUpdate(commands);
                    break;
                case "GAME":
                    parseGame(commands);
                    done = true;
                    break;
                default:
                    System.out.println("Unknown command");
                    done = true;
            }
        }
    }
    
    private void parseRequest(String[] commands){
        if(commands[1].equals("ACTION"))
            handler.performAction(commands[2]);
        else
            System.out.println("Undefined Request");
    }
    
    private void parseResult(String[] commands){
        if(commands.length==2)
            handler.handleActionResult(commands[1]);
        else if(commands.length==4 && commands[2].equals("YOUSUNKMY"))
            handler.handleActionResult(commands[1], commands[3]);
        else
            System.out.println("Undefined Result");
    }
    
    private void parseUpdate(String[] commands){
        if(commands.length==4)
            handler.handleUpdate(commands[1], commands[2] + commands[3]);
        else
            handler.handleUpdate(commands[1], commands[2]);
    }
    
    private void parseGame(String[] commands){
        if(commands[1].equals("RESULT")){
            if(commands.length==4)
                handler.handleGameResult(commands[3]);
            if(commands.length > 4)
                handler.handleGameResult(commands[3], Arrays.copyOfRange(commands, 4, commands.length));
        }
        else
            System.out.println("Undefined Game");
    }
}
