package bussiness;

import Dao.CallBackend;
import bussiness.Balancing.RoundRobin;
import dtos.Usuarios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Service  {




        private String port;

        @GetMapping("/index.html")
        public String chatNow() {
            return "application is up on port : " + port;
        }
        @CrossOrigin(origins ="*")
        @PostMapping(value = "/add", consumes = "application/json",produces = "application/json")
        //@RequestMapping(value = "/add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
        public String invokeCharbook(@RequestBody Usuarios usuario){
             Usuarios user = new Usuarios();
            user.setNombre(usuario.getNombre());
            CallBackend callBackend = new CallBackend();
            return callBackend.callService(user,RoundRobin.getServer());

            }
    public static void main(String[] args) {
        SpringApplication.run(Service.class, args);
    }

        }


