// Elevator Simulator: Person.java
// Describes the persons who move between floors
import javax.swing.*;

public class Person {
   int currentFloor, destFloor;
   Building building;
   JTextArea output;

   public Person( Building b, JTextArea o, int c, int d )
   {
      building = b;
      output = o;
      currentFloor = c;
      destFloor = d;
   }

   public void begin()
   {
      output.append( "\nNew PERSON created. Current FLOOR = " + currentFloor + 
                     " Destination FLOOR = " + destFloor );
      if ( building.floor[ currentFloor ].floorDoor.isOpen() ) {
         boardElevator();
      } else {
         building.floor[ currentFloor ].callButton.pressButton();
      }
   }

   public void boardElevator()
   {
      output.append( "\nPERSON boards ELEVATOR." );
      building.elevator.setOccupied( true );
      building.elevator.destButton[ destFloor ].pressButton();
   }

   public void exitElevator()
   {
      output.append( "\nPERSON exits ELEVATOR." );
      building.elevator.setOccupied( false );
      output.append( "\n\n***END PERSON***\n\n" );
   }
}