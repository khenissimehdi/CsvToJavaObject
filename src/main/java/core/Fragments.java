package main.java.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Fragments {

    public static List<Fragment> readFromFile(String pathName) throws IOException {
       return  Files.readAllLines(Path.of(pathName)).stream().map(s -> new Fragment(s.split(";")[0], Arrays.stream(s.split(";")).skip(1).toList())).toList();
    }

    public static Map<String, Fragment> fromListToMap(List<Fragment> fragmentList) {
        return fragmentList.stream().collect(Collectors.toUnmodifiableMap(Fragment::title, e->e));
    }

    public static Long numberOfUniqueFragments(List<Fragment> fragmentList) {
       // return fragmentList.stream().flatMap(Stream).collect()
      return fragmentList.stream().map(Fragment::fragmentList).flatMap(List::stream).distinct().count();
    }

    public static Map<String, Long>  numberOfFragmentBySomething(List<Fragment> fragmentList) {
        return fragmentList.stream().map(Fragment::fragmentList).flatMap(List::stream)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public static Optional<FragmentSomethingCount> someInMostFragments( Map<String, Long> map) {
        
        return map.entrySet().stream().
                map(e -> new FragmentSomethingCount(e.getKey(), e.getValue())).collect(Collectors.maxBy(Comparator.comparing(e->e.numberOf())));
    }
}
