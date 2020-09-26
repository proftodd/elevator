// Elevator Simulator: FloorLight.java
// Describes the floor lights on each floor of the building
import javax.swing.JTextArea;

public class FloorLight {
   private boolean lit;
   private int floor;
   private JTextArea output;

   public FloorLight( int f, JTextArea o )
   {
      lit = false;
      floor = f;
      output = o;
   }

   public void activateFloorLight()
   {
      lit = true;
      output.append( "\nFLOORLIGHT on FLOOR " + floor + " turns on." );
   }

   public void deactivateFloorLight()
   {
      lit = false;
      output.append( "\nFLOORLIGHT on FLOOR " + floor + " turns off." );
   }

   public boolean isOn()
   {
      return lit;
   }
}