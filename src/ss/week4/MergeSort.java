package ss.week4;

import java.util.ArrayList;
import java.util.List;


public class MergeSort {

	private static <Elem extends Comparable<Elem>> void merge(List<Elem> left, List<Elem> right, List<Elem> whole) {
		int leftIndex = 0;
		int rightIndex = 0;
		int wholeIndex = 0;

		while (leftIndex < left.size() && rightIndex < right.size()) {
			if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
				whole.set(wholeIndex, left.get(leftIndex));
				leftIndex++;
			} 
			else {
				whole.set(wholeIndex, right.get(rightIndex));
				rightIndex++;
			}
			wholeIndex++;
		}
		// if a part ends quicker than the other part to add the rest of the list
		List<Elem> rest;
		
		int restIndex;
		// when you go through the list of all left and there is no more
		
		if (leftIndex >= left.size()) {
			rest = right;
			restIndex = rightIndex;
		}
		// same but for right
		
		else {
			rest = left;
			restIndex = leftIndex;
		}
		// kalan listenin indeksinden baslayarak hepsinin tam listeye ekle
    	// tamindeks arttiriliyor boylece hep ayni indekse farkli elemanlar yerine yenileri geliyor
		
		for (int i = restIndex; i < rest.size(); i++) {
		
			whole.set(wholeIndex, rest.get(i));
			wholeIndex++;
		}
	}
	// where youtube guy explains it is split into more pieces till there is 1 in each list
	
	public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> whole) {
		
		
		List<Elem> left = new ArrayList<Elem>();
		List<Elem> right = new ArrayList<Elem>();
		int center;
		
		//dont sort/divide if list is 1 element or 0
		
		if (whole.size() <= 1) {
			return;
		}
		
		else {
			
			center = whole.size() / 2;
			// listenin sol yarisini sol listesine ekle
			for (int i = 0; i < center; i++) {
				left.add(whole.get(i));
			}
			
			// listenin sag yarisini sag listesine ekle
			for (int i = center; i < whole.size(); i++) {
				right.add(whole.get(i));
			}
			
			mergesort(left);
			mergesort(right);

			merge(left, right, whole);
		}
	}
}