/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 * �㷨����һ�����ķ�ʽǰ����ÿ�����񣬷���һ��beeper
 * �ؼ���ת����жϣ��Լ�����beeper��ʱ��
 * 
 * ת�����ۺ�ʱ�����ϰ�����karelת����������Ȼ��ǰ������ת��û���ϰ���һ��
 * ����beeper����һ������moveOnֻǰ�����ڶ�����moveOnAndPutBeeper()ǰ���󲢷���beeper��
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		putBeeper();					//���ȷ���һ��beeper
		while(LoopCondition()){			//����ѭ�������Ļ��ͼ���
			moveOn();					//ǰ��һ��ֱ�߻���ת����ǰ����
			moveOnAndPutBeeper();		//ǰ��һ�񲢷���һ��beeper
		}
	}

	/*
	 * ǰ����������beeper
	 * ���ǰ�����ϰ���move
	 * ��������ת��ת��
	 * ������beeper
	 */
	private void moveOnAndPutBeeper() {
		if(frontIsClear()){
			move();
		}else{
			upAndTurnAround();
		}
		putBeeper();
	}

	private void moveOn() {
		if(frontIsClear()){
			move();
		}else{
			upAndTurnAround();
		}
		
	}

	private void upAndTurnAround() {
		// TODO Auto-generated method stub
		faceToNorth();
		upAndTurn();
	}

	private void upAndTurn() {
		// TODO Auto-generated method stub
		move();
		//ת�����������ת
		if(leftIsClear()){
			turnLeft();
		}else{
			turnRight();
		}
	}

	private void faceToNorth() {
		// TODO Auto-generated method stub
		while(notFacingNorth()){
			turnLeft();			
		}
	}

	private boolean LoopCondition() {
		// TODO Auto-generated method stub
		return (frontIsClear()||leftIsClear())&&(frontIsClear()||rightIsClear());
	}

}
