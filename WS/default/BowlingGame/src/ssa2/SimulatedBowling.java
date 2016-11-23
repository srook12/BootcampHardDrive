package ssa2;

public class SimulatedBowling {
	private static java.util.Random rnd = new java.util.Random((new java.util.Date()).getTime());
	
	// 2-D array indexes the number of games and total number of bowls per game, which
	// could potentially be 21
	private int bowlingScores[][] = new int[NUM_GAMES][NUM_FRAMES * 2 + 1];
	private static final int NUM_FRAMES = 10;
	private static final int NUM_GAMES = 3;
	
	// Status constants
	private static final String BEFORE_NINTH = "B49";
	private static final String NINTH = "9th";
	private static final String TENTH = "10th";
	
	// Holds the cumulative score of each game
	private int cumulativeScores[][] = new int[NUM_GAMES][NUM_FRAMES];
	
	// Holds the string representation of the scores shown to the player
	private String bowlingScoresString[][] = new String[NUM_GAMES][NUM_FRAMES*2+1];
	
	public void bowl() {
		// For each game
		
		for(int game = 0; game < bowlingScores.length; game++) {
			bowlGame(game);
		}
		/*
		bowlingScores[0][0] = 10;
		bowlingScores[0][1] = 0;
		bowlingScores[0][2] = 10;
		bowlingScores[0][3] = 0;
		bowlingScores[0][4] = 10;
		bowlingScores[0][6] = 10;
		bowlingScores[0][8] = 10;
		bowlingScores[0][10] = 10;
		bowlingScores[0][12] = 10;
		bowlingScores[0][14] = 10;
		bowlingScores[0][16] = 10;
		bowlingScores[0][17] = 0;
		bowlingScores[0][18] = 2;
		bowlingScores[0][19] = 7;
		bowlingScores[0][20] = 0;
		*/
		calculateCumulativeScores();
		writeScoresAsStrings();
		printScores();
	}
	
	private void bowlGame(int game) {
		for(int frame = 0; frame < NUM_FRAMES; frame++) {
			bowlFrame(game, frame);
		}
	}
	
	private void bowlFrame(int game, int frame) {
		// Always bowl twice, no matter the frame
		int firstShot = getPinsKnockedDown();
		int secondShot = getPinsKnockedDown();
		
		// For frames 1 - 9
		if(frame < NUM_FRAMES - 1) {
			// Depending on the first shot, we may need to adjust the second shot
			
			// if secondShot >= (10-firstShot), set secondShot = 10-firstShot;
			// otherwise, leave it alone
			secondShot = getResidual(firstShot, secondShot);
		}
		// Frame 10 is special
		else {
			// If first shot of the 10th frame is not a strike, get the residual
			// for the second shot
			if(firstShot < 10) {
				secondShot = getResidual(firstShot, secondShot);
			}
			
			// Get the value of the third shot if it happens
			int thirdShot = getValueOfThirdShot(firstShot, secondShot);
			bowlingScores[game][frame*2+2] = thirdShot;
		}
		
		// Store the values of the first and second shots
		bowlingScores[game][frame*2] = firstShot;
		bowlingScores[game][frame*2+1] = secondShot;
	}
	
	private int getResidual(int firstShot, int secondShot) {
		return Math.min(secondShot, (10 - firstShot));
	}
	
	private int getValueOfThirdShot(int firstShot, int secondShot) {
		int thirdShot = 0;
		
		// If the first shot is a strike...
		if(firstShot == 10) {
			// Bowl the third shot regardless
			thirdShot = getPinsKnockedDown();
			
			// If the second shot is a strike, then the third shot is between 1
			// and 10 inclusive (do nothing); otherwise, the third shot is the residual
			if(secondShot < 10) {
				thirdShot = getResidual(secondShot, thirdShot);
			}
		}
		// Otherwise, we need a spare to take the third shot
		else if((firstShot + secondShot) == 10) {
			// Third shot would be between 1 and 10 inclusive
			thirdShot = getPinsKnockedDown();
		}
		
		// If neither of these cases, we don't take the third shot and it remains 0
		
		return thirdShot;
	}
		
	private int getPinsKnockedDown() {
		
		int randomInt = rnd.nextInt(11); // zero to ten
		return randomInt;
	}
	
	private void calculateCumulativeScores() {		
		for(int game = 0; game < bowlingScores.length; game++) {
			calculateCumulativeScoresGame(game);
		}
	}
	
