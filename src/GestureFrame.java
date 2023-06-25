import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class GestureFrame extends JFrame implements MouseInputListener {

    GesturePanel inputArea;
    JLabel gestureText;
    JLabel debugText;

    GestureFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mouse Gesture Drawing");
        setSize(400,400);
        setLayout(null);
        setVisible(true);

        gestureText = new JLabel();
        gestureText.setText("Gesture input here");
        gestureText.setBounds(0,200,200,20);
        add(gestureText);

        inputArea = new GesturePanel();
        inputArea.setSize(200,200);
        inputArea.setBackground(Color.LIGHT_GRAY);
        inputArea.setOpaque(true);
        inputArea.addMouseListener(this);
        inputArea.addMouseMotionListener(this);
        add(inputArea);

        debugText = new JLabel();
        debugText.setBounds(0,300,300,100);
        add(debugText);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /// TODO: 25.06.2023 einbauen, dass wenn feld verlassen wir, aufzeichnung endet
        //System.out.println("draaaag");
        debugText.setText("Mouse momentan: " + e.getX() + " " + e.getY());
        inputArea.path.lineTo(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("mmoooove");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("click");
        System.out.println(inputArea.getBorder());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("press");
        inputArea.path = new GeneralPath();
        inputArea.path.moveTo(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("released");
        inputArea.path.lineTo(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("gone");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("back");
    }
}
