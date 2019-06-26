import java.awt.*;

import javax.swing.*;

public class ScoreSheet extends JPanel {
	public static int panelWidth, panelHeight;
	private String appName;
	public JFrame appFrame;
	
	ScoreSheet(String appName, int panelWidth, int panelHeight)	{
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.appName = appName;
		
		appFrame = new JFrame(appName);
		appFrame.setSize(panelWidth, panelHeight);
		appFrame.setVisible(true);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setResizable(false);
		appFrame.setLocationRelativeTo(null);
		
	}
}
