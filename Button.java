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
    }
}

class ButtonFrame extends JFrame{
    public ButtonFrame(){
        super("Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setVisible(true);
        addKeyListener(new KeyAdapter){
            public void keyPressed(keyEvent e){
                String pressedKey = e.getKeyText(e.getKeyCode());

            }
        }
        addMouseMotionListener(new MouseAdapter()){
            public void mouseClicked(MouseEvent e){

            }
        }
    }

}

class ButtonPanel extends JPanel{
    private ArrayList<String> charArray = new ArrayList<String>();
    private ArrayList<Integer> x_Array = new ArrayList<String>();
    private ArrayList<Integer> y_Array = new ArrayList<String>();
    
    public ButtonPanel(){
    }

    public void reset(int button){
        if(button == 3){

        }
    }

    public void paintComponent(Graphics g){

    }
}
