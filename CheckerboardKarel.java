/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		putBeeper();
		while(LoopCondition()){
			moveOn();
			moveOnAndPutBeeper();
		}
		/*while((frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear())){
			if(frontIsClear()){
				move();
			}else{
				while(notFacingNorth()){			//如果不朝北边的话，转向以朝北
					turnLeft();					
				}
				move();
				//转向后向左向右转
				if(leftIsClear()){
					turnLeft();
				}else{
					turnRight();
				}
			}
			
			//添加beeper
			if(frontIsClear()){
				move();
				putBeeper();
			}else{
				while(notFacingNorth()){
					turnLeft();
					
				}
				move();
				putBeeper();
				if(leftIsClear()){
					turnLeft();
				}else{
					turnRight();
				}
			}
		}*/
	}

	private void moveOnAndPutBeeper() {
		// TODO Auto-generated method stub
		if(frontIsClear()){
			move();
			putBeeper();
		}else{
			upAndTurnAround();
			putBeeper();
		}
	}

	private void moveOn() {
		// TODO Auto-generated method stub
		if(frontIsClear()){
			move();
		}else{
			upAndTurnAround();
		}
		
	}

	private void upAndTurnAround() {
		// TODO Auto-generated method stub
		faceToNorth();
		upAndTurn();
	}

	private void upAndTurn() {
		// TODO Auto-generated method stub
		move();
		//转向后向左向右转
		if(leftIsClear()){
			turnLeft();
		}else{
			turnRight();
		}
	}

	private void faceToNorth() {
		// TODO Auto-generated method stub
		while(notFacingNorth()){
			turnLeft();			
		}
	}

	private boolean LoopCondition() {
		// TODO Auto-generated method stub
		return (frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear());
	}

}
