// Elevator simulator: Clock.java
// Describes the clock that times the elevator's movements
// Thread that monitors the elevator
// Monitor for the elevator
import javax.event.*;
import javax.swing.*;

public class Clock extends Thread implements ActionListener {
   private final int TIME = 60000;
   private Elevator elevator;
//   private ClockTimer ct;
   private JTextArea output;
   private Timer timer;

   public class clock ( Elevator e,// ClockTimer c,
                        JTextArea o )
   {
      elevator = e;
//      ct = c;
      output = o;
      timer = new Timer( TIME, this );
   }

   public void run()
   {
      output.append( "\nThe CLOCK has been instantiated." );
      while( elevator.isMoving() ) {
//      ct.animate( TIME );
         timer.start();
      }
   }

   public void actionPerformed( ActionEvent e )
   {
      output.append( "\nThe CLOCK has finished counting." );
   }
}