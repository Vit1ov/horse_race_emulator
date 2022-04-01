package services;

import lombok.RequiredArgsConstructor;
import models.Race;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RaceServiceImpl implements RaceService {

    private final HorseService horseService;

    public Race getRace(int quantity) {

        return new Race(horseService.getRandomHorses(quantity));
    }

}
