// Elevator Simulator: FloorControlBoard.java
// Customized JPanel class to show the call buttons and floor lights
import java.awt.*;
import javax.swing.*;

public class FloorControlBoard extends JPanel {
   private Color currentColor = Color.white;
   private ImageIcon lightOn, lightOff, thisLight;

   public FloorControlBoard()
   {
      lightOn = new ImageIcon( getClass().getResource( "images/lightOn.gif" ) );
      lightOff = new ImageIcon( getClass().getResource( "images/lightOff.gif" ) );
      thisLight = lightOff;
   }

   public Dimension getPreferredSize() { return new Dimension( 120, 67 ); }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( 22, 22, 28, 28 );
      g.drawOval( 28, 28, 16, 16 );
      g.setColor( currentColor );
      g.fillOval( 29, 29, 14, 14 );
      thisLight.paintIcon( this, g, 60, 20 );
   }

   public void activateButton()
   {
      currentColor = Color.yellow;
      repaint();
   }

   public void deactivateButton()
   {
      currentColor = Color.white;
      repaint();
   }

   public void activateLight() {
      thisLight = lightOn;
      repaint();
   }

   public void deactivateLight() {
      thisLight = lightOff;
      repaint();
   }
}