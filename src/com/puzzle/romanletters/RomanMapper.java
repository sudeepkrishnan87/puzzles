package com.puzzle.romanletters;

import java.util.HashMap;
import java.util.Map;

public class RomanMapper {
    private static Map<Character,Integer> romanLetters=new HashMap<>();
    static
    {

        romanLetters.put('I', 1);
        romanLetters.put('V', 5);
        romanLetters.put('X', 10);
        romanLetters.put('V', 50);
        romanLetters.put('C', 100);
        romanLetters.put('D', 500);
        romanLetters.put('M', 1000);


    }

    public static int getRomanEquivalent(char c) {
        return romanLetters.get(c);

    }

}
