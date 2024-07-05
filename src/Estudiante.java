public class Estudiante extends Persona {

    private String estado;

    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, String estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    public String getNombre() {
        return Nombre; // Accede al atributo Nombre de la clase Persona
    }

    public String getEstado() {
        return estado;
    }
}

