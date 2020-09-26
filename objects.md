# building
The *building* has two *floors*, an *elevator*, and *person*s.
​
# elevator
The *elevator* moves back and forth between the two *floor*s in the *building*. It has *elevator doors*, two destination *button*s and can hold one *person*. The *elevator* has two possible directions, "up" and "down". When a *person* pushes a call *button* on a *floor*, the *elevator* closes its *elevator door*s and that *floor*'s *floor door*s, moves to the destination *floor*, and signals its arrival by ringing a floor *bell* and opening its *elevator door*s and the *floor door*s. When a *person* boards the *elevator* and pushes a destination *button*, the *elevator* closes its *elevator door*s and the current floor’s *floor door*s and moves to the destination *floor*. The *elevator* always knows its current *floor* and its destination *floor*. When the *elevator* reaches a *floor*, the call *button* and elevator *button* corresponding to that *floor* are reset (turned off), the *floor door*s and *elevator door*s open, and the *person* exits the *elevator*.
​
# person
A *person* arrives on a *floor* and pushes the call *button* for the *elevator*. When the *elevator* arrives and opens its *elevator door*s and the *floor door*s, the *person* boards the *elevator* and pushes a destination *button* for his or her destination. The *person* cannot enter or exit the *elevator* if the *elevator door*s or the *floor door*s are closed. When the *elevator* arrives at its destination *floor•, the *person* exits the *elevator* and disappears. The *person* always knows its current *floor* and its destination *floor*.
​
# elevator doors
The *elevator door*s open when the *elevator* arrives at a *floor* and close when the *elevator* moves to another *floor*. *elevator door*s have two states, "open" and "closed" and two actions, **open** and **close**.
​
# floor
A *floor* holds *person*s. The *floor* has *floor door*s, a *call button*, a *floor light*, and a *floor bell*.
​
# call/floor button
The *call button*s signal the *elevator* to come to that *floor*. Each *call button* has two states, "on" and "off". A *call button* is turned on by a *person* and turned off when the *elevator* arrives on that *floor*.
​
# floor doors
The *floor door*s open when the *elevator* arrives at a *floor* and close when the *elevator* moves to another *floor*. *floor door*s have two states, "open" and "closed", and two actions, **open** and **close**.
​
# floor light
A *floor light* goes on over the *floor door*s when the *elevator* arrives at a *floor* and turns off when the *elevator* leaves a *floor*. Each *floor light* has two states, "on" and "off".
​
# floor bell
A *floor bell* goes off when the *elevator* arrives at a *floor*.
​
# destination/elevator button
A *destination button* tells the *elevator* where to go next. Each *destination button* has two states, "on" and "off". A *person* turns the *destination button* on. The *destination button* is turned off when the *elevator* arrives at that *floor*.