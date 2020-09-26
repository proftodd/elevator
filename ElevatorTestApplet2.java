// Elevator Simulator: ElevatorTestApplet2.java
// Tests the Door class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorTestApplet2 extends JApplet implements ActionListener {
   public JButton oed1, ced1, ioed1, oed2, ced2, ioed2, ofd1, cfd1, iofd1, ofd2, cfd2, iofd2;
   public JTextArea output;
   public JScrollPane scroller;
   public JPanel thisPanel;
   public Door ed1, ed2, fd1, fd2;

   public void init()
   {
      Container c = getContentPane();

      output = new JTextArea( 20, 20 );
      scroller = new JScrollPane( output );
      c.add( scroller, BorderLayout.EAST );

      thisPanel = new JPanel();
      thisPanel.setLayout( new GridLayout( 4, 3, 5, 5 ) );

      oed1 = new JButton( "open Door 1" );
      oed1.addActionListener( this );
      thisPanel.add( oed1 );

      ced1 = new JButton( "close Door 1" );
      ced1.addActionListener( this );
      thisPanel.add( ced1 );

      ioed1 = new JButton( "isOpen()" );
      ioed1.addActionListener( this );
      thisPanel.add( ioed1 );

      oed2 = new JButton( "open Door 2" );
      oed2.addActionListener( this );
      thisPanel.add( oed2 );

      ced2 = new JButton( "close Door 2" );
      ced2.addActionListener( this );
      thisPanel.add( ced2 );

      ioed2 = new JButton( "isOpen()" );
      ioed2.addActionListener( this );
      thisPanel.add( ioed2 );

      ofd1 = new JButton( "open Door 1" );
      ofd1.addActionListener( this );
      thisPanel.add( ofd1 );

      cfd1 = new JButton( "close Door 1" );
      cfd1.addActionListener( this );
      thisPanel.add( cfd1 );

      iofd1 = new JButton( "isOpen()" );
      iofd1.addActionListener( this );
      thisPanel.add( iofd1 );

      ofd2 = new JButton( "open Door 2" );
      ofd2.addActionListener( this );
      thisPanel.add( ofd2 );

      cfd2 = new JButton( "close Door 2" );
      cfd2.addActionListener( this );
      thisPanel.add( cfd2 );

      iofd2 = new JButton( "isOpen()" );
      iofd2.addActionListener( this );
      thisPanel.add( iofd2 );

      c.add( thisPanel, BorderLayout.CENTER );

      ed1 = new Door( output );
      ed2 = new Door( output );

      fd1 = new Door( output );
      fd2 = new Door( output );
  }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == oed1 ) {
         ed1.open();
      }

      if ( e.getSource() == ced1 ) {
         ed1.close();
      }

      if ( e.getSource() == ioed1 ) {
         output.append( "\nElevator door 1 is " + ( ( ed1.isOpen() ) ? "open." : "closed." ) );
      }

      if ( e.getSource() == oed2 ) {
         ed2.open();
      }

      if ( e.getSource() == ced2 ) {
         ed2.close();
      }

      if ( e.getSource() == ioed2 ) {
         output.append( "\nElevator door 2 is " + ( ( ed2.isOpen() ) ? "open." : "closed." ) );
      }

      if ( e.getSource() == ofd1 ) {
         fd1.open();
      }

      if ( e.getSource() == cfd1 ) {
         fd1.close();
      }

      if ( e.getSource() == iofd1 ) {
         output.append( "\nFloor door 1 is " + ( ( fd1.isOpen() ) ? "open." : "closed." ) );
      }

      if ( e.getSource() == ofd2 ) {
         fd2.open();
      }

      if ( e.getSource() == cfd2 ) {
         fd2.close();
      }

      if ( e.getSource() == iofd2 ) {
         output.append( "\nFloor door 2 is " + ( ( fd2.isOpen() ) ? "open." : "closed." ) );
      }
   }
}