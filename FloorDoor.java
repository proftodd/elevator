// Elevator Simulator: FloorDoor.java
// Describes the floor doors
import javax.swing.JTextArea;

public class FloorDoor extends Door {
   public Floor floor;

   public FloorDoor( Floor f, JTextArea o )
   {
      super( o );
      floor = f;
   }

   public void open()
   {
      setOpen( true );
      floor.floorLight.activateFloorLight();
      floor.floorBell.ringFloorBell();
      super.output.append( "\nFLOORDOOR on FLOOR " + floor.getFloor() + " opens." );
      floor.callButton.resetButton();
   }

   public void close()
   {
      setOpen( false );
      floor.floorLight.deactivateFloorLight();
      super.output.append( "\nFLOORDOOR on FLOOR " + floor.getFloor() + " closes." );
   }
}