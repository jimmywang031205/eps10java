import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class View extends JPanel implements ActionListener	{
	
	private String appName;
	public static int panelWidth, panelHeight;
	private Graphics2D g2;
	
	private Dice dice = new Dice(10,10);
	
	public JFrame appFrame;
	private JPanel gamePanel;
	private JPanel buttonPanel;
	private JPanel dicePanel;
	private GridLayout buttonGridLayout;
	
	public JButton rollDiceBtn, menuBtn;
	
	public JButton dice1Btn, dice2Btn, dice3Btn, dice4Btn, dice5Btn, dice6Btn;
	
	private Container container;
	
	public View(int panelWidth, int panelHeight, JFrame frame) {
		super();
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.appName = appName;
		
		//setup frame
		appFrame = new JFrame(appName);
		//appFrame.setSize(panelWidth, panelHeight);
		appFrame.setVisible(true);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setResizable(true);
		
		//setup textPanel
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(600,500));
		gamePanel.setBackground(new Color (162,213,171));
		gamePanel.setFocusable(true);
		
		//setup buttonPanel
		buttonPanel = new JPanel();
		buttonGridLayout = new GridLayout(2,3);
		buttonPanel.setLayout(buttonGridLayout);
		Dimension dim = new Dimension(150, 50);
		rollDiceBtn = new JButton("ROLL DICE");
		rollDiceBtn.setOpaque(true);
		rollDiceBtn.setBackground(new Color(85,123,131));
		rollDiceBtn.setForeground(new Color(91,81,81));
		menuBtn = new JButton("MENU");
		menuBtn.setOpaque(true);
		menuBtn.setForeground(new Color(91,81,81));
		menuBtn.setBackground(new Color(85,123,131));
		addButtonsToPanel(buttonPanel, dim, rollDiceBtn);
		addButtonsToPanel(buttonPanel, dim, menuBtn);
		
		dicePanel = new JPanel();
		Dimension dim1 = new Dimension(95,15);
		dice1Btn = new JButton("DICE 1");
		dice1Btn.setOpaque(true);
		dice2Btn = new JButton("DICE 2");
		dice2Btn.setOpaque(true);
		dice3Btn = new JButton("DICE 3");
		dice3Btn.setOpaque(true);
		dice4Btn = new JButton("DICE 4");
		dice4Btn.setOpaque(true);
		dice5Btn = new JButton("DICE 5");
		dice5Btn.setOpaque(true);
		dice6Btn = new JButton("DICE 6");
		dice6Btn.setOpaque(true);
		addButtonsToPanel(dicePanel, dim1, dice1Btn);
		addButtonsToPanel(dicePanel, dim1, dice2Btn);
		addButtonsToPanel(dicePanel, dim1, dice3Btn);
		addButtonsToPanel(dicePanel, dim1, dice4Btn);
		addButtonsToPanel(dicePanel, dim1, dice5Btn);
		addButtonsToPanel(dicePanel, dim1, dice6Btn);
		
		
		//setup container,add both panels to frame
		container = appFrame.getContentPane();
		container.add(gamePanel, BorderLayout.NORTH);
		container.add(dicePanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);
		appFrame.pack();
		
	}
	
	public void paintComponent(Graphics g)	{
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	//adds a button to the panel
	private void addButtonsToPanel(JPanel p, Dimension d, JButton btn) {
		btn.setPreferredSize(d);
		btn.setFocusable(false); //prevents focus from getting taken away from keyboard
		p.add(btn);
	}
	
	
	public void actionPerformed(ActionEvent e)	{
		System.out.println("ACTION");
		repaint();
	}
}