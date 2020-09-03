package plots.enums;

import lombok.Getter;

@Getter
public enum Crop {
    TOMATO("Tomato", false, 30),
    CUCUMBER("Cucumber", false, 20),
    RADISH("Radish", false, 5),
    LETTUCE("Lettuce", false, 15),
    PAPRIKA("Paprika", false, 25),
    CANNABIS("Cannabis", true, 8),
    MOONSEED("Moonseed", true, 35);

    private String name;
    private boolean isPermitRequired;
    private int calories;

    Crop(String name, boolean isPermitRequired, int calories) {
        this.name = name;
        this.isPermitRequired = isPermitRequired;
        this.calories = calories;
    }

    public Crop getHighestCaloryCrop() {
        Crop currentMax = Crop.values()[0];
        for(Crop crop:Crop.values()) {
            if (crop.getCalories() > currentMax.getCalories()) {
                currentMax = crop
        }
        }
    }
}