package agent.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

public class Utilities {

    private static Process p;
    private static String hostName = "";

    public static String getHostName()
    {
        try {
            if (hostName == "") {
                Yaml yaml = new Yaml();
// hostname=5ebfbfba062e17088cd76417
                InputStream is = new FileInputStream("/etc/javert.d/javert.yml");
                BufferedReader buf = new BufferedReader(new InputStreamReader(is));

                String line = buf.readLine();
                StringBuilder sb = new StringBuilder();

                while (line != null) {
                    sb.append(line).append("\n");
                    line = buf.readLine();
                }

                String fileAsString = sb.toString();


                Map<String, Object> obj = yaml.load(fileAsString);

                for (Map.Entry<String, Object> e : obj.entrySet()) {
                    String key    = e.getKey();
                    Object value  = e.getValue();
                    hostName = String.valueOf(value);
                }

                System.out.println(obj);
                return hostName;

            }
        }
        catch (Exception ex){
            return "";
        }
        return hostName;
    }

    public static BufferedReader runLinuxCommand(String cmd) {

        try {
            p = Runtime.getRuntime().exec(cmd);
            return new BufferedReader(new InputStreamReader(p.getInputStream()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void terminateCommand() throws InterruptedException {
        p.waitFor();
        p.destroy();
    }
}
