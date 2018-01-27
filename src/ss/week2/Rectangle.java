package ss.week2;

public class Rectangle {
	
	//@ private invariant length >= 0;
	//@ private invariant width >=0;
    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     */
  /*@ 
   * requires length >= 0 && width >=0;
   * ensures length() == length && width() == width;
   */
    public Rectangle(int length, int width) {
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@pure 
    public int length() {
    	return this.length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@pure
    public int width() {
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
  //@ ensures \result >=0;
  //@ ensures \result == length() *width();
  /*@ pure*/
    public int area() {
    	return length*width;
    }

    /**
     * The perimeter of this Rectangle.
     */

  //@ ensures \result >=0;
    //@ ensures \result == 2(length() +width());
    public int perimeter() {
    	return 2*(length+width);
    }
}
