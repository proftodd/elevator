// Elevator Simulator: ElevatorApplet.java
// Driver applet to run the elevator simulator. Version 2.0
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorApplet extends JApplet implements ActionListener {
   private Container container;
   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints;
   public JTextArea output;
   public JScrollPane scroller;
   private JButton f1, f2;
   public Building b;
   public static final int FLOORS = 2;

   public void init()
   {
      container = getContentPane();
      gbLayout = new GridBagLayout();
      container.setLayout( gbLayout );

      // instantiate gridbag constraints
      gbConstraints = new GridBagConstraints();
      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;

      ClockTimer clock = new ClockTimer();
      clock.setBackground( Color.white );

      FloorCanvas floor[] = new FloorCanvas[ ( FLOORS + 1 ) ];
      FloorControlBoard fcb[] = new FloorControlBoard[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) {
         floor[ i ] = new FloorCanvas();
         floor[ i ].setBackground( Color.white );
         fcb[ i ] = new FloorControlBoard();
         fcb[ i ].setBackground( Color.white );
      }

      ElevatorCanvas elevator = new ElevatorCanvas();
      elevator.setBackground( Color.white );

      ElevatorControlBoard eb = new ElevatorControlBoard();
      eb.setBackground( Color.white );

      gbConstraints.fill = GridBagConstraints.BOTH;
      addComponent( clock, 0, 0, 1, FLOORS );
      for ( int i = 1; i <= FLOORS; i++ ) {
         addComponent( floor[ i ], ( i - 1 ), 1, 1, 1 );
      }
      addComponent( elevator, 0, 2, 1, FLOORS );

      JPanel controlButtonPanel = new JPanel();
      controlButtonPanel.setLayout( new GridLayout( ( FLOORS + 1 ), 1 ) );
      controlButtonPanel.add( fcb[ 1 ] );
      controlButtonPanel.add( eb );
      controlButtonPanel.add( fcb[ 2 ] );
      addComponent( controlButtonPanel, 0, 3, 1, FLOORS );

      gbConstraints.weightx = 0;
      gbConstraints.weighty = 0;
      JPanel addPersonButtonPanel = new JPanel();
      f1 = new JButton( "Floor 1" );
      f1.addActionListener( this );
      f2 = new JButton( "Floor 2" );
      f2.addActionListener( this );
      addPersonButtonPanel.setLayout( new FlowLayout() );
      addPersonButtonPanel.add( f1 );
      addPersonButtonPanel.add( f2 );
      addComponent( addPersonButtonPanel, FLOORS, 0, 4, 1 );

      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;
      output = new JTextArea( 15, 35 );
      scroller = new JScrollPane( output );
      addComponent( scroller, ( FLOORS + 1 ), 0, 4, 1 );

      b = new Building( FLOORS, output );
   }

   //addComponent is programmer defined
   private void addComponent( Component c, int row, int column, int width, int height )
   {
      // set gridx and gridy
      gbConstraints.gridx = column;
      gbConstraints.gridy = row;

      // set gridwidth and gridheight
      gbConstraints.gridwidth = width;
      gbConstraints.gridheight = height;

      // set constraints
      gbLayout.setConstraints( c, gbConstraints );
      container.add( c );
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == f1 ) {
         b.createPerson( 1, 2 );
      } else {
         b.createPerson( 2, 1 );
      }
   }
}