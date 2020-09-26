// Elevator Simulator: FloorCanvas.java
// Customized JPanel class to show the Floors
import java.awt.*;
import javax.swing.*;

public class FloorCanvas extends JPanel {
   public Dimension getPreferredSize()
   {
      return new Dimension( 300, 100 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.fillRect( 20, 98, 280, 3 );
   }
}