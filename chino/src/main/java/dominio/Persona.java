package dominio;

public class Persona {

    private int idPersona;
    private String nombre;
    private String apellido;
    private String direccion;

<<<<<<< HEAD
    //CONSTRUCTOR QUE SIRVE PARA EL SELECT
=======
>>>>>>> 724a550d7677c789c75d2a99d94195c930266440
    public Persona(int idPersona, String nombre, String apellido, String direccion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

<<<<<<< HEAD
    //CONSTRUCTOR QUE SIRVE PARA EL INSERT
    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

=======
>>>>>>> 724a550d7677c789c75d2a99d94195c930266440
    public int getIdPersona() {
        return idPersona;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion;
    }
}
