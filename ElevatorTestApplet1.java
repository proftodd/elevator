// Elevator Simulator: ElevatorTestApplet1.java
// Tests the FloorBell, FloorLight, and DestButton classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorTestApplet1 extends JApplet implements ActionListener {
   public JLabel thisLabel;
   public JButton rfb1, rfb2, afl1, dfl1, iofl1, afl2, dfl2, iofl2, pdb1, rdb1, iodb1,
                  pdb2, rdb2, iodb2, pcb1, rcb1, iocb1, pcb2, rcb2, iocb2;
   public JTextArea output;
   public JScrollPane scroller;
   public JPanel thisPanel;
   public FloorBell fb1, fb2;
   public FloorLight fl1, fl2;
   public ElevatorButton db1, db2, cb1, cb2;

   public void init()
   {
      Container c = getContentPane();

      output = new JTextArea( 20, 20 );
      scroller = new JScrollPane( output );
      c.add( scroller, BorderLayout.EAST );

      thisPanel = new JPanel();
      thisPanel.setLayout( new GridLayout( 7, 3, 5, 5 ) );

      thisLabel = new JLabel( "Testing FloorBell, ElevatorButton, and FloorLight" );
      thisPanel.add( thisLabel );

      rfb1 = new JButton( "ringFloorBell1()" );
      rfb1.addActionListener( this );
      thisPanel.add( rfb1 );

      rfb2 = new JButton( "ringFloorBell2()" );
      rfb2.addActionListener( this );
      thisPanel.add( rfb2 );

      afl1 = new JButton( "activateFloorLight1()" );
      afl1.addActionListener( this );
      thisPanel.add( afl1 );

      dfl1 = new JButton( "deactivateFloorLight1()" );
      dfl1.addActionListener( this );
      thisPanel.add( dfl1 );

      iofl1 = new JButton( "isOn()" );
      iofl1.addActionListener( this );
      thisPanel.add( iofl1 );

      afl2 = new JButton( "activateFloorLight2()" );
      afl2.addActionListener( this );
      thisPanel.add( afl2 );

      dfl2 = new JButton( "deactivateFloorLight2()" );
      dfl2.addActionListener( this );
      thisPanel.add( dfl2 );

      iofl2 = new JButton( "isOn()" );
      iofl2.addActionListener( this );
      thisPanel.add( iofl2 );

      pdb1 = new JButton( "pressDestButton1()" );
      pdb1.addActionListener( this );
      thisPanel.add( pdb1 );

      rdb1 = new JButton( "resetDestButton1()" );
      rdb1.addActionListener( this );
      thisPanel.add( rdb1 );

      iodb1 = new JButton( "isOn()" );
      iodb1.addActionListener( this );
      thisPanel.add( iodb1 );

      pdb2 = new JButton( "pressDestButton2()" );
      pdb2.addActionListener( this );
      thisPanel.add( pdb2 );

      rdb2 = new JButton( "resetDestButton2()" );
      rdb2.addActionListener( this );
      thisPanel.add( rdb2 );

      iodb2 = new JButton( "isOn()" );
      iodb2.addActionListener( this );
      thisPanel.add( iodb2 );

      pcb1 = new JButton( "pressCallButton1()" );
      pcb1.addActionListener( this );
      thisPanel.add( pcb1 );

      rcb1 = new JButton( "resetCallButton1()" );
      rcb1.addActionListener( this );
      thisPanel.add( rcb1 );

      iocb1 = new JButton( "isOn()" );
      iocb1.addActionListener( this );
      thisPanel.add( iocb1 );

      pcb2 = new JButton( "pressCallButton2()" );
      pcb2.addActionListener( this );
      thisPanel.add( pcb2 );

      rcb2 = new JButton( "resetCallButton2()" );
      rcb2.addActionListener( this );
      thisPanel.add( rcb2 );

      iocb2 = new JButton( "isOn()" );
      iocb2.addActionListener( this );
      thisPanel.add( iocb2 );

      c.add( thisPanel, BorderLayout.CENTER );

      fb1 = new FloorBell( 1, output );
      fb2 = new FloorBell( 2, output );

      fl1 = new FloorLight( 1, output );
      fl2 = new FloorLight( 2, output );

      db1 = new ElevatorButton( 1, output );
      db2 = new ElevatorButton( 2, output );

      cb1 = new ElevatorButton( 1, output );
      cb2 = new ElevatorButton( 2, output );
  }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == rfb1 ) {
         fb1.ringFloorBell();
      }

      if ( e.getSource() == rfb2 ) {
         fb2.ringFloorBell();
      }

      if ( e.getSource() == afl1 ) {
         fl1.activateFloorLight();
      }

      if ( e.getSource() == dfl1 ) {
         fl1.deactivateFloorLight();
      }

      if ( e.getSource() == iofl1 ) {
         output.append( "\nFloor Light 1 is " + ( ( fl1.isOn() ) ? "on." : "off." ) );
      }

      if ( e.getSource() == afl2 ) {
         fl2.activateFloorLight();
      }

      if ( e.getSource() == dfl2 ) {
         fl2.deactivateFloorLight();
      }

      if ( e.getSource() == iofl2 ) {
         output.append( "\nFloor Light 2 is " + ( ( fl2.isOn() ) ? "on." : "off." ) );
      }

      if ( e.getSource() == pdb1 ) {
         db1.pressButton();
      }

      if ( e.getSource() == rdb1 ) {
         db1.resetButton();
      }

      if ( e.getSource() == iodb1 ) {
         output.append( "\nDestination button 1 is " + ( ( db1.isOn() ) ? "on." : "off." ) );
      }

      if ( e.getSource() == pdb2 ) {
         db2.pressButton();
      }

      if ( e.getSource() == rdb2 ) {
         db2.resetButton();
      }

      if ( e.getSource() == iodb2 ) {
         output.append( "\nDestination button 2 is " + ( ( db2.isOn() ) ? "on." : "off." ) );
      }

      if ( e.getSource() == pcb1 ) {
         cb1.pressButton();
      }

      if ( e.getSource() == rcb1 ) {
         cb1.resetButton();
      }

      if ( e.getSource() == iocb1 ) {
         output.append( "\nCall button 1 is " + ( ( cb1.isOn() ) ? "on." : "off." ) );
      }

      if ( e.getSource() == pcb2 ) {
         cb2.pressButton();
      }

      if ( e.getSource() == rcb2 ) {
         cb2.resetButton();
      }

      if ( e.getSource() == iocb2 ) {
         output.append( "\nCall button 2 is " + ( ( cb2.isOn() ) ? "on." : "off." ) );
      }

   }
}