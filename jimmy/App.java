
public class App {
	public static void main(String[] args)	{
		new App("Yahtzee by Jimmy & Brian");
	}
	App(String appName)	{
		Panel myPanel = new Panel(appName, 600, 400);
		ScoreSheet myScoreSheet = new ScoreSheet();
		Game myGame = new Game(myPanel, myScoreSheet);
		Controller myController = new Controller(myPanel, myGame);
		DicePanelListener dicePanelListener = new DicePanelListener(myPanel, myController);
		ScoreBoardPanelListener scoreBoardPanelListener = new 
				ScoreBoardPanelListener(myPanel, myController);
	}
}
