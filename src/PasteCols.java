
import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author TomoyaMizumoto
 */
public class PasteCols {
    private static final String NULL = "NULL";
    private static final String OTAB = "\t";

    
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArrayCol1 = new ArrayList<>();  // stored col1 texts
        ArrayList<String> TextsArrayCol2 = new ArrayList<>();  // stored col2 texts
        
        String[] files = processArgsArray(args);
        String COL1 = files[0];
        String COL2 = files[1];
        
        TextsArrayCol1 = FIO.FileReader(COL1);
        TextsArrayCol2 = FIO.FileReader(COL2);
        
        for(int i = 0; i < TextsArrayCol1.size(); i++){
            if(TextsArrayCol2.get(i).equals(NULL)){
                TextsArrayCol2.set(i, "");
            }
            String output = TextsArrayCol1.get(i) + OTAB + TextsArrayCol2.get(i);
            println(output);
            //String output = String.join(TAB, TextsArrayCol1, TextsArrayCol2);
        }
    }
    
    private static String[] processArgsArray(String[] args) {
        String[] files = {"", ""}; 
        int i = 0;
        while (i < args.length) {
            if(args[i].equals("-col1")){
                files[0] = args[i+1];
                i+=2;
            }
            else if(args[i].equals("-col2")){
                files[1] = args[i+1];
                i+=2;
            }
            else{
                println("ERROR");
                System.exit(1);
            }
        }
        if(files[0].isEmpty() || files[1].isEmpty()){
            println("ERROR");
            System.exit(1);
        }
        return files;
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
