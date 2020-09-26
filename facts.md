# Building
- Attributes
  - has two floors
  - has an elevator
- Behaviors
  - none

# Floor
- Attributes
  - has floor doors
  - has floor light
  - has floor bell
  - has call button
  - has persons (one at a time)
- Behaviors
  - none

# Elevator
- Attributes
  - only moves when necessary
  - current floor
  - destination floor
  - directions- up and down
  - has two destination buttons
  - has elevator doors
- Behaviors
  - moveElevator(): Moves the elevator between floors. Requires as an argument the destination floor. 
- Method Calls Sent to Other Classes
  - Elevator sends boardElevator() method call to the Person
  - Elevator sends closeFloorDoors() method call to the FloorDoors
  - Elevator sends closeElevatorDoors() method call to the Elevator Doors
  - Elevator sends deactivateFloorLight() to the current Floor’s FloorLight
  - Elevator sends activateFloorLight() to the destination Floor’s FloorLight
  - Elevator sends openElevatorDoors() method call to the Elevator Doors
  - Elevator sends openFloorDoors() method call to the FloorDoors
  - Elevator sends exitElevator() method call to the Person
  - Elevator sends resetCallButton() method call to the CallButton
  - Elevator sends resetDestinationButton() method call to the DestinationButton
  - Elevator sets its current Floor to the destination Floor

# Person 
- Attributes
  - current floor, randomly determined
  - destination floor, never creation floor
- Behaviors
  - When created, calls pressDestinationButton() (class DestinationButton).
  - boardElevator() Causes the person to board the elevator. Calls pressDestinationButton() (class DestinationButton).
  - exitElevator() Causes the person to exit the elevator. Person is destroyed when this method is called.
- Method Calls Sent to Other Classes
  - Person sends the isOn() method call to the CallButton
  - Person sends the pressCallButton() method call to the CallButton
  - Person sends isOpen() method call to the FloorDoors
  - Person sends isOpen() method call to the ElevatorDoors
  - Person sends the isOn() method call to the DestinationButton
  - Person sends the pressDestinationButton() method call to the DestinationButton

# ElevatorDoors
- Attributes
  - open or closed
- Behaviors
  - openElevatorDoors() Causes the elevator doors to open. Called by class Elevator.
  - closeElevatorDoors() Causes the elevator doors to close. Called by class Elevator.
  - isOpen() Returns whether the doors are open or closed. Called by the Person to determine if it can board or not.
- Method Calls Sent to Other Classes
  - none

# FloorDoors
- Attributes
  - open or closed
- Behaviors
  - openFloorDoors() Causes the floor doors to open. Called by class Elevator.
  - closeFloorDoors() Causes the floor doors to close. Called by class Elevator.
  - isOpen() Returns whether the doors are open or closed. Called by the Person to determine if it can board or not.
- Method Calls Sent to Other Classes
  - none

# CallButton
- Attributes
  - on or off
- Behaviors
  - pressCallButton() Summons the Elevator. Called by a Person. Calls moveElevator() (class Elevator) and passes it the destination floor as an argument.
  - resetCallButton() Turns the CallButton off. Called by the Elevator.
  - isOn() Returns whether the button is lit or not. Called by the Elevator.
- Method Calls Sent to Other Classes
  - CallButton sends the moveElevator() method call to the Elevator

# DestinationButton
- Attributes
  - on or off
- Behaviors
  - pressDestButton() Tells the elevator where to go. Called by a Person. Calls moveElevator() (class Elevator) and passes it the destination floor as an argument.
  - resetDestButton() Turns the DestinationButton off. Called by the Elevator.
  - isOn() Returns whether the button is lit or not. Called by the Elevator.
- Method Calls Sent to Other Classes
  - CallButton sends the moveElevator() method call to the Elevator

# FloorLight
- Attributes
  - on or off
- Behaviors
  - activateFloorLight() Turns the FloorLight on. Called by the Elevator when it arrives at the floor.
  - deactivateFloorLight() Turns the FloorLight off. Called by the Elevator when it leaves the floor.
  - isOn() Returns whether the button is lit or not. Called by the Elevator.

# FloorBell
- Attributes
- Behaviors
  - ringFloorBell() Rings a bell. Called by the Elevator when it arrives at a floor.
