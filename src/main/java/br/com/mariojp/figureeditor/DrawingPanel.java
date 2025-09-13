
package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.factory.*;
import br.com.mariojp.Colors.*;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    
    private final List<DrawableShape> shapes = new ArrayList<>();
    private ShapeFactory shapeFactory = new CircleFactory();
    private ColorStrategy colorStrategy = new BlueColorStrategy();

    DrawingPanel() {
        
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        var mouse = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 ) {
                	Shape s = shapeFactory.createShape(getMousePosition(), DEFAULT_SIZE);
                    shapes.add(new DrawableShape(s,colorStrategy));
                    repaint();
                }
            }
        };
        addMouseListener(mouse);        
    }
    
    public void setShapeFactory(ShapeFactory factory) {
    	this.shapeFactory = factory;
    }
    
    public void setColorStrategy(ColorStrategy strategy) {
    	this.colorStrategy = strategy;
    }
    

    void clear() {
        shapes.clear();
        repaint();
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (DrawableShape ds : shapes) {
            g2.setColor(ds.colorStrategy.getFillColor());
            g2.fill(ds.shape);
            g2.setColor(ds.colorStrategy.getBorderColor());
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(ds.shape);
        }

        g2.dispose();
    }
    
    private static class DrawableShape{
    	Shape shape;
    	ColorStrategy colorStrategy;
    	DrawableShape(Shape s, ColorStrategy c){
    		this.shape = s;
    		this.colorStrategy = c;
    	}
    }

}
