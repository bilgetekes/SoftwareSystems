package ss.week4.tictactoe;
import ss.week4.tictactoe.Player;;



public class Board {
    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";
    
    
    
    /**
     * The DIM by DIM fields of the Tic Tac Toe student. See NUMBERING for the
     * coding of the fields.
     */
    //@ private invariant fields.length == DIM*DIM;
    /*@ invariant (\forall int i; 0 <= i & i < DIM*DIM;
        getField(i) == Mark.EMPTY || getField(i) == Mark.XX || getField(i) == Mark.OO); */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty student.
     */
    //@ ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
    /*
     * start from zero and mark all of them empty
     */
    public Board() {
    	// TODO: implement, see exercise P-4.18
    	fields = new Mark[DIM * DIM];
		this.reset();
    }
    /*
     * copies the board
     */
    /**
     * Creates a deep copy of this field.
     */
    /*@ ensures \result != this;
        ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                \result.getField(i) == this.getField(i));
      @*/
    public Board deepCopy() {
    	// TODO: implement, see exercise P-4.18
    	Board deepCopy = new Board();
		for (int i = 0; i < (DIM * DIM); i++) {
			deepCopy.fields[i] = this.fields[i];
		}
		return deepCopy;
        
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @return the index belonging to the (row,col)-field
     */
    //@ requires 0 <= row & row < DIM;
    //@ requires 0 <= col & col < DIM;
    /*@pure*/
    public int index(int row, int col) {
    	// TODO: implement, see exercise P-4.18
    	switch (row) {
		case 0:
			return col;
		case 1:
			return col + 3;
		case 2:
			return col + 6;
		default:
			return -1;
		}
    }

    /**
     * Returns true if ix is a valid index of a field on the student.
     * @return true if 0 <= index < DIM*DIM
     */
    //@ ensures \result == (0 <= index && index < DIM * DIM);
    /*@pure*/
    public boolean isField(int index) {
    	// TODO: implement, see exercise P-4.18
    	if (index >= 0 && index < (DIM * DIM)) {
			return true;
		}
		return false;
    }

    /**
     * Returns true of the (row,col) pair refers to a valid field on the student.
     *
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    //@ ensures \result == (0 <= row && row < DIM && 0 <= col && col < DIM);
    /*@pure*/
    public boolean isField(int row, int col) {
    	// TODO: implement, see exercise P-4.18
        return isField(index(row, col));
    }
    
    /**
     * Returns the content of the field i.
     *
     * @param i
     *            the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    //@ requires this.isField(i);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int i) {
    	// TODO: implement, see exercise P-4.18
    	if (isField(i)) {
			return fields[i];
		}
		return null;
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return the mark on the field
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int row, int col) {
    	// TODO: implement, see exercise P-4.18
    	if (isField(index(row, col))) {
			return fields[index(row, col)];
		}
		return null;
    }

    /**
     * Returns true if the field i is empty.
     *
     * @param i
     *            the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    //@ requires this.isField(i);
    //@ ensures \result == (this.getField(i) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int i) {
    	// TODO: implement, see exercise P-4.18
    	if (isField(i)) {
			return (fields[i] == Mark.EMPTY);
		}
		return false;
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return true if the field is empty
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == (this.getField(row,col) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int row, int col) {
    	// TODO: implement, see exercise P-4.18
    	if (isField(index(row, col))) {
			return (fields[index(row, col)] == Mark.EMPTY);
		}
		return false;
        
    }

    /**
     * Tests if the whole student is full.
     *
     * @return true if all fields are occupied
     */
    //@ ensures \result == (\forall int i; i <= 0 & i < DIM * DIM; this.getField(i) != Mark.EMPTY);
    /*@pure*/
    public boolean isFull() {
    	// TODO: implement, see exercise P-4.18
    	for (int i = 0; i < fields.length; i++) {
			if (isEmptyField(i)) {
				return false;
			}
		}
		return true;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole student is full.
     *
     * @return true if the game is over
     */
    //@ ensures \result == this.isFull() || this.hasWinner();
    /*@pure*/
    public boolean gameOver() {
    	// TODO: implement, see exercise P-4.18
    	if (isFull() || hasWinner()) {
			return true;
		}
		return false;
       
    }
    /*
     * ri row index
     * ci column index
     */

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a row controlled by m
     */
    /*@ pure */
    public boolean hasRow(Mark m) {
    	// TODO: implement, see exercise P-4.18
    	for (int ri = 0; ri < DIM; ri++) {
			boolean isEqual = true;
			for (int ci = 0; ci < DIM; ci++) {
				if (isEqual == true) {
					isEqual = this.getField(ri, ci) == m;
				}
			}
			if (isEqual == true) {
				return true;
			}
		}
		return false;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a column controlled by m
     */
    /*@ pure */
    public boolean hasColumn(Mark m) {
    	// TODO: implement, see exercise P-4.18
    	for (int ci = 0; ci < DIM; ci++) {
			boolean isEqual = true;
			for (int ri = 0; ri < DIM; ri++) {
				if (isEqual == true) {
					isEqual = this.getField(ri, ci).equals(m);
				}
			}
			if (isEqual == true) {
				return true;
			}
		}
		return false;
       
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a diagonal controlled by m
     */
    /*@ pure */
    public boolean hasDiagonal(Mark m) {
    	// TODO: implement, see exercise P-4.18
    	boolean isEqual = true;
		boolean isEqual2 = true;
		for (int i = 0; i < DIM * DIM; i = i + 4) {
			if (isEqual) {
				isEqual = this.getField(i).equals(m);
			}
		}
	
		for (int i = 2; i <= (DIM + DIM); i = i + 2) {
			if (isEqual2) {
				isEqual2 = this.getField(i).equals(m);
			}
		}
		if (isEqual || isEqual2) {
			return true;
		} else {
			return false;
		}
        
    }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     *
     * @param m
     *            the mark of interest
     * @return true if the mark has won
     */
    //@requires m == Mark.XX | m == Mark.OO;
    //@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
    /*@ pure */
    public boolean isWinner(Mark m) {
    	// TODO: implement, see exercise P-4.18
    	return (hasRow(m) || hasColumn(m) || hasDiagonal(m));
 
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     *
     * @return true if the student has a winner.
     */
    //@ ensures \result == isWinner(Mark.XX) | \result == isWinner(Mark.OO);
    /*@pure*/
    public boolean hasWinner() {
    	// TODO: implement, see exercise P-4.18
    	return (isWinner(Mark.XX)|| isWinner(Mark.OO));
    }

    /**
     * Returns a String representation of this student. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    /**
     * Empties all fields of this student (i.e., let them refer to the value
     * Mark.EMPTY).
     */
    /*@ ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                this.getField(i) == Mark.EMPTY); @*/
    public void reset() {
    	// TODO: implement, see exercise P-4.18
    	for (int i = 0; i < (DIM * DIM); i++) {
			this.fields[i] = Mark.EMPTY;
		}
    }

    /**
     * Sets the content of field i to the mark m.
     *
     * @param i
     *            the field number (see NUMBERING)
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(i);
    //@ ensures this.getField(i) == m;
    public void setField(int i, Mark m) {
    	// TODO: implement, see exercise P-4.18
    	fields[i] = m;
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     *
     * @param row
     *            the field's row
     * @param col
     *            the field's column
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(row,col);
    //@ ensures this.getField(row,col) == m;
    public void setField(int row, int col, Mark m) {
    	// TODO: implement, see exercise P-4.18
    	fields[(index(row, col))] = m;
    }
}
