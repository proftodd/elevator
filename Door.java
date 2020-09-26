// Elevator Simulator: Door.java
// Describes the doors in the building
import javax.swing.JTextArea;

public abstract class Door {
   private boolean openState;
   public JTextArea output;

   public Door( boolean io, JTextArea o )
   {
      setOpen( io );
      output = o;
   }

   public abstract void open();
   public abstract void close();

   public void setOpen( boolean io ) { openState = io; }

   public boolean isOpen() { return openState; }
}