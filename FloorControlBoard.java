// Elevator Simulator: FloorControlBoard.java
// Customized JPanel class to show the call buttons and floor lights
import java.awt.*;
import javax.swing.*;

public class FloorControlBoard extends JPanel {
   public Dimension getPreferredSize()
   {
      return new Dimension( 120, 67 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( 22, 22, 22, 22 );
      g.drawOval( 26, 26, 14, 14 );
   }
}