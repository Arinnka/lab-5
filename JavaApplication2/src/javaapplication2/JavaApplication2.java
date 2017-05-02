/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Arinn
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    
    public static final String alb = "abcdefghijklmnopqrstuvwxyz";
   static String[][] generateMap(char[] alphabet, char[] key, char[] message) {
        int count = 1;
        double heighttmp = message.length / key.length;
        int height = (int) (Math.ceil(heighttmp) + 2);
        String[][] map = new String[height][key.length];
        for (int i = 0; i < key.length; i++) {
            map[0][i] = String.valueOf(key[i]);
        }
        for (char c : alphabet) {
            for (int i = 0; i < key.length; i++) {
                if (c == key[i]) {
                    map[1][i] = Integer.toString(count);
                    count++;
                }
            }
        }
        count = 0;
        for (int i = 2; i < height; i++) {
            for (int j = 0; j < key.length; j++) {

                if (count < message.length) {
                    map[i][j] = String.valueOf(message[count]);
                    count++;
                } else {
                    map[i][j] = "";
                }
            }
        }
        return map;
    }

 public static boolean chkey(String keytmp) {
        for (int l = 0; l < keytmp.length(); l++) {
            if (!(alb.contains(String.valueOf(keytmp.charAt(l))))) {
                System.out.println("Key string may contain only lowercase letters");
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        char[] alphabet = alb.toCharArray();
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter message");
        String messagetmp = in.nextLine();
        char[] message = messagetmp.toCharArray();

        System.out.println("Enter key");
        String keytmp = "";
        try {
            do{
                        System.out.println("Key string may contain only lowercase letters");
            keytmp = reader.readLine();
        }
            while(!chkey(keytmp));
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (keytmp.length() > message.length) {
            int difference = keytmp.length() - message.length;
            keytmp = keytmp.substring(0, keytmp.length() - difference);
        }

        char[] key = keytmp.toCharArray();

        String[][] map = generateMap(alphabet, key, message);
        for (String[] c : map) {
            System.out.println(Arrays.toString(c));
        }

        int count = 1;
        double heighttmp = message.length / key.length;
        int height = (int) (Math.ceil(heighttmp) + 2);
        int stolbec;
        System.out.print("Encoded message");
        for (int j = 0; j < key.length; j++) {
            stolbec = Arrays.asList(map[1]).indexOf(String.valueOf(count));
            for (int i = 2; i < height; i++) {
                System.out.print(map[i][stolbec]);
            }
            count++;
        }

        System.out.println("\n");
        System.out.print("Decoded message:");
        for (int i = 2; i < height; i++) {
            for (int j = 0; j < key.length; j++) {
                System.out.print(map[i][j]);
            }
        }
        System.out.println("\n");
    }
}

    
    

