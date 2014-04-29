
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TomoyaMizumoto
 */
public class PrintTailSent {
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        if(args.length == 0){
            println("ERROR: please input number");
            System.exit(1);
        }
        
        int n = Integer.parseInt(args[0]);
        int tailStart = TextsArray.size() - n;
        for(int i = tailStart; i < TextsArray.size(); i++){
            println(TextsArray.get(i));
        }  
    }
    private static void println(Object obj) { System.out.println(obj); }
}
