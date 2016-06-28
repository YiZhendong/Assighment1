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
//		turnAround();						//后转
//		move();								//前进
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

	// 循环清除左右两边的方块
	private void removeBlocksStepByStep() {
		while(blockNumber()>2){
			removeWestBlock();
			removeEastBlock();
		}
		while(beepersPresent()){
			move();
			if(beepersPresent()){
				move();
				if(beepersPresent()){
					turnAround();
					move();
					move();
					pickBeeper();
					break;
				}
			}
		}
		
		/*removeEastBlock();					//清除最东边的方块
		removeWestBlock();					//接着清除最西边的方块
		while(beepersPresent()){			//如果当先存在方块
			move();
			
		}
		if(noBeepersPresent()){				//并且前方的格子中没有被阻塞
			turnAround();
			move();
			removeEastBlock();					//清除最东边的方块
			removeWestBlock();					//接着清除最西边的方块
		}
		*/
	}

	private int blockNumber() {
		// 计算所有的block的数量
		int i=0;
		while(beepersPresent()){
			i++;
			move();
		}
		return i;
	}

	private void removeEastBlock() {
		if(beepersPresent()){				//判断是否三个方块相邻，如果是的话，移除最东边的方块
			move();
			if(beepersPresent()){
				turnAround();				//存在，则后退，移除
				move();
				move();
				pickBeeper();
			}
		}
	}

	//移除最西边的方块
	private void removeWestBlock() {		
		turnAround();						//转身
		move();								//move一格
		while(beepersPresent()){			//如果当先存在方块
			if(frontIsClear()){				//并且前方的格子中没有被阻塞
				move();
			}else{
				break;
			}
		}
		turnAround();
		pickBeeper();
		move();
	}

}
