package org.jtodd.elevator;

// Elevator Simulator: FloorDoor.java
// Describes the floor doors
import javax.swing.JTextArea;

public class FloorDoor extends Door {
   public Floor floor;
   private FloorCanvas canvas;

   public FloorDoor( Floor f, FloorCanvas fc, JTextArea o )
   {
      super( o );
      floor = f;
      canvas = fc;
   }

   public void open()
   {
      setOpen( true );
      floor.floorLight.activateFloorLight();
      floor.floorBell.ringFloorBell();
      canvas.setOpen( true );
      super.output.append( "\nFLOORDOOR on FLOOR " + floor.getFloor() + " opens." );
      floor.callButton.resetButton();
   }

   public void close()
   {
      setOpen( false );
      floor.floorLight.deactivateFloorLight();
      canvas.setOpen( false );
      super.output.append( "\nFLOORDOOR on FLOOR " + floor.getFloor() + " closes." );
   }
}