// Elevator Simulator: Floor.java
// Describes the floors of the building
import java.awt.event.*;
import javax.swing.*;

public class Floor {
   private final int FLOOR;
   public Building building;
   public FloorDoor floorDoor;
   public FloorLight floorLight;
   public FloorBell floorBell;
   public CallButton callButton;
   public ElevatorApplet applet;
   public FloorCanvas canvas;
   public JTextArea output;
   public Person p[];
   private Person departingPerson;

   public Floor( Building b, ElevatorApplet ea, JTextArea o, int f )
   {
      building = b;
      applet = ea;
      output = o;
      FLOOR = f;
      floorDoor = new FloorDoor( this, applet.fCanvas[ FLOOR ], output );
      floorLight = new FloorLight( FLOOR, applet.fcb[ FLOOR ], output );
      floorBell = new FloorBell( FLOOR, output );
      callButton = new CallButton( building, FLOOR, applet.fcb[ FLOOR ], output );
      canvas = applet.fCanvas[ FLOOR ];
      p = new Person[ 1 ];
   }

   public int getFloor() { return FLOOR; }

   public void createPerson( int d )
   {
      p[ 0 ] = new Person( building, output, FLOOR, d, canvas.getStartingPersonX(),
                           canvas.getPersonY(), getRandomPerson() );
      disableButton();
      p[ 0 ].start();
   }

   public int getRandomPerson() { return (int) ( Math.random() * 10 ) + 1; }

   public void disableButton() { applet.f[ FLOOR ].setEnabled( false ); }

   public void enableButton() { applet.f[ FLOOR ].setEnabled( true ); }
}