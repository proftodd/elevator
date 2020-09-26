// Elevator Simulator: ElevatorCanvas.java
// Customized JPanel class to show the elevator
import java.awt.*;
import javax.swing.*;

public class ElevatorCanvas extends JPanel {
   public Dimension getPreferredSize()
   {
      return new Dimension( 100, 200 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( 5, 10, 75, 90 );
   }
}