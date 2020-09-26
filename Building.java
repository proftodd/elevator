// Elevator Simulator: Building.java
// Describes the building
import javax.swing.*;

public class Building {
   public ElevatorApplet applet;
   private final int FLOORS;
   public Floor floor[];
   public Elevator elevator;
   public ClockTimer clock;
   public JTextArea output;
   private int elevatorDest;

   public Building( ElevatorApplet ea, int f, ClockTimer c, JTextArea o )
   {
      applet = ea;
      FLOORS = f;
      clock = c;
      output = o;
      elevator = new Elevator( this, applet, output, FLOORS );
      floor = new Floor[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) {
         floor[ i ] = new Floor( this, applet, output, i );
      }
      elevator.start();
   }

   public boolean isLightOn()
   {
      boolean isOn = false;
      for( int i = 1; i <= FLOORS; i++ ) {
         isOn = isOn || floor[ i ].callButton.isLit();
         isOn = isOn || elevator.destButton[ i ].isLit();
      }
      return isOn;
   }

   public void setElevatorDest( int f ) { elevatorDest = f; }

   public int getElevatorDest() { return elevatorDest; }
}