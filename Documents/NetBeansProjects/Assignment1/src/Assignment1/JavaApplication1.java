/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Tanvirul Islam
 */
public class JavaApplication1 {

    static int num[] = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Number of variable:");
        int var = sc.nextInt();

        char c = 'a';

        for (int i = 0; i < var; i++) {
            System.out.print(c + "= ");
            num[i] = sc.nextInt();
            System.out.println("");
            c++;
        }

        System.out.println("Enter the number of equation: ");
        int eqn_num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < eqn_num; i++) {
            System.out.println("Enter Equation:");
            String s = sc.nextLine();

            if (!eqn_validate(s, var)) {
                System.out.println("Invalid Equation");
                continue;
            }

            s = convertPostfix(s);

            System.out.println("Result :" + evaluate_expr(s));

        }

    }

    static boolean eqn_validate(String s, int n) {
        boolean prev_operator = true;
        for (char c : s.toCharArray()) {
            boolean current_operator;

            if (c >= 'a' && c <= 96 + n) {
                current_operator = false;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                current_operator = true;
            } else {
                return false;
            }

            if (!current_operator ^ prev_operator) {
                return false;
            }
            prev_operator = current_operator;
        }
        return true;
    }

    static String convertPostfix(String s) {

        Char_Stack st = new Char_Stack();
        String temp = "";

        for (char c : s.toCharArray()) {
            // System.out.println("for"+temp);
            if (c >= 97 && c <= 122) {
                temp = temp + c;
            } else {
                while (st.checkPresidence(c)) {
                    // System.out.println("While"+temp);
                    temp = temp + st.pop();
                }
                st.push(c);

            }

        }
        char c = st.pop();
        while (c != ' ') {

            temp += c;
            c = st.pop();
        }

        return temp;
    }

    static double evaluate_expr(String s) {
        Stack<Double> st = new Stack<>();
        String temp = "";

        for (char c : s.toCharArray()) {
            if (c >= 97 && c <= 122) {
                st.push(Double.valueOf(num[c - 97]));
            } else {
                //char x=st.pop();
                double num1 = st.pop();
                // x=st.pop();
                double num2 = st.pop();

                if (c == '-') {
                    st.push(num1 - num2);
                } else if (c == '*') {
                    st.push(num1 * num2);
                } else if (c == '/') {
                    st.push(num1 / num2);
                } else if (c == '+') {
                    st.push(num1 + num2);
                }
            }

        }

        return st.pop();
    }

}
