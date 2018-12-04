package ru.shestakov.models;

public class EvenOddManager {

    public String check(String text) {
        return (Integer.parseInt(text) % 2 == 0) ? "even" : "odd";
    }

}
