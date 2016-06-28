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

	// ���beeper��������2����ѭ������������ߵķ��飬����ʲôҲ����
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
	
	//�Ƴ�����ϵ�beeper,��ǰ��һС���ߵ�beeper�ĵط�
	private void removeBlock() {
		pickBeeper();
		move();
	}

	/*
	 * ������karelλ����block��һ��
	 * �����karel�ܵ���block����һ�ˣ�iΪblock��������ת�������Ա��������ζ�ѭ�����Ӱ��
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
		
		
		//��ת����
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
	 * ��karel�Ƶ�����beeper���е�λ�õ�����ϵ�һ��
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
