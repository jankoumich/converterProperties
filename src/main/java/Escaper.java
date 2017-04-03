import java.io.InputStream;
import java.util.Map;

/**
 * Created by janko on 01/04/2017.
 */
public class Escaper {
    private static Map<String, String> htmlEscapeMap;
    private final String HTML_ESCAPE_CODES = "htmlEscape.csv";

    public Escaper(int mode){
        switch (mode){
            case 1:
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream inputStream = classLoader.getResourceAsStream(HTML_ESCAPE_CODES);
                Reader reader = new Reader(inputStream);
                htmlEscapeMap = reader.readCsv(",");
                break;
            default:
                break;
        }
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

            if(htmlEscapeMap.containsKey(character)
                    & (!character.equals("&") || !character.equals("#") || !character.equals(";"))){
                String replaceWith = htmlEscapeMap.get(character);
                escaped = escaped.replace(character, replaceWith);
                System.out.println("Replaced: " + character + " with: " + replaceWith);
            }
        }

        return escaped;
    }
}
