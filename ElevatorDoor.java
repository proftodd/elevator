// Elevator Simulator: ElevatorDoor.java
// Describes the elevator doors
import javax.swing.JTextArea;

public class ElevatorDoor extends Door {

   public ElevatorDoor( boolean io, JTextArea o )
   {
      super( io, o );
   }

   public void open()
   {
      setOpen( true );
      super.output.append( "\nElevator Doors open" );
   }

   public void close()
   {
      setOpen( false );
      super.output.append( "\nElevator Doors close" );
   }
}