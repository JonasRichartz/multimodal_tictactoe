import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class GestureFrame extends JFrame implements MouseInputListener {

    GesturePanel inputArea;
    JLabel gestureText;
    JLabel debugText;
    ArrayList<Double> pathAngles;
    ArrayList<Point> pathPoints;
    Point startingPoint;

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

        pathAngles = new ArrayList<>();
        pathPoints = new ArrayList<>();

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /// TODO: 25.06.2023 einbauen, dass wenn feld verlassen wir, aufzeichnung endet oder so
        debugText.setText("Mouse Position: " + e.getX() + " " + e.getY());
        inputArea.path.lineTo(e.getX(), e.getY());
        addAngle(e.getX(), e.getY());
        pathPoints.add(e.getPoint());
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
        pathAngles.clear();
        pathPoints.clear();
        startingPoint = e.getPoint();
        pathPoints.add(e.getPoint());
        inputArea.path.moveTo(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("released");
        inputArea.path.lineTo(e.getX(), e.getY());
        addAngle(e.getX(), e.getY());
        pathPoints.add(e.getPoint());
        repaint();
        System.out.println(pathAngles);
        double max = 0;
        for (Double pathAngle : pathAngles) {
            if (pathAngle > max && !pathAngle.isNaN())
                max = pathAngle;
        }
        System.out.println(max);
    }

    // anzahl messpunkte festsetzen -> interpolieren oder löschen von messpunkten, so dass es gleich ist
    // winkelabfolge von templates abspeichern 

    private void addAngle(int x, int y) {
        Point lastAdded = pathPoints.get(pathPoints.size()-1);
        double startOld = Math.sqrt(Math.pow((lastAdded.y - startingPoint.y), 2) + Math.pow((lastAdded.x - startingPoint.x), 2));   //Strecke zwischen dem alten Punkt und dem Startpunkt
        double oldNew = Math.sqrt(Math.pow((y - lastAdded.y), 2) + Math.pow((x - lastAdded.x), 2));                                 //zwischen alt und neuem punkt
        double startNew = Math.sqrt(Math.pow((y - startingPoint.y), 2) + Math.pow((x - startingPoint.x), 2));                       //zwischen start und neuem punkt
        if (oldNew == 0){
            pathAngles.add(0.0);
            return;
        }

        double angle = Math.acos((Math.pow(startOld, 2) + Math.pow(oldNew, 2) - Math.pow(startNew, 2))/(2*startOld*oldNew))*180/Math.PI; //winkel gesetz zeug (*180/pi um auf grad zahlen zu kommen)
        if (angle < 0) {
            angle += 360; // negative winkel positiv machen
        }

        pathAngles.add(angle);

        //Formel aus Aufgabenstellung 5. b)
        /*if (Math.abs(x - y) < Math.PI) {
            pathAngles.add((Math.abs(x - y))/Math.PI);
        } else {
            pathAngles.add((2*Math.PI - (Math.abs(x - y))) / Math.PI);
        }*/
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
