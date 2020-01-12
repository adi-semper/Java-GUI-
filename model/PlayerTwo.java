package model;

public class PlayerTwo extends Player {

    private char symbol = 'X';

    public PlayerTwo() {
    
        super();
    
    }
   
    public char getSymbol() {
    
        return symbol;
    
    }
    
    public String getText() {
        
        return "  \'" + symbol + "\'";
    
    }
    
    public void changeSymbol() {
        
        if ( symbol == 'O' ) {
     	   symbol = 'X';
        } else {
     	   symbol = 'O';
        }
     
     }

}
