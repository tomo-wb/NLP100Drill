
import java.util.ArrayList;


/**
 *
 * @author TomoyaMizumoto
 */
public class KakusanKibou {
    private static String KakusanKibou = "拡散希望";
     
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        for(int i = 0; i < TextsArray.size(); i++){
            if(TextsArray.get(i).contains(KakusanKibou)){
                println(TextsArray.get(i));
            }
        }
    }
    private static void println(Object obj) { System.out.println(obj); }
}
