package business;
import com.mongodb.MongoClient;
import dtos.Usuarios;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import java.util.Date;
import java.util.List;

public class ConexionServicios {


    MongoClient client = new MongoClient("databasemongo", 27017); //connect to mongodb
    Datastore datastore = new Morphia().createDatastore(client, "mydatabase1"); //select mydatabase collection
    public List<Usuarios> addUsuarios(Usuarios usuarios){
        usuarios.setFecha_cracion(new Date());
        datastore.save(usuarios);
        List<Usuarios> list = datastore.find(Usuarios.class ).order("-fecha_cracion").limit(10).asList();
        if(list != null){
            return list;
        }
        return null;
    }
}
