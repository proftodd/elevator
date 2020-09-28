package org.jtodd.elevator;

// Elevator Simulator: ClockTimer.java
// Customized JPanel class to show the clock
import java.awt.*;
import javax.swing.*;

public class ClockTimer extends JPanel implements Runnable {
   private boolean ticking;
   private Elevator elevator;
   private ElevatorCanvas elevatorCanvas;
   private JTextArea output;
   private int count;
   private Thread t;

   public ClockTimer( JTextArea o )
   {
      setTicking( false );
      output = o;
      t = new Thread( this );
      t.start();
   }

   public Dimension getPreferredSize() { return new Dimension( 80, 200 ); }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawOval( 5, 5, 70, 70 );
      g.drawLine( 40, 40, getTimerX(), getTimerY() );
   }

   public void run()
   {
      count = 0;
      while ( true ) {
         try {
            t.sleep( 50 );
         } catch ( InterruptedException e ) {}
         if ( ticking ) {
           elevatorCanvas.moveDrawing( elevator.getDirection() );
           if ( ++count == 199 ) {
              count = 0;
              output.append( "\nCLOCKTIMER has completed one cycle." );
              setTicking( false );
           }
         }
         repaint();
      }
   }

   public void setTicking( boolean t ) { ticking = t; }

   public boolean isTicking() { return ticking; }

   public int getCount() { return count; }

   private int getTimerX()
   {
     return 40 + (int) ( 35 * Math.sin( Math.PI / 100 * count ) );
   }

   private int getTimerY()
   {
     return 40 - (int) ( 35 * Math.cos( Math.PI / 100 * count ) );
   }

   public void registerElevator( Elevator e ) { elevator = e; }

   public void registerECanvas( ElevatorCanvas ec ) { elevatorCanvas = ec; }
}