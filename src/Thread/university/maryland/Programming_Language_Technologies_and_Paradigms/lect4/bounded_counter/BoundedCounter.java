package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4.bounded_counter;

/**
 * Class of non-thread-safe bounded-counter objects
 * 
 * @author Rance Cleaveland
 *
 */
public class BoundedCounter {
	private int value = 0;
	private int upperBound = 0;
	
	//INVARIANT 1:  0 <= value <= upperBound
	//INVARIANT 2:  value = # of calls to inc since last reset
	//              or object creation, if # of calls <= upperBound
	//INVARIANT 3:  value = upperBound if # of calls to inc since last reset
	//              or object creation > upperBound
	
	/**
	 * Constructor
	 * 
	 * Precondition:  argument must be >=0
	 * Postcondition:  object created
	 * Exception:  If argument < 0, IllegalArgumentException thrown
	 * 
	 * @param upperBound	Upper bound that counter can count to
	 * @throws IllegalArgumentException	Thrown if negative upperbound provided
	 */
	public BoundedCounter (int upperBound) throws IllegalArgumentException {
		if (upperBound >= 0) this.upperBound = upperBound;
		else throw new IllegalArgumentException (
				"Bad argument to BoundedCounter: " + upperBound + "; must be >= 0");
	}

	/**
	 * Returns current value of counter
	 * 
	 * Precondition:  none
	 * Postcondition:  current value returned
	 * Exception:  none
	 * @return
	 */
	public int current () {
		return value;
	}
	
	/**
	 * Resets counter
	 * 
	 * Precondition:  none
	 * Postcondition:  sets counter value to 0
	 * Exception:  non
	 * 
	 */
	public void reset () {
		value = 0;
	}

	/**
	 * Returns boolean indicating whether or not current value is at its maximum allowed value
	 * 
	 * Precondition:  none
	 * Postcondition:  returns whether or not current value == upperbound
	 * Exception:  none
	 * @return
	 */
	public boolean isMaxed () {
		return (value == upperBound);
	}

	/**
	 * Increments counter value, if possible
	 * 
	 * Precondition:  none
	 * Postcondition:  increment value if it is not maxed out; otherwise, do nothing.
	 * Exception:  none
	 */
	public void inc () {
		if (!isMaxed()) ++value;
	}
}
