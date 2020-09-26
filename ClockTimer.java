// Elevator Simulator: ClockTimer.java
// Customized JPanel class to show the clock
import java.awt.*;
import javax.swing.*;

public class ClockTimer extends JPanel {
   public Dimension getPreferredSize()
   {
      return new Dimension( 80, 200 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawOval( 5, 5, 70, 70 );
      g.drawLine( 40, 40, 40, 5 );
   }
}