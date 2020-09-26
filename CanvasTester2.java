// Elevator Simulator: CanvasTester2.java
// Driver application to test the elevator simulator GUI.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasTester2 extends JFrame {
   private Container container;
   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints;

   public CanvasTester2()
   {
      super( "Elevator Simulator GUI" );

      container = getContentPane();
      gbLayout = new GridBagLayout();
      container.setLayout( gbLayout );

      // instantiate gridbag constraints
      gbConstraints = new GridBagConstraints();
      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;

      ClockTimer clock = new ClockTimer();
      clock.setBackground( Color.white );

      FloorCanvas floor1 = new FloorCanvas();
      floor1.setBackground( Color.white );

      FloorCanvas floor2 = new FloorCanvas();
      floor2.setBackground( Color.white );

      ElevatorCanvas elevator = new ElevatorCanvas();
      elevator.setBackground( Color.white );

      FloorControlBoard fcb1 = new FloorControlBoard();
      fcb1.setBackground( Color.white );

      FloorControlBoard fcb2 = new FloorControlBoard();
      fcb2.setBackground( Color.white );

      ElevatorControlBoard eb = new ElevatorControlBoard();
      eb.setBackground( Color.white );

      gbConstraints.fill = GridBagConstraints.BOTH;
      addComponent( clock, 0, 0, 1, 2 );
      addComponent( floor1, 0, 1, 1, 1 );
      addComponent( floor2, 1, 1, 1, 1 );
      addComponent( elevator, 0, 2, 1, 2 );

      JPanel controlButtonPanel = new JPanel();
      controlButtonPanel.setLayout( new GridLayout( 3, 1 ) );
      controlButtonPanel.add( fcb1 );
      controlButtonPanel.add( eb );
      controlButtonPanel.add( fcb2 );
      addComponent( controlButtonPanel, 0, 3, 1, 2 );

      gbConstraints.weightx = 0;
      gbConstraints.weighty = 0;
      JPanel addPersonButtonPanel = new JPanel();
      JButton f1 = new JButton( "Floor 1" );
      JButton f2 = new JButton( "Floor 2" );
      addPersonButtonPanel.setLayout( new FlowLayout() );
      addPersonButtonPanel.add( f1 );
      addPersonButtonPanel.add( f2 );
      addComponent( addPersonButtonPanel, 2, 0, 4, 1 );

      gbConstraints.weightx = 1;
      gbConstraints.weighty = 1;
      JTextArea output = new JTextArea( 15, 35 );
      addComponent( output, 3, 0, 4, 1 );

      setSize( 608, 528 );
      show();
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

   public static void main( String args[] )
   {
      CanvasTester2 app = new CanvasTester2();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }
}