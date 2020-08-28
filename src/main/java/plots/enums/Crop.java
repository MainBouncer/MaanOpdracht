package plots.enums;

public enum Crop {
    TOMATO("Tomato"),
    CUCUMBER("Cucumber"),
    RADISH("Radish"),
    LETTUCE("Lettuce"),
    PAPRIKA("Paprika");
    String name;

    Crop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}