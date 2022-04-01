package services;

import lombok.RequiredArgsConstructor;
import models.Horse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService {

    private final List<Horse> horses;

    public List<Horse> getRandomHorses(int number) {

        Random rand = new Random();
        List<Horse> givenList = new ArrayList<>(horses); //возвращаю копию листа horses
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
