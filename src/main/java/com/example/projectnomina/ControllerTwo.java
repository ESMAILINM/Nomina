package com.example.projectnomina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.*;

public class ControllerTwo {

    @FXML
    private TextField Modena;

    @FXML
    private TextField Monto;

    @FXML
    private TextField NCuenta;

    @FXML
    private TextField NombreEmpleado;

    @FXML
    private TextField SecuenciaTrans;

    @FXML
    private TextField codigoempresa;

    @FXML
    private TextField nomEmpresa;

    @FXML
    private TextField secuencia;

    @FXML
    void OnActionBuscar(ActionEvent event) {
        String nombreBuscado = NombreEmpleado.getText();  // Buscar por el nombre del empleado ingresado
        File archivo = new File("Banco", "Popular.txt");

        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                boolean encontrado = false;
                while ((linea = reader.readLine()) != null) {
                    if (linea.contains("NombreEmpleado: " + nombreBuscado)) {
                        String[] datos = linea.split(", ");
                        for (String dato : datos) {
                            // Verifica si el dato contiene ": ", luego lo divide
                            String[] partes = dato.split(": ");
                            if (partes.length == 2) {  // Verifica si tiene dos partes
                                switch (partes[0]) {
                                    case "Moneda":
                                        Modena.setText(partes[1]);
                                        break;
                                    case "Monto":
                                        Monto.setText(partes[1]);
                                        break;
                                    case "NCuenta":
                                        NCuenta.setText(partes[1]);
                                        break;
                                    case "NombreEmpleado":
                                        NombreEmpleado.setText(partes[1]);
                                        break;
                                    case "SecuenciaTrans":
                                        SecuenciaTrans.setText(partes[1]);
                                        break;
                                    case "CodigoEmpresa":
                                        codigoempresa.setText(partes[1]);
                                        break;
                                    case "NomEmpresa":
                                        nomEmpresa.setText(partes[1]);
                                        break;
                                    case "Secuencia":
                                        secuencia.setText(partes[1]);
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                System.out.println("Error al dividir el dato: " + dato);
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
            }
        }
    }


    // Método para guardar un nuevo registro
    @FXML
    void OnActionGuardar(ActionEvent event) {
        File directorio = new File("Banco");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        File archivo = new File(directorio, "Popular.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String moneda = Modena.getText();
            String monto = Monto.getText();
            String nCuenta = NCuenta.getText();
            String nombreEmpleado = NombreEmpleado.getText();
            String secuenciaTrans = SecuenciaTrans.getText();
            String codigoEmpresa = codigoempresa.getText();
            String nomEmp = nomEmpresa.getText();
            String secuenciaVal = secuencia.getText();

            writer.write("Moneda: " + moneda + ", Monto: " + monto + ", NCuenta: " + nCuenta +
                    ", NombreEmpleado: " + nombreEmpleado + ", SecuenciaTrans: " + secuenciaTrans +
                    ", CodigoEmpresa: " + codigoEmpresa + ", NomEmpresa: " + nomEmp +
                    ", Secuencia: " + secuenciaVal);
            writer.newLine();

            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para editar un registro existente
    @FXML
    void onActionEditar(ActionEvent event) {
        String nombreEmpleado = NombreEmpleado.getText();
        File archivo = new File("Banco", "Popular.txt");

        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                boolean encontrado = false;
                StringBuilder contenidoNuevo = new StringBuilder();

                while ((linea = reader.readLine()) != null) {
                    if (linea.contains(nombreEmpleado)) {
                        // Reemplazar la línea con los nuevos valores
                        linea = "Moneda: " + Modena.getText() + ", Monto: " + Monto.getText() +
                                ", NCuenta: " + NCuenta.getText() + ", NombreEmpleado: " + NombreEmpleado.getText() +
                                ", SecuenciaTrans: " + SecuenciaTrans.getText() + ", CodigoEmpresa: " + codigoempresa.getText() +
                                ", NomEmpresa: " + nomEmpresa.getText() + ", Secuencia: " + secuencia.getText();
                        encontrado = true;
                    }
                    // Escribir la línea (modificada o no) al nuevo contenido
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

    // Métodos adicionales para manejar eventos de los campos (no se usan directamente en este código)
    @FXML
    void onActionCodigoEmpresa(ActionEvent event) {
        String codigo = codigoempresa.getText();
    }

    @FXML
    void onActionModena(ActionEvent event) {
        String moneda = Modena.getText();
    }

    @FXML
    void onActionMonto(ActionEvent event) {
        String monto = Monto.getText();
    }

    @FXML
    void onActionNCuenta(ActionEvent event) {
        String nCuenta = NCuenta.getText();
    }

    @FXML
    void onActionNomEmpresa(ActionEvent event) {
        String NomEmpresa = nomEmpresa.getText();
    }

    @FXML
    void onActionSecuencia(ActionEvent event) {
        String Secuencia = secuencia.getText();
    }

    @FXML
    void onActionSecuenciatrans(ActionEvent event) {
        String secuenciatrans = SecuenciaTrans.getText();
    }

    @FXML
    void onAntionNombreEmpleado(ActionEvent event) {
        String nombre = NombreEmpleado.getText();
    }
}
