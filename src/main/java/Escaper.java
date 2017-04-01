import java.util.Map;

/**
 * Created by janko on 01/04/2017.
 */
public class Escaper {

    /**
     * Escape special characters based on provided csv.
     * Numbers and &#; removed and ignored to prevent from modifying already applied html sequence
     *
     * @param string
     * @return
     */
    public static String escapeWithHtml(String string){
        Reader reader1 = new Reader("/Users/janko/Desktop/htmlEscape.csv");
        Map<String, String> escapeMap = reader1.readCsv(",");
        String escaped = string;

        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            String character = String.valueOf(c);

            if(escapeMap.containsKey(character)
                    & (!character.equals("&") || !character.equals("#") || !character.equals(";"))){
                String replaceWith = escapeMap.get(character);
                escaped = escaped.replace(character, replaceWith);
            }
        }

        return escaped;
    }
}
