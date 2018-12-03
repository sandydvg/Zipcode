public class ValidateValue {

    private int[] values;

    /**
     * Sets the input value to the users input.
     *
     * @param args User input (ZIP code ranges).
     */
    public ValidateValue(String[] args) {
        this.values = convertValues(args);
    }

    /**
     * Takes the user input and converts it to an array
     * of Integers.
     * @param args User input
     * @return Array of Integers with ZIP code ranges
     */
    private int[] convertValues(String[] args) {

        //creates integer array 2 times the size of user input
        int[] values = new int[args.length*2];

        for(int i = 0, j = 0; i < args.length; i++) {
            String current = args[i];

            //pulls values from user input
            String value1 = current.substring(1, 6);
            String value2 = current.substring(7, 12);

            //converts string to integer and adds it to integer array
            values[j++] = Integer.parseInt(value1);
            values[j++] = Integer.parseInt(value2);
        }
        return values;
    }

    /**
     * Controller for validating values entered by user.
     */
    public void checkValues() {

        //Checks to make sure ZIP is a valid range (low,high)
        orderCheck();

    }

    /**
     * Checks to make sure values entered are in proper order.
     *
     * Note: Proper order is [low,high]
     */
    private void orderCheck() {
        for(int i = 0; i < this.values.length; i++) {
            int value1 = values[i++];
            int value2 = values[i];
            if(value1 > value2) {
                System.out.println("Error: First number in ZIP range must be less than second number.");
                System.exit(0);
            }
        }
    }

    public int[] getValues() {
        return this.values;
    }

    /**
     * Builds and returns a string of all the values the user entered.
     *
     * @return User values
     */
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < this.values.length; i++) {
            if(i < this.values.length - 1) {
                s += values[i] + ", ";
            } else {
                s += values[i];
            }
        }
        return s;
    }
}
