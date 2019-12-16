import java.util.ArrayList;

import javafx.animation.Animation.Status;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class DrawPane extends Pane {
	private ArrayList<DataGraph> rects;
	private Timeline animation;					//��Ҫʱ����
	private int duration = 200;					//ʱ����Ĭ�ϲ���ʱ��
	private Status status = Status.STOPPED;		//ʱ����״̬
	private ProgressBar progressBar;			//������
	private Label label;						//��������sorting��ǩ
	
	//���췽��
	public DrawPane() {
		rects = new ArrayList<>();
	}
	
	//��ʼ�����������������
	public void initProgressBar() {
		progressBar = new ProgressBar();
		label = new Label("Sorting...");
		label.setLayoutX(375);
		label.setLayoutY(520);
		label.setFont(Font.font(null, FontWeight.BOLD, 14));
		progressBar.setLayoutX(195);
		progressBar.setLayoutY(550);
		progressBar.setPrefWidth(400);
		progressBar.setProgress(0);
		super.getChildren().addAll(label, progressBar);
	}
	
	//���ý���������
	public void setProgressBar(double n) {
		progressBar.setProgress(n);
	}
	
	//����ʱ���ߵĲ�������
	public void setDuration(SnapShot snapShot, int duration) {
		this.duration = duration;
		pause();
		animation = new Timeline(new KeyFrame(Duration.millis(duration), e -> run(snapShot)));
		animation.setCycleCount(Timeline.INDEFINITE);
		
		//�������Ϊ����δ�������򣬽�״̬����Ϊֹͣ��������Ϊ��ͣ
		if (snapShot.isEmpty()) {
			status = Status.STOPPED;
		}
		else {
			status = Status.PAUSED;
		}
	}
	
	//��ʼ����ʱ�����Ѿ��������ն������ɶ���
	public void run(SnapShot snapShot) {
		//������������
		setProgressBar((snapShot.getMaxQueueSize() - snapShot.size()) / snapShot.getMaxQueueSize());
		if (!snapShot.isEmpty()) {
			Information temp = snapShot.dequeue();
			//����λ��
			if (temp.getSx() != -1) {
				TranslateTransition tt1 = new TranslateTransition(
						Duration.millis(duration - duration / 8), 
						rects.get(temp.getFx()).getLabel()
						);
				tt1.setFromX(rects.get(temp.getFx()).getTranslateX());
				tt1.setToX(rects.get(temp.getSx()).getTranslateX());
				tt1.playFromStart();
				
				TranslateTransition tt2 = new TranslateTransition(
						Duration.millis(duration - duration / 8), 
						rects.get(temp.getSx()).getLabel()
						);
				tt2.setFromX(rects.get(temp.getSx()).getTranslateX());
				tt2.setToX(rects.get(temp.getFx()).getTranslateX());
				tt2.playFromStart();
				
				DataGraph t = rects.get(temp.getFx());
				rects.set(temp.getFx(), rects.get(temp.getSx()));
				rects.set(temp.getSx(), t);
			}
			//�任��ɫ
			else {
				FillTransition ft = new FillTransition(
						Duration.millis(duration - duration / 9), 
						rects.get(temp.getFx()).getRect(), 
						rects.get(temp.getFx()).getColor(),
						temp.getColor()
						);
				ft.play();
			}
			
		}
	}
	
	//δ�����ԭʼ���ݵĳ�ʼ������
	public void draw(ArrayList<Integer> array) {
		DataGraph.graphAdapter(array);
		rects.clear();
		super.getChildren().clear();
		for (int i = 0; i < array.size(); i++) {
			DataGraph rect = new DataGraph(i, array.get(i));
			rect.added(this);
			rects.add(rect);
		}
		initProgressBar();
	}
	
	//ʱ���ߵ���Ӧ�����ķ�װ
	public void play(SnapShot snapShot, int duration) {
		if (animation == null) {
			animation = new Timeline(new KeyFrame(Duration.millis(duration), e -> run(snapShot)));
			animation.setCycleCount(Timeline.INDEFINITE);
		}
		status = Status.RUNNING;
		animation.play();
	}
	
	public void pause() {
		if (animation != null) {
			animation.pause();
		}
		status = Status.PAUSED;
	}
	
	public void stop() {
		if (animation != null) {
			animation.stop();
		}
		status = Status.STOPPED;
	}
	
	public  Status getStatus() {
		return status;
	}
	
	
}
