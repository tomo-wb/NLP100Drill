
import java.util.ArrayList;


/**
 *
 * @author TomoyaMizumoto
 */
public class PrintHeadSent {
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        if(args.length == 0){
            println("ERROR: please input number");
            System.exit(1);
        }
        
        int n = Integer.parseInt(args[0]);
        for(int i = 0; i < n; i++){
            println(TextsArray.get(i));
        }  
    }
    private static void println(Object obj) { System.out.println(obj); }
}
