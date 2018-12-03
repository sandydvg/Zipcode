import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Creates output by sorting and condensing user input */
public class ComputeOutput {

	private int[] values;
	
	/**
	 * Constructor for compute output
	 * @param input User entered values
	 */
	public ComputeOutput(int[] input) {
		this.values = input;
	}
	
	/**
	 * Controller for computing the output.
	 */
	public void compute() {
		
		//sorts the array of ZIP codes from low to high
		sortValues();
		
		//reduces the output to the minimum number of ZIP code ranges
		minimizeOutput();
	}
	
	/**
	 * Sorts ZIP code ranges from low to high.
	 * 
	 * Note: Values are moved in the array as sets of 2.
	 */
	private void sortValues() {
		
		//extracts all the starting values from ZIP code pairs
		int[] orderedValues = new int[this.values.length/2];
		for(int i = 0, j = 0; i < orderedValues.length; i++, j+=2) {
			orderedValues[i] = this.values[j];
		}
		
		//sorts ZIP pairs by starting values
		Arrays.sort(orderedValues);
		
		//reconstructs array
		int[] newValueOrder = new int[this.values.length];
		for(int i = 0, k = 0; i < orderedValues.length; i++) {
			for(int j = 0; j < this.values.length; j++) {
				if(orderedValues[i] == this.values[j]) {
					newValueOrder[k++] = this.values[j++];
					newValueOrder[k++] = this.values[j];
					break;
				}
			}
		}
		
		//sets the sorted array
		this.values = newValueOrder;
	}
	
	/**
	 * If ranges overlap, the array will be condensed and
	 * arbitrary values will be removed.
	 */
	private void minimizeOutput() {
		
		//creates an integer array list (easier to manipulate than array)
		ArrayList<Integer> minOut = new ArrayList<Integer>();
		int startValue = this.values[0];
		int endValue = this.values[1];
		if(this.values.length > 2) {
			for(int i = 2; i < this.values.length; i++) {
				int newStartValue = this.values[i++];
				int newEndValue = this.values[i];
				
				//checks if the current end range is less than
				if(endValue < (newStartValue + 1)) {
					
					//adds the current values to the list
					minOut.add(startValue);
					minOut.add(endValue);
					
					//sets the current values to the next values.
					startValue = newStartValue;
					endValue = newEndValue;
					
					//checks if any more values exist
					if((i+1) >= this.values.length){
						minOut.add(startValue);
						minOut.add(endValue);
					}
				} else {
					
					//if the next end value is higher than the current one
					if(endValue < newEndValue) {
						endValue = newEndValue;
						if((i+1) >= this.values.length) {
							minOut.add(startValue);
							minOut.add(endValue);
						}
					
					}
				}
			}
		
		//if no values are left
		} else {
			minOut.add(startValue);
			minOut.add(endValue);
		}
		
		//converts the array list to an array
		Iterator<Integer> itr = minOut.iterator();
		int[] temp = new int[minOut.size()];
		for(int i = 0; i < temp.length; i++) {
			int val = itr.next();
			temp[i] = val;
		}
		
		//sets the output array
		this.values = temp;
		
	}
	
	/**
	 * Constructs string of computed output
	 * 
	 * @return Proper output
	 */
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.values.length; i++) {
			if(i < this.values.length - 2) {
				s += "[" + this.values[i] + "," + this.values[++i] + "] ";
			} else {
				s += "[" + this.values[i] + "," + this.values[++i] + "]";
			}
		}
		return s;
	}
}
