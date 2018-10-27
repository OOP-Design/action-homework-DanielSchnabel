import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Circle{
    public static void main(String[] args){
        /**
        The main method creates the CFrame frame and CPanel panel. It adds panel to frame, sets frame's defualt close operation as well as
        making it visible.

        @param String args
        @return void
        */
        CFrame frame = new CFrame();
        CPanel panel = new CPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class CFrame extends JFrame{
    /**
    CFrame is a child class of JFrame. It's constructor sets the size of the frame to 700 x 700.

    @param nothing
    @return nothing
    */
    public CFrame(){
        super("Circle Game");
        setSize(700,700);
    }
}
class CPanel extends JPanel{
    /**
    CPanel is a child class of JPanel. It creates four integers: x_circle and y_circle correspond to the
    x and y coordinates of the drawing to be made. x_dia and y_dia correspond to the diameter of the circle.
    */
    int x_circle = 200;
    int y_circle = 200;
    int x_dia = 100;
    int y_dia = 100;

    public CPanel(){
        /**
        The CPanel constructor adds a MouseMotionListener as an anonymous inner class. This creates two local variables, x_mouse and y_mouse,
        which correspond to the x and y coordinates of the mouse pointer. These values and the circle's coordinates are then put into
        the disance formula, where the mouse's location is subtracted from the circle location plus a certain number of points nessessary to
        center the detection area with the circle. If these values ever become less than or equal to 50 (the radius of the circle), a new
        pair of coordinates for the circle are randomly generated and paintComponent is called to remake the circle at those new points
        via repaint().

        @param nothing
        @return nothing
        */
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
        /**
        The paintComponent uses the Graphics class to draw a circle. It sets the circles color to red and uses x_circle, y_circle ,x_dia,
        and y_dia in their corresponding position as agruments for the fillOval() method to create a circle.

        @param Graphics g
        @return void
        */
        g.setColor(Color.RED);
        g.fillOval(x_circle, y_circle ,x_dia, y_dia);
    }
}
