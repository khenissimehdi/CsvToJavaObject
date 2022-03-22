package main.java.core;

import java.util.Objects;

public record FragmentSomethingCount(String fragment, long numberOf) {
    public FragmentSomethingCount(String fragment, long numberOf) {
        this.fragment = Objects.requireNonNull(fragment);
        this.numberOf = numberOf;
    }
}
