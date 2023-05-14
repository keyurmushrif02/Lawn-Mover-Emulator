package sdp_final4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LawnMowerGUI extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int ROWS = 19;
    private static final int COLS = 19;
    private boolean[][] grass = new boolean[ROWS][COLS];
    private int squareSize = 30;
    private int row = 0;
    private int col = -1;
    private int x;
    private int y;
    private int width = 5;
    private int height = 5;
    private Direction direction = Direction.RIGHT;
    private Timer timer;
    private boolean running = false;
    private JButton startButton;
    private JButton stopButton;

    public LawnMowerGUI() {
        super();
        setLayout(null);
        setPreferredSize(new Dimension(COLS * squareSize, ROWS * squareSize + 70));


        startButton = new JButton("Start");
        startButton.setBounds(10, ROWS * squareSize + 10, 80, 30);
        startButton.addActionListener(this::startMower);
        add(startButton);

        stopButton = new JButton("Stop");
        stopButton.setBounds(100, ROWS * squareSize + 10, 80, 30);
        stopButton.addActionListener(this::stopMower);
        add(stopButton);

        timer = new Timer(1000, this);
        timer.setInitialDelay(0);
    }

    public void startMower(ActionEvent evt) {
        running = true;
        timer.start();
    }

    public void stopMower(ActionEvent evt) {
        running = false;
        timer.stop();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (running) {
            if (direction == Direction.RIGHT) {
                col++;
                if (col == COLS) {
                    row++;
                    if (row == ROWS) {
                        running = false; // stop if bottom edge is reached
                        return;
                    }
                    col = COLS - 1;
                    direction = Direction.LEFT;
                    y += height;
                }
            } else { // direction == Direction.LEFT
                col--;
                if (col == -1) {
                    row++;
                    if (row == ROWS) {
                        running = false; // stop if bottom edge is reached
                        return;
                    }
                    col = 0;
                    direction = Direction.RIGHT;
                    y += height;
                }
            }
            grass[row][col] = true;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < grass.length; row++) {
            for (int col = 0; col < grass[row].length; col++) {
                if (grass[row][col]) {
                    g.setColor(new Color(0, 100, 0)); // dark green color
                } else {
                    g.setColor(new Color(154, 205, 50)); // faint green color
                }
                g.fillRect(col * squareSize, row * squareSize, squareSize, squareSize);

                // Draw a frame around each square if it has been cut
                if (grass[row][col]) {
                    g.setColor(Color.BLACK);
                    g.drawRect(col * squareSize, row * squareSize, squareSize, squareSize);
                }
            }
        }
        g.setColor(Color.BLUE);
        g.fillRect(col * squareSize - width / 2, row * squareSize - height / 2 + y, width, height);
    }


    private enum Direction {
        RIGHT, LEFT
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lawn Mower Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new LawnMowerGUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
}