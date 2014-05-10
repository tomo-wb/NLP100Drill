
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author TomoyaMizumoto
 */
public class KakusanKibou {
    private static final String KakusanKibou = "拡散希望";
    
    public static void main(String[] args){
        try (ExtensionBufferedReader ebr = new ExtensionBufferedReader(new InputStreamReader(System.in))){
            String tweet = ebr.readLine();
            while (tweet != null){
                tweet = tweet.replaceAll("\\\\n", " ");
                PrintKakusanKibou(tweet);
                tweet = ebr.readLine();
            }
            ebr.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static void PrintKakusanKibou(String tweet){
        if(tweet.contains(KakusanKibou)){
            println(tweet);
        }
    }

    private static void println(Object obj) { System.out.println(obj); }
}
