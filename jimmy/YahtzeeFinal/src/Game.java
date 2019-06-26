import javax.swing.JFrame;

import java.util.Arrays;

public class Game extends JFrame{
	
	public ScoreSheet scoresheet; 
	public static Panel panel;
	public static int[][] playerDice = new int[2][5];
	public static boolean[][] playerSaveDice = new boolean[2][5];
	public static int playerTurn = 2;
	
	public static boolean gameOver = true;
	public static int counter = 0;
	
	Game(Panel panel, ScoreSheet scoreSheet)	{
		this.panel = panel;
		this.scoresheet = scoreSheet;
	}
	
	public void play()	{
		panel.addToConsole("Game Start!");
		playerTurn = (int) (Math.random()*2);
		System.out.println(playerTurn);
		gameOver = false;
	}
	
	public void rollDice()	{
		if(counter < 3)	{
			for(int i = 0; i < 5; i++)	{
				if(playerSaveDice[playerTurn][i] == false)	{
					playerDice[playerTurn][i] = (int) (Math.random() * 6 + 1);
				}
			}
			counter++;
		} else {
			panel.addToConsole("No rolls left! Please choose something from scoresheet!");
		}
		sort();
		panel.dicePanel.updateDice();
	}
	
	
	
	public void sort()	{
		if(playerTurn == 0)	{
			for(ScoreSheet.Score item:ScoreSheet.P1scoreSheet)	{
				if(item.getScoreType().equals("Ones") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Ones")) {
							if(numberSort(1,temp) > 0)	{
								_score.setMyPoints(numberSort(1,temp));
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Twos") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Twos")) {
							if(numberSort(2,temp) > 0)	{
								_score.setMyPoints((numberSort(2,temp))*2);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Threes") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Threes")) {
							if(numberSort(3,temp) > 0)	{
								_score.setMyPoints((numberSort(3,temp))*3);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Fours") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Fours")) {
							if(numberSort(4,temp) > 0)	{
								_score.setMyPoints((numberSort(4,temp))*4);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Fives") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Fives")) {
							if(numberSort(5,temp) > 0)	{
								_score.setMyPoints((numberSort(5,temp))*5);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Sixes") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Sixes")) {
							if(numberSort(6,temp) > 0)	{
								_score.setMyPoints((numberSort(6,temp))*6);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Sum") && !item.getTerminate())	{
					int temp = 0;
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getUsed() && (_score.getScoreType().equals("Ones") || _score.getScoreType().equals("Twos") ||
							_score.getScoreType().equals("Threes") || _score.getScoreType().equals("Fours") ||
							_score.getScoreType().equals("Fives") || _score.getScoreType().equals("Sixes")))	{
							temp += (_score.getMyPoints());
							System.out.println(_score.getScoreType()+" now have:"+temp);
						} else if(_score.getScoreType().equals("Sum"))	{
							_score.setMyPoints(temp);
							panel.scoreSheetPanel.update();
						}
					}
				}
				if(item.getScoreType().equals("Bonus") && !item.getTerminate())	{
					int temp = 0;
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Sum"))	{
							if(_score.getMyPoints() >= 63)	{
								for(ScoreSheet.Score _temp: ScoreSheet.P1scoreSheet)	{
									if(_temp.getScoreType().equals("Bonus"))	{
										_temp.setMyPoints(35);
										for(ScoreSheet.Score _subScore: ScoreSheet.P1scoreSheet)	{
											if(_subScore.getScoreType().equals("Total Score"))	{
												_subScore.addMyPoints(_temp.getMyPoints());
											}
										}
									}
								}
							}
						}
					}
				}
				if(item.getScoreType().equals("Three of a Kind") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					System.out.println("Three of a Kind");
					for(int i = 1; i <= 6; i++)	{
						if(numberSort(i,temp) == 3 || numberSort(i,temp) == 4)	{
							for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
								if(_score.getScoreType().equals("Three of a Kind"))	{
									_score.setMyPoints(sumUp(temp));
									_score.setSuggested(true);
									panel.scoreSheetPanel.update();
								}
							}
							break;
						} else {
							for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
								if(_score.getScoreType().equals("Three of a Kind"))	{
									_score.setMyPoints(0);
									_score.setSuggested(false);
									panel.scoreSheetPanel.update();
								}
							}
						}
					}
				}
				if(item.getScoreType().equals("Four of a Kind") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(int i = 1; i <= 6; i++)	{
						if(numberSort(i,temp) == 4)	{
							for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
								if(_score.getScoreType().equals("Four of a Kind"))	{
									_score.setMyPoints(sumUp(temp));
									_score.setSuggested(true);
									panel.scoreSheetPanel.update();
								}
							}
							break;
						} else {
							for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
								if(_score.getScoreType().equals("Four of a Kind"))	{
									_score.setMyPoints(0);
									_score.setSuggested(false);
									panel.scoreSheetPanel.update();
								}
							}
						}
					}
				}
				if(item.getScoreType().equals("Full House") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					if(isFullHouse(temp))	{
						for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
							if(_score.getScoreType().equals("Full House")) {
								_score.setMyPoints(25);
								_score.setSuggested(true);
								panel.scoreSheetPanel.update();
							}
						}
						break;
					} else {
						for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
							if(_score.getScoreType().equals("Full House"))	{
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Small Straight") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					if(isSmallStraight(temp))	{
						for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
							if(_score.getScoreType().equals("Small Straight"))	{
								_score.setMyPoints(30);
								_score.setSuggested(true);
							}
						}
					} else {
						for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
							if(_score.getScoreType().equals("Small Straight"))	{
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Large Straight") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					if(isLargeStraight(temp))	{
						for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
							if(_score.getScoreType().equals("Large Straight"))	{
								_score.setMyPoints(40);
								_score.setSuggested(true);
							}
						}
					} else {
						for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
							if(_score.getScoreType().equals("Large Straight"))	{
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Chance") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
						if(_score.getScoreType().equals("Chance"))	{
							_score.setMyPoints(sumUp(temp));
							panel.scoreSheetPanel.update();
						}
					}
				}
				if(item.getScoreType().equals("Yahtzee") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(int i = 1; i <= 6; i++)	{
						if(numberSort(i,temp) == 5)	{
							for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
								if(_score.getScoreType().equals("Yahtzee"))	{
									_score.setMyPoints(50);
									_score.setSuggested(true);
									panel.scoreSheetPanel.update();
								}
							}
							break;
						} else {
							for(ScoreSheet.Score _score: ScoreSheet.P1scoreSheet)	{
								if(_score.getScoreType().equals("Yahtzee"))	{
									_score.setMyPoints(0);
									_score.setSuggested(false);
									panel.scoreSheetPanel.update();
								}
							}
						}
					}
				}
			}
		} else if(playerTurn == 1)	{
			for(ScoreSheet.Score item:ScoreSheet.P2scoreSheet)	{
				if(item.getScoreType().equals("Ones") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Ones")) {
							if(numberSort(1,temp) > 0)	{
								_score.setMyPoints(numberSort(1,temp));
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Twos") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Twos")) {
							if(numberSort(2,temp) > 0)	{
								_score.setMyPoints((numberSort(2,temp))*2);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Threes") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Threes")) {
							if(numberSort(3,temp) > 0)	{
								_score.setMyPoints((numberSort(3,temp))*3);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Fours") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Fours")) {
							if(numberSort(4,temp) > 0)	{
								_score.setMyPoints((numberSort(4,temp))*4);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Fives") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Fives")) {
							if(numberSort(5,temp) > 0)	{
								_score.setMyPoints((numberSort(5,temp))*5);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Sixes") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Sixes")) {
							if(numberSort(6,temp) > 0)	{
								_score.setMyPoints((numberSort(6,temp))*6);
								_score.setSuggested(true);
							} else {
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Sum") && !item.getTerminate())	{
					int temp = 0;
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getUsed() && (_score.getScoreType().equals("Ones") || _score.getScoreType().equals("Twos") ||
							_score.getScoreType().equals("Threes") || _score.getScoreType().equals("Fours") ||
							_score.getScoreType().equals("Fives") || _score.getScoreType().equals("Sixes")))	{
							temp += (_score.getMyPoints());
							System.out.println(_score.getScoreType()+" now have:"+temp);
						} else if(_score.getScoreType().equals("Sum"))	{
							_score.setMyPoints(temp);
							panel.scoreSheetPanel.update();
						}
					}
				}
				if(item.getScoreType().equals("Bonus") && !item.getTerminate())	{
					int temp = 0;
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Sum"))	{
							if(_score.getMyPoints() >= 63)	{
								for(ScoreSheet.Score _temp: ScoreSheet.P2scoreSheet)	{
									if(_temp.getScoreType().equals("Bonus"))	{
										_temp.setMyPoints(35);
										for(ScoreSheet.Score _subScore: ScoreSheet.P2scoreSheet)	{
											if(_subScore.getScoreType().equals("Total Score"))	{
												_subScore.addMyPoints(_temp.getMyPoints());
											}
										}
									}
								}
							}
						}
					}
				}
				if(item.getScoreType().equals("Three of a Kind") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					System.out.println("Three of a Kind P2");
					for(int i = 1; i <= 6; i++)	{
						if(numberSort(i,temp) == 3 || numberSort(i,temp) == 4)	{
							for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
								if(_score.getScoreType().equals("Three of a Kind"))	{
									System.out.println("Is P2 Three of a Kind");
									_score.setMyPoints(sumUp(temp));
									_score.setSuggested(true);
									panel.scoreSheetPanel.update();
								}
							}
							break;
						} else {
							for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
								if(_score.getScoreType().equals("Three of a Kind"))	{
									_score.setMyPoints(0);
									_score.setSuggested(false);
									panel.scoreSheetPanel.update();
								}
							}
						}
					}
				}
				if(item.getScoreType().equals("Four of a Kind") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(int i = 1; i <= 6; i++)	{
						if(numberSort(i,temp) == 4)	{
							for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
								if(_score.getScoreType().equals("Four of a Kind"))	{
									_score.setMyPoints(sumUp(temp));
									_score.setSuggested(true);
									panel.scoreSheetPanel.update();
								}
							}
							break;
						} else {
							for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
								if(_score.getScoreType().equals("Four of a Kind"))	{
									_score.setMyPoints(0);
									_score.setSuggested(false);
									panel.scoreSheetPanel.update();
								}
							}
						}
					}
				}
				if(item.getScoreType().equals("Full House") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					if(isFullHouse(temp))	{
						for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
							if(_score.getScoreType().equals("Full House")) {
								_score.setMyPoints(25);
								_score.setSuggested(true);
								panel.scoreSheetPanel.update();
							}
						}
						break;
					} else {
						for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
							if(_score.getScoreType().equals("Full House"))	{
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Small Straight") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					if(isSmallStraight(temp))	{
						for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
							if(_score.getScoreType().equals("Small Straight"))	{
								_score.setMyPoints(30);
								_score.setSuggested(true);
							}
						}
					} else {
						for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
							if(_score.getScoreType().equals("Small Straight"))	{
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Large Straight") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					if(isLargeStraight(temp))	{
						for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
							if(_score.getScoreType().equals("Large Straight"))	{
								_score.setMyPoints(40);
								_score.setSuggested(true);
							}
						}
					} else {
						for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
							if(_score.getScoreType().equals("Large Straight"))	{
								_score.setMyPoints(0);
								_score.setSuggested(false);
							}
						}
					}
				}
				if(item.getScoreType().equals("Chance") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
						if(_score.getScoreType().equals("Chance"))	{
							_score.setMyPoints(sumUp(temp));
							panel.scoreSheetPanel.update();
						}
					}
				}
				if(item.getScoreType().equals("Yahtzee") && !item.getTerminate())	{
					int[] temp = new int[5];
					for(int i = 0; i < 5; i++)	{
						temp[i] = playerDice[playerTurn][i];
					}
					for(int i = 1; i <= 6; i++)	{
						if(numberSort(i,temp) == 5)	{
							for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
								if(_score.getScoreType().equals("Yahtzee"))	{
									_score.setMyPoints(50);
									_score.setSuggested(true);
									panel.scoreSheetPanel.update();
								}
							}
							break;
						} else {
							for(ScoreSheet.Score _score: ScoreSheet.P2scoreSheet)	{
								if(_score.getScoreType().equals("Yahtzee"))	{
									_score.setMyPoints(0);
									_score.setSuggested(false);
									panel.scoreSheetPanel.update();
								}
							}
						}
					}
				}
			}
		}
	}
	
	public int sumUp(int[] array)	{
		int sum = 0;
		for(int i = 0; i < 5; i++)	{
			sum += array[i];
		}
		return sum;
	}
	
	public int numberSort(int num, int[] array)	{
		int counter = 0;
		for(int dice = 0; dice < 5; dice++)	{
			if(array[dice] == num)	{
				counter++;
			}
		}
		return counter;
	}
	
	public boolean isLargeStraight(int[] dice) {
		Arrays.sort(dice);
	     boolean found = false;
	     int c = 0;
	     for (int i = 0; i < dice.length - 1; i++)
	     {
	   	 

	         if (dice[i + 1] == dice[i] + 1)
	         {
	             c++;
	         }
	         else if (dice[i + 1] == dice[i])
	         {
	             continue;
	         }
	         else
	         {
	             c = 0;
	         }
	         
	         if (c > 3) {
	   	     found = true;
	   	     break;
	   	 }
	     }

	     if (found)
	     {
	        System.out.println("large");
	        return true;
	     }
	     else
	     {
	         System.out.println("nope");
	         return false;
	   }
	}
	
	public boolean isSmallStraight(int[] array)	{
		 Arrays.sort(array);
		 boolean found = false;
		 int c = 0;
		 for (int i = 0; i < array.length - 1; i++)	{
	         if (array[i + 1] == array[i] + 1)	{
	             c++;
	         }
	         else if (array[i + 1] == array[i])	{
	             continue;
	         }
	         else	{
	             c = 0;
	         }
	         if (c == 3 && !isLargeStraight(array)) {
	        	 found = true;
	        	 break;
		   	 }
		 }
		 if (found)	{
		     return true;
		 }
	     else	{
	    	 return false;
	     }
	}
	
	

	
	public boolean isFullHouse(int[] array)	{
		int temp1 = array[0];
		int temp2 = 0;
		int c1 = 0;
		int c2 = 0;
		int ten1, ten2, ten3;


		for(int i = 0; i < array.length; i++) {
		if(array[i] == temp1) {
		c1++;
		}
		}

		for(int i = 0; i < array.length; i++) {
		if(array[i] != temp1) {
		temp2 = array[i];
		break;
		}
		}

		for(int i = 0; i < array.length; i++) {
		if(array[i] == temp2) {
		c2++;
		}
		}

		if((c1 == 2 && c2 == 3) || (c1 == 3 && c2 == 2)) {
		System.out.println("FullHouse");
		return true;
		} else {
		System.out.println("nope");
		return false;
		}
		}
	
	public static void switchPlayer() {
		if(playerTurn == 1)	{
			playerTurn = 0;
		} else {
			playerTurn = 1;
		}
		counter = 0;
		panel.diceReset();
		for(int player = 0; player < 2; player++)	{
			for(int i = 0; i < 5; i++)	{
				playerDice[player][i] = 0;
				playerSaveDice[player][i] = false;
			}
		}
		panel.dicePanel.updateDice();
		panel.scoreSheetPanel.update();
	}
	
	public void setGameOver(boolean gameOver)	{
		this.gameOver = gameOver;
	}
	
	public boolean getGameOver()	{
		return gameOver;
	}
}
