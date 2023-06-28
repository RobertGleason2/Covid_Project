import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/** Searches for the file, puts the elements contained in the file in an ArrayList, and finds the element in the arrayList the user wants to know
 *
 * @author Robert Gleason
 * @version 0.1
 */
public class CovidDataStr {

    protected String USCases;
    protected ArrayList <String> caseList = new ArrayList <String> (); //creates a new ArrayList

    /**Default Constructor
     *
     */
    public CovidDataStr() {

    }

    /** returns aString representation of the collection
     *
     * @return a string representation of the collection
     */
    public String numCases() {
        return caseList.toString();
    }

    /** Finds the file and adds the data to the ArrayList caseList
     *
     * @param fName the name of the file being found in the file reader
     * @return retVal returns true if the file has been read and closed
     */
    public boolean loadData(String fName) {
        BufferedReader br = null;
        String line;
        boolean retVal = false;

        try {
            br = new BufferedReader( new FileReader(fName));//reads the file

        }catch(FileNotFoundException fnfex) { //set to catch a fnf exception
            System.out.println(fnfex.getMessage() + "The file could not be found.");
            System.exit(0); // exits the program file if fnf exeption
        }
        try {
            while((line = br.readLine()) != null) //will execute the loop as long as there is a line to read
                caseList.add(line); //issue with the file being read and stored
            retVal = true;
        } catch (IOException ioex) { //set to catch an io exception
            System.out.println(ioex.getMessage() + "Error reading file.");
        }finally { //closes the file
            try{
                br.close();
            }catch(IOException ioex) { //set to catch an io exception
                System.out.println(ioex.getMessage() + "File is closing.");
            }
        }
        return retVal;
    }

    /** Searches through the ArrayList for the data the user wants
     *
     * @param key the data prefix the data starts with
     * @return retVal returns the data found in the ArrayList
     */
    public String findMonth(String key) {
        String retVal = null;
        for(int i = 0; i < caseList.size(); i++) {
            if(caseList.get(i).startsWith(key)) {
                retVal = caseList.get(i);
                break;
            }
        }
        return retVal;
    }
}