	private void calculateCumulativeScoresGame(int game) {
		int cumulativeScore = 0;
		for(int frame = 0; frame < NUM_FRAMES; frame++) {
			int bonus = 0;
			
			// Frames 1-8
			if(frame < NUM_FRAMES - 2) {
				// Add the current frame		
				cumulativeScore += (bowlingScores[game][2*frame] + 
						 bowlingScores[game][2*frame+1]);
				
				// Get bonus if the frame was a strike
				if(isStrike(game, frame*2)) {
					bonus = scoreStrike(game, frame*2, BEFORE_NINTH);
				} 
				// Get bonus if the frame was a spare
				else if(isSpare(game, frame*2, frame*2+1)) {
					bonus = scoreSpare(game, frame*2);
				}
			}
			// Frame 9
			else if(frame == 8) {
				// Add the current frame		
				cumulativeScore += (bowlingScores[game][2*frame] + 
						 bowlingScores[game][2*frame+1]);
				
				// Get bonus if the frame was a strike
				if(isStrike(game, frame*2)) {
					bonus = scoreStrike(game, frame*2, NINTH);
				} 
				// Get bonus if the frame was a spare
				else if(isSpare(game, frame*2, frame*2+1)) {
					bonus = scoreSpare(game, frame*2);
				}
			}
			// Frame 10
			else {
				// Strike on the first throw
				if(isStrike(game, frame*2)) {
					cumulativeScore += bowlingScores[game][2*frame];
					bonus = scoreStrike(game, frame*2, TENTH);
				}
				// Spare on the first throw
				else if(isSpare(game, frame*2, frame*2+1)) {
					cumulativeScore += (bowlingScores[game][2*frame] +
							            bowlingScores[game][2*frame+1]);
					bonus = scoreSpare(game, frame*2);
				} else {
					cumulativeScore += (bowlingScores[game][2*frame] +
				            bowlingScores[game][2*frame+1]);
				}
			}
			
			cumulativeScore += bonus;
			cumulativeScores[game][frame] = cumulativeScore;
		}
	}
		
	private int scoreStrike(int game, int frameIndex, String status) {
		int bonus = 0;
		
		switch(status) {
		    case BEFORE_NINTH:
		    	// Take first shot
		    	bonus += bowlingScores[game][frameIndex + 2];
		    	
		    	// Take second shot 
		    	if(isStrike(game, frameIndex + 2)) {
		    		bonus += bowlingScores[game][frameIndex + 4];
		    	} else {
		    		bonus += bowlingScores[game][frameIndex + 3];
		    	}
		    	
		    	break;
		    case NINTH:
		    	// Take first shot
		    	bonus += bowlingScores[game][frameIndex + 2];
		    	
		    	// Take second shot
		    	bonus += bowlingScores[game][frameIndex + 3];
		    	break;
		    case TENTH:
		    	bonus += bowlingScores[game][frameIndex + 1];
		    	bonus += bowlingScores[game][frameIndex + 2];
		    	
		    	break;
		}	
		return bonus;
	}
	
	private int scoreSpare(int game, int frameIndex) {
		// Get the next throw
		return bowlingScores[game][frameIndex + 2];		
	}
	
	private void writeScoresAsStrings() {
		for(int game = 0; game < bowlingScores.length; game++) {
			for(int frame = 0; frame < NUM_FRAMES; frame++) {
				// For frames 1 - 9
				if(frame < NUM_FRAMES - 1) {
					// Check for a strike
					if(isStrike(game, frame*2)) {
						markStrike(game, frame*2, false);
					}
					// Check for a spare
					else if(isSpare(game, frame*2, frame*2+1)) {
						markSpare(game, frame*2, frame*2+1);
					}
					// For open frames
					else {
						markOpenFrame(game, 2*frame, 2*frame+1);
					}
				}
				// For frame 10
				else {
					if(!(firstShotStrikeTenth(game, frame) ||
					     firstShotSpareTenth(game, frame))) {
						markNumber(game, frame*2);
						markNumber(game, frame*2+1);
						markNumber(game, frame*2+2);
					}					
				}
			}
		}
	}
	
	private boolean isStrike(int game, int frameIndex) {
		return bowlingScores[game][frameIndex] == 10;		
	}
	
	private void markStrike(int game, int frameIndex, boolean isTenthFrame) {
		if(!isTenthFrame) {
			bowlingScoresString[game][frameIndex] = "-";
			bowlingScoresString[game][frameIndex+1] = "X";
		} else	{	
			bowlingScoresString[game][frameIndex] = "X";
		}
	}
	
	private boolean isSpare(int game, int firstFrameIndex, int secondFrameIndex) {
		return (bowlingScores[game][firstFrameIndex] + 
			   bowlingScores[game][secondFrameIndex]) == 10;
	}
	
	private void markSpare(int game, int firstFrameIndex, int secondFrameIndex) {
		markNumber(game, firstFrameIndex);
		bowlingScoresString[game][secondFrameIndex] = "/";
	}
	
	private void markOpenFrame(int game, int firstFrameIndex, int secondFrameIndex) {
		markNumber(game, firstFrameIndex);
		markNumber(game, secondFrameIndex);
	}
	
