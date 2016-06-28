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
			if(!LoopCondition()) break;
			moveOn();					//继续前进一格
			putBeeper();				//放置一个beeper
		}
	}


	/*
	 * 前进一格，直走或者转向并move
	 * 如果前方是空的话，move，
	 * 否则，向上拐，并转向
	 */
	private void moveOn() {
		if(frontIsClear()){
			move();
		}else{
			upAndTurnAround();
		}
		
	}

	/*
	 * 向上拐并转向
	 * 首先将方向朝向北，然后向上转并转向
	 */
	private void upAndTurnAround() {
		// TODO Auto-generated method stub
		faceToNorth();
		upAndTurn();
	}

	/*
	 * 前进，并根据左右情况转向
	 */
	private void upAndTurn() {
		move();
		if(leftIsClear()){
			turnLeft();
		}else{
			turnRight();
		}
	}

	/*
	 * 转向，直到面朝北
	 */
	private void faceToNorth() {
		// TODO Auto-generated method stub
		while(notFacingNorth()){
			turnLeft();			
		}
	}

	/*
	 * 循环条件函数
	 * 根据前左右的情况判断是否继续循环
	 */
	private boolean LoopCondition() {
		// TODO Auto-generated method stub
		return (frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear());
	}

}
