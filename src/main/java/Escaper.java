import java.io.InputStream;
import java.util.Map;

/**
 * Created by janko on 01/04/2017.
 */
public class Escaper {
    private static Map<String, String> escapeMap;

    public Escaper(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("htmlEscape.csv");
        Reader reader = new Reader(inputStream);
//        Reader reader = new Reader("/Users/janko/Desktop/htmlEscape.csv");
        escapeMap = reader.readCsv(",");
    }

    /**
     * Escape special characters based on provided csv.
     * Numbers and &#; removed and ignored to prevent from modifying already applied html sequence
     *
     * @param string
     * @return
     */
    public String escapeWithHtml(String string){
        String escaped = string;

        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            String character = String.valueOf(c);

            if(escapeMap.containsKey(character)
                    & (!character.equals("&") || !character.equals("#") || !character.equals(";"))){
                String replaceWith = escapeMap.get(character);
                escaped = escaped.replace(character, replaceWith);
                System.out.println("Replaced: " + character + " with: " + replaceWith);
            }
        }

        return escaped;
    }
}
