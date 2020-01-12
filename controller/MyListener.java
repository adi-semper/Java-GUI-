package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class MyListener extends WindowAdapter implements ActionListener{

    private ListenerControl control;

    public MyListener( ListenerControl control ) {
    
        this.control = control; 
    
    }

	@Override
	public void actionPerformed( ActionEvent e ) {

        JButton btn = (JButton) e.getSource();
        
        if ( btn instanceof JButton ) {
        
            handleButtonEvents( btn );
        
        }

	}

	private void handleButtonEvents( JButton btn ) {

	    String text = btn.getText();
	
        if ( text.equals( "Start" ) ) {
        
            control.startPressed();
        
        } else if ( text.equals( "Switch letters" ) ) {
        
            control.switchPressed();
        
        } else if ( text.equals( "Restart" ) ) {
        
            control.restartPressed();
        
        } else {
        
            control.boardPressed( btn );
        
        }
	
	}

	@Override
    public void windowClosing( WindowEvent e ) {

        System.exit( 0 );

    }
	
}
