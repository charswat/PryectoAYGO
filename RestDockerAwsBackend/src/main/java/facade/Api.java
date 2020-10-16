package facade;

import static spark.Spark.post;
import business.ConexionServicios;
import com.google.gson.Gson;
import dtos.Usuarios;


public class Api {
    public static ConexionServicios Service = new ConexionServicios();

    public static void main(String[] args){

        Gson gson = new Gson();

        post("/add", (req, res) -> {
            res.type("application/json");
            Usuarios usuarios = gson.fromJson(req.body(), Usuarios.class);
            return Service.addUsuarios(usuarios);
        }, gson ::toJson);

    }
}
