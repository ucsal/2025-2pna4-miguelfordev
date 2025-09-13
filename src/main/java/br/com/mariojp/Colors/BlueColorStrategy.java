package br.com.mariojp.Colors;

import java.awt.Color;

public class BlueColorStrategy implements ColorStrategy{

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return new Color(30,144,255);
	}

	@Override
	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return new Color(0,0,0,70);
	}

}
