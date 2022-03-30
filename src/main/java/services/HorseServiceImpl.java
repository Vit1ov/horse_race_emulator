package services;

import lombok.Setter;
import models.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorseServiceImpl implements HorseService {

    @Setter
    private List<Horse> horses;

    public List<Horse> getRandomHorses(int number) {

        Random rand = new Random();
        List<Horse> givenList = new ArrayList<>(horses);
        List<Horse> result = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            Horse randomHorse = givenList.get(randomIndex);
            result.add(randomHorse);
            givenList.remove(randomIndex);
        }
        return result;
    }

}
