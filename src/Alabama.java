import java.io.*;
import java.util.*;
/**The base class that calls the CovidDataStr class
 *
 * @author Robert Gleason
 * @version 1.0
 */

public class Alabama {

    /**Default Constructor
     *
     */
    public Alabama() {

    }

    public static void main(String[] args) {
        System.out.println("Please enter a Month(March - November). ");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();

        CovidDataStr alCovid = new CovidDataStr();
        alCovid.loadData("D:\\OneDrive\\Desktop\\Coding Projects\\Covid_Project\\Covid\\CovidNums.txt");

        System.out.println("The number of Covid cases for " + input + " in Alabama is " + (String)alCovid.findMonth(input));
    }
}
	
	
	