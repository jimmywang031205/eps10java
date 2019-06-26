import java.awt.*;
import java.awt.geom.*;

public class Dice {
	
	protected RoundRectangle2D shape;
	protected int xPos, yPos;
	protected int diceWidth = 80, diceHeight = 80;
	protected int value = 0;
	protected boolean selected = false;
	
	Dice(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	void draw(Graphics2D g2) {
		this.value = value;
		shape = new RoundRectangle2D.Float(xPos-(diceWidth/2),yPos-(diceHeight/2), diceWidth, diceHeight, 40, 40);
		drawFillShape(shape, Color.white, g2);
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
		if(selected)	{
			RoundRectangle2D outline = new RoundRectangle2D.Double(xPos-(diceWidth/2),yPos-(diceHeight/2), diceWidth, diceHeight, 40, 40);
			drawShape(outline, Color.green, g2);
		}
	}
	
	void reset()	{
		value = 0;
		selected = false;
	}
	
	void drawFillCircle(int x, int y, Color fillColor, Graphics2D g2)	{
		Ellipse2D.Double shape = new Ellipse2D.Double(x, y, 10, 10);
		drawFillShape(shape, fillColor, g2);
	}
	
	void drawShape(Shape s, Color fillColor, Graphics2D g2)	{
		g2.setColor(fillColor);
		g2.setStroke(new BasicStroke(5));
		g2.draw(s);
		g2.setStroke(new BasicStroke(1));
	}
	
	void drawFillShape(Shape s, Color fillColor, Graphics2D g2)	{
		g2.setColor(fillColor);
		g2.fill(s);
		g2.draw(s);
	}
	
	public boolean isTouchingDice(int x, int y)	{
		if((xPos+80/2) > x && (xPos-80/2) < x &&
				(yPos+80/2) > y && (yPos-80/2) < y)	{
			return true;
		} else {
			return false;
		}
	}
	
	public int getXPos()	{
		return xPos;
	}
	
	public int getYPos()	{
		return yPos;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value)	{
		this.value = value;
	}
	
	public void setRandomValue()	{
		value = (int) (Math.random() * 6 + 1);
	}
	
	public void setSelected(boolean bool)	{
		this.selected = bool;
	}
	
	public boolean getSelected() {
		return selected;
	}
}
