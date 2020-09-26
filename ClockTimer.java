// Elevator Simulator: ClockTimer.java
// Customized JPanel class to show the clock
import java.awt.*;
import javax.swing.*;

public class ClockTimer extends JPanel implements Runnable {
   private boolean ticking;
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
      g.drawLine( 40, 40, 40, 5 );
   }

   public void run()
   {
      count = 0;
      while ( true ) {
         try {
            t.sleep( 50 );
         } catch ( InterruptedException e ) {}
         if ( ticking ) {
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
}