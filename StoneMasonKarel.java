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
		SetColumnStone();		//��һ��ȫ������
		turnBack();				//����һ�к�ص������·�
		if(leftIsClear()){		//�������ж��Ƿ񻹿��Լ���
			ontinue();
		}
	}
	
	private void turnBack() {
		
		
	}

	//����һ��
	private void SetColumnStone() {
		turnLeft();					//����ʱ�����
		while(leftIsBlocked()){
			if(noBeepersPresent()){		//�жϵ�ǰλ���Ƿ���beeper
				putBeeper();
			}
			move();
		}
		
	}

	private void Continue() {
		// TODO Auto-generated method stub
		
	}

}
