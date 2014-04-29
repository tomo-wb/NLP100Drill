
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Tab2Space {
    public static void main(String[] args){
        ArrayList<String> TextsArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            TextsArray = new ArrayList<>();
            String str = br.readLine();
            while(str != null){
                TextsArray.add(str);
                str = br.readLine();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        
        for(int i = 0; i < TextsArray.size(); i++){
            String text = TextsArray.get(i);
            text = text.replaceAll("\\t", " ");
            println(text);
        }
    }
    private static void println(Object obj) { System.out.println(obj); }
}
