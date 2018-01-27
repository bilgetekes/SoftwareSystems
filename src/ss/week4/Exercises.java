package ss.week4;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
        int result = 0;
    	for (int i =0;i < arr.length ; i++) {
          if(arr[i] < 0) {
        	  result = result +1;
          }
        }
    	return result;
    }

    public static void reverseArray(int[] ints) {
      if( ints.length != 0) {
    		for (int y = 0; y < ints.length/2 ; y++) {
    			int temp = ints[y];
    			ints[y] = ints[ints.length-(y+1)];
    			ints[ints.length-(y+1)]= temp;
    		}
      }
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
