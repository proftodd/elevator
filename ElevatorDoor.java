// Elevator Simulator: ElevatorDoor.java
// Describes the elevator doors
import javax.swing.JTextArea;

public class ElevatorDoor extends Door {
   private ElevatorCanvas canvas;

   public ElevatorDoor( ElevatorCanvas ec, JTextArea o )
   {
      super( o );
      canvas = ec;
   }

   public void open()
   {
      setOpen( true );
      canvas.setOpen( true );
      super.output.append( "\nELEVATORDOOR opens." );
   }

   public void close()
   {
      setOpen( false );
      canvas.setOpen( false );
      super.output.append( "\nELEVATORDOOR closes." );
   }
}