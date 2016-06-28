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
		while((frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear())){
			if(frontIsClear()){
				move();
			}else{
				while(notFacingNorth()){			//����������ߵĻ���ת���Գ���
					turnLeft();
					
				}
				move();
				//ת�����������ת
				if(leftIsClear()){
					turnLeft();
				}else{
					turnRight();
				}
			}
			
			//���beeper
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
		}
	}

}
