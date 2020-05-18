package agent.system;

import agent.utils.SystemInfo;
import agent.utils.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

@RestController
public class SysController {

    @GetMapping("/memory")
    public ArrayList<Memory> getMemoryInfo()
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

    @GetMapping("/sysproc")
    public SysProcResponse systemProcess() {

        try {
            SysProcResponse procrsp = new SysProcResponse();
            procrsp.setHostName(Utilities.getHostName());
            procrsp.setSysproclist(SystemInfo.getSystemProccesses());
            return procrsp;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return null;

        }
    }


    @GetMapping("/kernel")
    public Kernel kernelData() {

        try {
            return SystemInfo.kernelData();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return null;

        }
    }
}
