package commandExecutor;

import java.util.Scanner;

public class CommandExecutor {

    public void start() {
        boolean execution = true;
        Scanner console = new Scanner(System.in);

        // днаюбхрэ опедбюпхрекэмши гюосяй бяеу  менаундхлшу опнжеяянб

        while (execution) {
            String line = console.nextLine();
            execute(line);
        }
    }

    public void execute(String line) {

    }
}
