package model;

import javafx.scene.image.Image;

public class Estudiante {
    //nombre apellido edad genero carrera semestre fecha ingreso foto
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String carrera;
    private String semestre;
    private String fechaIngreso;
    private Image imagen;

    public Estudiante(String nombre, String apellido, int edad, String genero, String carrera, String semestre, String fechaIngreso, Image imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.carrera = carrera;
        this.semestre = semestre;
        this.fechaIngreso = fechaIngreso;
        this.imagen = imagen;
    }

    public Estudiante() {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre='" + semestre + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
