import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public enum BackgroundColor{
    /**
    BackgroundColor enum is an enumeration containing all of the possible break background colors that can be used by the program. These colors
    are Red, Green, and Blue. This also contains a variable color of type Color. The constructor takes in a Color and assigns it to the
    variable color. The color() method returns the variable color.
    */
    Red(Color.RED), Green(Color.GREEN), Blue(Color.BLUE);
    public Color color;

    BackgroundColor(Color color){
        /**
        See enum for explanation
        @param Color color
        @return nothing
        */
        this.color = color;
    }
    Color color(){
        /**
        See enum for explanation
        @param nothing
        @return Color color
        */
        return color;
    }
}
