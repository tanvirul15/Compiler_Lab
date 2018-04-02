/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;
/**
 *
 * @author Tanvirul Islam
 */
public class Char_Stack {

    char operator[];
    int top;

    public Char_Stack() {
        operator = new char[100];
        top = -1;
    }

    public char pop() {
        char c = ' ';
        if (top >= 0) {
            c = operator[top];
            top--;
        }

        return c;
    }

    public void push(char c) {
        top++;
        operator[top] = c;

    }

    boolean checkPresidence(char c) {

        if (top == -1) {
            return false;
        } else if (c == '+' || c == '-') {
            return true;
        } else if (c == '*' || c == '/') {
            if (operator[top] == '*' || operator[top] == '/') {
                return true;
            }
        }
        return false;
    }

}
