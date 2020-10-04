package org.jtodd.elevator;

// Elevator Simulator: ElevatorBoard.java
// Customized JPanel class to show the elevator buttons and floor bell
import java.awt.*;
import javax.swing.*;

public class ElevatorControlBoard extends JPanel {
   private Color currentColor[];
   private final int FLOORS;
   private ImageIcon bell;

   public ElevatorControlBoard( int f )
   {
      FLOORS = f;
      currentColor = new Color[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) { currentColor[ i ] = Color.white; }
      bell = new ImageIcon( getClass().getResource( "/images/bell.gif" ) );
   }

   public Dimension getPreferredSize()
   {
      return new Dimension( 120, 66 );
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( 22, 5, 28, ( 28 * FLOORS ) );
      for ( int i = 1; i <= FLOORS; i++ ) {
         g.setColor( Color.black );
         g.drawOval( 28, 11 + 28 * ( i - 1 ), 16, 16 );
         g.setColor( currentColor[ i ] );
         g.fillOval( 29, 12 + 28 * ( FLOORS - i - 1 ), 14, 14 );
      }
      bell.paintIcon( this, g, 70, 16 );
   }

   public void activateButton( int f ) {
      currentColor[ f ] = Color.yellow;
      repaint();
   }

   public void deactivateButton( int f ) {
      currentColor[ f ] = Color.white;
      repaint();
   }
}