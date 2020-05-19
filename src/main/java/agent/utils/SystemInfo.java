package agent.utils;

import agent.system.Kernel;
import agent.system.SysProc;

import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SystemInfo {

    public static ArrayList<SysProc> getSystemProccesses()
    {
        ArrayList<SysProc> sysprocs = new ArrayList<>();
        try {
            String dfOut;

            BufferedReader br = Utilities.runLinuxCommand("ps aux");
            System.out.println("print ps aux");
            int headers = 0;

            DecimalFormat decimals = new DecimalFormat("0.00");


            while ((dfOut = br.readLine()) != null) {
                if (headers >0) {
                    System.out.println(dfOut);
                    String after = dfOut.trim().replaceAll(" +", " ");
                    String[] split = after.split(" ");
                    System.out.println(split);

                    SysProc proc = new SysProc();
                    proc.setUser(split[0]);
                    proc.setPid(Integer.parseInt(split[1]));
                    proc.setCpu(split[2]);
                    proc.setMem(split[3]);
                    proc.setCommand(split[10]);

                    sysprocs.add(proc);
                }
                headers++;
            }
            return sysprocs;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return sysprocs;
        }
    }

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
