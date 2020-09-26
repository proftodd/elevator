// Elevator Simulator: CallButton.java
// Describes the call buttons on each floor in the building
import javax.swing.*;

public class CallButton extends ElevatorButton {

   public CallButton( Elevator e, int f, JTextArea o )
   {
      super( e, f, o );
   }

   public void pressButton()
   {
      setLit( true );
      super.output.append( "\nCall Button on floor " + targetFloor + " has been pushed." );
      elevator.moveElevator( targetFloor );
   }

   public void resetButton()
   {
      if ( super.lit ) {
         setLit( false );
         super.output.append( "\nCall Button on floor " + targetFloor + " has turned off." );
      }
   }
}