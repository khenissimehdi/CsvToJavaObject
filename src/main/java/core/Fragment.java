package main.java.core;

import java.util.List;
import java.util.Objects;

// Why we used List ?
public record Fragment(String title, List<String> fragmentList) {

    public Fragment(String title, List<String> fragmentList) {
        this.title =  Objects.requireNonNull(title);
        this.fragmentList =  Objects.requireNonNull(fragmentList);
    }
}
