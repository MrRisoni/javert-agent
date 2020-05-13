package agent.disk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

@RestController
public class DiskController {


    @GetMapping("/partitions")
    public ArrayList<Partition> partitions() {

        ArrayList<Partition> partitions = new ArrayList<>();


        try {
            String dfOut;
            Process p;
            p = Runtime.getRuntime().exec("df -h");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((dfOut = br.readLine()) != null) {
                System.out.println("---------------");
                System.out.println("line: " + dfOut);
                String after = dfOut.trim().replaceAll(" +", " ");
                String[] split = after.split(" ");

                System.out.println(split);
                System.out.println(split[3]);
                System.out.println(split.length);

                Partition prt = new Partition(split[0], split[1], split[2], split[3], split[4]);
                partitions.add(prt);
            }
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();

            partitions.remove(0);
            return partitions;

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return partitions;

        }


    }

}
