
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Window extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1000, 600);
		DrawPane drawPane = new DrawPane();
		Agent agent = new Agent(drawPane);
		ControlPane controlPane = new ControlPane(agent);
		
		//�ָ��߲���
		Line line = new Line(790, 0, 790, 610);
		line.setFill(Color.BLACK);
		
		
		//����������
		controlPane.setLayoutX(800);
		controlPane.setLayoutY(0);
		
		//����Ϳ������ͷָ��߼�����ײ����
		pane.getChildren().addAll(controlPane, drawPane, line);
		
		
		stage.setScene(scene);
		stage.setTitle("�����㷨������ʾ");
		stage.setResizable(false);
		stage.show();
	}
}
