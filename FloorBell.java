// Elevator Simulator: FloorBell.java
// Describes the floor bells on each floor of the building
import javax.swing.JTextArea;

public class FloorBell {
   private int floor;
   private JTextArea output;

   public FloorBell( int f, JTextArea o )
   {
      floor = f;
      output = o;
   }

   public void ringFloorBell()
   {
      output.append( "\nFloor bell on floor " + floor + " rings." );
   }
}