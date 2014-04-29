/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author TomoyaMizumoto
 */
public class LineCount {
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
        println(TextsArray.size());
    }
    
    private static ArrayList<String> FileReader(File file){
        ArrayList<String> TextsArray = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            while(str != null){
                TextsArray.add(str);
                str = br.readLine();
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        return TextsArray;
    }
    
    private static String processArgsArray(String[] args) {
        int i = 0;
        String file = "";
        while (i < args.length) {
            String option = args[i];
            if(option.equals("-file")){
                file = args[i+1];
                i+=2;
            }
            else{
                // print ERRROR
                System.exit(2);
            }
        }
        return file;
    }
    
    private static void println(Object obj) { System.out.println(obj); }
}
