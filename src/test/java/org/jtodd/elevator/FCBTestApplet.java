// Elevator Simulator: FCBTestApplet.java
// Canvas to test the methods and attributes of the FloorControlBoard
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FCBTestApplet extends JApplet implements ActionListener {
   FloorControlBoard board;
   JButton buttonOn, buttonOff, lightOn, lightOff;

   public void init()
   {
      board = new FloorControlBoard();
      buttonOn = new JButton( "Button On" );
      buttonOn.addActionListener( this );
      buttonOff = new JButton( "Button Off" );
      buttonOff.addActionListener( this );
      lightOn = new JButton( "Light On" );
      lightOn.addActionListener( this );
      lightOff = new JButton( "Light Off" );
      lightOff.addActionListener( this );

      Container c = getContentPane();
      c.setLayout( new FlowLayout() );
      c.add( board );
      c.add( buttonOn );
      c.add( buttonOff );
      c.add( lightOn );
      c.add( lightOff );
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == buttonOn ) { board.activateButton(); }
      else if ( e.getSource() == buttonOff ) { board.deactivateButton(); }
      else if ( e.getSource() == lightOn ) { board.activateLight(); }
      else if ( e.getSource() == lightOff ) { board.deactivateLight(); }
   }
}