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
   private int numPersons;
   private int elevatorDest;
   public ThreadGroup person;
   public Person personPosition[];		// array to track where each person is
							// personPosition[ 0 ] = elevator
							// personPosition[ 1 ] = first floor
							// personPosition[ 2 ] = second floor, etc.
							// In this version of the simulator, there can
							// be a maximum of one person on each floor, plus
							// one in the elevator, so this array has a size of
							// ( FLOORS + 1 ).
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
      person = new ThreadGroup( "Persons" );
      personPosition = new Person[ ( FLOORS + 1 ) ];
      elevator.start();
   }

   public void createPerson( int c, int d )
   {
      if ( floor[ c ].getNumPersons() >= 1 ) {
         JOptionPane.showMessageDialog( null, "Only one person may occupy\n" +
                                              "a floor at a time.",
                                        "Error", JOptionPane.ERROR_MESSAGE );
      } else {
         floor[ c ].setNumPersons( floor[ c ].getNumPersons() + 1 );
         personPosition[ c ] = new Person( "Persons", this, output, c, d );
         personPosition[ c ].start();
      }
   }

   public int getNumPersons() { return person.activeCount(); }

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