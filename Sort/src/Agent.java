import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.Animation.Status;

public class Agent {
	private Sort sort;						//����ӿ�
	private SnapShot snapShot;				//���ն�����
	private ArrayList<Integer> rawArray;	//ԭʼ����
	private ArrayList<Integer> array;		//�����������
	private FileOperation FO;				//�ļ�������
	private DrawPane drawPane;				//�������������
	private int duration = 200;				//��������ʱ��
	private int randomDataSize = 20;		//���������������Χ
	
	public Agent() {
		
	}
	
	//����
	public Agent(DrawPane drawPane) {
		FO = new FileOperation();
		array = new ArrayList<>();
		rawArray = new ArrayList<>();
		snapShot = new SnapShot();
		this.drawPane = drawPane;
		
	}
	
	//��������ʽ
	public void setWayOfSort(String way) {
		if (way.equals("ð������")) {
			sort = new BubbleSort();
		}
		else if (way.equals("��������")) {
			sort = new InsertSort();
		}
		else if (way.equals("ѡ������")) {
			sort = new SelectionSort();
		}
		else if (way.equals("��������")) {
			sort = new QuickSort();
		}
	}
	
	//�ָ�����
	public void recover() {
		array = (ArrayList<Integer>) rawArray.clone();
	}
	
	public void sort() {
		sort.sort(0, array.size() - 1, array, snapShot);
		//draw();
	}
	
	public void save() throws IOException {
		FO.writeFile(rawArray);
	}
	
	public void randomData() {
		rawArray.clear();
		array.clear();
		for (int i = 0; i < randomDataSize; i++) {
			int temp = (int)(Math.random() * 100 + 1);
			array.add(temp);
			rawArray.add(temp);
		}
	}
	
	public void play() {
		if (drawPane.getStatus() == Status.STOPPED && !array.isEmpty()) {
			sort();
		}
		
		drawPane.play(snapShot, duration);
	}
	
	public void pause() {
		drawPane.pause();
	}
	
	public void draw() {
		drawPane.draw(rawArray);
	}
	
	public void stop() {
		drawPane.stop();
		snapShot.clear();
	}
	
	public void textInput(String[] temp) {
		array.clear();
		rawArray.clear();
		try {
			if (temp != null) {
				for (int i = 0; i < temp.length; i++) {
					int t = Integer.valueOf(temp[i]);
					array.add(t);
					rawArray.add(t);
				}
			}
		} catch (NumberFormatException e) {
			//System.out.println("111");
			array.clear();
			rawArray.clear();
		}
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
		drawPane.setDuration(snapShot, duration);
	}
	
	public void setRandomDataSize(int randomDataSize)  {
		this.randomDataSize = randomDataSize;
	}
	
}
