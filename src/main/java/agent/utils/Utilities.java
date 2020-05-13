package agent.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utilities {

    private static Process p;

    public static BufferedReader runLinuxCommand(String cmd) {

        try {

            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            return br;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void terminateCommand() throws InterruptedException {
        p.waitFor();
        p.destroy();
    }
}
