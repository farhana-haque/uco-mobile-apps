package Shapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Square extends Shape {
	private static final float xINC = 100;
	private static final float yINC = 70;

	@Override
	public void Draw(Canvas canvas, Paint paint) {
		paint.setColor(super.getColor());
		canvas.drawRect(getX(), getY(), getX() + xINC, getY() + yINC, paint);
		if (getNumb() != -1) {
			paint.setColor(Color.RED);
			paint.setTextSize(35);
			canvas.drawText(getNumb() + " ", getCenterX(), getCenterY(), paint);
		}
	}

	public Square(int xloc, int yloc, int n) {
		setX(xloc);
		setY(yloc);
		setNumb(n);
	}

	public Square(int xloc, int yloc, int n, int color) {
		setX(xloc);
		setY(yloc);
		setNumb(n);
		super.setColor(color);
	}

	public Square(Shape s) {
		setX(s.getX());
		setY(s.getY());
		setNumb(s.getNumb());
		super.setColor(s.getColor());
	}

	public Square(Shape prev, int n) {
		setX(prev.getX());
		setY(prev.getY() + yINC + 3);
		setNumb(n);
	}

	public float getCenterY() {
		return getY() + (yINC / 2);
	}

	public float getCenterX() {
		return getX();
	}
}