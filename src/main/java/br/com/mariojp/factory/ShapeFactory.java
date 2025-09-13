package br.com.mariojp.factory;

import java.awt.Point;
import java.awt.Shape;

public interface ShapeFactory {

	Shape createShape(Point p, int size);
}
