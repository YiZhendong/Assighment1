/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run(){
		while(frontIsClear()){
			turnEast();				//将起始位置朝东
			SetColumnStone();		//将一列全部填满
			turnBack();				//填满一列后回到该列下方
			
		}
	}
	
	//转向东
	private void turnEast() {
		while(notFacingEast()){		//如果不是朝东，向左转，直到朝东
			turnLeft();
		}
	}

	//返回下方
	private void turnBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
	}

	//填满一列
	private void SetColumnStone() {
		turnLeft();					//出发时向左拐
		while(frontIsClear()){
			if(noBeepersPresent()){		//判断当前位置是否有beeper
				putBeeper();
			}
			move();
		}
		
	}

	private void Continue() {
		// TODO Auto-generated method stub
		
	}

}
