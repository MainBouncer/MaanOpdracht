package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner {
    private String name;

    public Owner(String name) {
        this.name = name;
    }

}
