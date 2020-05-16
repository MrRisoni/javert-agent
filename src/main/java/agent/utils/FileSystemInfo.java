package agent.utils;

import agent.disk.Partition;
import agent.disk.ZPool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileSystemInfo {

    public static ArrayList<ZPool> getZpoolStatus() {
        String dfOut;
        ArrayList<ZPool> pool = new ArrayList<>();

        BufferedReader br = Utilities.runLinuxCommand("zpool status");
        int foundName = 0;
        int foundBlankLine = 0;
        int readNewLine= 0;
        try {
            while ((dfOut = br.readLine()) != null) {

                if (foundBlankLine == 0) {
                    String after = dfOut.trim().replaceAll(" +", " ");
                    if (after.contains("NAME STATE")) {
                        foundName = 1;
                    }
                    if (foundName == 1 && readNewLine == 1) {
                        System.out.println(after);
                         String[] split = after.split(" ");
                        pool.add(new ZPool(split[0],split[1]));

                        if (after.length() < 1) {
                            foundBlankLine = 1;
                        }
                    }
                    if (foundName == 1 && readNewLine == 0) {
                        readNewLine = 1;
                    }
                }
            }

            return pool;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return pool;

        }
    }

    public static ArrayList<Partition> getZFSList() {
        String dfOut;
        ArrayList<Partition> zfslist = new ArrayList<>();

        BufferedReader br = Utilities.runLinuxCommand("zfs list");
        int lineCount = 0;
        try {
            while ((dfOut = br.readLine()) != null) {
                // skip NAME                   USED  AVAIL  REFER  MOUNTPOINT
                if (lineCount > 0) {
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
