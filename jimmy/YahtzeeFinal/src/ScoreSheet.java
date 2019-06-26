import java.util.ArrayList;

public class ScoreSheet {
	public static ArrayList<Score> P1scoreSheet;
	public static ArrayList<Score> P2scoreSheet;
	public static final String[] DESCRIPTIONS = {"ScoreSheet",
			"Ones", "Twos", "Threes", "Fours", "Fives"
			, "Sixes", "Sum", "Bonus", "Three of a Kind", 
			"Four of a Kind", "Full House", "Small Straight", 
			"Large Straight", "Chance", "Yahtzee", "Total Score"
	};
	
	public ScoreSheet()	{
		P1scoreSheet = new ArrayList<Score>();
		P2scoreSheet = new ArrayList<Score>();
		initialize();
		clearSheet();
		display();
	}
	
	public void initialize()	{
		Score tempscore1 = new Score();
		tempscore1.setSuggested(false);
		tempscore1.setUsed(false);
		tempscore1.setMyPoints(0);
		tempscore1.setPointsXPos(170);
		tempscore1.setPointsYPos(20);
		tempscore1.setScoreType("ScoreSheet P1");
		P1scoreSheet.add(tempscore1);
		Score tempscore2 = new Score();
		tempscore2.setSuggested(false);
		tempscore2.setUsed(false);
		tempscore2.setMyPoints(0);
		tempscore2.setPointsXPos(170);
		tempscore2.setPointsYPos(20);
		tempscore2.setScoreType("ScoreSheet P2");
		P2scoreSheet.add(tempscore2);
	}
	
	public void clearSheet()	{
		for (int i = 1; i <= 2; i++)	{
			int counter = 43;
			for (int index = 1; index < 17; index++) {
				Score tempscore = new Score();
				tempscore.setSuggested(false);
				tempscore.setUsed(false);
				tempscore.setMyPoints(0);
				if(i == 1)	{
					tempscore.setPointsXPos(170);
				} else if(i == 2)	{
					tempscore.setPointsXPos(370);
				}
				tempscore.setPointsYPos(counter);
				tempscore.setScoreType(DESCRIPTIONS[index]);
				counter += 23;
				addScore(tempscore, i);
			}
		}
	}
	
	public void display()	{
		for(Score _score: P1scoreSheet)	{
			System.out.println(_score.getScoreType()+" X:"+_score.getPointsXPos()+" Y:"+_score.getPointsYPos());
		}
	}
	
	public void addScore(Score tempscore, int player)	{
		if (player == 1)	{
			P1scoreSheet.add(tempscore);
		} else if (player == 2)	{
			P2scoreSheet.add(tempscore);
		}
	}
	
	public void addScoreP1(Score tempscore)	{
		P1scoreSheet.add(tempscore);
	}
	
	public void addScoreP2(Score tempscore)	{
		P2scoreSheet.add(tempscore);
	}
	
	class Score	{
		private int myPoints;
		private int xPos, yPos;
		private boolean suggested;
		private boolean used;
		private boolean terminate;
		private String scoreType;
		
		public Score()	{
			myPoints = 0;
			used = false;
		}
		
		public void setScoreType(String scoreType)	{
			this.scoreType = scoreType;
		}
		
		public String getScoreType()	{
			return scoreType;
		}
		
		public void setMyPoints(int myPoints)	{
			this.myPoints = myPoints;
		}
		
		public void addMyPoints(int myPoints)	{
			this.myPoints += myPoints;
		}
		
		public int getMyPoints()	{
			return myPoints;
		}
		
		public void setPointsXPos(int xPos)	{
			this.xPos = xPos;
		}
		public int getPointsXPos()	{
			return xPos;
		}
		
		public void setPointsYPos(int yPos)	{
			this.yPos = yPos;
		}
		
		public int getPointsYPos()	{
			return yPos;
		}

		public void setUsed(boolean used)	{
			this.used = used;
		}
		
		public boolean getUsed()	{
			return used;
		}
		
		public void setTerminate(boolean terminate)	{
			this.terminate = terminate;
		}
		
		public boolean getTerminate()	{
			return this.terminate;
		}
		
		public void setSuggested(boolean suggested)	{
			this.suggested = suggested;
		}
		
		public boolean getSuggested()	{
			return this.suggested;
		}
		
		public boolean isTouching(int mouseX, int mouseY)	{
			if(!used && !scoreType.equals("ScoreSheet") && !scoreType.equals("ScoreSheet P2") && !scoreType.equals("Total Score"))	{
				if((xPos+22) > mouseX && mouseX > (xPos-8) && (yPos+6) > mouseY && mouseY > (yPos-8))	{
					return true;
				} else	{
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
