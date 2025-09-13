package br.com.mariojp.factory;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class SquareFactory implements ShapeFactory{

	@Override
	public Shape createShape(Point p, int size) {
		// TODO Auto-generated method stub
		return new Rectangle2D.Double(p.x, p.y, size, size);
	}

}
