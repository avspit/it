package ru.shestakov.models;

public class DivisionManager {

    public boolean check(String text) {
        int num = Integer.parseInt(text);
        return (num % 5 == 0 || num % 11 == 0);
    }

}
