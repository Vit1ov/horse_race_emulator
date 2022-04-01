import configs.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.EmulationService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        EmulationService emulationService = context.getBean(EmulationService.class);
        context.close();

        emulationService.startHorseRace();

    }
}
