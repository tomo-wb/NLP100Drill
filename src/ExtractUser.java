
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
public class ExtractUser {
    private static HashMap<String, Integer> User = new HashMap<>();
    
    public static void main(String[] args){
        try (ExtensionBufferedReader ebr = new ExtensionBufferedReader(new InputStreamReader(System.in))){
            String tweet = ebr.readLine();
            while (tweet != null){
                ExtractUser(tweet);
                tweet = ebr.readLine();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static void ExtractUser(String str){
        Pattern p = Pattern.compile("@[A-Za-z0-9_]+");
        Matcher m = p.matcher(str);
        while(m.find()){
            String user = m.group();
            if(!User.containsKey(user)){
                println(user);
                User.put(user, 1);
            } 
        }
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
