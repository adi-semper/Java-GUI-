package view.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class TicTacToeFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel nullLabel;
    private JLabel playerOneLabel;
    private JLabel playerTwoLabel;
    private JLabel whichTurnLabel;
    private JLabel player1Symbol;
    private JLabel player2Symbol;
    private JLabel player1Score;
    private JLabel player2Score;
    
    private JButton[][] boardButtons;
    private JButton startButton;
    private JButton restartButton;
    private JButton switchSymbols;
    private JButton nullButton;
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel playerPanel;
    private JPanel boardPanel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    
    public TicTacToeFrame() {
    
        createComponents();
        setPanels();
        setFontSize();
        addComponents();
        addBorders();
        
        setPreferredSize( new Dimension ( 520, 500 ) );
        pack();
        setLocationRelativeTo( null );
    
    }
    
    public JLabel getWhichTurn() {
    
        return whichTurnLabel;
    
    }

    public JLabel getPlayerTwo() {
    
        return playerTwoLabel;
    
    }
    
    public JLabel getPlayerTwoSymbol() {
    
        return player2Symbol;
    
    }
    
    public JLabel getPlayerTwoScore() {
    
        return player2Score;
    
    }
    
    public JLabel getPlayerOne() {
        
        return playerOneLabel;
    
    }
    
    public JLabel getPlayerOneSymbol() {
    
        return player1Symbol;
    
    }
    
    public JLabel getPlayerOneScore() {
    
        return player1Score;
    
    }
    
    public JButton getStartButton() {
    
        return startButton;
    
    }
    
    public JButton getRestartButton() {
    
        return restartButton;
    
    }
    
    public JButton getSwitchButton() {
    
        return switchSymbols;
    
    }
    
    public JButton[][] getBoardButtons() {
    
        return boardButtons;
    
    }
    
    private void addBorders() {
        
        CompoundBorder externalBorder = new CompoundBorder(
                new EmptyBorder( 10, 10, 10, 10 ),
                new TitledBorder( new EtchedBorder(), "Tic-Tac-Toe" ) );

        CompoundBorder internalBorder = new CompoundBorder(
                new EmptyBorder( 30, 20, 30, 20 ), BorderFactory.createEmptyBorder() );
        
        whichTurnLabel.setBorder( internalBorder );
        playerOneLabel.setBorder( internalBorder );
        player1Symbol.setBorder( internalBorder );
        player1Score.setBorder( internalBorder );
        playerTwoLabel.setBorder( internalBorder );
        player2Symbol.setBorder( internalBorder );
        player2Score.setBorder( internalBorder );
        
        mainPanel.setBorder( externalBorder );
    
    }

	private void addComponents() {
    
        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
                boardPanel.add( boardButtons[ row ][ col ] );
            
            }
        }

        northPanel.add( playerOneLabel );
        northPanel.add( player1Symbol );
        northPanel.add( player1Score );
        
        topPanel.add( whichTurnLabel );
        topPanel.add( nullLabel );
        
        playerPanel.add( startButton );
        playerPanel.add( restartButton );
        playerPanel.add( switchSymbols );
        
        centerPanel.add( topPanel );
        centerPanel.add( boardPanel );
        centerPanel.add( nullButton );
        centerPanel.add( playerPanel );
        
        southPanel.add( playerTwoLabel );
        southPanel.add( player2Symbol );
        southPanel.add( player2Score );
        
        mainPanel.add( northPanel );
        mainPanel.add( centerPanel );
        mainPanel.add( southPanel );
        
        setContentPane( mainPanel );
    
    }

	private void setPanels() {
    
        mainPanel.setLayout( new BoxLayout( mainPanel, BoxLayout.X_AXIS ) );
        boardPanel.setLayout( new GridLayout( 3, 3 ) );
        northPanel.setLayout( new BoxLayout( northPanel, BoxLayout.Y_AXIS ) );
        centerPanel.setLayout( new BoxLayout( centerPanel, BoxLayout.Y_AXIS ) );
        southPanel.setLayout( new BoxLayout( southPanel, BoxLayout.Y_AXIS ) );
        playerPanel.setLayout( new BoxLayout( playerPanel, BoxLayout.X_AXIS ) );
        topPanel.setLayout( new BoxLayout( topPanel, BoxLayout.X_AXIS ) );
        
    }

	private void createComponents() {

	    nullLabel = new JLabel( "      " );
        playerOneLabel = new JLabel( "Player 1" );
        playerTwoLabel = new JLabel( "Player 2" );
        whichTurnLabel = new JLabel( "Game Awaiting..." );
        player1Symbol = new JLabel( " \'O\'" );
        player2Symbol = new JLabel( "  \'X\'" );
        player1Score = new JLabel( "Score: 0" );
        player2Score = new JLabel( "Score: 0" );
        
        boardButtons = new JButton[ 3 ][ 3 ];
        for ( int row = 0; row < 3; row++ ) {
            for ( int col = 0; col < 3; col++ ) {
            
                boardButtons[ row ][ col ] = new JButton( " " );
            }
        }
        
        startButton = new JButton( "Start" );
        restartButton = new JButton( "Restart" );
        switchSymbols = new JButton( "Switch letters" );
        
        mainPanel = new JPanel();
        boardPanel = new JPanel();
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        playerPanel = new JPanel();
        topPanel = new JPanel();
        
        nullButton = new JButton( " " );
        nullButton.setContentAreaFilled( false );
        nullButton.setBorderPainted( false );
        nullButton.setEnabled( false );

    }
	
	public void reset() {
	
	    whichTurnLabel.setText( "Game Awaiting..." );
	    player1Score.setText( "Score: 0" );
	    player2Score.setText( "Score: 0" );
	    
	    for ( int row = 0; row < 3; row++ ) {
	    	for ( int col = 0; col < 3; col++ ) {
	    	
	    	    boardButtons[ row ][ col ].setText( " " );
	    	}
	    }
	
	}
	
	public void resetButtons() {
	
        for ( int row = 0; row < 3; row++ ) {
	    	for ( int col = 0; col < 3; col++ ) {
	    	
	    	    boardButtons[ row ][ col ].setText( " " );
	    	}
	    }
	
	}
	
	private void setFontSize() {

		player1Symbol.setFont( new Font( "Arial", Font.BOLD, 30 ) );
        playerOneLabel.setFont( new Font( "Arial", Font.BOLD, 15 ) );
        player1Score.setFont( new Font( "Arial", Font.BOLD, 15 ) );
        
        player2Symbol.setFont( new Font( "Arial", Font.BOLD, 30 ) );
        playerTwoLabel.setFont( new Font( "Arial", Font.BOLD, 15 ) );
        player2Score.setFont( new Font( "Arial", Font.BOLD, 15 ) );
        
        whichTurnLabel.setFont( new Font( "Arial", Font.BOLD, 25 ) );

	}

}
