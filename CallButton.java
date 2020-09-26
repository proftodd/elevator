// Elevator Simulator: CallButton.java
// Describes the call buttons on each floor in the building
// Attributes:
//    elevator
//    floor number
//    FloorControlBoard for graphical output
//    JTextArea for text output
//    on or off
// Behaviors:
//    pressButton()
//       Summons the Elevator. Called by a Person. Calls moveElevator() (class Elevator) and
//       passes it the destination floor as an argument.
//    resetButton()
//       Turns the CallButton off. Called by the Elevator.
//    isLit()
//       Returns whether the button is lit or not. Called by the Elevator.
//    setLit()
//       Utility method for altering the lit status
// Method Calls Sent to Other Classes:
//    CallButton sends the moveElevator() method call to the Elevator
import javax.swing.*;

public class CallButton {
   public Building building;
   public final int FLOOR;
   public FloorControlBoard board;
   public JTextArea output;
   private boolean lit;

   public CallButton( Building b, int f, FloorControlBoard fcb, JTextArea o )
   {
      building = b;
      FLOOR = f;
      board = fcb;
      output = o;
      setLit( false );
   }

   public void pressButton()
   {
      setLit( true );
      output.append( "\nCALLBUTTON on FLOOR " + FLOOR + " is pushed." );
      board.activateLight();
      building.setElevatorDest( FLOOR );
   }

   public void resetButton()
   {
      if ( lit ) {
         setLit( false );
         board.deactivateLight();
         output.append( "\nCALLBUTTON on FLOOR " + FLOOR + " is turned off." );
      }
   }

   public void setLit( boolean isLit ) { lit = isLit; }

   public boolean isLit() { return lit; }
}