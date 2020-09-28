package org.jtodd.elevator;

// Elevator simulator: Clock.java
// Describes the clock that times the elevator's movements
// Thread that monitors the elevator
// Monitor for the elevator
import java.awt.event.*;
import javax.swing.*;

public class Clock extends Thread implements ActionListener {
   private final int TIME = 60000;
   private Elevator elevator;
   private JTextArea output;
   private Timer timer;

   public Clock ( Elevator e,// ClockTimer c,
                        JTextArea o )
   {
      elevator = e;
      output = o;
      timer = new Timer( TIME, this );
   }

   public void run()
   {
      output.append( "\nThe CLOCK has been instantiated." );
      while( elevator.isMoving() ) {
         timer.start();
      }
   }

   @Override
   public void actionPerformed( ActionEvent e )
   {
      output.append( "\nThe CLOCK has finished counting." );
   }
}