public interface CommandController{

    void execute(String command);
    boolean canHandle(String command);

}