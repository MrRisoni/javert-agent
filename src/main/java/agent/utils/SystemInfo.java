package agent.utils;

import agent.system.Kernel;

import java.io.BufferedReader;

public class SystemInfo {


    public static Kernel kernelData() {
        Kernel kern = new Kernel();

        try {
            String dfOut;

            BufferedReader br = Utilities.runLinuxCommand("uname -r");

            while ((dfOut = br.readLine()) != null) {
                System.out.println("line: " + dfOut);
                kern.setVersion(dfOut);
            }

             br = Utilities.runLinuxCommand("uname -v");

            while ((dfOut = br.readLine()) != null) {
                System.out.println("line: " + dfOut);
                kern.setCreated(dfOut);
            }

            Utilities.terminateCommand();
            return kern;

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return kern;

        }
    }
}
