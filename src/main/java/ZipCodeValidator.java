public class ZipCodeValidator {


    private String[] zipcode;

    /**
     * Sets the zipcode value to the users zipcode.
     *
     * @param args User zipcode (ZIP code ranges).
     */
    public ZipCodeValidator(String[] args) {
        this.zipcode = args;
    }

    /**
     * Checks the zipcode for validity.
     */
    public void checkzipcode() {

        //checks to make sure zipcode was entered
        emptyCheck();

        //checks to make sure zipcode is in correct format
        formatCheck();
    }

    /**
     * Checks if user entered any zipcode.
     */
    private void emptyCheck() {
        if(zipcode.length == 0) {
            System.out.println("Error: No zipcode detected.");
            System.exit(0);
        }
    }

    /**
     * Checks if each value entered is in proper format.
     *
     * Format example: [95608,96670]
     */
    private void formatCheck() {

        //loops through all the zipcode values
        for(int i = 0; i < this.zipcode.length; i++) {

            String current = this.zipcode[i];

            //checks all characters to make sure they are valid
            for(int j = 0; j < current.length(); j++) {
                char c = current.charAt(j);

                //checks for starting [ character
                if(j == 0 && c != '[') {
                    formatError(i, j);
                    System.out.println("Missing starting [");
                    System.exit(0);

                    //checks if character is a number
                } else if (j == 1 || j == 2 || j == 3 || j == 4 || j == 5
                        || j == 7 || j == 8 || j == 9 || j == 10 || j == 11) {
                    if(!Character.isDigit(c)) {
                        formatError(i, j);
                        System.out.println("Non number detected.");
                        System.exit(0);
                    }

                    //checks for the , separator
                } else if (j == 6 && c != ',') {
                    formatError(i, j);
                    System.out.println("Missing , seperator.");
                    System.exit(0);

                    //checks for ending ] character
                } else if (j == 12 && c != ']') {
                    formatError(i, j);
                    System.out.println("Missing ending ]");
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Prints an error message to assist user to correct their zipcode.
     *
     * @param valueNum The ZIP code range value where the error occurred.
     * @param charNum The position where the error occurred in the value.
     */
    private void formatError(int valueNum, int charNum) {
        //added 1 for user readability
        valueNum++;
        charNum++;
        System.out.println("Error: Invalid zipcode @ zipcode range #" + valueNum + ", character #" + charNum);
    }

    /**
     * Getter for the zipcode value(s).
     *
     * @return User zipcode.
     */
    public String[] getzipcode() {
        return this.zipcode;
    }

    /**
     * Builds and returns a string out of the zipcode array.
     *
     * @return User zipcode
     */
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < this.zipcode.length; i++) {
            if(i < this.zipcode.length - 1) {
                s += this.zipcode[i] + " ";
            } else {
                s += this.zipcode[i];
            }
        }
        return s;
    }
}
