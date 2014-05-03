
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TomoyaMizumoto
 */
public class ExtractRT {
    private static String RT = "RT";
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        for(int i = 0; i < TextsArray.size(); i++){
            Pattern p = Pattern.compile("(.*) "+RT+" .*");
            Matcher m = p.matcher(TextsArray.get(i));
            if(m.find()){
                String RTreply = m.group(1);
                println("O "+TextsArray.get(i));
                println("E "+ RTreply);
            }
        }
    }
    private static void println(Object obj) { System.out.println(obj); }
}
