package services;

import lombok.AllArgsConstructor;
import models.Race;

@AllArgsConstructor
public class RaceServiceImpl implements RaceService {

    private final HorseService horseService;

    public Race getRace(int quantity) {

        return new Race(horseService.getRandomHorses(quantity));
    }

}
