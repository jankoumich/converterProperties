import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by janko on 01/04/2017.
 */
public class Writer {

    private File file;

    public Writer(String pathToFile){
        file = new File(pathToFile);
    }

    /**
     * Method to create new java properties file
     *
     * @param properties
     */
    public void writeToJavaProperties(Properties properties) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, null);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
