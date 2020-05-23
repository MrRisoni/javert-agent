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
        return SystemInfo.getMemoryInfo();
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


    @GetMapping("/neofetch")
    public NeoFetchResponse neofetch()
    {
        try {
          return SystemInfo.neofetch();
        }
        catch (Exception ex){
            return null;
        }
    }
}
