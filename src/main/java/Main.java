import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Converter Java Properties is starting work");
        Map<String, String> propertiesMap = readInputFile("/Users/janko/Desktop/test.csv");
        writePropertiesToFile("/Users/janko/Desktop/test.properties", propertiesMap);
        System.out.println("...and it is done, enjoy :)");
    }

    /**
     * Read input file checks if input file can be find
     *
     * @param inputFile The name of input file
     */
    private static HashMap<String, String> readInputFile(String inputFile) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String line;
        Scanner scanner = tryFile(inputFile);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] lineParsed = line.split(",",2);
            String key = lineParsed[0].trim();
            String value = lineParsed[1].trim();

            hashMap.put(key, value);
        }

        scanner.close();

        return hashMap;
    }


    /**
     * Method to create new java properties file
     *
     * @param propertiesPath
     */
    //TODO escape using read file with espace and irterate over all characters in the string with replace
    private static void writePropertiesToFile(String propertiesPath, Map<String, String> hashMap) {
        Properties properties = new Properties();
        File file = new File(propertiesPath);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Iterator mapIterator = hashMap.keySet().iterator();

            while(mapIterator.hasNext()) {
                String key = mapIterator.next().toString();
                String value = hashMap.get(key);

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
