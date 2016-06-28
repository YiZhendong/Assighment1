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
		/*while(beepersPresent()){
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
		*/
		/*removeEastBlock();					//�����ߵķ���
		removeWestBlock();					//������������ߵķ���
		while(beepersPresent()){			//������ȴ��ڷ���
			move();
			
		}
		if(noBeepersPresent()){				//����ǰ���ĸ�����û�б�����
			turnAround();
			move();
			removeEastBlock();					//�����ߵķ���
			removeWestBlock();					//������������ߵķ���
		}
		*/
	}
	
	/*
	 * ��karel�Ƶ�����beeper���е�λ�õ�����ϵ�һ��
	 */
	private void moveToBlockEnd() {
		while(frontIsBlocked()&&beepersPresent()){
			move();
		}
		if(beepersPresent()){
			turnAround();
			move();
		}else{
			turnAround();
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
			}
		}
		turnAround();
		return i;
	}

	private void removeEastBlock() {
		
		
		/*if(beepersPresent()){				//�ж��Ƿ������������ڣ�����ǵĻ����Ƴ���ߵķ���
			move();
			if(beepersPresent()){
				turnAround();				//���ڣ�����ˣ��Ƴ�
				move();
				move();
				pickBeeper();
			}
		}*/
	}

	//�Ƴ������ߵķ���
	private void removeWestBlock() {		
		turnAround();						//ת��
		move();								//moveһ��
		while(beepersPresent()){			//������ȴ��ڷ���
			if(frontIsClear()){				//����ǰ���ĸ�����û�б�����
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
