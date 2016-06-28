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
		putLineBlocks();				//��һ����������,��ת��
		removeBlocksStepByStep();		//ѭ������ߺ��ұ߸��ƶ�һ������
	}

	//����һ�з���,��ת��
	private void putLineBlocks() {
		while(frontIsClear()){
			putBeeper();
			move();
		}
		putBeeper();
		turnAround();
		
	}

	// ѭ������������ߵķ���
	private void removeBlocksStepByStep() {
		while(blockNumber()>2){	
			moveToBlockEnd();
			removeEastBlock();
			moveToBlockEnd();
			removeWestBlock();	
		}
	}
	
	/*
	 * ������karelλ����block��һ��
	 * �����karel�ܵ���block����һ�ˣ�iΪblock������ת��
	 */
	private int blockNumber() {
		// �������е�block������
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
		System.out.print(i);
		System.out.print(facingEast());
		return i;
		
	}

	/*
	 * ��karel�Ƶ�����beeper���е�λ�õ�����ϵ�һ��
	 */
	private void moveToBlockEnd() {
		while(frontIsClear()&&beepersPresent()){
			move();
		}
		if(beepersPresent()){
			turnAround();
			move();
		}else{
			turnAround();
		}
	}
	
	private void removeEastBlock() {
		pickBeeper();
		turnAround();
	}

	//�Ƴ������ߵķ���
	private void removeWestBlock() {		
		pickBeeper();
		turnAround();
	}

}
