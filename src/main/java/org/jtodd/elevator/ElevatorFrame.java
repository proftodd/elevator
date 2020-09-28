package org.jtodd.elevator;

// Elevator Simulator: ElevatorApplet.java
// Driver applet to run the elevator simulator. Version 4.0
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorFrame extends JFrame implements ActionListener {
   private Container container;
   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints;
   public ClockTimer clock;
   public FloorCanvas fCanvas[];
   public FloorControlBoard fcb[];
   public ElevatorCanvas eCanvas;
   public ElevatorControlBoard eb;
   public JTextArea output;
   public JScrollPane scroller;
   public JButton f[];
   public Building b;
   public static final int FLOORS = 2;

   public void createAndShowGui()
   {
      container = getContentPane();
      gbLayout = new GridBagLayout();
      container.setLayout( gbLayout );

      // instantiate gridbag constraints
      gbConstraints = new GridBagConstraints();
      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;

      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;
      output = new JTextArea( 15, 35 );
      scroller = new JScrollPane( output );
      addComponent( scroller, ( FLOORS + 1 ), 0, 4, 1 );

      clock = new ClockTimer( output );
      clock.setBackground( Color.white );

      fCanvas = new FloorCanvas[ ( FLOORS + 1 ) ];
      fcb = new FloorControlBoard[ ( FLOORS + 1 ) ];
      for ( int i = 1; i <= FLOORS; i++ ) {
         fCanvas[ i ] = new FloorCanvas( i );
         fCanvas[ i ].setBackground( Color.white );
         fcb[ i ] = new FloorControlBoard();
         fcb[ i ].setBackground( Color.white );
      }

      eCanvas = new ElevatorCanvas();
      eCanvas.setBackground( Color.white );

      eb = new ElevatorControlBoard( ( FLOORS + 1 ) );
      eb.setBackground( Color.white );

      gbConstraints.fill = GridBagConstraints.BOTH;
      addComponent( clock, 0, 0, 1, FLOORS );
      for ( int i = 1; i <= FLOORS; i++ ) {
         addComponent( fCanvas[ i ], ( FLOORS - i ), 1, 1, 1 );
      }
      addComponent( eCanvas, 0, 2, 1, FLOORS );

      JPanel controlButtonPanel = new JPanel();
      controlButtonPanel.setLayout( new GridLayout( ( FLOORS + 1 ), 1 ) );
      controlButtonPanel.add( fcb[ 2 ] );
      controlButtonPanel.add( eb );
      controlButtonPanel.add( fcb[ 1 ] );
      addComponent( controlButtonPanel, 0, 3, 1, FLOORS );

      gbConstraints.weightx = 0;
      gbConstraints.weighty = 0;
      JPanel addPersonButtonPanel = new JPanel();
      f = new JButton[ ( FLOORS + 1 ) ];
      f[ 1 ] = new JButton( "Floor 1" );
      f[ 1 ].addActionListener( this );
      f[ 2 ] = new JButton( "Floor 2" );
      f[ 2 ].addActionListener( this );
      addPersonButtonPanel.setLayout( new FlowLayout() );
      addPersonButtonPanel.add( f[ 1 ] );
      addPersonButtonPanel.add( f[ 2 ] );
      addComponent( addPersonButtonPanel, FLOORS, 0, 4, 1 );

      b = new Building( this, FLOORS, clock, output );

      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(new Dimension(700, 550));
      this.setVisible(true);
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
      if ( e.getSource() == f[ 1 ] ) {
         b.floor[ 1 ].createPerson( 2 );
      } else if ( e.getSource() == f[ 2 ] ) {
         b.floor[ 2 ].createPerson( 1 );
      }
   }

   public void stop() {
      b.elevator = null;
      clock = null;
   }
}