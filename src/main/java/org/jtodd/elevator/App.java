package org.jtodd.elevator;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String [] args) {
        SwingUtilities.invokeLater(() -> new ElevatorFrame().createAndShowGui());
    }
}
