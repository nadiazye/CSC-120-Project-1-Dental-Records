import java.util.Scanner; // import line needed in order to get user input
public class NZRDentalRecords { // beginning of Dental Records class (includes my initials) =============================
    //putting in Scanner keyboard ------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //Scanner keyboard line ------------------------------------------------
    // CONSTANT VARIABLES - DO NOT CHANGE -------------------------------------------------------------------------------
    private static final int MAX_TEETH = 10;
    private static final int MAX_TEETH_LOC = 2;
    // CONSTANTS --------------------------------------------------------------------------------------------------------
    public static void main(String[] args) { // beginning of main method ================================================

        //Variables
        int totalFamilyNumber;
        String [] nameRecord; //to hold name data
        char[][][] teethInformation; //3d array for family teeth
        int [][] numberOfTeeth;



        //Displaying the beginning of the records:
        System.out.println("Welcome to the Floridian Tooth Records ");
        System.out.println("----------------------------------------------------");

        //check if totalFam is working
        totalFamilyNumber = getFamilyNumber();
        //getting the number of people in the family

    } // end of main method =============================================================================================

    public static int getFamilyNumber() { // beginning of getFamilyNumber ===============================================

        int totalFamilyNumber;

        //asking the user for their number of family members
        System.out.println("Please enter the number of people in this family:    ");
        totalFamilyNumber = keyboard.nextInt();

        //foolproof the family number (cannot be a negative number and cannot be more than 6)
        while (totalFamilyNumber < 0 || totalFamilyNumber > 6) { //beginning of while loop
            System.out.println("Invalid number of people, please try again:   ");

            totalFamilyNumber = keyboard.nextInt();
        } // end of while loop

        return totalFamilyNumber;

        }// end of getFamilyNumber ======================================================================================

} // end of Dental Records class (includes my initials) =================================================================
