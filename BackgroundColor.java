import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public enum BackgroundColor{
    Red(Color.RED), Green(Color.GREEN), Blue(Color.BLUE);
    public Color color;

    BackgroundColor(Color color){
        this.color = color;
    }
    Color color(){
        return color;
    }
}
