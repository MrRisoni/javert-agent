package agent.rest;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import agent.disk.Partition;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import agent.system.Kernel;
import agent.utils.FileSystemInfo;
import agent.utils.SystemInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Skedul {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /*  @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println(dateFormat.format(new Date()));
    }


   @Scheduled(fixedRate = 5000)
    public void anotherRerouse() {
        Kernel kern = SystemInfo.kernelData();

        try {
            System.out.println(kern);


            HttpPost postRequest = new HttpPost("http://localhost:3500/api/zfs/list");
            Gson gson = new Gson();
            DefaultHttpClient httpClient = new DefaultHttpClient();
            StringEntity input = new StringEntity(gson.toJson(kern));
            System.out.println("GSON TO KRN");
            System.out.println(gson.toJson(kern));

            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);



        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
*/
    @Scheduled(fixedRate = 5000)
    public void anotherRerouse() {
        ArrayList<Partition> zfsl = FileSystemInfo.getZFSList();

        try {
            System.out.println(zfsl);
            HttpPost postRequest = new HttpPost("https://iaveris-api.herokuapp.com/api/zfs/list");
            Gson gson = new Gson();
            DefaultHttpClient httpClient = new DefaultHttpClient();
            StringEntity input = new StringEntity(gson.toJson(zfsl));
            System.out.println("GSON TO KRN");
            System.out.println(gson.toJson(zfsl));

            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);



        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
