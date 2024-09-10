package org.carrots.visualsort;

import java.util.ArrayList;

public interface Sort {
	//排序算法接口
	public abstract void sort(int left, int right, ArrayList<Integer> array, SnapShot snapShot);
}
