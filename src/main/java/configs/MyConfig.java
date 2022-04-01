package configs;

import models.Breed;
import models.Horse;
import models.Rider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApp.properties")
@ComponentScan("services")
public class MyConfig {

    @Bean
    public Rider rider1() {
        final Rider rider = new Rider();
        rider.setName("Kent Farrington");
        return rider;
    }
    @Bean
    public Rider rider2() {
        final Rider rider = new Rider();
        rider.setName("McLain Ward");
        return rider;
    }
    @Bean
    public Rider rider3() {
        final Rider rider = new Rider();
        rider.setName("Adrienne Sternlicht");
        return rider;
    }
    @Bean
    public Rider rider4() {
        final Rider rider = new Rider();
        rider.setName("Margie Engle");
        return rider;
    }
    @Bean
    public Rider rider5() {
        final Rider rider = new Rider();
        rider.setName("Michael Smith");
        return rider;
    }

    @Bean
    public Horse horse1(@Value("${horse1.breed}") Breed breed) {
        final Horse horse = new Horse();
        horse.setRider(rider1());
        horse.setBreed(breed);
        return horse;
    }
    @Bean
    public Horse horse2(@Value("${horse2.breed}") Breed breed) {
        final Horse horse = new Horse();
        horse.setRider(rider2());
        horse.setBreed(breed);
        return horse;
    }
    @Bean
    public Horse horse3(@Value("${horse3.breed}") Breed breed) {
        final Horse horse = new Horse();
        horse.setRider(rider3());
        horse.setBreed(breed);
        return horse;
    }
    @Bean
    public Horse horse4(@Value("${horse4.breed}") Breed breed) {
        final Horse horse = new Horse();
        horse.setRider(rider4());
        horse.setBreed(breed);
        return horse;
    }
    @Bean
    public Horse horse5(@Value("${horse5.breed}") Breed breed) {
        final Horse horse = new Horse();
        horse.setRider(rider5());
        horse.setBreed(breed);
        return horse;
    }
}
