package ch16.supplier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Goods {
    private String name;
    private String color;
    private boolean useful;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isUseful() {
        return useful;
    }

    @Override
    public String toString() {
        return name + " (" + color+")";
    }
}
