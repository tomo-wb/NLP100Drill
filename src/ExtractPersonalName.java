
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author TomoyaMizumoto
 */
public class ExtractPersonalName {
    private static final String title = "(さん|くん|君|氏|ちゃん|殿)"; 
    private static HashMap<String, Integer> personalNames = new HashMap<>();
    
    public static void main(String[] args){
        try (ExtensionBufferedReader ebr = new ExtensionBufferedReader(new InputStreamReader(System.in))){
            String tweet = ebr.readLine();
            while (tweet != null){
                tweet = tweet.replaceAll("\\\\n", " ");
                PersonalName(tweet);
                tweet = ebr.readLine();
            }
            ebr.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static void PersonalName(String tweet){
        Pattern p = Pattern.compile("(@?[A-Za-z]+?|\\p{InCJKUnifiedIdeographs}+?|\\p{InHiragana}+?|\\p{InKatakana}+?)"+title);
        Matcher m = p.matcher(tweet);
        while(m.find()){
            String personalName = m.group(1);
            if(!personalNames.containsKey(personalName)){
                println(personalName);
                personalNames.put(personalName, 1);
            }
            tweet = m.replaceFirst("");
            m = p.matcher(tweet);
        }
    }
    private static void println(Object obj) { System.out.println(obj); }
}
