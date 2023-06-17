package _01_Encapsulate_the_Data;

import java.awt.Robot;

public class EncapsulateTheData {

	// 1. Encapsulate all the members.
		
	// 2. Implement the setter restrictions described above each member variable.

	// 3. Pass all the JUnit tests.

	/* 
	 * All negative arguments should set itemsReceived to 0.
	 */

	private int itemsReceived;
	public void setItemsReceived(int rpn) {
		if (rpn < 0) {
			itemsReceived = 0;
		} else {
			itemsReceived = rpn;
		}
	}
	public int getItemsReceived() {
		return itemsReceived;
}
	/*
	 * degreesTurned must be locked between 0.0 and 360.0 inclusive.
	 * 
	 * All parameters outside this range should set degreesTurned to the nearest
	 * bound.
	 */
	private double degreesTurned;
	public void setDegreesTurned(double d) {
		if (d > 0 && d <= 360) {
			degreesTurned = d;
		}

	}

	public double getDegreesTurned() {
		return degreesTurned;
	}
	/*
	 * nomenclature must not contain an empty String.
	 * 
	 * An empty String parameter should set nomenclature to a String with a single
	 * space.
	 */

	private String nomenclature;
	public void setNomenclature(String str) {
		if (str == "") {
			nomenclature = " ";
		} else  if (nomenclature == "") {
			nomenclature = str;
		} else {
			nomenclature = str;
		}
	}
	public String getNomenclature() {
		return nomenclature;
	}
	/*
	 * memberObj must not be a String.
	 * 
	 * A String parameter should set memberObj to a new Object();
	 * 
	 * Hint: Use the instanceof operator.
	 * 
	 * Example:
	 * 
	 * Robot rob = new Robot();
	 * 
	 * System.out.println(rob instanceof Robot); // prints true
	 * 
	 * System.out.println(rob instanceof Random); //prints false
	 */

	private Object memberObj;
	public void setMemberObj(Object o) {
		if (!(o instanceof String)) {
			memberObj = o;
		}
	}
	public Object getMemberObj() {
		return memberObj;
	}
}
