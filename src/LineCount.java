
import java.util.ArrayList;

/**
 *
 * @author TomoyaMizumoto
 */
public class LineCount {
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        // print line size
        println(TextsArray.size());
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
