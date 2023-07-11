import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MmiFrame extends JFrame implements ActionListener {
    GameController gameController;
    Timer timer;
    TimerTask timerTask_cancelMmi;

    JButton[] buttons;
    JButton button_place;
    JButton button_x;
    JButton button_o;
    JButton button_action;
    JButton button_newGame;
    JButton button_stop;

    Color custom_lightBlue;
    Color custom_green;
    Color custom_lightGray;
    Color custom_red;
    Color custom_blue;

    AudioPlayer audioPlayer;

    public MmiFrame(GameController gController) {
        gameController = gController;
        audioPlayer = new AudioPlayer();

        //define Timer and TimerTasks
        timer = new Timer();
        timerTask_cancelMmi = new TimerTask() {
            @Override
            public void run() {
                resetMmiInput();
            }
        };

        //define variables for UI use
        ImageIcon icon_frame = new ImageIcon("src/Icons/icons8-tic-tac-toe-48.png");
        ImageIcon icon_stop = new ImageIcon("src/Icons/icons8-stop-48.png");
        ImageIcon icon_newGame = new ImageIcon("src/Icons/icons8-memories-48.png");

        JPanel panel_north = new JPanel();
        JPanel panel_south = new JPanel();
        JPanel panel_east = new JPanel();
        JPanel panel_west = new JPanel();
        JPanel panel_center = new JPanel();

        custom_lightBlue = new Color(180,200,220); // color for background
        custom_lightGray = new Color (225,225,225); //color  for button
        custom_red = new Color(230, 45, 45); //color for x
        custom_blue = new Color(25, 100, 250); //color for o
        custom_green = new Color(40,150,40); // color if draw

        //frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Point-and-Click-Input");
        setSize(400,400);
        setLayout(new BorderLayout());
        setIconImage(icon_frame.getImage());
        setVisible(false);
        setLocation(0, 400);

        //panels
        panel_north.setBackground(custom_lightBlue);
        panel_south.setBackground(custom_lightBlue);
        panel_east.setBackground(custom_lightBlue);
        panel_west.setBackground(custom_lightBlue);
        panel_center.setBackground(Color.BLACK);

        panel_north.setPreferredSize(new Dimension(400,60));
        panel_south.setPreferredSize(new Dimension(400,60));
        panel_east.setPreferredSize(new Dimension(60,400));
        panel_west.setPreferredSize(new Dimension(60,400));
        panel_center.setPreferredSize(new Dimension(280,280));

        panel_center.setLayout(new GridLayout(3,3,3,3));
        panel_north.setLayout(new FlowLayout());
        panel_south.setLayout(new FlowLayout());

        panel_center.setBorder(new LineBorder(Color.BLACK, 3, false));

        //buttons
        button_place = new JButton();
        button_x = new JButton();
        button_o = new JButton();
        button_action = new JButton();
        button_newGame = new JButton();
        button_stop = new JButton();

        buttons = new JButton[9];
        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            panel_center.add(buttons[i]);
            buttons[i].setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBorder(new LineBorder(Color.BLACK, 1, false));
            buttons[i].setEnabled(false);
        }

        buttons[0].setText("<html><center>Top<br />Left</center></html>");
        buttons[1].setText("<html><center>Top<br />Middle</center></html>");
        buttons[2].setText("<html><center>Top<br />Right</center></html>");
        buttons[3].setText("<html><center>Middle<br />Left</center></html>");
        buttons[4].setText("<html><center>Center</center></html>");
        buttons[5].setText("<html><center>Middle<br />Left</center></html>");
        buttons[6].setText("<html><center>Bottom<br />Left</center></html>");
        buttons[7].setText("<html><center>Bottom<br />Middle</center></html>");
        buttons[8].setText("<html><center>Bottom<br />Right</center></html>");

        button_place.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button_place.setText("Place");
        button_place.setBackground(custom_lightGray);
        button_place.setForeground(Color.BLACK);
        button_place.setFocusable(false);
        button_place.setHorizontalAlignment(SwingConstants.CENTER);
        button_place.setVerticalAlignment(SwingConstants.CENTER);
        button_place.addActionListener(this);
        button_place.setPreferredSize(new Dimension(100,50));
        button_place.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_place.setEnabled(true);

        button_x.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button_x.setText("X");
        button_x.setBackground(custom_lightGray);
        button_x.setForeground(Color.BLACK);
        button_x.setFocusable(false);
        button_x.setHorizontalAlignment(SwingConstants.CENTER);
        button_x.setVerticalAlignment(SwingConstants.CENTER);
        button_x.addActionListener(this);
        button_x.setPreferredSize(new Dimension(50,50));
        button_x.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_x.setEnabled(false);

        button_o.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button_o.setText("O");
        button_o.setBackground(custom_lightGray);
        button_o.setForeground(Color.BLACK);
        button_o.setFocusable(false);
        button_o.setHorizontalAlignment(SwingConstants.CENTER);
        button_o.setVerticalAlignment(SwingConstants.CENTER);
        button_o.addActionListener(this);
        button_o.setPreferredSize(new Dimension(50,50));
        button_o.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_o.setEnabled(false);

        button_action.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button_action.setText("Action");
        button_action.setBackground(custom_lightGray);
        button_action.setForeground(Color.BLACK);
        button_action.setFocusable(false);
        button_action.setHorizontalAlignment(SwingConstants.CENTER);
        button_action.setVerticalAlignment(SwingConstants.CENTER);
        button_action.addActionListener(this);
        button_action.setPreferredSize(new Dimension(100,50));
        button_action.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_action.setEnabled(true);

        button_newGame.setBackground(custom_lightGray);
        button_newGame.setForeground(Color.BLACK);
        button_newGame.setFocusable(false);
        button_newGame.setHorizontalAlignment(SwingConstants.CENTER);
        button_newGame.setVerticalAlignment(SwingConstants.CENTER);
        button_newGame.addActionListener(this);
        button_newGame.setPreferredSize(new Dimension(50,50));
        button_newGame.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_newGame.setEnabled(false);
        button_newGame.setIcon(icon_newGame);

        button_stop.setBackground(custom_lightGray);
        button_stop.setForeground(Color.BLACK);
        button_stop.setFocusable(false);
        button_stop.setHorizontalAlignment(SwingConstants.CENTER);
        button_stop.setVerticalAlignment(SwingConstants.CENTER);
        button_stop.addActionListener(this);
        button_stop.setPreferredSize(new Dimension(50,50));
        button_stop.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_stop.setEnabled(false);
        button_stop.setIcon(icon_stop);

        //add buttons to panels

        panel_north.add(button_place);
        panel_north.add(button_x);
        panel_north.add(button_o);
        panel_south.add(button_action);
        panel_south.add(button_newGame);
        panel_south.add(button_stop);

        //add panels to frame
        add(panel_north,BorderLayout.NORTH);
        add(panel_south,BorderLayout.SOUTH);
        add(panel_east,BorderLayout.EAST);
        add(panel_west,BorderLayout.WEST);
        add(panel_center,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i=0; i<buttons.length; i++){
            if (actionEvent.getSource() == buttons[i]) {
                gameController.gameUI.buttons[i].doClick();
                resetMmiInput();
                if(gameController.game_over) {
                    button_place.setEnabled(false);
                }
            }
        }
        if(actionEvent.getSource().equals(button_place)) {
            audioPlayer.playSound("src/Audio/Button.wav");
            resetMmiInput();
            if(button_place.getBackground() == custom_lightGray) {
                button_place.setBackground(custom_green);
                timer.schedule(timerTask_cancelMmi, 10000);
                if(gameController.turn_x) {
                    button_x.setEnabled(true);
                }else{
                    button_o.setEnabled(true);
                }
            }else{
                button_place.setBackground(custom_lightGray);
            }
        }

        if(actionEvent.getSource() == button_x) {
            audioPlayer.playSound("src/Audio/Button.wav");
            if(button_x.getBackground() == custom_lightGray) {
                button_x.setBackground(custom_red);
                for(JButton b : buttons) {
                    for(int i=0; i<buttons.length; i++) {
                        if(gameController.gameUI.buttons[i].getText().equals("")) {
                            buttons[i].setEnabled(true);
                        }
                    }
                }
            }else{
                button_x.setBackground(custom_lightGray);
                for(JButton b : buttons) {
                    b.setEnabled(false);
                }
            }
        }
        if(actionEvent.getSource() == button_o) {
            audioPlayer.playSound("src/Audio/Button.wav");
            if(button_o.getBackground() == custom_lightGray) {
                button_o.setBackground(custom_blue);
                for(int i=0; i<buttons.length; i++) {
                    if(gameController.gameUI.buttons[i].getText().equals("")) {
                        buttons[i].setEnabled(true);
                    }
                }
            }else{
                button_o.setBackground(custom_lightGray);
                for(JButton b : buttons) {
                    b.setEnabled(false);
                }
            }
        }
        if(actionEvent.getSource() == button_action) {
            audioPlayer.playSound("src/Audio/Button.wav");
            resetMmiInput();
            if(button_action.getBackground() == custom_lightGray) {
                button_action.setBackground(custom_green);
                timer.schedule(timerTask_cancelMmi, 10000);
                button_newGame.setEnabled(true);
                button_stop.setEnabled(true);
            }else{
                button_action.setBackground(custom_lightGray);
            }
        }
        if(actionEvent.getSource() == button_newGame) {
            resetMmiInput();
            button_place.setEnabled(true);
            gameController.gameUI.button_reset.doClick();
        }
        if(actionEvent.getSource() == button_stop) {
            audioPlayer.playSound("src/Audio/Button.wav");
            System.exit(0);
        }
    }
    public void resetMmiInput(){
        //function to reset Buttons and timer after timer runs out or action is completed
        JButton[] allButtons = {button_place, button_x, button_o, button_o, button_action, button_newGame, button_stop};
        for(JButton b : allButtons){
            b.setBackground(custom_lightGray);
        }
        for(JButton b: buttons){
            b.setEnabled(false);
        }
        button_x.setEnabled(false);
        button_o.setEnabled(false);
        button_newGame.setEnabled(false);
        button_stop.setEnabled(false);

        resetTimer();
    }

    public void resetTimer(){
        timer.cancel();
        timer.purge();
        timer = new Timer();
        timerTask_cancelMmi = new TimerTask() {
            @Override
            public void run() {
                resetMmiInput();
            }
        };
    }
}
