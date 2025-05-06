package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.util.Arrays;


public class RegisterController {
    private Curso curso;
    @FXML
    private ComboBox<String> comboBoxCarrera;

    @FXML
    private ComboBox<String> comboBoxGenero;

    @FXML
    private ComboBox<String> comboBoxSemestre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtFechaIngreso;

    @FXML
    private TextField txtFoto;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize() { //Metodo especial de JavaFX que se ejecuta al iniciar la vista//Llenar los comboBox con los datos necesarios
        curso = new Curso("Algoritmos II", "1101", "208-C");
        comboBoxGenero.getItems().addAll(
                Arrays.stream(typeGenero.values()).map(Enum::name).toList()
        );
        comboBoxCarrera.getItems().addAll(
                Arrays.stream(typeCarrera.values()).map(Enum::name).toList()
        );
        comboBoxSemestre.getItems().addAll(
                Arrays.stream(typeSemestre.values()).map(Enum::name).toList()
        );
    }

    @FXML
    void buscarFoto(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar foto");

        //por tipos de archios
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg", "*.jpeg"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );

        File file = fc.showOpenDialog(null);
        if (file != null) {
            txtFoto.setText(file.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo");
        }


    }

    private EstudiantesController estCtrl;

    @FXML
    void matricularEstudiante(ActionEvent event) {
        Estudiante estudiante = new Estudiante(); // QUitar el new Estudiante() y usar el ptron Singleton
        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setCarrera(comboBoxCarrera.getValue().toString());
        estudiante.setGenero(comboBoxGenero.getValue().toString());
        estudiante.setEdad(Integer.parseInt(txtEdad.getText()));
        estudiante.setSemestre(comboBoxSemestre.getValue().toString());
        estudiante.setFechaIngreso(txtFechaIngreso.getText());
        estudiante.setImagen(new javafx.scene.image.Image("file:" + txtFoto.getText()));
        curso.addEstudiante(estudiante);
        if (estCtrl != null) {
            estCtrl.setCurso(curso);
        }
    }

    @FXML
    void verEstudiantes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EstudiantesView.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista de estudiantes
            estCtrl = loader.getController();
            estCtrl.setCurso(curso);

            // Mostrar la nueva vista
            Stage stage = new Stage();
            stage.setTitle("Listado de Estudiantes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
