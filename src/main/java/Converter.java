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

    public Converter(String inputPath, String outputPath, int mode){
        this.reader = new Reader(inputPath);
        this.propertiesMap = reader.readCsv(",");
        this.properties = new Properties();
        setProperties(propertiesMap, mode);
        this.writer = new Writer(outputPath);
        writer.writeToJavaProperties(properties);
    }


    private void setProperties(Map<String, String> map, int mode){
        Iterator mapIterator = map.keySet().iterator();
        Escaper escaper = new Escaper();

        while(mapIterator.hasNext()) {
            String key = mapIterator.next().toString();
            String value;

            switch (mode){
                case 1:
                    value = escaper.escapeWithHtml(map.get(key));
                    break;
                default:
                    value = map.get(key);
                    break;
            }

            properties.setProperty(key, value);
        }
    }

}
