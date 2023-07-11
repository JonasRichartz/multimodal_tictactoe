import javafx.scene.transform.MatrixType;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GestureFrame extends JFrame implements MouseInputListener {
    
    GesturePanel panel_inputArea;
    JLabel label_gestureText;
    JLabel label_debugText;
    ArrayList<Point> pathPoints;
    GestureDeclaration gestureDeclaration;
    GameController gameController;
    
    GestureFrame(GameController gController){

        gameController = gController;

        //define variables for functional use
        pathPoints = new ArrayList<>();
        gestureDeclaration = new GestureDeclaration();
        
        //define variables for UI use
        ImageIcon icon_frame = new ImageIcon("src/Icons/icons8-tic-tac-toe-48.png");
        JPanel panel_north = new JPanel();
        JPanel panel_south = new JPanel();
        JPanel panel_east = new JPanel();
        JPanel panel_west = new JPanel();

        Color custom_lightBlue = new Color(180,200,220); // color for background

        //frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gesture-Input");
        setSize(400,400);
        setLayout(new BorderLayout());
        setIconImage(icon_frame.getImage());
        setVisible(false);
        //setLocation(200, 200);
        
        //panels
        panel_north.setBackground(custom_lightBlue);
        panel_south.setBackground(custom_lightBlue);
        panel_east.setBackground(custom_lightBlue);
        panel_west.setBackground(custom_lightBlue);

        panel_north.setPreferredSize(new Dimension(50,50));
        panel_south.setPreferredSize(new Dimension(50,50));
        panel_east.setPreferredSize(new Dimension(50,50));
        panel_west.setPreferredSize(new Dimension(50,50));

        panel_inputArea = new GesturePanel(); //center panel
        panel_inputArea.setPreferredSize(new Dimension(250,250));
        panel_inputArea.setBackground(Color.WHITE);
        panel_inputArea.setOpaque(true);
        panel_inputArea.addMouseListener(this);
        panel_inputArea.addMouseMotionListener(this);
        panel_inputArea.setBorder(new LineBorder(Color.BLACK, 5, false));

        //labels
        label_gestureText = new JLabel();
        label_gestureText.setText("Gesture input here");
        label_gestureText.setFont(new Font("Comic Sans MS", Font.BOLD,25));
        label_gestureText.setForeground(Color.BLACK);

        label_debugText = new JLabel();
        label_debugText.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        label_debugText.setForeground(Color.BLACK);

        //add labels to panels
        panel_south.add(label_debugText, new GridBagConstraints());
        panel_north.add(label_gestureText, new GridBagConstraints());

        //add panels to frame
        add(panel_north,BorderLayout.NORTH);
        add(panel_south,BorderLayout.SOUTH);
        add(panel_east,BorderLayout.EAST);
        add(panel_west,BorderLayout.WEST);
        add(panel_inputArea,BorderLayout.CENTER);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /// TODO: 25.06.2023 einbauen, dass wenn feld verlassen wir, aufzeichnung endet oder so
        label_debugText.setText("Mouse position: " + e.getX() + " " + e.getY());
        panel_inputArea.path.lineTo(e.getX(), e.getY());
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
        //System.out.println(panel_inputArea.getBorder());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("press");
        panel_inputArea.path = new GeneralPath();
        pathPoints.clear();
        pathPoints.add(e.getPoint());
        panel_inputArea.path.moveTo(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("released");
        panel_inputArea.path.lineTo(e.getX(), e.getY());
        pathPoints.add(e.getPoint());
        String debugText = "Identified gesture: ";

        //interpret gesture
        if(pathPoints.size()<10) {
            debugText = "More input required";
        }else {
            if (!gameController.gameUI.mmi_active) {
                //execute dtw
                int dtw_value = dtw(gestureDeclaration.gestureArray_angles);
                double endX = pathPoints.get(pathPoints.size() - 1).getX() - pathPoints.get(0).getX();
                double endY = pathPoints.get(pathPoints.size() - 1).getY() - pathPoints.get(0).getX();

                //straight line identified
                if (dtw_value == 0) {
                    if (Math.abs(endX) > Math.abs(endY)) {
                        if (endX > 0) {
                            debugText += "Middle right";
                            gameController.gameUI.buttons[5].doClick();
                        } else {
                            debugText += "Middle left";
                            gameController.gameUI.buttons[3].doClick();
                        }
                    } else {
                        if (endY > 0) {
                            debugText += "Bottom middle";
                            gameController.gameUI.buttons[7].doClick();
                        } else {
                            debugText += "Top middle";
                            gameController.gameUI.buttons[1].doClick();
                        }
                    }
                }
                //corner identified
                if (dtw_value == 1) {
                    if (endX > 0) {
                        if (endY > 0) {
                            debugText += "Bottom right";
                            gameController.gameUI.buttons[8].doClick();
                        } else {
                            debugText += "Top right";
                            gameController.gameUI.buttons[2].doClick();
                        }
                    } else {
                        if (endY > 0) {
                            debugText += "Bottom left";
                            gameController.gameUI.buttons[6].doClick();
                        } else {
                            debugText += "Top left";
                            gameController.gameUI.buttons[0].doClick();
                        }
                    }
                }
                if (dtw_value == 2) {
                    debugText += "Center";
                    gameController.gameUI.buttons[4].doClick();
                }
                if (dtw_value == 3) {
                    debugText += "Start new game";
                    gameController.gameUI.button_reset.doClick();
                }
                if (dtw_value == 4) {
                    debugText += "Quit game";
                    System.exit(0);
                }
            }else{
                //mmi is active!
                //execute dtw
                int dtw_value = dtw(gestureDeclaration.gestureArray_angles_mmi);
                double endX = pathPoints.get(pathPoints.size() - 1).getX() - pathPoints.get(0).getX();
                double endY = pathPoints.get(pathPoints.size() - 1).getY() - pathPoints.get(0).getX();

                //straight line identified
                if (dtw_value == 0) {
                    if (Math.abs(endX) > Math.abs(endY)) {
                        if (endX > 0) {
                            debugText += "Middle right";
                            gameController.gameUI.mmiFrame.buttons[5].doClick();
                        } else {
                            debugText += "Middle left";
                            gameController.gameUI.mmiFrame.buttons[3].doClick();
                        }
                    } else {
                        if (endY > 0) {
                            debugText += "Bottom middle";
                            gameController.gameUI.mmiFrame.buttons[7].doClick();
                        } else {
                            debugText += "Top middle";
                            gameController.gameUI.mmiFrame.buttons[1].doClick();
                        }
                    }
                }
                //corner identified
                if (dtw_value == 1) {
                    if (endX > 0) {
                        if (endY > 0) {
                            debugText += "Bottom right";
                            gameController.gameUI.mmiFrame.buttons[8].doClick();
                        } else {
                            debugText += "Top right";
                            gameController.gameUI.mmiFrame.buttons[2].doClick();
                        }
                    } else {
                        if (endY > 0) {
                            debugText += "Bottom left";
                            gameController.gameUI.mmiFrame.buttons[6].doClick();
                        } else {
                            debugText += "Top left";
                            gameController.gameUI.mmiFrame.buttons[0].doClick();
                        }
                    }
                }
                if (dtw_value == 2) {
                    debugText += "Center";
                    gameController.gameUI.mmiFrame.buttons[4].doClick();
                }
                if (dtw_value == 3) {
                    debugText += "Start new game";
                    gameController.gameUI.mmiFrame.button_newGame.doClick();
                }
                if (dtw_value == 4) {
                    debugText += "Quit game";
                    gameController.gameUI.mmiFrame.button_stop.doClick();
                }
                if (dtw_value == 5) {
                    debugText += "Place";
                    gameController.gameUI.mmiFrame.button_place.doClick();
                }
                if (dtw_value == 6) {
                    debugText += "Action";
                    gameController.gameUI.mmiFrame.button_action.doClick();
                }
                if (dtw_value == 7) {
                    debugText += "x";
                    gameController.gameUI.mmiFrame.button_x.doClick();
                }
                if (dtw_value == 8) {
                    debugText += "o";
                    gameController.gameUI.mmiFrame.button_o.doClick();
                }
            }
        }
        label_debugText.setText(debugText);
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

    public int dtw(double [][] predefinedGestureArray){

        //DTW algorithm

        double[] currentPathX = new double[pathPoints.size()];
        double[] currentPathY = new double[pathPoints.size()];
        double[] costAngles = new double[predefinedGestureArray.length];

        //remove duplicates
        for(int i= 1; i<pathPoints.size(); i++) {
            if(pathPoints.get(i).getX() == pathPoints.get(i-1).getX() && pathPoints.get(i).getY() == pathPoints.get(i-1).getY()) {
                pathPoints.remove(i);
                i-=1;
            }
        }

        //get relative current path for X and Y values
        for (int i = 0; i < pathPoints.size(); i++) {

            currentPathX[i] = pathPoints.get(i).getX() - pathPoints.get(0).getX();
            currentPathY[i] = pathPoints.get(i).getY() - pathPoints.get(0).getY();
        }

        //get angles for path
        double [] currentAngles = new double[pathPoints.size()-2];

        for (int i= 0; i<pathPoints.size()-2; i++) {

            //note that 0.01 is added to the sides to avoid NaN-Error
            double a = (Math.sqrt(Math.pow(currentPathX[i+1],2) + Math.pow(currentPathY[i+1],2)))+0.01;
            double b = (Math.sqrt(Math.pow(currentPathX[i+1] - currentPathX[i+2],2) + Math.pow(currentPathY[i+1] - currentPathY[i+2],2)))+0.01;
            double c = (Math.sqrt(Math.pow(currentPathX[i+2],2) + Math.pow(currentPathY[i+2],2)))+0.01;

            double angle_c = Math.round((Math.acos((Math.pow(c,2)-(Math.pow(a,2))-Math.pow(b,2))/(-2*a*b)))*(180/3.14));
            double angle_b = (Math.acos((Math.pow(b,2)-(Math.pow(a,2))-Math.pow(c,2))/(-2*a*c)))*(180/3.14);
            double angle_a = (Math.acos((Math.pow(a,2)-(Math.pow(c,2))-Math.pow(b,2))/(-2*c*b)))*(180/3.14);
            currentAngles[i]=angle_c;
            //System.out.print(angle_c + ", ");
        }
        //dtw algorithm for X values
        for(int x=0; x<predefinedGestureArray.length; x++) {
            double[] testAngles = predefinedGestureArray[x];

            int n = currentAngles.length;
            int m = testAngles.length;

            double[][] matrix_X = new double[n + 1][m + 1];
            for (int i = 1; i < n + 1; i++) {
                matrix_X[i][0] = 1000000;
            }
            for (int i = 1; i < m + 1; i++) {
                matrix_X[0][i] = 1000000;
            }
            matrix_X[0][0] = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    matrix_X[i][j] = Math.abs(currentAngles[i - 1] - testAngles[j - 1]) + Math.min(Math.min(matrix_X[i - 1][j - 1], matrix_X[i][j - 1]), matrix_X[i - 1][j]);
                }
            }
            //System.out.println("Abweichung X" + matrix_X[n][m]);
            costAngles[x] = matrix_X[n][m];
        }
        double min_cost = costAngles[0];
        int counter = 0;
        for(int i=1; i<costAngles.length; i++) {
            if (costAngles[i] < min_cost){
                min_cost = costAngles[i];
                counter = i;
            }
        }
        return counter;
    }
}
