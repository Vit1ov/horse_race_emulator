package services;

import models.Horse;

import java.util.List;

public interface HorseService {

    List<Horse> getRandomHorses(int number);

}
