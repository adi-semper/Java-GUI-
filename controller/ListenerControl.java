package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import model.GameMechanics;
import model.PlayerOne;
import model.PlayerTwo;
import view.gui.TicTacToeFrame;

public class ListenerControl {

    private GameMechanics game;
    private TicTacToeFrame frame;
    private JButton[][] board;
    private JButton startButton;
    private JButton restartButton;
    private JButton switchButton;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    private int whichTurn;
    private int turns;
    
    private MyListener listen;
    
    private static final int ONE = 0;
    private static final int TWO = 1;
    
    public ListenerControl() {
    
        createComponents();
        makeFrameLookPretty();
        setListeners();
        disableButtons();
        
        frame.setVisible( true );
    
    }

    public void startPressed() {
    
        startButton.setEnabled( false );
        enableButtons();
        switchButton.setEnabled( false );
        frame.resetButtons();
        game.getBoard().clearBoard();
        
        setupTurn();
        
        makeFrameLookPretty();
    
    }
    
    public void switchPressed() {
    
        playerOne.changeSymbol();
        playerTwo.changeSymbol();
        
        frame.getPlayerOneSymbol().setText( playerOne.getText() );
        frame.getPlayerTwoSymbol().setText( playerTwo.getText() );
    
    }
    
    public void restartPressed() {
    
        game.clear();
        frame.reset();
        disableButtons();
        startButton.setEnabled( true );
        switchButton.setEnabled( true );
        whichTurn = ONE;
        turns = 0;
        makeFrameLookPretty();
    
    }
    
    private void enableButtons() {
    
    	for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                board[ row ][ col ].setEnabled( true );
            }
    	}
    
    }
    
    public void boardPressed( JButton btn ) {
    
        char symbol;
    
        if ( whichTurn == ONE ) {
        
            symbol = playerOne.getSymbol();
            btn.setText( symbol + "" );
        
        } else {
        
        	symbol = playerTwo.getSymbol();
            btn.setText( symbol + "" );
        
        }
        
        btn.setFont( new Font( "Arial", Font.BOLD, 40 ) );
        
        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                
                if ( board[ row ][ col ].equals( btn ) ) {
                
                    game.getBoard().addToBoard( row, col, symbol );
                    btn.setEnabled( false );
                
                }
            
            }
        
        }
        
        nextTurn();
        
    }
    
    private void setupTurn() {
    
        turns++;
    
         if ( turns % 2 == 0 ){
        
            whichTurn = TWO;
            frame.getWhichTurn().setText( "Turn: " + playerTwo.getSymbol() );
        	
        } else {
            whichTurn = ONE;
            frame.getWhichTurn().setText( "Turn: " + playerOne.getSymbol() );
        }
    
    }
    
    private void nextTurn() {
    
        if ( game.getBoard().hasWon( playerOne.getSymbol() ) ) {
        
        	frame.getWhichTurn().setText( "Player 1 has Won!" );
            playerOne.won();
            frame.getPlayerOneScore().setText( "Score: " + playerOne.getScore() );
        	disableButtons();
        	allowButtons();
        	wonWhere();
        
        } else if ( game.getBoard().hasWon( playerTwo.getSymbol() ) ) {
        
        	frame.getWhichTurn().setText( "Player 2 has Won!" );
        	playerTwo.won();
        	frame.getPlayerTwoScore().setText( "Score: " + playerTwo.getScore() );
        	disableButtons();
        	allowButtons();
        	wonWhere();
        
        } else if ( boardNotFilled() ) {
    
            if ( whichTurn == ONE ) {
        
                whichTurn = TWO;
            	frame.getWhichTurn().setText( "Turn: " + playerTwo.getSymbol() );
        
            } else {
        
                whichTurn = ONE;
                frame.getWhichTurn().setText( "Turn: " + playerOne.getSymbol() );
            
            }
        
        } else {
        	
            frame.getWhichTurn().setText( "Tied!" );
            allowButtons();
        
        }
        
    
    }
    
    private boolean boardNotFilled() {
    
        int target = 0;
        
        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
            
                if ( !board[ row ][ col ].getText().equals( " " ) ) {
                
                    target++;
                
                }
            
            }
        
        }
        
        return target != 9;
    
    }
    
    private void disableButtons() {

    	for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                board[ row ][ col ].setEnabled( false );
            }
    	}
    
	}
    
    private void allowButtons() {
    
        startButton.setEnabled( true );
    
    }

	private void createComponents() {
    
        game = new GameMechanics();
        playerOne = (PlayerOne) game.getPlayer( ONE );
        playerTwo = (PlayerTwo) game.getPlayer( TWO );
        frame = game.getFrame();
        board = frame.getBoardButtons();
        startButton = frame.getStartButton();
        restartButton = frame.getRestartButton();
        switchButton = frame.getSwitchButton();
        whichTurn = ONE;
        turns = 0;
        
        listen = new MyListener( this );
    
	}

	private void setListeners() {

        startButton.addActionListener( listen );
        restartButton.addActionListener( listen );
        switchButton.addActionListener( listen );

        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                board[ row ][ col].addActionListener( listen );
            
            }
        
        }
    }

	private void makeFrameLookPretty() {
	
	    JButton[][] buttons = frame.getBoardButtons();
	
	    for ( int row = 0; row < 3; row++ ) {
	        for ( int col = 0; col < 3; col++ ) {
	        
	            buttons[ row ][ col ].setBackground( Color.WHITE );
	        }
	    }
	    
	    setButtonBorders( buttons );
	    
	}

    private void setButtonBorders( JButton[][] board ) {

        Color black = Color.BLACK;
        
        board[0][0].setBorder( BorderFactory.createMatteBorder( 0, 0, 4, 4, black ) );
        
        board[0][1].setBorder( BorderFactory.createMatteBorder( 0, 4, 4, 4, black ) );
        
        board[0][2].setBorder( BorderFactory.createMatteBorder( 0, 4, 4, 0, black ) );
        
        board[1][0].setBorder( BorderFactory.createMatteBorder( 4, 0, 4, 4, black ) );
        
        board[1][1].setBorder( BorderFactory.createMatteBorder( 4, 4, 4, 4, black ) );
        
        board[1][2].setBorder( BorderFactory.createMatteBorder( 4, 4, 4, 0, black ) );

        board[2][0].setBorder( BorderFactory.createMatteBorder( 4, 0, 0, 4, black ) );
        
        board[2][1].setBorder( BorderFactory.createMatteBorder( 4, 4, 0, 4, black ) );
        
        board[2][2].setBorder( BorderFactory.createMatteBorder( 4, 4, 0, 0, black ) );
    }
    
    private void wonWhere() {
    
        String result = game.getBoard().getWonHow();
        int where = game.getBoard().getWonWhere();
        Color green = new Color( 105, 255, 105 );
        
        if ( result.equals( "horizontal" ) ) {
        
            for ( int col = 0; col < 3; col++ ) {
            
                board[ where ][ col ].setBackground( green );
            
            }
        
        } else if ( result.equals( "vertical" ) ) {
        
        	for ( int row = 0; row < 3; row++ ) {
                
                board[ row ][ where ].setBackground( green );
            
            }
        
        } else if( result.equals( "positiveSlope" ) ) {
        
            board[ 2 ][ 0 ].setBackground( green );
            board[ 1 ][ 1 ].setBackground( green );
            board[ 0 ][ 2 ].setBackground( green );
        
        } else {
        
            board[ 0 ][ 0 ].setBackground( green );
            board[ 1 ][ 1 ].setBackground( green );
            board[ 2 ][ 2 ].setBackground( green );
        
        }
        
    
    }
}
