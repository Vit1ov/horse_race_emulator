package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Race {

    @Getter
    private List<Horse> competitors;

    @Override
    public String toString() {
        return "Upcoming Race" + "\n" +
                competitors;
    }
}
