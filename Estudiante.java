
package archivoestudiantes;
import java.io.Serializable;
import java.util.Date;

public class Estudiante implements Serializable, Comparable<Estudiante> {
    public final long serialVersionUID= 1L;
    private String nombre;
    private String apellido;
    private int ci;
    private Date fechaNac;

    public Estudiante() {
        nombre="Carlos";
        apellido= "Robles";
        ci=70707070;
    }
    public Estudiante(String nombre, String apellido, int ci, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.fechaNac = fechaNac;
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

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return String.format("Estudiante: %s %s, con CI: %dy fecha de nacimiento: %s", nombre, apellido, ci, fechaNac);
    }

    @Override
    public int compareTo(Estudiante x) {
        return Integer.compare(this.ci, x.ci);
    }
}

