package dtos;

import java.io.Serializable;
import java.util.List;

public class ListUsers implements Serializable {
    List<Usuarios> usuariosList;

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }
}
