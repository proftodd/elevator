// Elevator Simulator: DestButton.java
// Describes the destination buttons in the elevator
// Attributes:
//    elevator
//    target floor number
//    ElevatorBoard for graphical output
//    JTextArea for text output
//    on or off
// Behaviors:
//    pressButton()
//       Tells the elevator where to go. Called by a Person.
//    resetDestButton()
//       Resets the button. Called by the Elevator.
//    setLit()
//       Utility method for altering the lit status
//    isLit()
//       Returns whether the button is lit or not. Called by the Elevator.
// Method Calls Sent to Other Classes:
//    moveElevator() to Elevator
//    activateButton() to ElevatorBoard
//    deactivateButton() to ElevatorBoard
import javax.swing.*;

public class DestButton {
   public Building building;
   public final int FLOOR;
   public ElevatorControlBoard board;
   public JTextArea output;
   public boolean lit;

   public DestButton( Building b, int f, ElevatorControlBoard eb, JTextArea o )
   {
      building = b;
      FLOOR = f;
      board = eb;
      output = o;
      setLit( false );
   }

   public void pressButton()
   {
      setLit( true );
      output.append( "\nDESTBUTTON for FLOOR " + FLOOR + " is pushed." );
      board.activateButton( FLOOR );
      building.setElevatorDest( FLOOR );
   }

   public void resetButton()
   {
      if ( lit ) {
         setLit( false );
         board.deactivateButton( FLOOR );
         output.append( "\nDESTBUTTON for FLOOR " + FLOOR + " is turned off." );
      }
   }

   public void setLit( boolean isLit ) { lit = isLit; }

   public boolean isLit() { return lit; }
}