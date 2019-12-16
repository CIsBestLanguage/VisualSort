import javafx.scene.paint.Color;

//��Ϣ��洢��������е�λ�ñ仯�Լ�Ҫ��ʾ����ɫ�仯
public class Information {
	private Color color;
	private int fx;
	private int sx;
	
	public Information() {
		
	}
	
	public Information(int fx, int sx) {
		this.fx = fx;
		this.sx = sx;
	}
	
	public Information(int fx, Color color) {
		this.fx = fx;
		this.sx = -1;
		this.color = color;
	}
	
	
	public int getFx() {
		return fx;
	}
	
	public int getSx() {
		return sx;				
	}
	
	public Color getColor() {
		return color;
	}
}
