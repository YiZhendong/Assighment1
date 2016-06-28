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
		putLineBlocks();				//将一行填满方块,并转向
		removeBlocksStepByStep();		//循环从左边和右边各移动一个方块
	}

	//填满一行方块,并转向
	private void putLineBlocks() {
		while(frontIsClear()){
			putBeeper();
			move();
		}
		putBeeper();
		turnAround();
		
	}

	// 如果beeper数量大于2，则循环清除左右两边的方块，否则什么也不做
	private void removeBlocksStepByStep() {
		while(blockNumber()>2){	
			moveToBlockEnd();
			removeBlock();
			moveToBlockEnd();
			removeBlock();		
		}
		/*if(blockNumber()==2){
			
		}*/
	}
	
	//移除最边上的beeper,并前进一小格，走到beeper的地方
	private void removeBlock() {
		pickBeeper();
		move();
	}

	/*
	 * 条件：karel位于有block的一端
	 * 结果：karel跑到有block的另一端，i为block数量，并转向两次以避免奇数次对循环造成影响
	 */
	private int blockNumber() {
		// 计算所有的block的数量
		int i=0;
		while(beepersPresent()){
			i++;
			if(frontIsClear()){
				move();
			}else{
				break;
			}
		}
		turnAround();
		
		
		//再转回来
		while(beepersPresent()){
			if(frontIsClear()){
				move();
			}else{
				break;
			}
		}
		turnAround();
		return i;
		
	}

	/*
	 * 将karel移到存在beeper所有的位置的最边上的一点
	 */
	private void moveToBlockEnd() {
		while(frontIsClear()&&beepersPresent()){
			move();
		}
		if(noBeepersPresent()){
			turnAround();
			move();
		}else{
			turnAround();
		}
	}
	
}
