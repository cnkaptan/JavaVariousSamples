package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4.line;

/**
 * Class of lines, with specification.  Class is correct.
 * 
 * @author Rance Cleaveland
 *
 */
public class CorrectLine {
	
	/**
	 * @invariant	p1 and p2 must be different points, and non-null
	 */
	private Point p1;
	private Point p2;

	/**
	 * @param p1	First point defining line
	 * @param p2	Second point
	 * @throws IllegalArgumentException	Thrown if points violate invariant
	 */
	CorrectLine (Point p1, Point p2) throws IllegalArgumentException {
		if ((p1 != null) && (p2 != null) && !p1.equals(p2)) {
			this.p1 = p1;
			this.p2 = p2;
		}
		else {
			throw new IllegalArgumentException (
					"Points to Line Constructor must be non-null, different.");
		}
	}
	
	/**
	 * Precondition:  p1 and p2 do not form a vertical line
	 * Postcondition:  returns slope of line formed by p1, p2
	 * Exception:  if precondition is violated, an ArithmeticException is thrown
	 * 
	 * @return	slope, in case precondition holds
	 * @throws ArithmeticException	in case precondition is violated
	 */
	public double slope () throws ArithmeticException {
		return ((p1.getY() - p2.getY()) / (p1.getX() - p2.getX()));
	}

}
