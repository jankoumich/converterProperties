import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by janko on 01/04/2017.
 */
public class Converter {
    private Map<String, String> propertiesMap;
    private Properties properties;
    private Reader reader;
    private Writer writer;

    public Converter(String inputPath, String outputPath){
        this.reader = new Reader(inputPath);
        this.propertiesMap = reader.readCsv(",");
        this.properties = new Properties();
        setProperties(propertiesMap);
        this.writer = new Writer(outputPath);
        writer.writeToJavaProperties(properties);
    }


    private void setProperties(Map<String, String> map){
        Iterator mapIterator = map.keySet().iterator();

        while(mapIterator.hasNext()) {
            String key = mapIterator.next().toString();
            String value = map.get(key);

            properties.setProperty(key, value);
        }

    }

}
