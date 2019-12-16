import java.util.ArrayList;

public class SelectionSort implements Sort {

	@Override
	public void sort(int left, int right, ArrayList<Integer> array, SnapShot snapShot) {
		int max = 0;
		int i,j;
		for (i = 0; i <= right; i++) {
			max = 0;
			for (j = 0; j <= right - i; j++) {
				//���������ڱ�λ�����Ϊ��ɫ����Ŀǰ���ֵ���Ϊ��ɫ
				snapShot.enqueue(j , ConstantData.GREEN);
				snapShot.enqueue(max , ConstantData.RED);
				if (array.get(max) < array.get(j)) {
					//�����ֱ����ֵ������ݽ�ԭ�������ֵ��������Ĭ�ϵ���ɫ�����µ����ֵ���Ϊ��ɫ
					snapShot.enqueue(max , ConstantData.BLUE);
					max = j;
					snapShot.enqueue(max , ConstantData.RED);
				}
				else if (max != j){
					//���δ������ǰ���ֵ�ı仯���ڱ��������λ������Ĭ�ϵ���ɫ
					snapShot.enqueue(j , ConstantData.BLUE);
				}
			}
			snapShot.enqueue(right - i , ConstantData.RED);
			snapShot.enqueue(max, right - i);
			int temp = array.get(max);
			array.set(max, array.get(right - i));
			array.set(right - i, temp);
			//���������Ĳ������Ϊ��ɫ
			snapShot.enqueue(max , ConstantData.BLUE);
			snapShot.enqueue(right - i, ConstantData.ORANGE);
		}
		
	}
	
	@Override
	public String toString() {
		return "ѡ������: \r\nƽ���㷨���Ӷ�:O(n2)";
		
	}

}
