import java.util.*;
class Solution {
    
    public String[] elements = {"A", "E", "I" ,"O", "U"};
    
    public int solution(String word) {
        int answer = 1;
        String first = "A";
        
        while (true) {
            if (word.equals(first)) return answer;
            first = next(first);
            answer++;
        }
        
    }
    
    public String next(String current) {
        String next = new String(current);
        
        if (current.length() < 5) {
            return current + "A";
        }
        
        for (int i = 5; i > 0; i--) {
            if (current.substring(i - 1, i).equals("U")) {
                next = next.substring(0, i - 1);
            }
            else {
                next = next.substring(0, i - 1);
                next += nextElement(current.substring(i - 1, i));
                return next;
            }
        }
        
        next = current.substring(0, 4);
        next += nextElement(current.substring(4, 5));
        
        
        return next;
    }
    
    public String nextElement(String e) {
        for (int i = 0; i < elements.length - 1; i++) {
            if (e.equals(elements[i])) return elements[i + 1];
        }
        return "";
    }
}

/*
ANNNN 10000
AANNN 11000
AAANN 11100

AAAAN
AAAAA
AAAAE
AAAAI
AAAAO
AAAAU 11115

AAAEN 11120
AAAEA
AAAEE
..
AUUUU

ENNNN
EANNN
EAANN
EAAAN
EAAAA
*/