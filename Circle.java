import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Circle{
    public static void main(String[] args){
        CFrame f = new CFrame();
        CPanel p = new CPanel();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
class CFrame extends JFrame{
    public CFrame(){
        super("Circle Game");
        setSize(700,700);
    }
}
class CPanel extends JPanel{
    int x_circle = 200;
    int y_circle = 200;
    int x_dia = 100;
    int y_dia = 100;

    public CPanel(){
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
                int x_mouse = (int) MouseInfo.getPointerInfo().getLocation().getX();
                int y_mouse = (int) MouseInfo.getPointerInfo().getLocation().getY();
                if(Math.sqrt(Math.pow((x_mouse - (x_circle+50)),2)+ Math.pow((y_mouse - (y_circle+100)),2)) <= 50){
                    x_circle = (int)(Math.random() * 600);
                    y_circle = (int)(Math.random() * 600);
                    repaint();
                }
            }
        });
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x_circle, y_circle ,x_dia, y_dia);
    }
}
