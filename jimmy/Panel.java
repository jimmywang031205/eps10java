import java.awt.*;

import java.awt.event.*;
import java.awt.geom.*;
import java.util.Iterator;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	private static Game game;
	private static int panelWidth, panelHeight;
	private Graphics2D g2;
	private int mouseX, mouseY;
	
	public Dice PlayerDice1;
	public Dice PlayerDice2;
	public Dice PlayerDice3;
	public Dice PlayerDice4;
	public Dice PlayerDice5;
	
	private JFrame appFrame;
	private JPanel buttonPanel;
	public scoreSheetCanvas scoreSheetPanel;
	public diceCanvas dicePanel;
	
	private GridLayout buttonGridLayout;
	public JButton rollDiceBtn;
	public JButton startStopBtn;
	
	private String console1 = "", console2 = "> Click on START / ROLL DICE to play game!";
	
	private Timer timer;
	
	private Container container;
	
	public Panel(String appName, int panelWidth, int panelHeight) {
		super();
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		
		timer = new Timer(16, null); //delay in millis
		timer.start();
		timer.addActionListener(this);
		
		appFrame = new JFrame(appName);
		appFrame.setVisible(true);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setResizable(false);
		
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500,50));
		buttonPanel.setBackground(new Color(152,185,242));
		buttonPanel.setFocusable(true);
		
		dicePanel = new diceCanvas();
		dicePanel.setPreferredSize(new Dimension(500,400));
		dicePanel.setBackground(new Color(20,27,65));
		dicePanel.setFocusable(true);
		
		scoreSheetPanel = new scoreSheetCanvas();
		scoreSheetPanel.setPreferredSize(new Dimension(400, 400));
		scoreSheetPanel.setBackground(new Color(145,142,244));
		
		buttonGridLayout = new GridLayout(1,3);
		buttonPanel.setLayout(buttonGridLayout);
		
		rollDiceBtn = new JButton("START / ROLL DICE");
		
		PlayerDice1 = new Dice(50,200);
		PlayerDice2 = new Dice(150,200);
		PlayerDice3 = new Dice(250,200);
		PlayerDice4 = new Dice(350,200);
		PlayerDice5 = new Dice(450,200);
		
		addButtonsToPanel(buttonPanel, new Dimension(400,20), rollDiceBtn);
		
		container = appFrame.getContentPane();
		container.add(dicePanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);
		container.add(scoreSheetPanel, BorderLayout.EAST);
		appFrame.pack();
		
	}
	
	public void addButtonsToPanel(JPanel p, Dimension d, JButton btn)	{
		btn.setPreferredSize(d);
		btn.setFocusable(false);
		p.add(btn);
	}
	
	public void diceReset()	{
		PlayerDice1.reset();
		PlayerDice2.reset();
		PlayerDice3.reset();
		PlayerDice4.reset();
		PlayerDice5.reset();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		dicePanel.updateDice();
		scoreSheetPanel.update();
	}
	
	class MouseListener extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {}
	}
	
	public void addToConsole(String text)	{
		if((console1 == ("NULL") || console1.equals("")) && (console2 == ("NULL") || console2.equals("")))	{
			console2 = ("> "+text);
		} else if(console1 == ("NULL") || console1.equals("")){
			console1 = console2.substring(2);
			console2 = ("> "+text);
		} else {
			console1 = console2.substring(2);
			console2 = ("> "+text);
		}
		dicePanel.updateDice();
	}
	
	class diceCanvas extends JPanel	{
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.PLAIN, 15));
			g.setColor(Color.white);
			if(game.playerTurn == 0) {
				g.drawString("Turn: P1", 5, 25);
			} else if(game.playerTurn == 1)	{
				g.drawString("Turn: P2", 5, 25);
			} else {
				g.drawString("Turn: ?", 5, 25);
			}
			g.drawString(("Rolls:"+game.counter), 450, 25);
			g.drawString(console1, 5, 370);
			g.drawString(console2, 5, 385);
			PlayerDice1.draw(g2);
			PlayerDice2.draw(g2);
			PlayerDice3.draw(g2);
			PlayerDice4.draw(g2);
			PlayerDice5.draw(g2);
		}
		public void updateDice()	{
			if(game.playerTurn == 0)	{
				PlayerDice1.setValue(game.playerDice[0][0]);
				PlayerDice2.setValue(game.playerDice[0][1]);
				PlayerDice3.setValue(game.playerDice[0][2]);
				PlayerDice4.setValue(game.playerDice[0][3]);
				PlayerDice5.setValue(game.playerDice[0][4]);
			} else if(game.playerTurn == 1)	{
				PlayerDice1.setValue(game.playerDice[1][0]);
				PlayerDice2.setValue(game.playerDice[1][1]);
				PlayerDice3.setValue(game.playerDice[1][2]);
				PlayerDice4.setValue(game.playerDice[1][3]);
				PlayerDice5.setValue(game.playerDice[1][4]);
			}
			repaint();
		}
		
	}
	
	class scoreSheetCanvas extends JPanel	{
		@Override
		public void paintComponent(Graphics g)	{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.PLAIN, 15));
			g.setColor(Color.black);
			for (ScoreSheet.Score _score: ScoreSheet.P1scoreSheet){
				if(!_score.getUsed())	{
					if(_score.getPointsYPos() == 20)	{
						g.setColor(Color.yellow);
					} else	{
						g.setColor(Color.black);
				}
	            g.drawString(_score.getScoreType(), 10, _score.getPointsYPos());
				} else {
					g.setColor(Color.red);
					g.drawString(_score.getScoreType(), 10, _score.getPointsYPos());
					g.setColor(Color.black);
					_score.setTerminate(true);
				}
	        }
			for (ScoreSheet.Score _score: ScoreSheet.P1scoreSheet){
				g.setColor(Color.blue);
				if(_score.getPointsYPos() == 20)	{
					
				} else {
					if(_score.getUsed() == false)	{
						if(_score.getSuggested() == true)	{
							g.setColor(Color.green);
							g.drawString(String.valueOf(_score.getMyPoints()), 170, _score.getPointsYPos());
							g.setColor(Color.blue);
						} else {
							g.drawString(String.valueOf(_score.getMyPoints()), 170, _score.getPointsYPos());
						}
					} else {
						g.setColor(Color.red);
						g.drawString(String.valueOf(_score.getMyPoints()), 170, _score.getPointsYPos());
						g.setColor(Color.blue);
						_score.setTerminate(true);
					}
				}
	        }
			for (ScoreSheet.Score _score: ScoreSheet.P2scoreSheet){
				if(!_score.getUsed())	{
					if(_score.getPointsYPos() == 20)	{
						g.setColor(Color.yellow);
					} else	{
						g.setColor(Color.black);
					}
		            g.drawString(_score.getScoreType(), 210, _score.getPointsYPos());
				} else {
					g.setColor(Color.red);
					g.drawString(_score.getScoreType(), 210, _score.getPointsYPos());
					g.setColor(Color.black);
					_score.setTerminate(true);
				}
	        }
			for (ScoreSheet.Score _score: ScoreSheet.P2scoreSheet){
				g.setColor(Color.blue);
				if(_score.getPointsYPos() == 20)	{
					
				} else {
					if(_score.getUsed() == false)	{
						if(_score.getSuggested() == true)	{
							g.setColor(Color.green);
							g.drawString(String.valueOf(_score.getMyPoints()), 370, _score.getPointsYPos());
							g.setColor(Color.blue);
						} else {
							g.drawString(String.valueOf(_score.getMyPoints()), 370, _score.getPointsYPos());
						}
					} else {
						g.setColor(Color.red);
						g.drawString(String.valueOf(_score.getMyPoints()), 370, _score.getPointsYPos());
						g.setColor(Color.blue);
						_score.setTerminate(true);
					}
				}
	        }
		}
		
		public void update()	{
			repaint();
		}
	}
	
	class MouseMotionListener extends MouseMotionAdapter {
		
		public void mouseMoved(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			//System.out.println(mouseX+" "+mouseY);
		}
		
		public void mouseDragged(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("ACTION!");
		repaint();
	}
	
}
