
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author TomoyaMizumoto
 */
public class DicSort2Col {
    private static final String ITAB = "\\t";
    private static final String OTAB = "\t";
    
    
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        TextsArray = changeCols(TextsArray);
        Collections.sort(TextsArray);
        TextsArray = changeCols(TextsArray);
        
        for(int i = 0; i < TextsArray.size(); i++){
            String[] cols = (TextsArray.get(i)).split(ITAB);
            if(cols[1].equals("NULL")){
                String text = cols[0] + " ";
                println(text);
            }
            else{
                println(TextsArray.get(i));
            }
        }
    }
    
    private static ArrayList<String> changeCols(ArrayList<String> TextsArray){
        String col1 = "";
        String col2 = "";
        for(int i = 0; i < TextsArray.size(); i++){
            String[] cols = (TextsArray.get(i)).split(ITAB);
            
            if(cols.length > 1){
                col1 = cols[0];
                col2 = cols[1];
            }
            else if(cols.length == 1){
                col1 = cols[0];
                col2 = "NULL";
            }
            else{
                println("ERROR");
                System.exit(2);
            }
            String text = col2 + OTAB + col1;    
            TextsArray.set(i, text);
        }
        return TextsArray;
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
