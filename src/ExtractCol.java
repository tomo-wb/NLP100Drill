
import java.util.ArrayList;

/**
 *
 * @author TomoyaMizumoto
 */
public class ExtractCol {
    private static final String ITAB = "\\t";
    private static final String NULL = "NULL";
    private static final String COL1 = "./txt/col1.txt";
    private static final String COL2 = "./txt/col2.txt";
    
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        String[] col1 = new String[TextsArray.size()];
        String[] col2 = new String[TextsArray.size()];
        
        // split texts to col1 and col2
        for(int i = 0; i < TextsArray.size(); i++){
            String[] cols = (TextsArray.get(i)).split(ITAB);
            if(cols.length > 1){
                col1[i] = cols[0];
                col2[i] = cols[1];
            }
            else if(cols.length == 1){
                col1[i] = cols[0];
                col2[i] = NULL;
            }
            else{
                println("ERROR");
                System.exit(2);
            }
        }
        FIO.StringListPrint(col1, COL1);
        FIO.StringListPrint(col2, COL2);
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
