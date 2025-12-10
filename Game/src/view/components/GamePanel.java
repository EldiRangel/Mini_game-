package view.components;

import model.Ghost;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GamePanel extends JPanel {
    private List<Ghost> ghosts;
    
    public GamePanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(600, 400));
    }
    
    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }
    
    public void setGameClickListener(GameClickListener listener) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.onGameClick(e.getPoint());
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (ghosts != null) {
            for (Ghost ghost : ghosts) {
                if (ghost.isVisible()) {
                    drawGhost(g, ghost);
                }
            }
        }
    }
    
    private void drawGhost(Graphics g, Ghost ghost) {
        Point pos = ghost.getPosition();
        int size = ghost.getSize();
        
        g.setColor(Color.WHITE);
        g.fillOval(pos.x, pos.y, size, size);
        
        g.setColor(Color.BLACK);
        g.fillOval(pos.x + size/4, pos.y + size/4, size/6, size/6);
        g.fillOval(pos.x + 2*size/3, pos.y + size/4, size/6, size/6);
        
        g.drawArc(pos.x + size/4, pos.y + size/2, size/2, size/4, 0, -180);
    }
    
    public interface GameClickListener {
        void onGameClick(Point point);
    }
            }
