import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        WingControls wingControls = new WingControls();
        EngineControls engineControls = new EngineControls();
        List<CommandController> commandControllers = new ArrayList<>();
        commandControllers.add(wingControls);
        commandControllers.add(engineControls);
        Cockpit cockpit = new Cockpit(commandControllers);

        Pilot pilot = Pilot.getInstance();
        pilot.init(cockpit);
        pilot.fly();

    }
}
