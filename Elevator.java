// Elevator Simulator: Elevator.java
// Describes the elevator
import javax.swing.*;

public class Elevator {
   public int floors;
   public Building building;
   public int currentFloor, destFloor;
   public DestButton destButton[];
   public ElevatorDoor elevatorDoor;
   public boolean occupied;
   public JTextArea output;

   public Elevator( Building b, JTextArea o, int f )
   {
      building = b;
      output = o;
      floors = f;
      currentFloor = 1;
      occupied = false;
      destButton = new DestButton[ ( floors + 1 ) ];
      for ( int i = 1; i <= floors; i++ ) {
         destButton[ i ] = new DestButton( this, i, output );
      }
      elevatorDoor = new ElevatorDoor( true, output );
   }

   public void moveElevator( int destination )
   {
      destFloor = destination;
      if ( destFloor == currentFloor ) {
         building.floor[ currentFloor ].floorDoor.open();
         elevatorDoor.open();
         building.floor[ currentFloor ].callButton.resetButton();
         building.person.boardElevator();
      } else {
         building.floor[ currentFloor ].floorDoor.close();
         elevatorDoor.close();
         building.floor[ currentFloor ].floorLight.deactivateFloorLight();
         building.floor[ destFloor ].floorLight.activateFloorLight();
         elevatorDoor.open();
         building.floor[ destFloor ].floorDoor.open();
         building.floor[ destFloor ].callButton.resetButton();
         destButton[ destFloor ].resetButton();
         currentFloor = destFloor;
         if ( occupied ) {
            building.person.exitElevator();
            if ( !building.floor[ currentFloor ].callButton.isOn() ) {
               elevatorDoor.close();
               building.floor[ currentFloor ].floorDoor.close();
            }
         } else {
            building.person.boardElevator();
         }
      }
   }

   public void setOccupied( boolean occ )
   {
      occupied = occ;
      output.append( "\nThe ELEVATOR is " + ( ( occupied ) ? "occupied." : "not occupied." ) );
   }
}