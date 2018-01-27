package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    // add a new node with the given index and element
    //checks if it is not below zero cuz index cant be below zero and esitlik isareti orda cunku 8. elemani 7. indexle eklersin
    // eger ilk elementiyse o zaman head normalde ilk olmasina ragmen simdi sondur ilk olanina baglar yani newnode
    //eger baska bir index verildiyse 0 dan farkli o zaman ondan onceki nodun bilgileri bunda kullanilir
    public void add(int index, Element element) {
    	assert element != null;
		assert 0 <= index && index <= this.size;
		Node newNode = new Node(element);
//		if (index == 0) {
//			newNode.previous = head.previous;
//			head.previous = newNode;
//			newNode.next= head;
//			this.head = newNode;
//		} else {
			Node p = getNode(index - 1);
			newNode.next = p.next;
			newNode.previous = p;
			p.next = newNode;
			newNode.next.previous = newNode;
//		}
		size++;
	}
    

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    /*
     * index sifirsa o zaman ilk eleman olan "head" element gider ve head.next yeni head olur
     * 
     */
    public void remove(int index) {
    	if (index == 0) {
    		head.next.previous = head.previous;
			head = head.next;
		} else {
			Node p = getNode(index - 1);
			p.next = p.next.next;
			p.next.next.previous = p;
			
		}
		size--;
    }
    
    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    
    public class Node {
    	
    	//constructor
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
