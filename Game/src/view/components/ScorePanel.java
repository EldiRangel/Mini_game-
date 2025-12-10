package view.components;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private JLabel scoreLabel;
    private JLabel livesLabel;
    private JLabel levelLabel;
    private JButton startButton;
    
    public ScorePanel() {
        setLayout(new FlowLayout());
        setBackground(Color.LIGHT_GRAY);
        
        scoreLabel = new JLabel("Puntuación: 0");
        livesLabel = new JLabel("Vidas: 3");
        levelLabel = new JLabel("Nivel: 1");
        startButton = new JButton("Iniciar Juego");
        
        add(scoreLabel);
        add(livesLabel);
        add(levelLabel);
        add(startButton);
    }
    
    public JLabel getScoreLabel() { return scoreLabel; }
    public JLabel getLivesLabel() { return livesLabel; }
    public JLabel getLevelLabel() { return levelLabel; }
    public JButton getStartButton() { return startButton; }
    
    public void updateScore(int score) {
        scoreLabel.setText("Puntuación: " + score);
    }
    
    public void updateLives(int lives) {
        livesLabel.setText("Vidas: " + lives);
    }
    
    public void updateLevel(int level) {
        levelLabel.setText("Nivel: " + level);
    }
}
