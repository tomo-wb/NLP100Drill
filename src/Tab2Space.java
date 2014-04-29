
import java.util.ArrayList;

/**
 *
 * @author TomoyaMizumoto
 */

public class Tab2Space {
    private static final String SPACE = " ";
    private static final String ITAB = "\\t";
    
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        // change "Tab" to "Space"
        for(int i = 0; i < TextsArray.size(); i++){
            String text = TextsArray.get(i);
            text = text.replaceAll(ITAB, SPACE);
            println(text);
        }
    }
    private static void println(Object obj) { System.out.println(obj); }
}
