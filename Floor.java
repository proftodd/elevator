// Elevator Simulator: Floor.java
// Describes the floors of the building
import javax.swing.JTextArea;

public class Floor {
   public int thisFloor;
   public Building building;
   public FloorDoor floorDoor;
   public FloorLight floorLight;
   public FloorBell floorBell;
   public CallButton callButton;
   public JTextArea output;

   public Floor( Building b, JTextArea o, int f )
   {
      building = b;
      output = o;
      thisFloor = f;
      floorDoor = new FloorDoor( thisFloor, false, output );
      floorLight = new FloorLight( thisFloor, output );
      floorBell = new FloorBell( thisFloor, output );
      callButton = new CallButton( building.elevator, thisFloor, output );
   }
}