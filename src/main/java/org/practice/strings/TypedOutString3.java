package org.practice.strings;

public class TypedOutString3 {

    public static void main(String[] args) {
        TypedOutString3 typedOutString1 = new TypedOutString3();
        System.out.println(typedOutString1.backspaceCompare("ga#b#c#", "gabc###"));
    }

    public boolean backspaceCompare(String s, String t) {

        if (s.equals(t)) {
            return true;
        }

        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        int hash1 = 0;
        int hash2 = 0;
        while (p1 >= 0 || p2 >= 0) {

            while (p1 >= 0 && (s.charAt(p1) == '#' || hash1 > 0)) {
                if (s.charAt(p1) == '#') {
                    hash1++;
                } else {
                    hash1--;
                }
                p1--;
            }

            while (p2 >= 0 && (t.charAt(p2) == '#' || hash2 > 0)) {
                if (t.charAt(p2) == '#') {
                    hash2++;
                } else {
                    hash2--;
                }
                p2--;
            }

            char sourceChar = p1 < 0 ? '\u0000' : s.charAt(p1);
            char targetChar = p2 < 0 ? '\u0000' : t.charAt(p2);

            System.out.println("Character from String 1: " + sourceChar);
            System.out.println("Character from String 2: " + targetChar);
            System.out.println();

            if (sourceChar != targetChar) {
                return false;
            }
            p1--;
            p2--;
        }
        return true;
    }
}
