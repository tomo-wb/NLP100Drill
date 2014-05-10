
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TomoyaMizumoto
 */
public class ExtractRT {
    public static void main(String[] args){
        try (ExtensionBufferedReader ebr = new ExtensionBufferedReader(new InputStreamReader(System.in))){
            String tweet = ebr.readLine();
            while (tweet != null){
                int num = 0;
                tweet = tweet.replaceAll("\\\\n", " ");
                //recursion(tweet,num);
                extractRTreply(tweet);
                tweet = ebr.readLine();
            }
            ebr.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static void extractRTreply(String tweet){
        Pattern p = Pattern.compile("(.+?)"+"(RT|QT)"+" @.*: (.*)");
        Matcher m = p.matcher(tweet);
        if(m.find()){
            String RTreply = m.group(1);
            printlnRT(RTreply);
        }
    }
    
    private static int recursion(String text, int num){
        Pattern p = Pattern.compile("(.+)"+"(RT|QT)"+" @.*: (.*)");
        Matcher m = p.matcher(text);
        if(m.find()){
            if(num > 0){
                String RTreply2 = m.group(3);
                printlnRT(RTreply2);
            }
            String RTreply = m.group(1);
            num += 1;
            num = recursion(RTreply,num);
        }
        else{
            Pattern p2 = Pattern.compile("(RT|QT)"+" @.*: (.*)");
            Matcher m2 = p2.matcher(text);
            if(m2.find()&& num > 0){
                String RTreply2 = m2.group(2);
                printlnRT(RTreply2);
            }
            else if(num > 0){
                printlnRT(text);
            }
        }
        return num;
    }
    
    private static void println(Object obj) { System.out.println(obj); }
    
    private static void printlnRT(String str) { 
        Pattern p = Pattern.compile("(RT|QT)"+" @.*: (.*)");
        Matcher m = p.matcher(str);
        
        if(!str.equals("")&& !m.find())
            System.out.println(str); 
    }
}
