// Elevator Simulator: DestButton.java
// Describes the destination buttons in the elevator
import javax.swing.*;

public class DestButton extends ElevatorButton {

   public DestButton( Elevator e, int f, JTextArea o )
   {
      super( e, f, o );
   }

   public void pressButton()
   {
      setLit( true );
      super.output.append( "\nDestination Button for floor " + targetFloor +
                           " has been pushed." );
      elevator.moveElevator( targetFloor );
   }

   public void resetButton()
   {
      if ( super.lit ) {
         setLit( false );
         super.output.append( "\nDestination Button for floor " + targetFloor +
                              " has turned off." );
      }
   }
}