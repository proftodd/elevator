// Elevator Simulator: ElevatorBoard.java
// Customized JPanel class to show the elevator buttons and floor bell
import java.awt.*;
import javax.swing.*;

public class ElevatorBoard extends JPanel {
   private Color currentColor[];
   private final int FLOORS;

   public ElevatorBoard( int f )
   {
      FLOORS = f;
      currentColor = new Color[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) { currentColor[ i ] = Color.white; }
   }

   public Dimension getPreferredSize()
   {
      return new Dimension( 120, 66 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( 22, 5, 28, ( 28 * ( FLOORS - 1 ) ) );
      for ( int i = 1; i <= FLOORS; i++ ) {
         g.setColor( Color.black );
         g.drawOval( 28, 11 + 28 * ( i - 1 ), 16, 16 );
         g.setColor( currentColor[ i ] );
         g.fillOval( 29, 12 + 28 * ( FLOORS - i - 1 ), 14, 14 );
      }
   }

   public void activateLight( int f ) {
      currentColor[ f ] = Color.yellow;
      repaint();
   }

   public void deactivateLight( int f ) {
      currentColor[ f ] = Color.white;
      repaint();
   }
}