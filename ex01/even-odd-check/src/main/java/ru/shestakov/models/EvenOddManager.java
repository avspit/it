package ru.shestakov.models;

public class EvenOddManager {

    public boolean check(String text) {
        return (Integer.parseInt(text) % 2 == 0);
    }

}
