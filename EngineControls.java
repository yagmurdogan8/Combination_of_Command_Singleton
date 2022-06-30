public class EngineControls implements CommandController{
    private Engine engine;

    static final String SPEED_UP ="SPEED_UP";
    static final String SLOW_DOWN ="SLOW_DOWN";

    EngineControls(){
        this.engine = new Engine();
    }
    @Override
    public void execute(String command) {
        switch (command) {
            case SPEED_UP:
                engine.speedUP();
                break;
            case SLOW_DOWN:
                engine.slowDOWN();
                break;
            default:
                System.out.println("Sorry I did not understand the command");
                break;
        }
    }
    @Override
    public boolean canHandle(String command) {
        return SPEED_UP.equals(command) ||
                SLOW_DOWN.equals(command);
    }

}