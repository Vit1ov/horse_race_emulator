package models;

import lombok.Data;

@Data
public class Rider {

    private String name;

    @Override
    public String toString() {
        return "" + name;
    }
}
