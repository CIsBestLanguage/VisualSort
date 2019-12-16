import java.util.LinkedList;

import javafx.scene.paint.Color;

public class SnapShot {
	private LinkedList<Information> queue;				//���д洢����
	private int timeOfSwap;								//��������е�Ԫ�ؽ�������
	private double maxQueueSize;						//�������ļ�¼
	
	public SnapShot() {
		queue = new LinkedList<>();
		timeOfSwap = 0;
	}
	
	public void enqueue(Information temp) {
		queue.add(temp);
	}
	
	//������Ϣ�����
	public void enqueue(int fx, int dx) {
		queue.add(new Information(fx, dx));
		maxQueueSize = queue.size();
		//����������һ
		timeOfSwap++;
	}
	
	//��ɫ�仯��Ϣ���
	public void enqueue(int fx, Color color) {
		queue.add(new Information(fx, color));
		maxQueueSize = queue.size();
	}
	
	//��������
	public Information dequeue() {
		return queue.removeFirst();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public Information getLast() {
		return queue.getLast();
	}
	
	public void clear() {
		maxQueueSize = 0;
		timeOfSwap = 0;
		queue.clear();
	}
	
	public int getTimeOfSwap() {
		return timeOfSwap;
	}
	
	public double getMaxQueueSize() {
		return maxQueueSize;
	}
	
	public int size() {
		return queue.size();
	}
}
