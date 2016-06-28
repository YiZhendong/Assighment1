/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 * 算法：以一条龙的方式前进，每走两格，放置一个beeper
 * 关键：转向的判断，以及放置beeper的时机
 * 
 * 转向：无论何时遇到障碍，将karel转至朝北方向，然后前进，再转向没有障碍的一侧
 * 放置beeper：第一个方法moveOn只前进，第二方法moveOnAndPutBeeper()前进后并放置beeper；
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		putBeeper();					//首先放置一个beeper
		while(LoopCondition()){			//满足循环条件的话就继续
			moveOn();					//前进一格（直走或者转向都算前进）
			moveOnAndPutBeeper();		//前进一格并放置一个beeper
		}
	}

	/*
	 * 前进，并放置beeper
	 * 如果前方无障碍，move
	 * 否则，向上转并转向
	 * 最后放置beeper
	 */
	private void moveOnAndPutBeeper() {
		if(frontIsClear()){
			move();
		}else{
			upAndTurnAround();
		}
		putBeeper();
	}

	private void moveOn() {
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
