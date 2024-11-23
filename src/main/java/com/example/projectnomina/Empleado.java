package com.example.projectnomina;
import com.google.gson.annotations.Expose;

public class Empleado {
    @Expose
    private String codigo;
    @Expose
    private String nombre;
    @Expose
    private String departamento;
    @Expose
    private String puesto;
    @Expose
    private String cedula;
    @Expose
    private String comisiones;
    @Expose
    private String salario;

    public Empleado(String codigo, String nombre, String departamento, String puesto, String cedula, String comisiones, String salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
        this.puesto = puesto;
        this.cedula = cedula;
        this.comisiones = comisiones;
        this.salario = salario;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getComisiones() {
        return comisiones;
    }

    public void setComisiones(String comisiones) {
        this.comisiones = comisiones;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
}
