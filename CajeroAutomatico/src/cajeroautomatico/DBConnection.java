/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

import cajeroautomatico.modelo.Cuenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class DBConnection {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:db;create=true";

    Connection conn;

    private DBConnection() {
        try {
            this.conn = DriverManager.getConnection(JDBC_URL);
            if (this.conn != null) {
                System.out.println("Conectado a la base de datos");
                this.init();
                this.printAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBConnection getInstance() {
        return DBConnectionHolder.INSTANCE;
    }
    
    private static class DBConnectionHolder {
        private static final DBConnection INSTANCE = new DBConnection();
    }

    public void init() {
        try {
            conn.createStatement().execute("Create TABLE Cuenta(Numero VARCHAR(250), NombrePropietario varchar(250), Saldo DOUBLE)");
        } catch (SQLException ex) { }
    }

    public void insertarCuenta(Cuenta cuenta) {
        try {
            conn.createStatement().execute("INSERT INTO Cuenta Values ('"
                    + cuenta.getNumero() + "', '"
                    + cuenta.getNombrePropietario() + "', "
                    + cuenta.getSaldo() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printAll() {
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Cuenta");
            while (result.next()) {
                System.out.println(result.getString("Numero") + ", " 
                        + result.getString("NombrePropietario") 
                        + ", " + result.getString("Saldo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cuenta getCuenta(String numeroCuenta) {
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Cuenta WHERE Numero = '" + numeroCuenta + "'");
            while (result.next()) {
                String nombrePropietario = result.getString("NombrePropietario");
                Double saldo = result.getDouble("Saldo");
                return new Cuenta(numeroCuenta, nombrePropietario, saldo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean existe(String numeroCuenta) {
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Cuenta WHERE Numero='" + numeroCuenta + "'");
            while (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void cerrarCuenta(String numeroCuenta) {
        try {
            conn.createStatement().execute("DELETE FROM Cuenta WHERE Numero='" + numeroCuenta + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depositar(String numeroCuenta, double cantidad) {
        try {
            conn.createStatement().execute("UPDATE Cuenta SET Saldo = Saldo + " + cantidad + " WHERE Numero='" + numeroCuenta + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void retirar(String numeroCuenta, double cantidad) {
        try {
            conn.createStatement().execute("UPDATE Cuenta SET Saldo = Saldo - " + cantidad + " WHERE Numero='" + numeroCuenta + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void transferir(String numeroCuentaOrigen, String numeroCuentaDestino, double cantidad) {
        this.retirar(numeroCuentaOrigen, cantidad);
        this.depositar(numeroCuentaDestino, cantidad);
    }
}
