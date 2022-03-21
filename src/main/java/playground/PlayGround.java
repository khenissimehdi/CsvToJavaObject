package main.java.playground;

import main.java.core.Fragments;

import java.io.IOException;

public class PlayGround {
    public static void main(String[] args) throws IOException {
        var csvToJava = Fragments.readFromFile("movies.txt");
        csvToJava.forEach(e -> System.out.println(e.title() + " " + (long) e.fragmentList().size()));
    }
}
