package model;

import java.awt.Point;
import java.util.Random;

public class Ghost {
    private Point position;
    private boolean visible;
    private final int size = 40;
    private Random random;
    
    public Ghost() {
        this.random = new Random();
        this.visible = false;
        this.position = new Point(0, 0);
    }
    
    public void spawn(int maxX, int maxY) {
        this.position.x = random.nextInt(maxX - size);
        this.position.y = random.nextInt(maxY - size);
        this.visible = true;
    }
    
    public void hide() {
        this.visible = false;
    }
    
    public Point getPosition() { return position; }
    public boolean isVisible() { return visible; }
    public int getSize() { return size; }
    
    public boolean contains(Point point) {
        return visible && 
               point.x >= position.x && point.x <= position.x + size &&
               point.y >= position.y && point.y <= position.y + size;
    }
}
