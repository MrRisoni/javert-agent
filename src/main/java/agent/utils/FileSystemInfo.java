package agent.utils;

import agent.disk.Partition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileSystemInfo {


    public static ArrayList<Partition> getZFSList() {
        String dfOut;
        ArrayList<Partition> zfslist = new ArrayList<>();

        BufferedReader br = Utilities.runLinuxCommand("zfs list");
        try {
            while ((dfOut = br.readLine()) != null) {
                String after = dfOut.trim().replaceAll(" +", " ");
                String[] split = after.split(" ");

                System.out.println(split);

                Partition prt = new Partition(split[0], split[1], split[2], split[3], split[4]);
                zfslist.add(prt);
            }

            return zfslist;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return zfslist;

        }
    }
}
