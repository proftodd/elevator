package org.jtodd.elevator;

// Elevator Simulator: Elevator.java
// Describes the elevator
import javax.swing.*;

public class Elevator extends Thread {
   private static int FLOORS;
   public Building building;
   private int currentFloor, destFloor;
   public DestButton destButton[];
   public ElevatorDoor elevatorDoor;
   public ElevatorCanvas canvas;
   private boolean occupied;
   private boolean moving;
   private int direction;
   public ElevatorFrame frame;
   public JTextArea output;

   public Elevator( Building b, ElevatorFrame frame, JTextArea o, int f )
   {
      building = b;
      this.frame = frame;
      output = o;
      FLOORS = f;
      currentFloor = 1;
      occupied = false;
      moving = false;
      destButton = new DestButton[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) {
         destButton[ i ] = new DestButton( building, i, frame.eb, output );
      }
      elevatorDoor = new ElevatorDoor( frame.eCanvas, output );
      canvas = frame.eCanvas;
      frame.clock.registerElevator( this );
      frame.clock.registerECanvas( canvas );
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
      moving = false;
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
      direction = ( destination - currentFloor ) > 0 ? -1 : 1;
      String someOutput = "\nELEVATOR moving from FLOOR " + currentFloor;
      currentFloor = destination;
      someOutput += " to FLOOR " + currentFloor;
      output.append( someOutput );
      moving = true;
      building.clock.setTicking( true );
      while ( true ) {
         if ( !building.clock.isTicking() ) {
            arriveAtFloor();
            break;
         }
      }
   }

   public void setOccupied( Person p )
   {
      occupied = true;
      canvas.addPerson( p );
      output.append( "\nThe ELEVATOR is occupied." );
   }

   public void setUnoccupied()
   {
      occupied = false;
      canvas.removePerson();
      output.append( "\nThe ELEVATOR is not occupied." );
   }

   public int getCurrentFloor() { return currentFloor; }

   public int getDirection() { return direction; }

   public boolean isMoving() { return moving; }
}