
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
public class ExtractBracketKanji {
    private static HashMap<String, Integer> abbrSet = new HashMap<>();
    
    public static void main(String[] args){
        try (ExtensionBufferedReader ebr = new ExtensionBufferedReader(new InputStreamReader(System.in))){
            String tweet = ebr.readLine();
            while (tweet != null){
                ExtractBracketKanji(tweet);
                tweet = ebr.readLine();
            }
            ebr.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static void ExtractBracketKanji(String tweet){
        Pattern p = Pattern.compile("(\\p{InCJKUnifiedIdeographs}+)[\\(（]([A-Z]+)[\\)）]");
        // \p{InCJKUnifiedIdeographs} is a Kanji character
        Matcher m = p.matcher(tweet);
        //println(tweet);
        while(m.find()){
            String kanji = m.group(1);
            String abbr = m.group(2);
            String key = kanji+"\t"+abbr;
            if(!abbrSet.containsKey(key)){
                println(key);
                abbrSet.put(key, 1);
            }
            tweet = m.replaceFirst("");
            m = p.matcher(tweet);
        }
        
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
