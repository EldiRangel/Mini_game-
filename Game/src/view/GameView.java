package view;

import view.components.GamePanel;
import view.components.ScorePanel;
import javax.swing.*;
import java.awt.*;

public class GameView {
    private JFrame frame;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    
    public GameView() {
        initializeFrame();
    }
    
    private void initializeFrame() {
        frame = new JFrame("Cazador de Fantasmas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        scorePanel = new ScorePanel();
        gamePanel = new GamePanel();
        
        frame.add(scorePanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    public void show() {
        frame.setVisible(true);
    }
    
    public GamePanel getGamePanel() { return gamePanel; }
    public ScorePanel getScorePanel() { return scorePanel; }
    public JFrame getFrame() { return frame; }
    }
