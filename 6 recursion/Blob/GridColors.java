package Blob;

//Solution to programming exercise 1, Section 6, Chapter 05
import java.awt.Color;
/**
 * An interface for colors
 * @author Koffman and Wolfgang
 */
public interface GridColors {
    Color PATH = new Color(121, 209, 236);
    Color IN_BLOB = PATH;
    Color BACKGROUND = Color.white;
    Color NON_BACKGROUND = Color.gray;
    Color ABNORMAL = NON_BACKGROUND;
    Color TEMPORARY = Color.black;
}