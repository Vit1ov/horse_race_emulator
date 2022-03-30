import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.EmulationService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        EmulationService emulationService = context.getBean(EmulationService.class);
        context.close();

        emulationService.startHorseRace();

    }
}
