package enums;

public enum Mineral {
    HELIUM3("Helium-3"),
    IRIDIUM("Iridium"),
    REGOLITH("Regolith"),
    GOLD("Gold"),
    PALLADIUM("Palladium"),
    PLATINUM("Platinum");
    String name;
    Mineral(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
