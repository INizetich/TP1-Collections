package Models;

public class Contacto {
    private String nombre;
    private String apellido;
    private String nroTelefono;

    public Contacto(String nombre, String apellido, String nroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroTelefono = nroTelefono;
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

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getNombreCompleto(){
        return getNombre().concat(getApellido());
    }

    @Override
    public String toString() {
        return "-------------------" + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Teléfono: " + nroTelefono + '\n' +
                "-------------------";
    }
}
