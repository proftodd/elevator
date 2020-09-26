// Elevator Simulator: Elevator.java
// Describes the elevator
import javax.swing.*;

public class Elevator extends Thread {
   private static int FLOORS;
   public Building building;
   private int currentFloor, destFloor;
   public DestButton destButton[];
   public ElevatorDoor elevatorDoor;
   private boolean occupied;
   public ElevatorApplet applet;
   public JTextArea output;

   public Elevator( Building b, ElevatorApplet ea, JTextArea o, int f )
   {
      building = b;
      applet = ea;
      output = o;
      FLOORS = f;
      currentFloor = 1;
      occupied = false;
      destButton = new DestButton[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) {
         destButton[ i ] = new DestButton( building, i, applet.eb, output );
      }
      elevatorDoor = new ElevatorDoor( output );
   }

   public void run()
   {
      while ( true ) {
         try {
            sleep( 1000 );
         } catch ( InterruptedException e ) {}
         if ( !building.isLightOn() && elevatorDoor.isOpen() ) {
            elevatorDoor.close();
            building.floor[ currentFloor ].floorDoor.close();
         } 
         if ( building.isLightOn() ) {
            departFloor( building.getElevatorDest() );
         }
      }
   }

   public void arriveAtFloor()
   {
      if ( destButton[ currentFloor ].isLit() ) { destButton[ currentFloor ].resetButton(); }
      elevatorDoor.open();
      building.floor[ currentFloor ].floorDoor.open();
   }

   public void departFloor( int destination )
   {
      if ( destination == currentFloor &&
           building.floor[ currentFloor ].callButton.isLit() ) {
         arriveAtFloor();
      } else {
         if ( elevatorDoor.isOpen() ) { elevatorDoor.close(); }
         if ( building.floor[ currentFloor ].floorDoor.isOpen() )
            { building.floor[ currentFloor ].floorDoor.close(); }
         moveElevator( destination );
      }
   }

   public void moveElevator( int destination )
   {
      String someOutput = "\nELEVATOR moving from FLOOR " + currentFloor;
      currentFloor = destination;
      someOutput += " to FLOOR " + currentFloor;
      output.append( someOutput );
      building.clock.setTicking( true );
      while ( true ) {
         if ( !building.clock.isTicking() ) {
            arriveAtFloor();
            break;
         }
      }
   }

   public void setOccupied( boolean occ )
   {
      occupied = occ;
      output.append( "\nThe ELEVATOR is " + ( occupied ? "occupied." : "not occupied." ) );
   }

   public int getCurrentFloor() { return currentFloor; }
}