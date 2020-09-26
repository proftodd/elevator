// Elevator Simulator: FloorCanvas.java
// Customized JPanel class to show the Floors
import java.awt.*;
import javax.swing.*;

public class FloorCanvas extends JPanel {
   private Color openedColor = Color.black;
   private final int FLOOR;
   private Person arrivingPerson, departingPerson;
   private final int PERSONY = 38;

   public FloorCanvas( int f )
   {
      FLOOR = f;
   }

   public Dimension getPreferredSize() { return new Dimension( 300, 100 ); }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor( Color.black );
      g.fillRect( 20, 98, 280, 3 );
      g.drawString( "FLOOR " + FLOOR, 25, 25 );
      if( arrivingPerson != null ) {
         arrivingPerson.getImage().paintIcon( this, g,
                                             arrivingPerson.getX(), arrivingPerson.getY() );
      }
      if( departingPerson != null ) {
         departingPerson.getImage().paintIcon( this, g,
                                             departingPerson.getX(), departingPerson.getY() );
      }
      g.setColor( openedColor );
      g.drawLine( 299, 1, 299, 98 );
   }

   public void setOpen( boolean opened ) {
      openedColor = ( opened ) ? Color.white : Color.black;
      repaint();
   }

   public void paintArrivingPerson( Person p )
   {
      arrivingPerson = p;
      repaint();
   }

   public void paintDepartingPerson( Person p )
   {
      departingPerson = p;
      repaint();
   }

   public int getStartingPersonX() { return 0; }

   public int getPersonY() { return PERSONY; }

   public int getWidth() { return 279; }

   public void eraseArrivingPerson()
   {
      arrivingPerson = null;
      repaint();
   }

   public void eraseDepartingPerson()
   {
      departingPerson = null;
      repaint();
   }
}