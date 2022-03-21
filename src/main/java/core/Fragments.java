package main.java.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fragments {

    public static List<Fragment> readFromFile(String pathName) throws IOException {
       return  Files.readAllLines(Path.of(pathName)).stream().map(s -> new Fragment(s.split(";")[0], Arrays.stream(s.split(";")).skip(1).toList())).toList();
    }
}
