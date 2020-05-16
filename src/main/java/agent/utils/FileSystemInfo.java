package agent.utils;

import agent.disk.Partition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileSystemInfo {

    public static  String getZpoolStatus() {
        String dfOut;
        ArrayList<Partition> zfslist = new ArrayList<>();

        BufferedReader br = Utilities.runLinuxCommand("zpool status");
        int lineCount =0;
        try {
            while ((dfOut = br.readLine()) != null) {
                // skip NAME                   USED  AVAIL  REFER  MOUNTPOINT
                if (lineCount >0) {
                    String after = dfOut.trim().replaceAll(" +", " ");
                   // String[] split = after.split(" ");
System.out.println(after);

                }
                lineCount++;
            }

            return "Foo";
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return "Foo";

        }
    }

    public static ArrayList<Partition> getZFSList() {
        String dfOut;
        ArrayList<Partition> zfslist = new ArrayList<>();

        BufferedReader br = Utilities.runLinuxCommand("zfs list");
        int lineCount =0;
        try {
            while ((dfOut = br.readLine()) != null) {
                // skip NAME                   USED  AVAIL  REFER  MOUNTPOINT
                if (lineCount >0) {
                    String after = dfOut.trim().replaceAll(" +", " ");
                    String[] split = after.split(" ");

                    Partition prt = new Partition(split[0], split[1], split[2], split[3], split[4]);
                    zfslist.add(prt);
                }
                lineCount++;
            }

            return zfslist;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return zfslist;

        }
    }
}
