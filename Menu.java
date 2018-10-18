import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Menu{
    public static void main(String[] args){
        MenuFrame frame = new MenuFrame();
        frame.setVisible(true);
    }
}

class MenuFrame extends JFrame{
    MenuPanel panel = new MenuPanel();
    public MenuFrame(){
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        setSize(700,700);
        add(panel);
    }
    public void displayMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new ColorMenu());
        setJMenuBar(menuBar);
    }
    private class ColorMenu extends JMenu{
        public ColorMenu(){
            super("Color Menu");
            for(BackgroundColor color : BackgroundColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name() + " Background");
                menuItem.addActionListener(new BackgroundColorListener(color));
                add(menuItem);
            }
        }
    }
    private class BackgroundColorListener implements ActionListener{
        private BackgroundColor color;
        public void actionPerformed(ActionEvent e){
           panel.setBackground(color.color());
        }
        public BackgroundColorListener(BackgroundColor color){
            this.color = color;
        }
    }
}

class MenuPanel extends JPanel{
    public MenuPanel(){
    }
}
