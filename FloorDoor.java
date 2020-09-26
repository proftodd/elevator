// Elevator Simulator: FloorDoor.java
// Describes the floor doors
import javax.swing.JTextArea;

public class FloorDoor extends Door {
   private int floor;

   public FloorDoor( int f, boolean io, JTextArea o )
   {
      super( io, o );
      setFloor( f );
   }

   public void setFloor( int f ) { floor = f; }

   public void open()
   {
      setOpen( true );
      super.output.append( "\nFLOORDOOR on FLOOR " + floor + " opens." );
   }

   public void close()
   {
      setOpen( false );
      super.output.append( "\nFLOORDOOR on FLOOR " + floor + " closes." );
   }

   public int getFloor() { return floor; }
}