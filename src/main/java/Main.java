import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;


public class Main {
    private static HashMap<String, String> propertiesMap = new HashMap<String, String>();

    public static void main(String[] args) {
        System.out.println("Converter Java Properties is starting work");
        readInputFile("/Users/janko/Desktop/test.csv");
        writeToPropertiesFile("/Users/janko/Desktop/test.properties");
        System.out.println("...and it is done, enjoy :)");
    }

    /**
     * Read input file checks if input file can be find
     *
     * @param inputFile The name of input file
     */
    private static void readInputFile(String inputFile) {
        String line;
        Scanner scanner = TryFile(inputFile);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] lineParsed = line.split(",",2);
            String key = lineParsed[0].trim();
            String value = HtmlUtils.htmlEscapeDecimal(lineParsed[1].trim());

            propertiesMap.put(key, value);
        }

        scanner.close();
    }


    /**
     * Method to create new java properties file
     *
     * @param propertiesPath
     */
    private static void writeToPropertiesFile(String propertiesPath) {
        Properties properties = new Properties();
        File file = new File(propertiesPath);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Iterator mapIterator = propertiesMap.keySet().iterator();

            while(mapIterator.hasNext()) {
                String key = mapIterator.next().toString();
                String value = propertiesMap.get(key);

                properties.setProperty(key, value);
            }

            properties.store(fileOutputStream, null);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to check if the file can be found, if not it close the program if found returns scanner
     *
     * @param file String that points to the input file
     * @return Scanner File read to process
     */
    private static Scanner TryFile(String file) {
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
