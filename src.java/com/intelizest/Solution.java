package com.intelizest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'vowelsubstring' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    
    // Returns true if x is vowel. 
    static boolean isVowel(char x) { 
        // Function to check whether a character is 
        // vowel or not 
        return (x == 'a' || x == 'e' || x == 'i' 
                || x == 'o' || x == 'u'); 
    } 
  
    public static int vowelsubstring(String s) {
        HashSet<Character> hash = new HashSet<Character>();  
            // To store vowels 
  
        // Outer loop picks starting character and 
        // inner loop picks ending character. 
        int n = s.length(); 
        int count =0;
        for (int i = 0; i < n; i++) { 
            for (int j = i; j < n; j++) { 
  
                // If current character is not vowel, 
                // then no more result substrings 
                // possible starting from str[i]. 
                if (isVowel(s.charAt(j)) == false) 
                    break; 
  
                // If vowel, then we insert it in hash 
                hash.add(s.charAt(j)); 
  
                // If all vowels are present in current 
                // substring 
                if (hash.size() == 5) 
                    System.out.print(s.substring(i, j + 1) + " "); 
                    count++;
            } 
            hash.clear(); 
        } 

        return count;
    } 

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = bufferedReader.readLine();

        int result = Result.vowelsubstring("axyzaeiou");

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */
    }
}
