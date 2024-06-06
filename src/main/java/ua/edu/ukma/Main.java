package ua.edu.ukma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean cyphering = true;
        String input;
        TuringMachine tm = new TuringMachine(20);
        System.out.println(tm.toString());
        System.out.println("Enter text to cypher: ");
        input = br.readLine();
        for (char a : input.toCharArray()) {
            tm.placeChar(a).right();
        }
        System.out.println(tm.toString());
        JSONParser wf = new JSONParser();
        wf.add(tm.toLine(), CaesarCipher.encrypt(tm.toLine(), 2));
        System.out.println(wf.getJSON());
    }
}