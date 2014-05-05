
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
        /*
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
        }*/
        String text = "RT @??: すうのよ RT @???: つい RT @???: なのだ";
        recursion(text);
    }
    
    private static void recursion(String text){
        Pattern p = Pattern.compile("(.*) "+RT+" @.*: (.*)");
        Matcher m = p.matcher(text);
        if(m.find()){
            String RTreply = m.group(1);
            m = p.matcher(RTreply);
            if(m.find()){
                String RTreply2 = m.group(2);
                println(RTreply2);
                recursion(RTreply);
            }
            else{
                Pattern p2 = Pattern.compile(RT+" @.*: (.*)");
                println(RTreply);
                Matcher m2 = p2.matcher(RTreply);
                if(m2.find()){
                    String RTreply2 = m2.group(1);
                    println(RTreply2);
                }
                else{
                
                }
                //Matcher m2 = p2.matcher(RTreply);
                //String RTreply2 = m2.group(1);
                //println(RTreply2);
            }
        }
        else{
            println(text);
        }
        //return text;
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
