
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author TomoyaMizumoto
 */
public class UniqNum {
    private static final String ITAB = "\\t";
    
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        HashMap<String,Integer> colHash = new HashMap<>();
        
        // split texts to col1 and col2
        for(int i = 0; i < TextsArray.size(); i++){
            String[] cols = (TextsArray.get(i)).split(ITAB);
            int num = 0;
            if(colHash.containsKey(cols[0])){
                num = colHash.get(cols[0]);
            }
            num += 1;
            colHash.put(cols[0], num);
        }
        println(colHash.size());
    }
    
    public static void println(Object obj) { System.out.println(obj); }
}
