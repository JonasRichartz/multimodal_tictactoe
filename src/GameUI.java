import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI implements ActionListener {

    JFrame frame = new JFrame();

    JPanel panel_north = new JPanel();
    JPanel panel_south = new JPanel();
    JPanel panel_east = new JPanel();
    JPanel panel_west = new JPanel();
    JPanel panel_center = new JPanel();

    JPanel panel_title = new JPanel();
    JPanel panel_turn = new JPanel();
    JPanel panel_speechInput = new JPanel();
    JPanel panel_player = new JPanel();
    JPanel panel_help = new JPanel();

    JButton[] buttons = new JButton[9];
    JButton button_reset = new JButton();
    JButton button_help = new JButton();
    JButton button_speechInput = new JButton();
    JButton button_player = new JButton();

    JLabel label_turn = new JLabel();
    JLabel label_title = new JLabel();

    Color custom_red = new Color(230, 45, 45); //color for x
    Color custom_blue = new Color(25, 100, 250); //color for o
    Color custom_green = new Color(40,150,40); // color if draw
    Color custom_lightBlue = new Color(180,200,220); // color for background
    Color custom_lightGray = new Color (225,225,225); //color  for "New Game" button

    ImageIcon icon_frame = new ImageIcon("src/Icons/icons8-tic-tac-toe-48.png");
    ImageIcon icon_speechInput = new ImageIcon("src/Icons/icons8-microphone-60.png");
    ImageIcon icon_player = new ImageIcon("src/Icons/icons8-monitor-50.png");

    AudioPlayer audioPlayer = new AudioPlayer();

    GameController controller;

    GameUI(GameController gameController){
        controller = gameController;
        renderUI();
    }

    private void renderUI() {
        //-------------------------------------------------define GUI------------------------------------------------//
        //frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(custom_lightBlue);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("TicTacToe");
        frame.setIconImage(icon_frame.getImage());

        //panels
        panel_north.setBackground(custom_lightBlue);
        panel_south.setBackground(custom_lightBlue);
        panel_east.setBackground(custom_lightBlue);
        panel_west.setBackground(custom_lightBlue);
        panel_center.setBackground(Color.BLACK);

        panel_title.setBackground(custom_lightBlue);
        panel_turn.setBackground(custom_lightBlue);
        panel_speechInput.setBackground(custom_lightBlue);
        panel_player.setBackground(custom_lightBlue);
        panel_help.setBackground(custom_lightBlue);

        panel_center.setBorder(new LineBorder(Color.BLACK, 5, false));

        panel_north.setPreferredSize(new Dimension(125,125));
        panel_south.setPreferredSize(new Dimension(125,125));
        panel_east.setPreferredSize(new Dimension(125,125));
        panel_west.setPreferredSize(new Dimension(125,125));
        panel_center.setPreferredSize(new Dimension(300,300));

        panel_title.setPreferredSize(new Dimension(40,40));
        panel_turn.setPreferredSize(new Dimension(40,40));
        panel_speechInput.setPreferredSize(new Dimension(40,40));
        panel_player.setPreferredSize(new Dimension(40,40));
        panel_help.setPreferredSize(new Dimension(40,40));

        panel_center.setLayout(new GridLayout(3,3,5,5));
        panel_north.setLayout(new GridLayout(2,1));
        panel_south.setLayout(new GridBagLayout());
        panel_east.setLayout(new GridLayout(3,1,10,10));

        panel_title.setLayout(new GridBagLayout());
        panel_turn.setLayout(new GridBagLayout());
        panel_speechInput.setLayout(new GridBagLayout());
        panel_player.setLayout(new GridBagLayout());
        panel_help.setLayout(new GridBagLayout());

        //buttons
        button_reset.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        button_reset.setText("New Game");
        button_reset.setBackground(custom_lightGray);
        button_reset.setForeground(Color.BLACK);
        button_reset.setFocusable(false);
        button_reset.setHorizontalAlignment(SwingConstants.CENTER);
        button_reset.setVerticalAlignment(SwingConstants.CENTER);
        button_reset.addActionListener(this);
        button_reset.setPreferredSize(new Dimension(200,75));
        button_reset.setBorder(new LineBorder(Color.BLACK, 3, false));

        button_speechInput.setBackground(custom_lightGray);
        button_speechInput.setForeground(Color.BLACK);
        button_speechInput.setFocusable(false);
        button_speechInput.setHorizontalAlignment(SwingConstants.CENTER);
        button_speechInput.setVerticalAlignment(SwingConstants.CENTER);
        button_speechInput.addActionListener(this);
        button_speechInput.setPreferredSize(new Dimension(75,75));
        button_speechInput.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_speechInput.setIcon(icon_speechInput);

        button_player.setBackground(custom_lightGray);
        button_player.setForeground(Color.BLACK);
        button_player.setFocusable(false);
        button_player.setHorizontalAlignment(SwingConstants.CENTER);
        button_player.setVerticalAlignment(SwingConstants.CENTER);
        button_player.addActionListener(this);
        button_player.setPreferredSize(new Dimension(75,75));
        button_player.setBorder(new LineBorder(Color.BLACK, 3, false));
        button_player.setIcon(icon_player);

        button_help.setFont(new Font("poornut", Font.BOLD, 60));
        button_help.setText("?");
        button_help.setBackground(custom_lightGray);
        button_help.setForeground(Color.BLACK);
        button_help.setFocusable(false);
        button_help.setHorizontalAlignment(SwingConstants.CENTER);
        button_help.setVerticalAlignment(SwingConstants.CENTER);
        button_help.addActionListener(this);
        button_help.setPreferredSize(new Dimension(75,75));
        button_help.setBorder(new LineBorder(Color.BLACK, 3, false));

        // add buttons to panel
        panel_south.add(button_reset, new GridBagConstraints());
        panel_speechInput.add(button_speechInput, new GridBagConstraints());
        panel_player.add(button_player, new GridBagConstraints());
        panel_help.add(button_help, new GridBagConstraints());

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            panel_center.add(buttons[i]);
            buttons[i].setFont(new Font("Comic Sans MS", Font.BOLD, 100));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBorder(new LineBorder(Color.BLACK, 1, false));
        }

        //labels
        label_title.setBackground(custom_lightBlue);
        label_title.setForeground(Color.BLACK);
        label_title.setFont(new Font("Comic Sans MS", Font.BOLD,50));
        label_title.setText("TicTacToe");
        label_title.setOpaque(true);
        label_title.setHorizontalAlignment(SwingConstants.CENTER);

        label_turn.setBackground(custom_lightBlue);
        label_turn.setForeground(Color.BLACK);
        label_turn.setFont(new Font("Comic Sans MS", Font.BOLD,35));
        label_turn.setText("O/X to play");
        label_turn.setOpaque(true);
        label_turn.setHorizontalAlignment(SwingConstants.CENTER);

        panel_title.add(label_title, new GridBagConstraints());
        panel_turn.add(label_turn, new GridBagConstraints());

        //add sub-panels to main-panels
        panel_north.add(panel_title);
        panel_north.add(panel_turn);
        panel_east.add(panel_speechInput);
        panel_east.add(panel_player);
        panel_east.add(panel_help);


        //add panels to frame
        frame.add(panel_north,BorderLayout.NORTH);
        frame.add(panel_south,BorderLayout.SOUTH);
        frame.add(panel_east,BorderLayout.EAST);
        frame.add(panel_west,BorderLayout.WEST);
        frame.add(panel_center,BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        //tictactoe button clicked
        for (JButton jButton : buttons) {
            if (actionEvent.getSource() == jButton) {
                if (controller.turn_x) {
                    if (jButton.getText().equals("")) {
                        jButton.setForeground(custom_red);
                        jButton.setText("X");
                        label_turn.setText("O's turn");
                        label_turn.setForeground(custom_blue);
                        audioPlayer.playSound("src/Audio/Cross.wav");
                        controller.moveMade();
                    }
                } else {
                    if (jButton.getText().equals("")) {
                        jButton.setForeground(custom_blue);
                        jButton.setText("O");
                        label_turn.setText("X's turn");
                        label_turn.setForeground(custom_red);
                        audioPlayer.playSound("src/Audio/Circle.wav");
                        controller.moveMade();
                    }
                }
                break;
            }
        }

        //"New Game" button clicked
        if (actionEvent.getSource() == button_reset) {
            for (JButton button : buttons) {
                button.setText("");
                button.setBackground(Color.WHITE);
                button.setEnabled(true);
            }
            audioPlayer.playSound("src/Audio/Button.wav");
            controller.firstTurn();
        }

        //" speechInput" button clicked
        if (actionEvent.getSource() == button_speechInput) {
            audioPlayer.playSound("src/Audio/Button.wav");
            if(button_speechInput.getBackground() == custom_lightGray) {
                button_speechInput.setBackground(custom_green);
            }else{
                button_speechInput.setBackground(custom_lightGray);
            }
        }

        //"Player" button clicked
        if (actionEvent.getSource() == button_player) {
            audioPlayer.playSound("src/Audio/Button.wav");
            if(button_player.getBackground() == custom_lightGray) {
                button_player.setBackground(custom_red);
                controller.computerPlaying = true;
                if(controller.turn_x && !controller.game_over){
                    controller.computerMove();
                }
            }else if(button_player.getBackground() == custom_red){
                button_player.setBackground(custom_blue);
                controller.computerPlaying = true;
                if(!controller.turn_x && !controller.game_over){
                    controller.computerMove();
                }
            }else{
                button_player.setBackground(custom_lightGray);
                controller.computerPlaying = false;
            }
        }

        //"help" button clicked
        if (actionEvent.getSource() == button_help) {
            audioPlayer.playSound("src/Audio/Button.wav");
        }
    }

    public void gameWon(int a, int b, int c) {
        //stops game if a player has won the game
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        if(controller.turn_x) {
            label_turn.setText("X-treme victory");
            label_turn.setForeground(custom_red);
            buttons[a].setBackground(custom_red);
            buttons[b].setBackground(custom_red);
            buttons[c].setBackground(custom_red);
        }else {
            label_turn.setText("O-some victory");
            label_turn.setForeground(custom_blue);
            buttons[a].setBackground(custom_blue);
            buttons[b].setBackground(custom_blue);
            buttons[c].setBackground(custom_blue);
        }
    }

    public void gameDrawn() {
        for (JButton button : buttons) {
            button.setEnabled(false);
            button.setBackground(custom_green);
        }
        label_turn.setText("Draw");
        label_turn.setForeground(custom_green);
    }
}
