/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao;

import com.cours.ebenus.utils.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ElHadji
 */
public class DriverManagerSingleton {

    Connection connection = null;

    private static final Log log = LogFactory.getLog(DriverManagerSingleton.class);

    public final static String className = DriverManagerSingleton.class.getName();
    // Url de connexion en base de donnée
    private static final String url = Constants.DATABASE_URL;

    // Utilisateur de la base de données
    private static final String user = Constants.DATABASE_USER;

    // Mot de passe de la base de données
    private static final String password = Constants.DATABASE_PASSWORD;

    // Drivers Jdbc
    private static final String jdbcDriver = Constants.JDBC_DRIVER;

    /** private constructor **/
    private DriverManagerSingleton() {}

    private static class DriverManagerSingletonHolder {
        private final static DriverManagerSingleton INSTANCE = new DriverManagerSingleton();
    }

    /** get instance unique **/
    public static DriverManagerSingleton getInstance() {
        return DriverManagerSingletonHolder.INSTANCE;
    }

    /** gestion de l'instance de connection a la db **/
    private static class ConnectionInstanceHolder {
        private static Connection INSTANCE;

        static {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                INSTANCE = DriverManager.getConnection(url, user, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnectionInstance() {
        return ConnectionInstanceHolder.INSTANCE;
    }
}
