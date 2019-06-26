import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;


public class Dice{
	
	protected int xPos, yPos;
	protected RoundRectangle2D shape;
	private int diceWidth = 80, diceHeight = 80;
	
	Dice(int x, int y)	{
		this.xPos = x;
		this.yPos = y;
	}
	
	void drawDice(int value, Graphics2D g2)	{
		drawRect(new Color(255,255,255), g2);
		switch(value)	{
		case 0:
			break;
		case 1:
			drawFillCircle(xPos-5, yPos-5,Color.red, g2);
			break;
		case 2:
			drawFillCircle(xPos+20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos-20-5, yPos+20-5,Color.red, g2);
			break;
		case 3:
			drawFillCircle(xPos+20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos-5, yPos-5,Color.red, g2);
			drawFillCircle(xPos-20-5, yPos+20-5,Color.red, g2);
			break;
		case 4:
			drawFillCircle(xPos-20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos-20-5, yPos+20-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos+20-5,Color.red, g2);
			break;
		case 5:
			drawFillCircle(xPos-20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos-5, yPos-5,Color.red, g2);
			drawFillCircle(xPos-20-5, yPos+20-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos+20-5,Color.red, g2);
			break;
		case 6:
			drawFillCircle(xPos-20-5, yPos+20-5,Color.red, g2);
			drawFillCircle(xPos-20-5, yPos-5,Color.red, g2);
			drawFillCircle(xPos-20-5, yPos-20-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos+20-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos-5,Color.red, g2);
			drawFillCircle(xPos+20-5, yPos-20-5,Color.red, g2);
			break;
		}
	}
	
	void drawRect(Color fillColor, Graphics2D g2)	{
		shape = new RoundRectangle2D.Float(xPos-(diceWidth/2), yPos-(diceHeight/2), diceWidth, diceHeight, 40, 40);
		drawFillShape(shape, xPos-(diceWidth/2), yPos-(diceHeight/2), diceWidth, diceHeight, fillColor, g2);
	}
	
	void drawFillCircle(int x, int y, Color fillColor, Graphics2D g2)	{
		Ellipse2D.Double shape = new Ellipse2D.Double(x, y, 10, 10);
		drawFillShape(shape, x, y, 10, 10, fillColor, g2);
	}
	
	void drawFillShape(Shape s, int x, int y, int width, int height, Color fillColor, Graphics2D g2)	{
		g2.setColor(fillColor);
		g2.fill(s);
		g2.draw(s);
	}
}
