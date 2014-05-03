
import java.util.ArrayList;
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
public class EOSNow {
    private static String Now = "なう";
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        for(int i = 0; i < TextsArray.size(); i++){
            Pattern p = Pattern.compile(Now+"$");
            Matcher m = p.matcher(TextsArray.get(i));
            if(m.find()){
                println(TextsArray.get(i));
            }
        }
    }
    private static void println(Object obj) { System.out.println(obj); }
}
