// Elevator Simulator: Building.java
// Describes the building
import javax.swing.*;

public class Building {
   public int floors;
   public Floor floor[];
   public Elevator elevator;
   public JTextArea output;
   public Person person;

   public Building( int f, JTextArea o )
   {
      floors = f;
      output = o;
      elevator = new Elevator( this, output, floors );
      floor = new Floor[ ( floors + 1 ) ];
      for ( int i = 1; i <= floors; i++ ) {
         floor[ i ] = new Floor( this, output, i );
      }
   }

   public void createPerson( int c, int d )
   {
      person = new Person( this, output, c, d );
      person.begin();
   }
}