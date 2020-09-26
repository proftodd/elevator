// Elevator Simulator: CanvasTester.java
// Driver application to test the canvases in the elevator simulator
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CanvasTester extends JFrame {
   private ElevatorControlBoard ecb;

   public CanvasTester()
   {
      super( "CanvasTester" );

      ecb = new ElevatorControlBoard();
      ecb.setBackground( Color.orange );

      Container c = getContentPane();
      c.add( ecb, BorderLayout.CENTER );

      setSize( 128, 96 );
      show();
   }

   public static void main( String args[] )
   {
      CanvasTester app = new CanvasTester();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }
}