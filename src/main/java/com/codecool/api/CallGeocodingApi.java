package com.codecool.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class CallGeocodingApi {

    public static Map<String, Double> getCoordinates(String address) throws JSONException {

        Map<String, Double> coordinates = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        String geocodingResourceUrl = "https://api.opencagedata.com/geocode/v1/json?q=" +
             address +
            "&key=62619016a8b448b290c76150ccc9893d&language=pl&pretty=1";
        ResponseEntity<String> response
                = restTemplate.getForEntity(geocodingResourceUrl, String.class);
        JSONObject jsonObject = new JSONObject(response.getBody());
        coordinates.put("lat", jsonObject.getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("geometry")
                .getDouble("lat"));
        coordinates.put("lng", jsonObject.getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("geometry")
                .getDouble("lng"));
        return coordinates;
    }
}