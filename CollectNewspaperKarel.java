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
	 * ������
	 * @see stanford.karel.SuperKarel#run()
	 */
	public void run(){
		CollectNewspaper();		//ȡ��ֽ
		//GoBack();				//����
	}

	/*
	 * ȡ��ֽ
	 */
	private void CollectNewspaper() {
		GoWithFloor();			//�����컨����
		GoWithWall();			//����ǽ��
		PickNewspaper();		//��ֽ
	}

	/*
	 * ����ǽ��
	 */
	private void GoWithWall() {
		while(leftIsBlocked()){		//ǰ��
			move();
		}
		turnLeft();					//��ת
	}

	/*
	 * �����컨����
	 */
	private void GoWithFloor() {
		while(leftIsBlocked()){	//ǰ��
			move();
		}
		turnRight();				//��ת
	}

	private void PickNewspaper() {
		move();
		pickBeeper();
	}
	
	private void GoBack() {
		// TODO Auto-generated method stub
		
	}




}
