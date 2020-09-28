package org.jtodd.elevator;

// Elevator Simulator: Door.java
// Describes the doors in the building
import javax.swing.JTextArea;

public abstract class Door {
   private boolean openState = false;
   public JTextArea output;

   public Door( JTextArea o ) { output = o; }

   public abstract void open();
   public abstract void close();

   public void setOpen( boolean io ) { openState = io; }

   public boolean isOpen() { return openState; }
}