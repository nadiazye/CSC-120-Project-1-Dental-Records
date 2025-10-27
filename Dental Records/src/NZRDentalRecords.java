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

        totalFamilyNumber = getFamilyNumber();
        //getting the number of people in the family

        //arrays
        nameRecord = new String[totalFamilyNumber];
        teethInformation = new char[totalFamilyNumber][MAX_TEETH_LOC][MAX_TEETH];
        numberOfTeeth = new int[MAX_TEETH_LOC][totalFamilyNumber];

        getFamilyData(totalFamilyNumber, nameRecord, teethInformation, numberOfTeeth);

        char menuChoice;

        do {
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            menuChoice = keyboard.next().toUpperCase().charAt(0);

            switch (menuChoice) {
                case 'P':
                    printFullRecords(totalFamilyNumber, nameRecord, teethInformation, numberOfTeeth);
                    break;
                case 'E':
                    extractTooth(totalFamilyNumber, nameRecord, teethInformation, numberOfTeeth);
                    break;
                case 'R':
                    calculateRoot(totalFamilyNumber, teethInformation, numberOfTeeth);
                    break;
                case 'X':
                    System.out.println("\nExiting the Floridian Tooth Records :-)");
                    break;
                default:
                    System.out.println("Invalid menu option, try again              : ");
            }
        } while (menuChoice != 'X');
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
            keyboard.nextLine();
            System.out.println("Please enter the name for family member " + (familyIndex + 1 ) + "    : ");
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

        do {
            System.out.printf("Please enter the %s for %-10s      : ", teethLocation, familyNames);
            teethUpOrLow = keyboard.next();
            teethLength = teethUpOrLow.length();


            //now to check the person put the right stuff and nothing foolish
            thisIsFine = true;
            for (int familyIndex1 = 0; familyIndex1 < teethLength; familyIndex1++) { // beginning of for
                char tooth = teethUpOrLow.charAt(familyIndex1);
                if (tooth != 'C' && tooth != 'c' && tooth != 'B' && tooth != 'b' && tooth != 'M' && tooth != 'm' && tooth != 'I' && tooth != 'i') { //beginning of if
                    thisIsFine = false;
                    break;
                } // end of if
            } // end of for

            //loop to check input length
            if (!thisIsFine) {
                System.out.println("Invalid teeth types, try again      : ");
            } else if (teethLength > 10) {
                System.out.println("Too many teeth, try again           : ");
            }

        } while (!thisIsFine || teethLength > 10);

         return teethUpOrLow;

    } // end of getUppersAndLowers method ================================================================================================================================================================

    public static void printFullRecords(int totalFamilyNumber, String[] familyNames, char [][][] teethInformation, int[][] numberOfTeeth) { //beginning of printFullRecords ==============================

            for (int familyIndex = 0; familyIndex < totalFamilyNumber; familyIndex++) { //beginning of for
                System.out.println(familyNames[familyIndex]);
                System.out.println("   Uppers:   ");
                for (int toothIndex = 0; toothIndex < numberOfTeeth[0][familyIndex]; toothIndex++) { //beginning of inner for 1
                    System.out.printf("%3d:%S", toothIndex + 1, teethInformation[familyIndex][0][toothIndex]);
                } //end of inner for 1
                System.out.println();
                System.out.println("   Lowers:   ");
                for (int toothIndex = 0; toothIndex < numberOfTeeth[1][familyIndex]; toothIndex++) { // beginning of inner for 2
                    System.out.printf("%3d:%S" , toothIndex + 1, teethInformation[familyIndex][1][toothIndex]);
                } // end of inner for 2

                System.out.println();

            } //end of for

        } //end of printFullRecords ======================================================================================================================================================================

        public static void extractTooth(int totalFamilyNumber, String [] familyNames, char [][][] teethInformation,int [][] numberOfTeeth) { // beginning of extractTooth ==============================
            String familyMember;
            boolean foundTooth = false;
            boolean correctUorL = false;
            char toothLayer;
            int saveMemberID = 0;
            int toothNum;
            int toothRow = 0;

            System.out.println("Which family member      : ");
            familyMember = keyboard.next();

            do { //beginning of do while
                for (int familyIndex = 0; familyIndex < totalFamilyNumber; familyIndex++) { // beginning of for
                if (familyMember.equalsIgnoreCase(familyNames[familyIndex])) { //beginning of if
                    foundTooth = true;
                    saveMemberID = familyIndex;
                } // end of if
            } //end of for
                if(!foundTooth){ //beginning of for
                    System.out.println("Invalid family member, try again      : ");
                    familyMember = keyboard.next();
                } //end of for

            } while (!foundTooth);
            System.out.println("Which tooth layer (U)pper or (L)ower      :");//end of do while
            toothLayer = keyboard.next().charAt(0);

            //checking if the tooth layer is upper or lower
            do { //beginning of do
                switch (toothLayer) { //beginning of switch case
                    case 'U':
                    case 'u':
                        correctUorL = true;
                        toothRow = 0;
                        break;
                    case 'L':
                    case 'l':
                        correctUorL = true;
                        toothRow = 1;
                    break;
                    default:
                        System.out.println("Invalid tooth layer, try again      : ");
                        toothLayer = keyboard.next().charAt(0);
                } // end of switch case
            } while (!correctUorL); // end of do

            System.out.println("Which tooth number       : ");
            toothNum = keyboard.nextInt();


            while (toothNum > numberOfTeeth[toothRow][saveMemberID] || toothNum <=0 || teethInformation [saveMemberID][toothRow][toothNum-1] == 'M') { // beginning of while

                if (toothNum > numberOfTeeth[toothRow][saveMemberID]) { // beginning of if else
                    System.out.println("Invalid tooth number, try again      : ");
                } else if (teethInformation[saveMemberID][toothRow][toothNum-1] == 'M') {
                    System.out.println("Missing tooth, try again      : ");
                }
                toothNum = keyboard.nextInt();
              } // end of while

            teethInformation[saveMemberID][toothRow][toothNum-1] = 'M';
        } //end of extractTooth ==========================================================================================================================================================================

            public static void calculateRoot(int totalFamilyNumber, char[][][] teethInformation, int[][] numberOfTeeth) { //beginning of calculateRoot =====================================================
                double sumC = 0.0;
                double sumB = 0.0;
                double sumM = 0.0;

                // Loop through each family member
                for (int famIndex = 0; famIndex < totalFamilyNumber; famIndex++) {
                    for (int rowIndex = 0; rowIndex < MAX_TEETH_LOC; rowIndex++) {
                        // Only iterate over actual number of teeth for this layer
                        for (int toothIndex = 0; toothIndex < numberOfTeeth[rowIndex][famIndex]; toothIndex++) {
                            char tooth = teethInformation[famIndex][rowIndex][toothIndex];
                            switch (tooth) {
                                case 'C':
                                    sumC++;
                                    break;
                                case 'B':
                                    sumB++;
                                    break;
                                case 'M':
                                    sumM++;
                                    break;
                                case 'I':
                                    // Ignore permanent missing teeth or placeholders
                                    break;
                                default:
                                    // Ignore empty/uninitialized array slots
                                    break;
                            }
                        }
                    }
                }

                // Solve Bx^2 + Cx - M = 0
                double a = sumB;
                double b = sumC;
                double c = -sumM;

                double discriminant = b * b - 4.0 * a * c;

                if (discriminant == 0.0) {
                    double root = -b / (2.0 * a);
                    System.out.printf("One root canal at %6.2f\n\n", root);
                } else if (discriminant > 0.0) {
                    double root1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
                    double root2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
                    System.out.printf("One root canal at %6.2f\nAnother root canal at %6.2f\n\n", root1, root2);
                } else {
                    System.out.println("No real roots\n");
                } // end of else

            } //end of calculate Root ========================================================================================================================================================================

} // end of Dental Records class (includes my initials) ==================================================================================================================================================
