package persona.dto;

public class PersonaDTO {
    
    private int id;
    private String nombre;
    private String apellido;
    
    public PersonaDTO(){ }

    public PersonaDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "PersonaDTO{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
}
