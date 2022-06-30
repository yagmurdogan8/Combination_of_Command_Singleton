import java.util.List;

public class Cockpit implements CommandController{
    private List<CommandController> commandControls;

    Cockpit(List<CommandController> commandControls){
        commandControls.add(this);
        this.commandControls = commandControls;
    }

    static final String TAKE_OFF = "TAKE_OFF";
    static final String LAND = "LAND";
    static final String REACH_ALTITUDE = "REACH_ALTITUDE";
    static final String EXIT = "EXIT";

    @Override
    public void execute(String command) {
        for (CommandController commandController : this.commandControls) {
            if (commandController instanceof Cockpit) {
                switch (command) {
                    case Cockpit.TAKE_OFF:
                        this.takeOff();
                        break;
                    case Cockpit.LAND:
                        this.land();
                        break;
                    case Cockpit.REACH_ALTITUDE:
                        this.reachAltitudeAndFly();
                        break;
                    case Cockpit.EXIT:
                        System.exit(1);
                }
            } else if (commandController.canHandle(command)) {
                commandController.execute(command);
            }
        }
    }


    @Override
    public boolean canHandle(String command) {
        return TAKE_OFF.equals(command) || LAND.equals(command) ||
                REACH_ALTITUDE.equals(command) || EXIT.equals(command);
    }



    private void takeOff(){
        System.out.println("Flight Take Off operations");
        this.execute(EngineControls.SPEED_UP);
        this.execute(WingControls.UP);
    }

    private void reachAltitudeAndFly(){
        System.out.println("Flying at an altitude");
        this.execute(EngineControls.SPEED_UP);
        this.execute(WingControls.FLAT);
    }

    private void land(){
        System.out.println("Landing the Plane");
        this.execute(EngineControls.SLOW_DOWN);
        this.execute(WingControls.DOWN);
    }


}