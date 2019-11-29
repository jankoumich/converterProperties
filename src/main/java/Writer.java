import java.io.*;
import java.util.Properties;

/**
 * Created by janko on 01/04/2017.
 */
public class Writer extends Properties{

    private File file;

    public Writer(String pathToFile){
        file = new File(pathToFile);
    }

    /**
     * Method to create new java properties file
     *
     * @param properties
     */
    public void writeToJavaProperties(PropertiesBasic properties) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
