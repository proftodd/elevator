// Elevator Simulator: ClockTimerTest.java
// Driver program to test the animation of the ClockTimer class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockTimerTest extends JApplet implements ActionListener {
   private ClockTimer clock;
   private JButton startButton, stopButton;
   private JTextArea output;

   public void start()
   {
      Container c = getContentPane();

      JPanel jp = new JPanel();
      jp.setLayout( new GridLayout( 3, 1 ) );

      startButton = new JButton( "Start Clock" );
      startButton.addActionListener( this );
      jp.add( startButton );

      stopButton = new JButton( "Stop Clock" );
      stopButton.addActionListener( this );
      jp.add( stopButton );

      output = new JTextArea( 5, 10 );
      jp.add( output );
      c.add( jp, BorderLayout.CENTER );

      clock = new ClockTimer( output );
      clock.setBackground( Color.white );
      c.add( clock, BorderLayout.WEST );
   }

   public void actionPerformed ( ActionEvent e )
   {
      if ( e.getSource() == startButton ) { clock.setTicking( true ); }
      else { clock.setTicking( false ); }
   }
}