package dtos;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.NotSaved;

import java.util.Date;

@Entity
public class Usuarios {
    @Id
    private ObjectId id;
    private  String nombre;
    private  String apellido;
    private Date fecha_cracion;

    public Date getFecha_cracion() {
        return fecha_cracion;
    }

    public void setFecha_cracion(Date fecha_cracion) {
        this.fecha_cracion = fecha_cracion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
