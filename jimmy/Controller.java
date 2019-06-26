import java.awt.*;
import java.awt.event.*;

public class Controller implements ActionListener {
	
	public Panel panel;
	public Game game;
	public static ScoreSheet scoreSheet;
	
	Controller(Panel panel, Game game)	{
		this.panel = panel;
		this.game = game;
		
		
		panel.rollDiceBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)	{
		checkButton(e.getActionCommand());
	}
	
	void checkButton(String s)	{
		switch(s) {
		case "START / ROLL DICE" :
			if(game.getGameOver())	{
				game.setGameOver(false);
				game.play();
			} else {
				game.rollDice();
			}
			break;
		}
	}
}
