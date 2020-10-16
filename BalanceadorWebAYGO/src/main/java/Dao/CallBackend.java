package Dao;

import dtos.Usuarios;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class CallBackend {
    public String callService(Usuarios usuarios,String adress)  {
        Gson gson = new Gson();
        System.out.println("Response ="+adress);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = gson.toJson(usuarios);
        System.out.println("Request JSON ="+requestJson);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.exchange(adress, HttpMethod.POST, entity, String.class);
        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
        System.out.println("Response ="+response.getBody());
        return response.getBody();

    }

}
