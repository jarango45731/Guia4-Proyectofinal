/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico.modelo;

/**
 *
 * @author jose
 */
public class Cuenta {
    private String numero;
    private String nombrePropietario;
    private double saldo;
    
    public Cuenta(String numero, String nombrePropietario, double saldo) {
        this.numero = numero;
        this.nombrePropietario = nombrePropietario;
        this.saldo = saldo;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the nombrePropietario
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * @param nombrePropietario the nombrePropietario to set
     */
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }
    
    public void retirar(double cantidad) {
        this.saldo -= cantidad;
    }
}
