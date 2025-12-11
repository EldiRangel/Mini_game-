package controller;

import model.GameModel;
import view.GameView;
import view.components.GamePanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;

public class GameController {
    private GameModel model;
    private GameView view;
    private Timer gameTimer;
    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        initializeController();
    }
    
    private void initializeController() {
        view.getScorePanel().getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        
        view.getGamePanel().setGameClickListener(point -> {
            handleGameClick(point);
        });
        
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
            }
        });
        
        updateView();
    }
    
    private void startGame() {
        model.startGame();
        gameTimer.start();
        updateView();
    }
    
    private void handleGameClick(Point point) {
        model.checkGhostClick(point);
        updateView();
    }
    
    private void updateGame() {
        model.spawnRandomGhost();
        view.getGamePanel().repaint();
    }
    
    private void updateView() {
        view.getScorePanel().updateScore(model.getPlayer().getScore());
        view.getScorePanel().updateLives(model.getPlayer().getLives());
        view.getScorePanel().updateLevel(model.getLevel());
        view.getGamePanel().setGhosts(model.getGhosts());
        view.getGamePanel().repaint();
        
        if (!model.isGameRunning() && gameTimer.isRunning()) {
            gameTimer.stop();
            showGameOver();
        }
    }
    
    private void showGameOver() {
        JOptionPane.showMessageDialog(view.getFrame(),
            "¡Juego Terminado!\nPuntuación Final: " + model.getPlayer().getScore(),
            "Game Over",
            JOptionPane.INFORMATION_MESSAGE);
    }
  }
