package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horse {

    private Rider rider;

    private Breed breed;

    private int position;

    @Override
    public String toString() {
        return "Horse with " +
                "rider: " + rider +
                ", breed: " + breed;
    }
}
