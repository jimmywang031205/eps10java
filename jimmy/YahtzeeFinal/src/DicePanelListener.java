import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DicePanelListener	{
	
	private int mouseX, mouseY;
	
	private Game game;
	public Panel panel;
	public Controller controller;
	
	DicePanelListener(Panel panel, Controller controller)	{
		this.panel = panel;
		this.controller = controller;
		panel.dicePanel.addMouseListener(new MouseListener());
		panel.dicePanel.addMouseMotionListener(new MouseMotionListener());
	}
	
	class MouseListener extends MouseAdapter	{
		public void mousePressed(MouseEvent e)	{
			if (panel.PlayerDice1.isTouchingDice(mouseX, mouseY))	{
				//System.out.println("DICE 1");
				if(panel.PlayerDice1.getSelected()) {
					panel.PlayerDice1.setSelected(false);
					if(game.playerTurn == 0)	{
						Game.playerSaveDice[0][0] = false;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][0] = false;
					}
				} else {
					panel.PlayerDice1.setSelected(true);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][0] = true;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][0] = true;
					}
				}
			} else if (panel.PlayerDice2.isTouchingDice(mouseX, mouseY))	{
				//System.out.println("DICE 2");
				if(panel.PlayerDice2.getSelected()) {
					panel.PlayerDice2.setSelected(false);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][1] = false;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][1] = false;
					}
				} else {
					panel.PlayerDice2.setSelected(true);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][1] = true;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][1] = true;
					}
				}
			} else if (panel.PlayerDice3.isTouchingDice(mouseX, mouseY))	{
				//System.out.println("DICE 3");
				if(panel.PlayerDice3.getSelected()) {
					panel.PlayerDice3.setSelected(false);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][2] = false;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][2] = false;
					}
				} else {
					panel.PlayerDice3.setSelected(true);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][2] = true;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][2] = true;
					}
				}
			} else if (panel.PlayerDice4.isTouchingDice(mouseX, mouseY))	{
				//System.out.println("DICE 4");
				if(panel.PlayerDice4.getSelected()) {
					panel.PlayerDice4.setSelected(false);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][3] = false;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][3] = false;
					}
				} else {
					panel.PlayerDice4.setSelected(true);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][3] = true;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][3] = true;
					}
				}
			} else if (panel.PlayerDice5.isTouchingDice(mouseX, mouseY))	{
				//System.out.println("DICE 5");
				if(panel.PlayerDice5.getSelected()) {
					panel.PlayerDice5.setSelected(false);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][4] = false;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][4] = false;
					}
				} else {
					panel.PlayerDice5.setSelected(true);
					if(game.playerTurn == 0)	{
						game.playerSaveDice[0][4] = true;
					} else if (game.playerTurn == 1)	{
						game.playerSaveDice[1][4] = true;
					}
				}
			}
			panel.dicePanel.updateDice();
		}
	}
	
	class MouseMotionListener extends MouseMotionAdapter	{
		public void mouseMoved(MouseEvent e)	{
			mouseX = e.getX();
			mouseY = e.getY();
		}
		public void mouseDragged(MouseEvent e)	{
			mouseX = e.getX();
			mouseY = e.getY();
		}
	}
}
