import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Button{
    /**
    The Button class, which contains the main method. The main method creates a button frame and sets it visibility to true.

    @param String args
    @return void
    */
    public static void main(String[] args){
        ButtonFrame frame = new ButtonFrame();
        frame.setVisible(true);
    }
}

class ButtonFrame extends JFrame{
    /**
    The ButtonFrame is a child class of JFrame and creates a ButtonPanel called panel.
    */
    static ButtonPanel panel = new ButtonPanel();


    public ButtonFrame(){
        /**
        The ButtonFrame constructor adds a KeyListener as an anonymous inner class. When a key is pressed, the keycode is converted into a
        string added to panel's charArray. Then panel's addLetter method is called. The constructor also sets the close operation, the
        size of the frame, removes resizing, and adds panel to the frame.

        @param nothing
        @return nothing
        */
        super("Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setResizable(false);
        add(panel);

        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                panel.charArray.add(e.getKeyText(e.getKeyCode()));
                panel.addLetter();
            }
        });
    }

}

class ButtonPanel extends JPanel{
    /**
    The ButtonPanel is a child class of JPanel and creates three ArrayLists. One of the ArrayLists, charArray, holds strings.
    It should be noted that charArray holds strings despite ostensibly holding characters, as it's name might imply,
    because .getKeyText() in the KetListener in ButtonFrame and drawString() in paintComponent both require strings,
    but since .getKeyText() will only return one letter (and therefore only one letter will be printed by drawString())
    the list is really holding characters in the format of strings, hence the name charArray.
    x_Array and y_Array hold integers, corresponding to x and y coordinates respectively.
    */
    public ArrayList<String> charArray = new ArrayList<String>();
    private ArrayList<Integer> x_Array = new ArrayList<Integer>();
    private ArrayList<Integer> y_Array = new ArrayList<Integer>();


    public ButtonPanel(){
        /**
        The ButtonPanel constructor adds a MouseListener as an anonymous inner class. When the mouse is clicked, the reset() method is called.

        @param nothing
        @return nothing
        */
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON3){
                    reset();
                }
            }
        });
    }

    public void addLetter(){
        /**
        The addLetter() method adds random numbers to x_Array and y_Array and calls the paintComponent via repaint().
        These random numbers are offset from the maximum frame size to help avoid having characters getting placed offscreen.

        @param nothing
        @return void
        */
        x_Array.add((int)(Math.random() * 680));
        y_Array.add((int)(Math.random() * 680));
        repaint();
    }

    public void reset(){
        /**
        The reset() method clears all three of the ArrayLists using their .clear() method. It them calls the paintComponent via repaint().

        @param nothing
        @return void
        */
        charArray.clear();
        x_Array.clear();
        y_Array.clear();
        repaint();
    }

    public void paintComponent(Graphics g){
        /**
        The paintComponent uses the Graphics class to draw a string. Because one set of x and y coordinates are created for each key press
        and the coordinates are added to ArrayLists the same order as the keypresses, the i-th place of each coordinate will always be the
        same. Whenever paintComponent is called, a for loop increments integer i by one for each entry in x_Array, Graphics drawString()
        will then draw a string using i-th entry in each array.

        @param Graphics g
        @return void
        */
        super.paintComponent(g);
        for(int i = 0; i < x_Array.size(); i++){
            g.drawString(charArray.get(i), x_Array.get(i), y_Array.get(i));
        }
    }
}
