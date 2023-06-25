import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class GesturePanel extends JPanel {

    GeneralPath path;

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        if (path != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(path);
        }
    }
}
