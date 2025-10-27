import java.util.Scanner; // import line needed in order to get user input
public class NZRDentalRecords { // beginning of Dental Records class (includes my initials) ================================================================================================================
    //putting in Scanner keyboard --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //Scanner keyboard line --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // CONSTANT VARIABLES - DO NOT CHANGE ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static final int MAX_TEETH = 10;
    private static final int MAX_TEETH_LOC = 2;
    // CONSTANTS -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) { // beginning of main method ===================================================================================================================================

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

    } // end of main method ===============================================================================================================================================================================

    public static int getFamilyNumber() { // beginning of getFamilyNumber =================================================================================================================================

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

        }// end of getFamilyNumber =======================================================================================================================================================================

    public static void getFamilyData (int totalFamilyNumber, String[] familyNames, char [][][] teethInformation, int [][] numberOfTeeth) { // beginning of getFamilyData =================================
        int familyInteger; // meant to show the number of family member, but familyNumber is used too much and I don't want to be confused
        String upperTeeth;
        String lowerTeeth;

        for (int familyIndex = 0; familyIndex < totalFamilyNumber; familyIndex++) { //beginning of for loop 1
            familyInteger = familyIndex + 1;
            System.out.println("Please enter the name for family member " + familyIndex + "    : ");
            familyNames[familyIndex] = keyboard.nextLine();

            //Getting the upper teeth for this specific family member
            upperTeeth = getUppersAndLowers(familyIndex,familyNames[familyIndex], "uppers");

            //actually storing the information
            numberOfTeeth[0][familyIndex] = upperTeeth.length();
            for (int familyIndex1 = 0; familyIndex1 < upperTeeth.length(); familyIndex1++) { // beginning of inner for loop 1
                teethInformation[familyIndex][0][familyIndex1] = upperTeeth.charAt(familyIndex1);
            } // end of inner for loop 1

            //Getting the lower teeth from this specific family member
            lowerTeeth = getUppersAndLowers(familyIndex, familyNames[familyIndex], "lowers");

            //actually storing the information
            numberOfTeeth[1][familyIndex] = lowerTeeth.length();
            for (int familyIndex2 = 0; familyIndex2 < lowerTeeth.length(); familyIndex2++) { //beginning of inner for loop 2
                teethInformation[familyIndex][1][familyIndex2] = lowerTeeth.charAt(familyIndex2);
            } //end of inner for loop 2
        } // end of for loop 1
    } // end of getFamilyData ============================================================================================================================================================================

    public static String getUppersAndLowers(int familyIndex, String familyNames, String teethLocation) { //beginning of get UppersAndLowers method =======================================================
        String teethUpOrLow;
        int teethLength = 0;
        boolean thisIsFine; //to check if the person put valid teeth types, didn't know what name to put

        System.out.printf("Please enter the %s for %-10s      : ", teethLocation, familyNames);
        teethUpOrLow = keyboard.next();
        teethLength = teethUpOrLow.length();


        //now to check the person put the right stuff and nothing foolish
        thisIsFine = true;
        for (int familyIndex1 = 0; familyIndex1 < teethLength; familyIndex1++) { // beginning of for
            char tooth = teethUpOrLow.charAt(familyIndex1);
            if (tooth != 'C' && tooth != 'c' && tooth != 'B' && tooth != 'b' && tooth != 'M' && tooth != 'm') { //beginning of if
                thisIsFine = false;
                break;
            } // end of if
        } // end of for

        //loop to check input length
        while (!thisIsFine || teethLength > 10) {

            if (teethLength > 10){ //beginning of if else
                System.out.println("Too many teeth, try again           : ");
            } else if (!thisIsFine) {
                System.out.println("Invalid teeth types, try again      : ");
        } // end of if else

            // asking user again for input
         teethUpOrLow = keyboard.next();
         teethLength = teethUpOrLow.length();

         //checking again for foolishness
         thisIsFine = true;
         for (int familyIndex2 = 0; familyIndex2 < teethLength; familyIndex2++) { // for
             char tooth = teethUpOrLow.charAt(familyIndex2);
             if (tooth != 'C' && tooth != 'c' && tooth != 'B' && tooth != 'b' && tooth != 'M' && tooth != 'm') { // if
                 thisIsFine = false;
                 break;
             }// end if
         } // end for
         teethUpOrLow = teethUpOrLow.toUpperCase();
         return teethUpOrLow;

    } // end of getUppersAndLowers method ================================================================================================================================================================
} // end of Dental Records class (includes my initials) ==================================================================================================================================================
