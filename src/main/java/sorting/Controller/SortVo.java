package sorting.Controller;

import java.util.List;

/**
 * @author Murali
 * Bean class to store sorted array and minimum swaps required to sort
 *
 */
public class SortVo {
	
	private List<Integer> userValues;
	
	private int swapNumber;

	public int getSwapNumber() {
		return swapNumber;
	}

	public void setSwapNumber(int swapNumber) {
		this.swapNumber = swapNumber;
	}

	@Override
	public String toString() {
		return "SortVo [userValues=" + userValues + "]";
	}

	public List<Integer> getUserValues() {
		return userValues;
	}

	public void setUserValues(List<Integer> userValues) {
		this.userValues = userValues;
	}

}
