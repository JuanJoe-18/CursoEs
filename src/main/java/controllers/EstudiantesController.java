package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Curso;
import model.Estudiante;

public class EstudiantesController {

    @FXML
    private TableView<Estudiante> tableViewEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colApellido;

    @FXML
    private TableColumn<Estudiante, String> colCarrera;

    @FXML
    private TableColumn<Estudiante, String> colGenero;

    @FXML
    private TableColumn<Estudiante, Integer> colEdad;

    @FXML
    private TableColumn<Estudiante, String> colSemestre;

    @FXML
    private TableColumn<Estudiante, String> colFechaIngreso;

    private Curso curso;

    public void setCurso(Curso curso) {
        this.curso = curso;
        cargarEstudiantes();
    }

    @FXML
    void initialize() {
        // Configurar columnas
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colApellido.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getApellido()));
        colCarrera.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCarrera()));
        colGenero.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGenero()));
        colEdad.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEdad()).asObject());
        colSemestre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSemestre()));
        colFechaIngreso.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFechaIngreso()));
    }

    private void cargarEstudiantes() {
        if (curso != null) {
            tableViewEstudiantes.setItems(FXCollections.observableArrayList(curso.getEstudiantes()));
        }
    }
}