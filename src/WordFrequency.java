
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TomoyaMizumoto
 */
public class WordFrequency {
    
    public static void main(String[] args){
        FileIO FIO = new FileIO();
        ArrayList<String> TextsArray = new ArrayList<>();  // stored texts
        TextsArray = FIO.FileSTDIN();
        
        HashMap<String,Integer> colHash = new HashMap<>();
        for(int i = 0; i < TextsArray.size(); i++){
            int num = 0;
            if(colHash.containsKey(TextsArray.get(i))){
                num = colHash.get(TextsArray.get(i));
            }
            num += 1;
            colHash.put(TextsArray.get(i), num);    
        }
        
        // reverse sort for HashMap
        ArrayList<Map.Entry<String,Integer>> entries = new ArrayList(colHash.entrySet());
        Collections.sort(entries, new Comparator(){
            @Override
            public int compare(Object obj1, Object obj2){
                Map.Entry ent1 =(Map.Entry)obj1;
                Map.Entry ent2 =(Map.Entry)obj2;
                Integer val1 = (Integer) ent1.getValue();
                Integer val2 = (Integer) ent2.getValue();
                return val2.compareTo(val1);
            }
        });
        
        //print result
        for (Entry<String,Integer> s : entries) {
            System.out.println(s.getKey()+": "+s.getValue());
        }
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
