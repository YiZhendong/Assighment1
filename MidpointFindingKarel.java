/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 * 
 * author:zhendongYi
 * time:2016/06/27 
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run(){
		putLineBlocks();				//将一行填满方块
		removeBlocksStepByStep();		//循环从左边和右边各移动一个方块
	}

	//填满一行方块
	private void putLineBlocks() {
		while(frontIsClear()){
			putBeeper();
			move();
		}
		putBeeper();
		
	}

	// 循环清除左右两边的方块
	private void removeBlocksStepByStep() {
		removeEastBlock();
		removeWestBlock();
	}

	private void removeEastBlock() {
		turnAround();
		move();
		if(beepersPresent()){
			move();
			if(beepersPresent()){
				turnAround();
				move();
				move();
				pickBeeper();
			}
		}
	}

	private void removeWestBlock() {
		turnAround();
		move();
		while(beepersPresent()){
			while(frontIsClear()){
				move();
			}
		}
		turnAround();
		pickBeeper();
		
	}

}
