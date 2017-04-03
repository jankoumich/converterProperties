import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by janko on 01/04/2017.
 */
public class Converter {
    private Properties properties;
    private Reader reader;
    private Writer writer;

    public Converter(String inputPath, String outputPath){
        this.properties = new Properties();
        this.reader = new Reader(inputPath);
        this.writer = new Writer(outputPath);
    }

    public void convert(int mode){
        Map<String, String> propertiesMap = reader.readCsv(",");
        setProperties(propertiesMap, mode);
        writer.writeToJavaProperties(properties);
    }

    /**
     * Set java properties based on given map <String, String> and the mode to either leave it as original input (0) or
     * escape it. Now supports only HTML escape sequence (1)
     *
     * @param map
     * @param mode
     */
    private void setProperties(Map<String, String> map, int mode){
        Iterator mapIterator = map.keySet().iterator();
        Escaper escaper = new Escaper(mode);

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
