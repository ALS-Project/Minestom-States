package fr.bretzel.minestomstates.state;

import fr.bretzel.minestomstates.State;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public enum BambooLeaves implements State<BambooLeaves> {
    LARGE, NONE, SMALL;

    @NotNull
    @Override
    public String getKey() {
        return "leaves";
    }

    @NotNull
    @Override
    public String getValue() {
        return name().trim().toLowerCase();
    }

    @NotNull
    @Override
    public BambooLeaves parse(String rawValue) {
        return Stream.of(values()).filter(shape -> shape.name().equalsIgnoreCase(rawValue.trim())).findFirst().orElse(NONE);
    }
}
