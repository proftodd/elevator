// Elevator Simulator: Person.java
// Describes the persons who move between floors
import javax.swing.*;

public class Person extends Thread {
   int currentFloor, destFloor;
   Building building;
   JTextArea output;

   public Person( String threadGroupName, Building b, JTextArea o, int c, int d )
   {
      super( threadGroupName );
      building = b;
      output = o;
      currentFloor = c;
      destFloor = d;
   }

   public void run()
   {
      output.append( "\nNew PERSON created. Current FLOOR = " + currentFloor + 
                     " Destination FLOOR = " + destFloor );
      while( true ) {
         try {
            sleep( 500 );
         } catch ( InterruptedException e ) {}
         if( building.floor[ currentFloor ].floorDoor.isOpen() ) {
            boardElevator();
            break;
         } else {
            if ( !building.floor[ currentFloor ].callButton.isLit() ) {
               building.floor[ currentFloor ].callButton.pressButton();
            }
         }
      }
   }

   public void boardElevator()
   {
      building.personPosition[ 0 ] = this;
      building.floor[ currentFloor ].setNumPersons( 
         building.floor[ currentFloor ].getNumPersons() - 1
      );
      output.append( "\nPERSON boards ELEVATOR." );
      building.elevator.setOccupied( true );
      building.elevator.destButton[ destFloor ].pressButton();
      while( true ) {
         if( building.elevator.elevatorDoor.isOpen() &&
             building.elevator.getCurrentFloor() == destFloor ) {
            exitElevator();
            break;
         }
      }
   }

   public void exitElevator()
   {
      output.append( "\nPERSON exits ELEVATOR." );
      building.elevator.setOccupied( false );
      output.append( "\n***END PERSON***" );
   }
}