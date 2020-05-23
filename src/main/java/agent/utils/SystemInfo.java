package agent.utils;

import agent.system.Kernel;
import agent.system.Memory;
import agent.system.NeoFetchResponse;
import agent.system.SysProc;

import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SystemInfo {


    public static ArrayList<Memory> getMemoryInfo()
    {
        ArrayList<Memory> memList = new ArrayList<>();

        try  {
            String dfOut;
            BufferedReader br = Utilities.runLinuxCommand("free -m");
            int lineId =0;
            while ((dfOut = br.readLine()) != null) {
                if (lineId>0) {
                    System.out.println("line: " + dfOut);
                    String after = dfOut.trim().replaceAll(" +", " ");
                    String[] split = after.split(" ");
                    Memory mry = new Memory();
                    mry.setName(split[0].replace(":",""));
                    mry.setTotal(Integer.parseInt(split[1]));
                    mry.setUsed(Integer.parseInt(split[2]));
                    memList.add(mry);
                }
                lineId++; // skip text output
            }
            return memList;
        }
        catch (Exception e){
            e.printStackTrace();
            return memList;
        }
    }

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

    public static String getOsName() {
        String os ="";
        try {
            String dfOut;
            BufferedReader br = Utilities.runLinuxCommand("lsb_release -a | grep Description");
            while ((dfOut = br.readLine()) != null) {
                os = dfOut;//.replace("Description:","");
            }
            return os;
        } catch (Exception ex) {
            return os;
        }

    }

    public static String getUptime()
    {
        String up ="";
        try {
            String dfOut;
            BufferedReader br = Utilities.runLinuxCommand("uptime -p");
            while ((dfOut = br.readLine()) != null) {
                up = dfOut;//.replace("Description:","");
            }
            return up;
        }catch (Exception ex) {
            return up;
        }
    }

    public static String getCPUModel()
    {
        String mdl ="";
        try {
            String dfOut;
            BufferedReader br = Utilities.runLinuxCommand("cat /proc/cpuinfo | grep 'model name' | uniq");
            while ((dfOut = br.readLine()) != null) {
                System.out.println("CPU MODEL " + dfOut);
                mdl = dfOut;
            }
            return mdl;
        }catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public static NeoFetchResponse neofetch() {
        NeoFetchResponse nf = new NeoFetchResponse();
        nf.setHostName(Utilities.getHostName());
        nf.setOs(getOsName());
        Kernel k = kernelData();
        nf.setKernel(k.toString());
        nf.setCpu(getCPUModel());
        nf.setUptime(getUptime());
        Memory m = getMemoryInfo().get(0);
        nf.setMemory(m.getUsed()+"/" + m.getTotal());

        return nf;
    }
}
