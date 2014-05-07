
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TomoyaMizumoto
 */
public class User2HTMLURL {
    public static void main(String[] args){
        try (ExtensionBufferedReader ebr = new ExtensionBufferedReader(new InputStreamReader(System.in))){
            String tweet = ebr.readLine();
            while (tweet != null){
                ID2URL(tweet);
                tweet = ebr.readLine();
            }
            ebr.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static void ID2URL(String tweet){
        Pattern p = Pattern.compile("[^>]@([A-Za-z0-9_]+)[^<]");
        Matcher m = p.matcher(tweet);
        while(m.find()){
            String user = m.group(1);
            tweet = m.replaceFirst("<a href =\"https://twitter.com/#\\!/"+ user + "\">@"+user+"</a>");
            m = p.matcher(tweet);
        }
        println(tweet);
    }
    private static void println(Object obj) { System.out.println(obj); }
}
