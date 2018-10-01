import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Button{
    public static void main(String[] args){
        ButtonFrame frame = new ButtonFrame();
        ButtonPanel panel = new ButtonPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}

class ButtonFrame extends JFrame{
    public ButtonFrame(){
        super("Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
    }
}

class ButtonPanel extends JPanel{
    public ArrayList<Character> charArray = new ArrayList<Character>();
    public ArrayList<Integer> x_Array = new ArrayList<Integer>();
    public ArrayList<Integer> y_Array = new ArrayList<Integer>();
    public int x;
    public int y;

    public ButtonPanel(){
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                String pressedKey = e.getKeyText(e.getKeyCode());
                charArray.add(pressedKey);
                repaint();
            }
        });
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON3){
                    reset();
                }
            }
        });
    }

    public void reset(){
        charArray.clear();
        x_Array.clear();
        y_Array.clear();
    }

    public void paintComponent(Graphics g){
        for(Character character : charArray.values()){
            x = (int)(Math.random() * 700);
            x_Array.add(x);
            y = (int)(Math.random() * 700);
            y_Array.add(y);
            String string = Character.toString(character);
            g.drawString(string, x, y);
        }
    }
}
