// Elevator Simulator: ElevatorButton.java
// Describes the buttons in the building
import javax.swing.*;

public abstract class ElevatorButton {
   boolean lit;
   int targetFloor;
   Elevator elevator;
   JTextArea output;

   public ElevatorButton( Elevator e, int f, JTextArea o )
   {
      elevator = e;
      targetFloor = f;
      output = o;
      setLit( false );
   }

   public void setLit( boolean isLit ) { lit = isLit; }

   public abstract void pressButton();
   public abstract void resetButton();

   public boolean isOn() { return lit; }
}