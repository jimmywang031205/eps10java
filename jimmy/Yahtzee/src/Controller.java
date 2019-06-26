import java.awt.*;
import java.awt.event.*;


public class Controller implements ActionListener {
	
	public View view;
	public Model model;
	
	Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		
		view.appFrame.addKeyListener(new KeyListener());
		view.rollDiceBtn.addActionListener(this);
		view.menuBtn.addActionListener(this);
		view.dice1Btn.addActionListener(this);
		view.dice2Btn.addActionListener(this);
		view.dice3Btn.addActionListener(this);
		view.dice4Btn.addActionListener(this);
		view.dice5Btn.addActionListener(this);
		view.dice6Btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkButton(e.getActionCommand());
	}
	
	void checkButton(String s) {
		switch(s) {
			case "ROLL DICE" :
				model.clearText();
				break;
			case "MENU"	:
				model.clearText();
				break;
			case "DICE 1"	:
				System.out.println("DICE 1");
				break;
			case "DICE 2"	:
				System.out.println("DICE 2");
				break;
			case "DICE 3"	:
				System.out.println("DICE 3");
				break;
			case "DICE 4"	:
				System.out.println("DICE 4");
				break;
			case "DICE 5"	:
				System.out.println("DICE 5");
				break;
			case "DICE 6"	:
				System.out.println("DICE 6");
				break;
		}
	}
	
	class KeyListener extends KeyAdapter {
		 public void keyTyped(KeyEvent e) {
			 model.updateText(e.getKeyChar());
		 }
	}
}