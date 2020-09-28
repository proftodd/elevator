package org.jtodd.elevator;

// Elevator Simulator: Person.java
// Describes the persons who move between floors
import javax.swing.*;

public class Person extends Thread {
   private int currentFloor, destFloor, personX, personY, index;
   private ImageIcon personIcon;
   private Building building;
   private JTextArea output;
   private boolean arriving, departing, riding, finished;

   public Person( Building b, JTextArea o, int c, int d, int x, int y, int i )
   {
      building = b;
      output = o;
      currentFloor = c;
      destFloor = d;
      personX = x;
      personY = y;
      index = i;
      personIcon = new ImageIcon( getClass().getResource(
         "/images/person" + (index > 9 ? "" : "0") + index + ".gif"
      ) );
      arriving = true;
      departing = false;
      riding = false;
      finished = false;
   }

   public void run()
   {
      output.append( "\nNew PERSON created. Current FLOOR = " + currentFloor + 
                     " Destination FLOOR = " + destFloor );
      while( !finished ) {
         try {
            sleep( 20 );
         } catch( InterruptedException e ) {}
         if( arriving ) {
            if( personX < building.floor[ currentFloor ].canvas.getWidth() - 20 ) {
               personX++;
               building.floor[ currentFloor ].canvas.paintArrivingPerson( this );
            } else {
               if( building.floor[ currentFloor ].floorDoor.isOpen() ) {
                  building.floor[ currentFloor ].canvas.eraseArrivingPerson();
                  boardElevator();
               } else {
                  if ( !building.floor[ currentFloor ].callButton.isLit() ) {
                     building.floor[ currentFloor ].callButton.pressButton();
                  }
               }
            }
         }
         if( riding ) {
            if( building.elevator.elevatorDoor.isOpen() &&
                building.elevator.getCurrentFloor() == destFloor ) {
               exitElevator();
            }
         }
         if( departing ) {
           if( personX > 20 ) {
               personX--;
               building.floor[ destFloor ].canvas.paintDepartingPerson( this );
            } else {
               departing = false;
               finished = true;
               building.floor[ destFloor ].canvas.eraseDepartingPerson();
               output.append( "\n***END PERSON***" );
            }
         }
      }
   }

   public void boardElevator()
   {
      arriving = false;
      riding = true;
      output.append( "\nPERSON boards ELEVATOR." );
      building.floor[ currentFloor ].enableButton();
      building.elevator.setOccupied( this );
      building.elevator.destButton[ destFloor ].pressButton();
      personX = building.elevator.canvas.getPersonX();
      personY = building.elevator.canvas.getPersonY();
   }

   public void exitElevator()
   {
      riding = false;
      departing = true;
      output.append( "\nPERSON exits ELEVATOR." );
      building.elevator.setUnoccupied();
      personX = building.floor[ destFloor ].canvas.getWidth();
      personY = building.floor[ destFloor ].canvas.getPersonY();
   }

   public ImageIcon getImage() { return personIcon; }

   public int getX() { return personX; }

   public int getY() { return personY; }

   public void setY( int y ) { personY = y; }
}