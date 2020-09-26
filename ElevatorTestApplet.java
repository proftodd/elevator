// Elevator Simulator: ElevatorTestApplet.java
// Driver applet to test the FloorDoor and ElevatorDoor classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorTestApplet extends JApplet implements ActionListener {
   public ElevatorDoor edoor;
   public FloorDoor fdoor;
   public JTextArea output;
   public JScrollPane scroller;
   public JPanel buttonPanel;
   public JButton openEDoor, closeEDoor, ioEDoor, openFDoor, closeFDoor, ioFDoor;

   public void init()
   {
      Container c = getContentPane();
      output = new JTextArea( 15, 35 );
      scroller = new JScrollPane( output );
      c.add( scroller, BorderLayout.CENTER );

      buttonPanel = new JPanel();
      buttonPanel.setLayout( new GridLayout( 2, 3, 5, 5 ) );
//      buttonPanel.setLayout( new GridLayout( 1, 3, 5, 5 ) );

      openEDoor = new JButton( "open()" );
      openEDoor.addActionListener( this );
      buttonPanel.add( openEDoor );

      closeEDoor = new JButton( "close()" );
      closeEDoor.addActionListener( this );
      buttonPanel.add( closeEDoor );

      ioEDoor = new JButton( "isOpen()" );
      ioEDoor.addActionListener( this );
      buttonPanel.add( ioEDoor );

      openFDoor = new JButton( "open()" );
      openFDoor.addActionListener( this );
      buttonPanel.add( openFDoor );

      closeFDoor = new JButton( "close()" );
      closeFDoor.addActionListener( this );
      buttonPanel.add( closeFDoor );

      ioFDoor = new JButton( "isOpen()" );
      ioFDoor.addActionListener( this );
      buttonPanel.add( ioFDoor );

      c.add( buttonPanel, BorderLayout.WEST );

      edoor = new ElevatorDoor( false, output );
      fdoor = new FloorDoor( 1, false, output );
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == openEDoor ) {
         edoor.open();
      }

      if ( e.getSource() == closeEDoor ) {
         edoor.close();
      }

      if ( e.getSource() == ioEDoor ) {
         output.append( "\nElevator Door is " + ( ( edoor.isOpen() ) ? "open." : "closed." ) );
      }

      if ( e.getSource() == openFDoor ) {
         fdoor.open();
      }

      if ( e.getSource() == closeFDoor ) {
         fdoor.close();
      }

      if ( e.getSource() == ioFDoor ) {
         output.append( "\nFloor Door on floor " + fdoor.getFloor() +
                        " is " + ( ( fdoor.isOpen() ) ? "open." : "closed." ) );
      }
   }
}