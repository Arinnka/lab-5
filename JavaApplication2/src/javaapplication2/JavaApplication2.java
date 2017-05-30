/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
    
   static String[][] generateMap(char[] alphabet, char[] key, char[] message) { 
int count = 1; 
double heighttmp = message.length * 1.0 / key.length ; 
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

public static void main(String[] args) throws UnsupportedEncodingException, IOException { 
String alb = "АБВГДЕЖЗИЙКЛМНОПРСТУФХШЩЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя., :-"; 
char[] alphabet = alb.toCharArray(); 
BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"Cp1251")); 


System.out.println("Enter message"); 
String messagetmp = in.readLine(); 
char[] message = messagetmp.toCharArray(); 

System.out.println("Enter the key"); 
String keytmp = in.readLine(); 

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
double heighttmp = message.length * 1.0 / key.length ; 
int height = (int) (Math.ceil(heighttmp) + 2); 
int stolbec; 
System.out.print("And the encoded message is ... "); 
for (int j = 0; j < key.length; j++) { 
stolbec = Arrays.asList(map[1]).indexOf(String.valueOf(count)); 
for (int i = 2; i < height; i++) { 
System.out.print(map[i][stolbec]); 
} 
count++; 
} 

System.out.println("\n"); 
System.out.print("And the decoded message is ... "); 
for (int i = 2; i < height; i++) { 
for (int j = 0; j < key.length; j++) { 
System.out.print(map[i][j]); 
} 
} 
System.out.println("\n");
}}
    
    

