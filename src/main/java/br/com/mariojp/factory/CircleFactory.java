package br.com.mariojp.factory;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.Point;

public class CircleFactory implements ShapeFactory{

	@Override
	public Shape createShape(Point p, int size) {
		return new Ellipse2D.Double(p.x, p.y, size, size);
	}

	
}
