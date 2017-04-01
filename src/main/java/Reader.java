import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by janko on 01/04/2017.
 */
public class Reader {
    private String inputPath;

    public Reader(String path){
        this.inputPath = path;
    }

    /**
     * Read input file checks if input file can be find
     *
     * @param delimiter The name of input file
     */
     public HashMap<String, String> readCsv(String delimiter) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String line;
        Scanner scanner = tryFile(inputPath);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] lineParsed = line.split(delimiter,2);
            String key = lineParsed[0].trim();
            String value = lineParsed[1].trim();

            hashMap.put(key, value);
        }

        scanner.close();

        return hashMap;
    }

    /**
     * Method to check if the file can be found, if not it close the program if found returns scanner
     *
     * @param file String that points to the input file
     * @return Scanner File read to process
     */
    private static Scanner tryFile(String file) {
        try {
            return new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + file);
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }
}
