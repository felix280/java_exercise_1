import java.util.Scanner;
public class Quit implements Command {
    @Override
    public String name() {
        String quit = "quit";
                return quit;
    }
    public boolean run(Scanner scanner){
        return false;
    }


}