// Elevator Simulator: FloorLight.java
// Describes the floor lights on each floor of the building
import javax.swing.JTextArea;

public class FloorLight {
   private boolean lit;
   private int floor;
   private FloorControlBoard board;
   private JTextArea output;

   public FloorLight( int f, FloorControlBoard fcb, JTextArea o )
   {
      lit = false;
      floor = f;
      board = fcb;
      output = o;
   }

   public void activateFloorLight()
   {
      lit = true;
      board.activateLight();
      output.append( "\nFLOORLIGHT on FLOOR " + floor + " turns on." );
   }

   public void deactivateFloorLight()
   {
      lit = false;
      board.deactivateLight();
      output.append( "\nFLOORLIGHT on FLOOR " + floor + " turns off." );
   }

   public boolean isOn() { return lit; }
}