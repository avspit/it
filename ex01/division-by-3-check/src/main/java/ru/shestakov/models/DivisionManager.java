package ru.shestakov.models;

public class DivisionManager {

    public String check(String text) {
        int num = Integer.parseInt(text);
        return (num % 3 == 0) ? "yes" : "no";
    }

}
