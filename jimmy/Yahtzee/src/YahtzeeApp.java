import javax.swing.JFrame;

public class YahtzeeApp extends JFrame {

	public YahtzeeApp (String appName)	{
		super(appName);
		View myView = new View(500,500, this);
		add(myView);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
	}
	public static void main(String[] args) {
		new YahtzeeApp("Yahtzee");
	}
	
//	YahtzeeApp(String appName)	{
//		View yahtzeeView = new View(appName, 500, 500);
//		Model yahtzeeModel = new Model(yahtzeeView);
//		Controller yahtzeeController = new Controller(yahtzeeView, yahtzeeModel);
//		ScoreSheet scoreSheetView = new ScoreSheet("Scoresheet", 300, 800);
//	}
	
}