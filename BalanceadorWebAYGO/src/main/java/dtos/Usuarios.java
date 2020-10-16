package dtos;



import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Usuarios implements Serializable {


    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_cracion=" + fecha_cracion +
                '}';
    }

    private  String nombre;
    private  String apellido;
    private Date fecha_cracion;

    public Date getFecha_cracion() {
        return fecha_cracion;
    }

    public void setFecha_cracion(Date fecha_cracion) {
        this.fecha_cracion = fecha_cracion;
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
