public class Persona {
    private String nombre;
    private String direccion;
    private String edad;

    public Persona(String nombre, String direccion, String edad) {
        if (nombre.equals("")){
            this.nombre="Desconocido";
        }else {
            this.nombre = nombre;
        }
        if (direccion.equals("")){
            this.direccion="Desconocido";
        }else {
            this.direccion = direccion;
        }
            this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return Integer.parseInt(edad);
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", direccion=" + direccion + ", edad=" + edad;
    }
}
