package br.com.mariojp.factory;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

public class TriangleFactory implements ShapeFactory{

	@Override
	public Shape createShape(Point p, int size) {
		// TODO Auto-generated method stub
		Polygon triangle = new Polygon();
        triangle.addPoint(p.x, p.y);
        triangle.addPoint(p.x + size, p.y);
        triangle.addPoint(p.x + size / 2, p.y - size);
		return triangle;
	}

}
