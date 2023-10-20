package org.example.exercise2;

public class Calculator {

    public Calculator() {

    }

    public boolean isPrime(int number) {
        int i = 2;

        while (i <= number / 2) {
            if (number % i == 0) {
                return false;
            }
            ++i;
        }

        return true;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isMultiple(int number, int divisor) {
        return number % divisor == 0;
    }
}
