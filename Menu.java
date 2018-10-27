import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Menu{
    /**
    The main method creates a MenuFrame called frame and makes it visible.

    @param String args
    @return void
    */
    public static void main(String[] args){
        MenuFrame frame = new MenuFrame();
        frame.setVisible(true);
    }
}

class MenuFrame extends JFrame{
    /**
    MenuFrame is a child class of JFrame. It creates a MenuPanel named panel.
    */
    MenuPanel panel = new MenuPanel();

    public MenuFrame(){
        /**
        MenuFrame's constructor sets the defualt close operation, sets the size of the frame to 700 x 700, adds panel to the frame, and
        calls displayMenu().

        @param nothing
        @return nothing
        */
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        setSize(700,700);
        add(panel);
    }
    public void displayMenu(){
        /**
        displayMenu() is a method which creates and sets a JMenuBar called menuBar. It adds ColorMenu to menuBar before setting it.

        @param nothing
        @return void
        */
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new ColorMenu());
        setJMenuBar(menuBar);
    }
    private class ColorMenu extends JMenu{
        public ColorMenu(){
            /**
            ColorMenu is a JMenu named Color Menu that, for each BackgroundColor within the BackgroundColor enum, creates a JMenuItem menuItem
            named that color's name followed by "Background". To each menuItem an ActionListener is added which is the BackgroundColorListener
            taking that specific color as an input. The menu Item is then added to ColorMenu.

            @param nothing
            @return nothing
            */
            super("Color Menu");
            for(BackgroundColor color : BackgroundColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name() + " Background");
                menuItem.addActionListener(new BackgroundColorListener(color));
                add(menuItem);
            }
        }
    }
    private class BackgroundColorListener implements ActionListener{
        /**
        BackgroundColorListener is an action listener which contains the private BackgroundColor color. The constructor for this
        class takes a BackgroundColor as an input and assigns it to this class's BackgroundColor color. When the action is triggered,
        the panel's Background is set to the color given by the color() method the private BackgroundColor color.
        */
        private BackgroundColor color;
        public void actionPerformed(ActionEvent e){
            /**
            see BackgroundColorListener for explanation
            @param ActionEvent e
            @return void
            */
            panel.setBackground(color.color());
        }
        public BackgroundColorListener(BackgroundColor color){
            /**
            see BackgroundColorListener for explanation
            @param BackgroundColor color
            @return nothing
            */
            this.color = color;
        }
    }
}

class MenuPanel extends JPanel{
    public MenuPanel(){
        /**
        This empty child class exists only to make a renamed version of JPanel. It does nothing JPanel does not already do.
        It is quite possibly the saddest class I have ever written.

        @param nothing
        @return nothing
        */
    }
}
