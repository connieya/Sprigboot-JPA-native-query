package com.nlobby.usage.web;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@RestController
public class MapController {

    @CrossOrigin
    @GetMapping("/api/map/{address}")
    public JSONObject 위도와경도추출(@PathVariable String address) throws IOException {

        System.out.println("address : " + address);

        String addr = URLEncoder.encode(address,"UTF-8");
        String nverApi = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query"+addr;

        URL url = new URL(nverApi);
        HttpURLConnection conn  = (HttpURLConnection) url.openConnection();

        String client_id = "po0v5t31yt";
        String client_secret = "HJOhVIE8SRGzxyPHOydT3EthxAeo3yCykBu69S8Z";

        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID",client_id);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);

        BufferedReader br;
        int responseCOde = conn.getResponseCode();
        if (responseCOde == 200){
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            System.out.println("responseCode = " + responseCOde);
        }else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String line;
        StringBuffer response = new StringBuffer();
        while ((line = br.readLine()) != null){
            response.append(line);
        }

        br.close();
        System.out.println("response : " + response);

        JSONTokener tokener = new JSONTokener(response.toString());
        JSONObject object = new JSONObject(tokener);


        JSONArray array = object.getJSONArray("addresses");

        for (int i=0; i< array.length(); i++) {
            JSONObject temp = (JSONObject) array.get(i);

            return temp;
        }

        return null;
    }
}
