/**
 *
 *
 *
 */

public class ZipcodeMainApplication {

    public static void main(String[] args) {

        ZipCodeValidator zips = new ZipCodeValidator(args);
        zips.checkzipcode();
        ValidateValue input= new ValidateValue(zips.getzipcode());

        ComputeOutput output = new ComputeOutput(input.getValues());
        output.compute();

        //Prints the user input
        System.out.println("input = " + input.toString());

        //Prints the correct output
        System.out.println("output = " + output.toString());

    }
}
