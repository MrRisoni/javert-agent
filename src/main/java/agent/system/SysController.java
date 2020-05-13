package agent.system;

import agent.disk.Partition;
import agent.utils.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/kernel")
    public Kernel kernelData() {
        Kernel kern = new Kernel();

        try {
            String dfOut;
            Process p;
            BufferedReader br = Utilities.runLinuxCommand("uname -r");

            while ((dfOut = br.readLine()) != null) {
                System.out.println("line: " + dfOut);
                kern.setVersion(dfOut);
            }
            Utilities.terminateCommand();

            p = Runtime.getRuntime().exec("uname -v");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((dfOut = br.readLine()) != null) {
                System.out.println("line: " + dfOut);
                kern.setCreated(dfOut);
            }
            p.waitFor();
            p.destroy();

            return kern;

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return kern;

        }
    }
}
