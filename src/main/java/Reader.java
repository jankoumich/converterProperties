import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by janko on 01/04/2017.
 */
public class Reader {
    private String inputPath;
    private InputStream inputStream;

    public Reader(String path){
        this.inputPath = path;
    }

    public Reader(InputStream inputStream){
        this.inputStream = inputStream;
    }

    /**
     * Read input file checks if input file can be find
     *
     * @param delimiter The name of input file
     */
     public HashMap<String, String> readCsv(String delimiter) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String line;
        Scanner scanner = (inputStream != null) ? tryInputStream(inputStream) : tryPath(inputPath);

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
    private Scanner tryPath(String file) {
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

    private Scanner tryInputStream(InputStream inputStream){return new Scanner(inputStream);
    }
}
