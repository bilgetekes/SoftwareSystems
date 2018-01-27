package ss.week4;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    //@ ensures \result.size == 0;
    public LinkedList () {
        size = 0;
        first = null;
    }
    /*
     * eger index sifirsa o zaman newnode head yani first oluyor
     * eger sifirdan farkliysa oncekinin bilgilerini kullaniyor
     */
    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }
    /*
     * eger p node u null cikiyorsa bu listteki ilk 
     * node oldugu anlamina gelir ve eger null degilse o zaman o nodun bir sonraki cikarilir ve cikarilan
     * nodun sonrasindakinin bilgileri onun indeksinin yerini alir
     */

    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
    	if (element != null) {
			Node p = findBefore(element);
			size--;
			if (p == null) {
				first = getNode(1);
			} else if (p.next != null) {
				p.next = p.next.next;
			}
		}
    }

    public Node findBefore(Element element) {
    	for (int i = 0; i < this.size(); i++) {
			if (getNode(i).next != null && this.getNode(i).next.getElement() == element) {
				return getNode(i);
			}
		}
		return null;
    }

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
