package model;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private String NRC;
    private String salon;
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso(String nombre, String NRC, String salon) {
        this.nombre = nombre;
        this.NRC = NRC;
        this.salon = salon;
        listaEstudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void addEstudiante(Estudiante estudiante) {
        this.listaEstudiantes.add(estudiante);
    }

    public Estudiante getEstudiantes() {
        return listaEstudiantes.get(0);
    }
}
