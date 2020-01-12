package model;

import utilities.Utilities;

public class Board {

    private char[][] board;
    private String wonHow;
    private int wonWhere;
    
    public Board() {
    
        board = new char[ 3 ][ 3 ];
        clearBoard();
    
    }
    
    public void addToBoard( int row, int col, char symbol ) {
    
        if ( Utilities.isBetween( row, 0, 3 ) &&
                Utilities.isBetween( col , 0, 3 ) ) {
        
            board[ row ][ col ] = symbol;
        }
    
    }
    
    public String getWonHow() {
    
        return wonHow;
    
    }
    
    public int getWonWhere() {
    
        return wonWhere;
    
    }
    
    public char get( int row, int col ) {
    
        char result = (char) 0;
    
        if ( row >= 0 && row < 3 &&
                col >=0 && col < 3 ) {
        
            result = board[ row ][ col ];
        }
        
        return result;
    
    }
    
    public boolean hasWon( char symbol ) {
    
    	boolean result = false;
    	String success = "" + symbol + symbol + symbol;
    	String horiLine = "";
        String vertLine = "";
        
        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                horiLine += board[ row ][ col ];
                vertLine += board[ col ][ row ];
            
            }
            
            if ( success.equals( horiLine ) ) {
            
                wonHow = "horizontal";
                wonWhere = row;
                result = true;
            
            } else if ( success.equals( vertLine ) ) {
            
                wonHow = "vertical";
                wonWhere = row;
                result = true;
            
            }
            
            horiLine = "";
            vertLine = "";
        }
        
        horiLine = "" + board[ 0 ][ 0 ] + board[ 1 ][ 1 ] + board[ 2 ][ 2 ];
        vertLine = "" + board[ 0 ][ 2 ] + board[ 1 ][ 1 ] + board[ 2 ][ 0 ];
        
        if ( success.equals( horiLine ) ) {
        
            wonHow = "negativeSlope";
            result = true;
        
        } else if ( success.equals( vertLine ) ) {
        
           wonHow = "positiveSlope";
           result = true;
        
        }
        
    
        return result;
    
    }
    
    public void clearBoard() {
    
        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                board[ row ][ col ] = Character.MIN_VALUE;
            
            }
        
        }
    
    }
    

}
