package org.jtodd.elevator;

// Elevator Simulator: ElevatorCanvas.java
// Customized JPanel class to show the elevator
import java.awt.*;
import javax.swing.*;

public class ElevatorCanvas extends JPanel {
   private Color doorColor = Color.black;
   private final int WIDTH = 75, HEIGHT = 90, UPPERLEFTX = 5, PERSONX = 53;
   private double upperLeftY = 109.0, personY;
   private Person occupant;
   private ImageIcon personIcon = new ImageIcon(
      getClass().getResource( "/images/person00.gif" )
   );

   public Dimension getPreferredSize() { return new Dimension( 100, 200 ); }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.drawRect( UPPERLEFTX, (int) Math.round( upperLeftY ), WIDTH, HEIGHT );
      g.setColor( doorColor );
      g.drawLine( UPPERLEFTX, (int) Math.round( upperLeftY ),
                  UPPERLEFTX, ( (int) Math.round( upperLeftY ) + HEIGHT ) );
      if( occupant != null ) {
         personIcon.paintIcon( this, g, occupant.getX(), occupant.getY() );
      }
   }

   public void setOpen( boolean opened ) {
      doorColor = ( opened ) ? Color.white : Color.black;
      repaint();
   }

   public void moveDrawing( int direction )
   {
      upperLeftY += direction * 103.0 / 199.0;
      if( occupant != null ) { occupant.setY( (int) upperLeftY + 30 ); }
      repaint();
   }

   public void addPerson( Person p )
   {
      occupant = p;
      personIcon = occupant.getImage();
   }

   public void removePerson() { occupant = null; }

   public int getPersonX() { return PERSONX; }

   public int getPersonY() { return (int) ( upperLeftY + 30 ); }
}