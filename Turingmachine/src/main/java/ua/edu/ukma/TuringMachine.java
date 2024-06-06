package ua.edu.ukma;

public class TuringMachine {
    char[] automat;
    int index;

    public static void main(String[] args) {
    }

    public TuringMachine(int length){
        automat = new char[length];
        index = 0;
    }

    public TuringMachine right() {
        index = ++index % automat.length;
        return this; }
    public TuringMachine left() {
        index = --index % automat.length;
        return this; }
    public TuringMachine placeChar(char a) {
        automat[index] = a;
        return this;
    }
    public TuringMachine removeChar() {
        automat[index] = 0;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char c : automat) {
            result.append((c != 0) ? c : "_");
        }
        result.append('\n');
        for (int i = 0; i < automat.length; i++) {
            result.append((i == index) ? "^" : " ");
        }
        return result.toString();
    }

    public String toLine() {
        StringBuilder result = new StringBuilder();
        for (char c : automat) {
            result.append((c != 0) ? c : "");
        }
        return result.toString();
    }
}
