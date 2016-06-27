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
			turnEast();				//����ʼλ�ó���
			SetColumnStone();		//��һ��ȫ������
			turnBack();				//����һ�к�ص������·�
			
		}
	}
	
	//ת��
	private void turnEast() {
		while(notFacingEast()){		//������ǳ���������ת��ֱ������
			turnLeft();
		}
	}

	//�����·�
	private void turnBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
	}

	//����һ��
	private void SetColumnStone() {
		turnLeft();					//����ʱ�����
		while(frontIsClear()){
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
