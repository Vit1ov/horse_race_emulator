package services;

import lombok.RequiredArgsConstructor;
import models.Horse;
import models.Race;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class EmulationServiceImpl implements EmulationService {

    private final RaceService raceService;

    public void startHorseRace() {

        int number = getNumberOfCompetitors();

        Race race = raceService.getRace(number);
        System.out.println(race);

        Horse bet = getBetFromCustomer(number, race);

        Horse winner = this.emulateRace(race);

        printResultOfBet(bet, winner);

    }

    private Horse emulateRace(Race race) {
        int numberOfCompetitors = race.getCompetitors().size();
        Horse winner = null;
        System.out.println("Current progress");
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < numberOfCompetitors; i++) {
                Horse currentHorse = race.getCompetitors().get(i);
                currentHorse.setPosition(currentHorse.getPosition() + (int) (Math.random() * 10));

                System.out.print("Horse " + (i + 1) + " " + currentHorse.getBreed() +
                        ": " + currentHorse.getPosition() + " ------ ");
                if (currentHorse.getPosition() >= 100) {
                    winner = currentHorse;
                    flag = false;
                    break;
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(winner + " IS WINNER");
        return winner;
    }

    private int getNumberOfCompetitors() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many horses will be in race? Please write number from 2 to 5.");
        int number = scanner.nextInt();
        if (number < 2 || number > 5) {
            throw new IllegalArgumentException("Incorrect number. Please start application again");
        }
        return number;
    }

    private Horse getBetFromCustomer(int number, Race race) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose your horse (make a bet). You can write value 1 to " + number);
        for (int i = 0; i < number; i++) {
            System.out.println(race.getCompetitors().get(i) + " ---> WRITE " + (i + 1));
        }
        Horse bet = null;
        int input = scanner.nextInt();
        if (input >= 1 && input <= number) {
            bet = race.getCompetitors().get(input - 1);
        } else {
            throw new IllegalArgumentException("Incorrect number. Please start application again");
        }
        return bet;
    }

    private void printResultOfBet(Horse bet, Horse winner) {
        if (winner == bet) {
            System.out.println("Congratulations! Your bet is WON!");
        } else {
            System.out.println("Your bet is lost");
        }
    }
}
