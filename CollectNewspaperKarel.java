/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 * 
 * author:zhendongYi
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	
	/*
	 * 主方法
	 * @see stanford.karel.SuperKarel#run()
	 */
	public void run(){
		CollectNewspaper();		//取报纸
		//GoBack();				//返回
	}

	/*
	 * 取报纸
	 */
	private void CollectNewspaper() {
		GoWithFloor();			//沿着天花板走
		GoWithWall();			//沿着墙走
		PickNewspaper();		//捡报纸
	}

	/*
	 * 沿着墙走
	 */
	private void GoWithWall() {
		while(leftIsBlocked()){		//前进
			move();
		}
		turnLeft();					//左转
	}

	/*
	 * 沿着天花板走
	 */
	private void GoWithFloor() {
		while(leftIsBlocked()){	//前进
			move();
		}
		turnRight();				//右转
	}

	private void PickNewspaper() {
		move();
		pickBeeper();
	}
	
	private void GoBack() {
		// TODO Auto-generated method stub
		
	}




}
