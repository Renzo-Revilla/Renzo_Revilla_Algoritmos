package Ejercicio3;

import Ejercicio1.StackLink;
import Actividad1.ExceptionIsEmpty;

public class Aplication {

    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                try {
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                        return false;
                    }
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("\n--- Prueba del Problema de los Corchetes ---");
        System.out.println("\"()()()[()]()\": " + symbolBalancing("()()()[()]()"));       // true
        System.out.println("\"((()))[]\": " + symbolBalancing("((()))[]"));               // true
        System.out.println("\"([])[]((\": " + symbolBalancing("([])[](("));               // false
        System.out.println("\"([{)]}\": " + symbolBalancing("([{)]}"));                   // false
        System.out.println("\"[\": " + symbolBalancing("["));                             // false
        System.out.println("\"[][][]{{{}}}\": " + symbolBalancing("[][][]{{{}}}"));       // true
    }
}
