import java.util.ArrayList;

public class InsertSort implements Sort {

	@Override
	public void sort(int left, int right, ArrayList<Integer> array, SnapShot snapShot) {
		int temp;
		int j;
		for (int i = 0; i <= right; i++) {
            for (j = i; j > 0 ; j--) {
            	//��������λ�õ��������Ϊ��ɫ������Ƚϵ��������Ϊ��ɫ
            	snapShot.enqueue(j, ConstantData.RED);
            	snapShot.enqueue(j - 1, ConstantData.GREEN);
            	
            	if (array.get(j) < array.get(j - 1)) {
            		snapShot.enqueue(j - 1, j);
                	temp = array.get(j - 1);
    				array.set(j - 1, array.get(j));
    				array.set(j, temp);
    				//����λ�ú���ɫ�������Ϊ��ɫ
    				snapShot.enqueue(j, ConstantData.ORANGE);
            	}
            	else {
            		//��δ����λ�����Ѿ����򣬽�ԭ����ɫ�Ĵ��Ƚ��������Ϊ����������ɫ
            		snapShot.enqueue(j - 1, ConstantData.ORANGE);
            		break;
            	}
            }
            //��������λ���򽫺�ɫ�������Ϊ��ɫ����δ����λ������ɫ�������Ϊ��ɫ
            snapShot.enqueue(j, ConstantData.ORANGE);
        }
		
	}
	
	@Override
	public String toString() {
		return "��������: \r\nƽ���㷨���Ӷ�:O(n2)";
		
	}

}
