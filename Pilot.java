class Pilot {

    private static Pilot uniqueInstance;

    private Pilot() {

    }

    public void init(Cockpit cockpit) {
        this.cockpit=cockpit;
    }

    public static Pilot getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Pilot();
        }
        return uniqueInstance;
    }

    private Cockpit cockpit;

    private String[] commands = {
            Cockpit.TAKE_OFF,
            EngineControls.SPEED_UP,
            WingControls.LEFT,
            Cockpit.REACH_ALTITUDE,
            WingControls.UP,
            WingControls.RIGHT,
            WingControls.FLAT,
            WingControls.DOWN,
            EngineControls.SLOW_DOWN,
            Cockpit.LAND,
            Cockpit.EXIT
    };

   /*  Pilot(Cockpit cockpit){
        this.cockpit = cockpit;
    }*/

    void fly(){
        System.out.println("");
        for(int i = 0; i <= commands.length; i ++){
            cockpit.execute(commands[i]);
            if(i != 9){
                System.out.println("--------------");
            }
            else {
                System.out.println("\nEND OF THE FLIGHT!");
            }
        }

    }

}