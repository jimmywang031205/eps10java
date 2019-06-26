import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class ScoreBoardPanelListener {
	
	private int mouseX, mouseY;
	
	private Game game;
	public Panel panel;
	public Controller controller;
	public static int counter = 0;
	
	ScoreBoardPanelListener(Panel panel, Controller controller)	{
		this.panel = panel;
		this.controller = controller;
		panel.scoreSheetPanel.addMouseListener(new MouseListener());
		panel.scoreSheetPanel.addMouseMotionListener(new MouseMotionListener());
	}
	
	class MouseListener extends MouseAdapter	{
		public void mousePressed(MouseEvent e)	{
			int addScore = 0;
			if(game.gameOver == false)	{
				for (ScoreSheet.Score _score: ScoreSheet.P1scoreSheet){
					if(_score.isTouching(mouseX, mouseY))	{
						if(_score.getScoreType().equals("Sum") || _score.getScoreType().equals("Bonus"))	{
							continue;
						} else if(game.playerTurn == 0)	{
							panel.addToConsole("Player1 selected "+_score.getScoreType());
							addScore = _score.getMyPoints();
							_score.setUsed(true);
							for(ScoreSheet.Score _subScore: ScoreSheet.P1scoreSheet)	{
								if(_subScore.getScoreType().equals("Total Score"))	{
									_subScore.addMyPoints(addScore);
									counter++;
									checkWin();
								}
							}
							panel.scoreSheetPanel.update();
							game.switchPlayer();
						} else {
							panel.addToConsole("Please choose something from your scoresheet!");
						}
					}
				}
				for (ScoreSheet.Score _score: ScoreSheet.P2scoreSheet){
					if(_score.isTouching(mouseX, mouseY))	{
						if(_score.getScoreType().equals("Sum") ||_score.getScoreType().equals("Bonus"))	{
							continue;
						} else if(game.playerTurn == 1)	{
							panel.addToConsole("Player2 selected "+_score.getScoreType());
							addScore = _score.getMyPoints();
							_score.setUsed(true);
							for(ScoreSheet.Score _subScore: ScoreSheet.P2scoreSheet)	{
								if(_subScore.getScoreType().equals("Total Score"))	{
									_subScore.addMyPoints(addScore);
									counter++;
									checkWin();
								}
							}
							panel.scoreSheetPanel.update();
							game.switchPlayer();
						} else {
							panel.addToConsole("Please choose something from your scoresheet!");
						}
					}
				}
			} else {
				panel.addToConsole("Game has not started yet!");
			}
		}
	}
	
	public void checkWin()	{
		if(ScoreBoardPanelListener.counter == 26)	{
			int P1Score = 0, P2Score = 0;
			for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
				if(_score.getScoreType().equals("Total Score"))	{
					P1Score = _score.getMyPoints();
				}
			}
			for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
				if(_score.getScoreType().equals("Total Score"))	{
					P2Score = _score.getMyPoints();
				}
			}
			System.out.println("Game finished!");
			if(P1Score > P2Score)	{
				panel.addToConsole("Player 1 has won!");
			} else if(P1Score < P2Score)	{
				panel.addToConsole("Player 2 has won!");
			} else {
				panel.addToConsole("It is a tie!");
			}
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
