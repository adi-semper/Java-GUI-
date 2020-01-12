package model;

public class PlayerOne extends Player {

    private char symbol = 'O';

    public PlayerOne() {
    
        super();
    
    }

    public char getSymbol() {
    
        return symbol;
    
    }
    
    public String getText() {
    
        return " \'" + symbol + "\'";
    
    }
    
    public void changeSymbol() {
    
       if ( symbol == 'O' ) {
    	   symbol = 'X';
       } else {
    	   symbol = 'O';
       }
    
    }
    
}
