package com.example.projectnomina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private ComboBox<String> Select;

    private String bancoSeleccionado;

    @FXML
    public void initialize() {
        Select.getItems().addAll("Popular", "BHD", "Banreserva");
    }

    // Método para capturar el banco seleccionado y abrir la pantalla correspondiente
    @FXML
    void onActionSelect(ActionEvent event) throws IOException {
        bancoSeleccionado = Select.getValue();  // Capturamos el banco seleccionado

        // Llamamos al método para abrir la pantalla correspondiente
        abrirPantalla(bancoSeleccionado);
    }

    // Método para abrir la pantalla y pasar el banco seleccionado al siguiente controlador
    private void abrirPantalla(String bancoSeleccionado) throws IOException {
        FXMLLoader loader = null;
        String title = null;

        switch (bancoSeleccionado) {
            case "Popular":
                loader = new FXMLLoader(HelloApplication.class.getResource("PantallaPo.view.fxml"));
                title = "Banco Popular";
                break;
            case "BHD":
                loader = new FXMLLoader(HelloApplication.class.getResource("Pantallabhd.fxml"));
                title = "Banco BHD";
                break;
            case "Banreserva":
                loader = new FXMLLoader(HelloApplication.class.getResource("Pantallabhd.fxml"));
                title = "Banco Banreserva";
                break;
        }

        if (loader != null) {
            Parent root = loader.load();
            // Obtenemos el controlador de la pantalla cargada
            ControllerOne controllerOne = loader.getController();
            controllerOne.setBancoSeleccionado(bancoSeleccionado); // Le pasamos el banco seleccionado
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
