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
		loopCondition1();
		/*while(loopCondition()){
			moveToRight();
			turnToUpLine();
			moveToLeft();
			turnToUpLine();
		}		*/
	}
	
	private boolean loopCondition(){
		return (frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear());
	}
	
	private void moveToRight(){
		if(frontIsClear()){
			move();
		}else{
			
		}
	}

	private boolean loopCondition1() {
		while((frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear())){
			if(frontIsClear()){
				move();
			}else{
				while(notFacingNorth()){			//如果不朝北边的话，转向以朝北
					turnLeft();
					move();
				}
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
					move();
					putBeeper();
				}
				if(leftIsClear()){
					turnLeft();
				}else{
					turnRight();
				}
			}
		}
		return false;
	}
}
