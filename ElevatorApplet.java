// Elevator Simulator: ElevatorApplet.java
// Driver applet to run the elevator simulator. Version 1.0
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorApplet extends JApplet implements ActionListener {
   public Building b;
   public JTextArea output;
   public JScrollPane scroller;
   public JButton newPerson;
   public static final int FLOORS = 2;

   public void init()
   {
      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

      newPerson = new JButton( "Create person" );
      newPerson.addActionListener( this );
      c.add( newPerson );

      output = new JTextArea( 15, 35 );
      scroller = new JScrollPane( output );
      c.add( scroller );

      b = new Building( 2, output );
   }

   public void actionPerformed( ActionEvent e )
   {
      int current = getRandom();
      int dest = getRandom();
      while ( current == dest ) {
         dest = getRandom();
      }
      b.createPerson( current, dest );
   }

   public int getRandom() {
      return (int) ( Math.random() * FLOORS ) + 1;
   }
}