	// If not 0, write the number; otherwise, write a dash
	private void markNumber(int game, int frameIndex) {
		if(bowlingScores[game][frameIndex] != 0) {
			bowlingScoresString[game][frameIndex] =
					String.valueOf(bowlingScores[game][frameIndex]);
		} else {
			bowlingScoresString[game][frameIndex] = "-";
		}
	}

	// If the first shot in the 10th frame is a strike, then the possibilities are:
	//     -Second shot is a strike
	//         -Third shot is a strike
	//         -Third shot less than 10
	//     -Second shot is a spare
	//     -Second shot is less than 10
	//         -Third shot is not more than 10-secondShot (pins aren't reset)
	private boolean firstShotStrikeTenth(int game, int frame) {
		boolean isFirstShotStrike = false;
		
		if(isStrike(game, frame*2)) {
			isFirstShotStrike = true;
			markStrike(game, frame*2, true);
				
			// Is the second shot a strike?
			if(isStrike(game, frame*2+1)) {
				markStrike(game, frame*2+1, true);
				
				// Is the third shot a strike?
				if(isStrike(game, frame*2+2)) {
					markStrike(game, frame*2+2, true);
				} else {
					markNumber(game, frame*2+2);
				}
			}
			// Does the second shot result in a spare along with the third shot?
			else if(isSpare(game, frame*2+1, frame*2+2)) {
				markSpare(game, frame*2+1, frame*2+2);
			} else {
				markNumber(game, frame*2+1);
				markNumber(game, frame*2+2);
			}
		}
		
		return isFirstShotStrike;
	}
	
	// If the first shot in the 10th frame is a spare, then the possibilities are:
	//     -Third shot is a strike
	//     -Third shot is less than 10
	private boolean firstShotSpareTenth(int game, int frame) {
		boolean isFirstShotSpare = false;
		
		if(isSpare(game, frame*2, frame*2+1)) {
			isFirstShotSpare = true;
			markSpare(game, frame*2, frame*2+1);
			
			// Third shot a strike?
			if(isStrike(game, frame*2+2)) {
				markStrike(game, frame*2+2, true);
			} else {
				markNumber(game, frame*2+2);
			}
		}
		
		return isFirstShotSpare;
	}
	
	private void printHeader() {
		System.out.print(String.format("%-14s", "Frames"));
		for(int frame = 1; frame <= NUM_FRAMES; frame++) {
			System.out.print(String.format("%2s", " "));
			System.out.print(String.format("%d", frame));
			System.out.print(String.format("%7s", " "));
		}
		System.out.println(String.format("%8s", "Total"));
		System.out.println();
		
	}
	
	private void printScores() {
		printHeader();
				
		int totalScoreSeries = 0;
		for(int game = 0; game < bowlingScores.length; game++) {
			System.out.print(String.format("%-10s", ("Game " + (game+1))));
			
			for(int frame = 0; frame < NUM_FRAMES; frame++) {
				String frameScoreString = "";
				
				if(frame < NUM_FRAMES - 1) {
					frameScoreString = String.format("[%s][%s]", 
						bowlingScoresString[game][frame*2], 
						bowlingScoresString[game][frame*2+1] );
					System.out.print(String.format("%10s", frameScoreString));
				} else {
					frameScoreString = String.format("[%s][%s][%s]", 
						bowlingScoresString[game][frame*2], 
						bowlingScoresString[game][frame*2+1],
						bowlingScoresString[game][frame*2+2]);
					System.out.print(String.format("%12s", frameScoreString));
				}
			}
			System.out.println();
			System.out.print(String.format("%14s", " "));
			
			for(int frame = 0; frame < NUM_FRAMES; frame++) {
				int totalFrame = bowlingScores[game][frame*2] + bowlingScores[game][frame*2+1];
				
				// Add the scores of the two bowls for each frame under 10
				if(frame < NUM_FRAMES - 1) {
					System.out.print(String.format("%3s", " "));
					//System.out.print(String.format("%3d", totalFrame));	
					System.out.print(String.format("%3d", cumulativeScores[game][frame]));
					System.out.print(String.format("%4s", " "));
				} else { // Add the scores of the possibly three bowls for frame 10
					totalFrame += bowlingScores[game][frame*2+2];
					System.out.print(String.format("%5s", " "));
					System.out.print(String.format("%3d", cumulativeScores[game][frame]));
					System.out.print(String.format("%4s", " "));
				}
			}
			totalScoreSeries += cumulativeScores[game][9];
			System.out.println(String.format("%6s\n", cumulativeScores[game][9]));				
		}
		System.out.println(String.format("%-114s%8d", "Total Series", totalScoreSeries));
	}
}
