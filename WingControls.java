public class WingControls implements CommandController{
    private Wings wings;

    static final String UP = "Upwards";
    static final String DOWN = "Downwards";
    static final String FLAT = "Flat";
    static final String LEFT = "Turn Left";
    static final String RIGHT = "Turn Right";

    WingControls() {
        this.wings = new Wings();
    }
    @Override
    public void execute(String command) {
        switch (command) {
            case UP:
                wings.upwards();
                break;
            case DOWN:
                wings.downwards();
                break;
            case FLAT:
                wings.flat();
                break;
            case RIGHT:
                wings.right();
                break;
            case LEFT:
                wings.left();
                break;
        }
    }
    @Override
    public boolean canHandle(String command) {

        return command.equals(FLAT) ||
                command.equals(DOWN) ||
                command.equals(UP) ||
                command.equals(LEFT) ||
                command.equals(RIGHT);
    }

}