// Elevator Simulator: ElevatorDoor.java
// Describes the elevator doors
import javax.swing.JTextArea;

public class ElevatorDoor extends Door {

   public ElevatorDoor( JTextArea o ) { super( o ); }

   public void open()
   {
      setOpen( true );
      super.output.append( "\nELEVATORDOOR opens." );
   }

   public void close()
   {
      setOpen( false );
      super.output.append( "\nELEVATORDOOR closes." );
   }
}