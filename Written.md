## Exercise \#1
What is the difference between a ```KeyListener``` and a ```KeyAdapter```?

The KeyListener listens for keystokes, it generates a keyboard event whenever a key is pressed, released, or typed. KeyAdapter, on the other hand, is simply a convience method that creates empty keyPressed, keyReleased, and keyTyped methods that can be filled in as needed. This is becuase KeyListener requires all of these methods (even if they are blank) to operate, and KeyAdapter fills those in for the programmer. Implementing KeyAdapter instead of KeyListener simply saves a few lines of code in most cases.

## Exercise \#2
What is the difference between a ```MouseListener``` and a ```MouseMotionListener```.

MouseListener is used detect the key presses and/or releases of the mouse, as well as when the mouse enteres or exits a certain area. MouseMotionListener detects general mouse movements, when a button is held down or not.

## Exercise \#3
Given a ```MouseEvent```, Java has the ```getButton``` and ```getModifiersEx``` methods for determining which mouse buttons are pressed. Are both methods really needed, that is, do they differ in any way?

getButton simply and immediately returns the button that was pressed, while getModifiersEx returns a set of the buttons that were pressed and the order in which they were pressed. As a result, getButton might be more useful in a situation were a single press is all that is needed, while getModifiersEx is more useful is situation where continuous presses or multiple button presses are more important.

## Exercise \#4
What is meant by an event source, event listener, and event object?

The event source is the thing that produces the event, the event listener detects the event, and the event object is the class or object that will respond to the event and is generally made in referance to the object.

## Exercise \#5
What is the purpose of an anonymous inner class? What would one use an anonymous inner class for?

Anonymous inner classes allow for the addition of extra functions to a program without adding a seperate class. A good example would be "addactionlistener" which is helpful when the function it will preform is too small to justify giving the action listener it's own class. However, it would be a good idea to give action listeners or other anonymous inner classes which preform more complex tasks their own class.
