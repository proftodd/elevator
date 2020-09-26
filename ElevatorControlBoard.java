// Elevator Simulator: ElevatorControlBoard.java
// Customized JPanel class to show the elevator buttons and floor bell
import java.awt.*;
import javax.swing.*;

public class ElevatorControlBoard extends JPanel {
   public Dimension getPreferredSize()
   {
      return new Dimension( 120, 66 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( 22, 5, 22, 56 );
      g.drawOval( 26, 14, 14, 14 );
      g.drawOval( 26, 41, 14, 14 );
   }
}