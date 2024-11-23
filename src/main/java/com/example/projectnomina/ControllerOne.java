package com.example.projectnomina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;

public class ControllerOne {

    @FXML
    private TextField Codigo;

    @FXML
    private Button Editar;

    @FXML
    private TextField Monto;

    @FXML
    private TextField Ncuenta;

    @FXML
    private TextField Referencia;

    @FXML
    private Button buscar;

    @FXML
    private TextField concepto;

    @FXML
    private Button guardar;

    @FXML
    private TextField nombre;

    private String bancoSeleccionado;

    public void setBancoSeleccionado(String bancoSeleccionado) {
        this.bancoSeleccionado = bancoSeleccionado;
    }

    @FXML
    void onActionBuscar(ActionEvent event) {
        String nombreBuscado = nombre.getText().trim();
        File archivo = new File("Banco", getArchivoBanco());

        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                boolean encontrado = false;

                while ((linea = reader.readLine()) != null) {
                    if (linea.toLowerCase().contains("nombreempleado: " + nombreBuscado.toLowerCase())) {
                        String[] datos = linea.split(", ");
                        for (String dato : datos) {
                            String[] partes = dato.split(": ");
                            if (partes.length == 2) {
                                switch (partes[0].trim()) {
                                    case "Codigo":
                                        Codigo.setText(partes[1].trim());
                                        break;
                                    case "Monto":
                                        Monto.setText(partes[1].trim());
                                        break;
                                    case "NCuenta":
                                        Ncuenta.setText(partes[1].trim());
                                        break;
                                    case "Referencia":
                                        Referencia.setText(partes[1].trim());
                                        break;
                                    case "Concepto":
                                        concepto.setText(partes[1].trim());
                                        break;
                                    case "NombreEmpleado":
                                        nombre.setText(partes[1].trim());
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Empleado no encontrado.");
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    @FXML
    void onActionEditar(ActionEvent event) {
        String nombreEmpleado = nombre.getText();
        File archivo = new File("Banco", getArchivoBanco());

        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                boolean encontrado = false;
                StringBuilder contenidoNuevo = new StringBuilder();

                while ((linea = reader.readLine()) != null) {
                    if (linea.contains(nombreEmpleado)) {
                        linea = "Codigo: " + Codigo.getText() + ", Monto: " + Monto.getText() +
                                ", NCuenta: " + Ncuenta.getText() + ", Nombre: " + nombreEmpleado +
                                ", Concepto: " + concepto.getText() + ", Referencia: " + Referencia.getText();
                        encontrado = true;
                    }
                    contenidoNuevo.append(linea).append("\n");
                }

                if (encontrado) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                        writer.write(contenidoNuevo.toString());
                        System.out.println("Registro editado correctamente.");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error al guardar los cambios.");
                    }
                } else {
                    System.out.println("Empleado no encontrado.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el archivo.");
            }
        } else {
            System.out.println("Archivo no encontrado.");
        }
    }

    @FXML
    void onactionGuardar(ActionEvent event) {
        File directorio = new File("Banco");
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        File archivo = new File(directorio, getArchivoBanco());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String ncuenta = Ncuenta.getText();
            String monto = Monto.getText();
            String referencia = Referencia.getText();
            String nombreEmpleado = nombre.getText();
            String conceptoVal = concepto.getText();
            String codigoVal = Codigo.getText();

            writer.write("Codigo: " + codigoVal + ", Monto: " + monto + ", NCuenta: " + ncuenta +
                    ", Nombre: " + nombreEmpleado + ", Concepto: " + conceptoVal + ", Referencia: "+referencia);
            writer.newLine();

            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getArchivoBanco() {
        switch (bancoSeleccionado) {
            case "BHD":
                return "BHD.txt";
            case "Banreserva":
                return "Banreserva.txt";
            default:
                throw new IllegalStateException("Unexpected value: " + bancoSeleccionado);
        }
    }

    @FXML
    void onActionCodigo(ActionEvent event) {
        String codigo = Codigo.getText();
    }

    @FXML
    void onActionConcepto(ActionEvent event) {
        String Concepto = concepto.getText();
    }

    @FXML
    void onActionMonto(ActionEvent event) {
        String monto = Monto.getText();
    }

    @FXML
    void onActionNcuenta(ActionEvent event) {
        String cuenta = Ncuenta.getText();
    }

    @FXML
    void onActionNombre(ActionEvent event) {
        String Nombre = nombre.getText();
    }

    @FXML
    void onActionReferencia(ActionEvent event) {
        String referencia = Referencia.getText();
    }
}
