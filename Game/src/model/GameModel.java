package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
    private Player player;
    private List<Ghost> ghosts;
    private boolean gameRunning;
    private int level;
    private Random random;
    private int gameWidth;
    private int gameHeight;
    
    public GameModel(int width, int height) {
        this.gameWidth = width;
        this.gameHeight = height;
        this.player = new Player("Jugador");
        this.ghosts = new ArrayList<>();
        this.random = new Random();
        this.level = 1;
        initializeGhosts();
    }
    
    private void initializeGhosts() {
        ghosts.clear();
        for (int i = 0; i < 3 + level; i++) {
            ghosts.add(new Ghost());
        }
    }
    
    public void startGame() {
        gameRunning = true;
        player.reset();
        level = 1;
        initializeGhosts();
    }
    
    public void spawnRandomGhost() {
        if (!gameRunning) return;
        
        for (Ghost ghost : ghosts) {
            if (!ghost.isVisible() && random.nextDouble() < 0.3) {
                ghost.spawn(gameWidth, gameHeight);
                break;
            }
        }
    }
    
    public void checkGhostClick(Point clickPoint) {
        if (!gameRunning) return;
        
        for (Ghost ghost : ghosts) {
            if (ghost.contains(clickPoint)) {
                ghost.hide();
                player.addScore(10 * level);
                
                if (allGhostsCaptured()) {
                    levelUp();
                }
                return;
            }
        }
        
        player.loseLife();
        if (!player.isAlive()) {
            gameOver();
        }
    }
    
    private boolean allGhostsCaptured() {
        for (Ghost ghost : ghosts) {
            if (ghost.isVisible()) {
                return false;
            }
        }
        return true;
    }
    
    private void levelUp() {
        level++;
        initializeGhosts();
    }
    
    private void gameOver() {
        gameRunning = false;
    }
    
    public Player getPlayer() { return player; }
    public List<Ghost> getGhosts() { return ghosts; }
    public boolean isGameRunning() { return gameRunning; }
    public int getLevel() { return level; }
             }
