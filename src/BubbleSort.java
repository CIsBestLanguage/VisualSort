import java.util.ArrayList;

public class BubbleSort implements Sort {
	
	@Override
	public void sort(int left, int right, ArrayList<Integer> array, SnapShot snapShot) {
		int temp;
		
		for (int i = 0; i <= right; i++) {
			snapShot.enqueue(0, ConstantData.GREEN);
			for (int j = 1; j <= right - i; j++) {
				//���бȽϵ������������Ϊ��ɫ
				snapShot.enqueue(j, ConstantData.GREEN);
				if (array.get(j) < array.get(j - 1)) {
					//����λ�õı任
					snapShot.enqueue(j , j - 1);
					temp = array.get(j - 1);
					array.set(j - 1, array.get(j));
					array.set(j, temp);
				}
				//��ǰһ�����ݻָ�Ϊ������ɫ
				snapShot.enqueue(j - 1, ConstantData.BLUE);
			}
			//�������Ĳ������Ϊ��ɫ
			snapShot.enqueue(right - i, ConstantData.ORANGE);
		}
		
	}
	
	@Override
	public String toString() {
		return "ð������: \r\nƽ���㷨���Ӷ�:O(n2)";
		
	}

}
