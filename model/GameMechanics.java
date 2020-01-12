package model;

import view.gui.TicTacToeFrame;

public class GameMechanics {

    private TicTacToeFrame frame; 
    private Board board;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    
    private static final int ONE = 0;
    
    public GameMechanics() {
    
        frame = new TicTacToeFrame();
        board = new Board();
        playerOne = new PlayerOne();
        playerTwo = new PlayerTwo();
    
    }
    
    public TicTacToeFrame getFrame() {
    
        return frame;
    
    }

    public Board getBoard() {
    
        return board;
    
    }
    
    public Player getPlayer( int which ) {
        
        return which == ONE ? playerOne : playerTwo;
    
    }
    
    public void clear() {
    
        board.clearBoard();
        playerOne.clear();
        playerTwo.clear();
    
    }
}
