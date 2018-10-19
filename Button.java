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
        frame.setVisible(true);
    }
}

class ButtonFrame extends JFrame{
    static ButtonPanel panel = new ButtonPanel();

    private String pressedKey;

    public ButtonFrame(){
        super("Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        add(panel);
    }

    class KeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            pressedKey = e.getKeyText(e.getKeyCode());
            panel.charArray.add(pressedKey);
            panel.addLetter();
        }
    }

}

class ButtonPanel extends JPanel{
    public ArrayList<String> charArray = new ArrayList<String>();
    private ArrayList<Integer> x_Array = new ArrayList<Integer>();
    private ArrayList<Integer> y_Array = new ArrayList<Integer>();

    private int x;
    private int y;

    private String line;
    private int x_location;
    private int y_location;


    public ButtonPanel(){
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON3){
                    reset();
                }
            }
        });
    }

    public void addLetter(){
        x = (int)(Math.random() * 690);
        x_Array.add(x);
        y = (int)(Math.random() * 690);
        y_Array.add(y);
        repaint();
    }

    public void reset(){
        charArray.clear();
        x_Array.clear();
        y_Array.clear();
        repaint();
    }

    public void paintComponent(Graphics g){
        for(int i = 0; i < x_Array.size(); i++){
            line = charArray.get(i);
            x_location = x_Array.get(i);
            y_location = y_Array.get(i);
            g.drawString(line, x, y);
        }
    }
}
