// Elevator Simulator: Floor.java
// Describes the floors of the building
import javax.swing.JTextArea;

public class Floor {
   private final int FLOOR;
   public Building building;
   public FloorDoor floorDoor;
   public FloorLight floorLight;
   public FloorBell floorBell;
   public CallButton callButton;
   public ElevatorApplet applet;
   public JTextArea output;
   private int numPersons;

   public Floor( Building b, ElevatorApplet ea, JTextArea o, int f )
   {
      building = b;
      applet = ea;
      output = o;
      FLOOR = f;
      floorDoor = new FloorDoor( this, output );
      floorLight = new FloorLight( FLOOR, output );
      floorBell = new FloorBell( FLOOR, output );
      callButton = new CallButton( building, FLOOR, applet.fcb[ FLOOR ], output );
      setNumPersons( 0 );
   }

   public void setNumPersons( int i ) { numPersons = i; };

   public int getNumPersons() { return numPersons; }

   public int getFloor() { return FLOOR; }
}