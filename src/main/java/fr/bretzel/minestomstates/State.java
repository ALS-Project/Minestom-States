package fr.bretzel.minestomstates;

import org.jetbrains.annotations.NotNull;

public interface State<T> {

    @NotNull
    String getKey();

    @NotNull
    String getValue();

    @NotNull
    T parse(String rawValue);
}
