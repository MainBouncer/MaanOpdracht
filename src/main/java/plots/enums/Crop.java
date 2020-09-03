package plots.enums;

public enum Crop {
    TOMATO("Tomato", false),
    CUCUMBER("Cucumber", false),
    RADISH("Radish", false),
    LETTUCE("Lettuce", false),
    PAPRIKA("Paprika", false),
    CANNABIS("Cannabis", true),
    MOONSEED("Moonseed", true);

    String name;
    boolean isPermitRequired;

    Crop(String name, boolean isPermitRequired) {
        this.name = name;
        this.isPermitRequired = isPermitRequired;
    }

    public String getName() {
        return name;
    }
    public boolean isPermitRequired() {return isPermitRequired;}
}