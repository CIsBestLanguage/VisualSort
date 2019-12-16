import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileOperation {
	
	//д���ļ�
	public void writeFile(ArrayList<Integer> rawArray) throws IOException {
		ArrayList<Integer> array;
		SnapShot snapShot = new SnapShot();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-HH-mm-ss");
		
		PrintWriter output = new PrintWriter(new File(df.format(new Date()) + ".txt"));
		
		//���������㷨�Ļ�����Ϣ�ͽ���������ʾ
		ArrayList<Sort> sort = new ArrayList<>();
		sort.add(new BubbleSort());
		sort.add(new InsertSort());
		sort.add(new SelectionSort());
		sort.add(new QuickSort());
		array = (ArrayList<Integer>) rawArray.clone();
		for (int i = 0; i < sort.size(); i++) {
			snapShot.clear();
			array = (ArrayList<Integer>) rawArray.clone();
			sort.get(i).sort(0, array.size() - 1, array, snapShot);
			output.println(sort.get(i).toString());
			output.println("����������" + snapShot.getTimeOfSwap());
		}
		
		output.println("��������" +  rawArray.size());
		
		//ԭʼ����
		output.println("ԭʼ���ݣ�");
		for (int i = 0; i < rawArray.size(); i++) {
			output.print(rawArray.get(i) + " ");
		}
		output.println("");
		
		//����������
		output.println("���������ݣ�");
		for (int i = 0; i < array.size(); i++) {
			output.print(array.get(i) + " ");
		}
		output.println("");
		output.println("ps:ѡ��������ÿ�α�����������ֻ���ҳ����ֵ�����������ڱ�����ɺ�����ÿ�α���ֻ����һ�Σ����Խ�����������");
		
		output.close();
	}

}
