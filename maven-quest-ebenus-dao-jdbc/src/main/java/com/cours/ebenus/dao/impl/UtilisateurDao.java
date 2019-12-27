/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.DriverManagerSingleton;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.cours.ebenus.dao.exception.EbenusException;
import com.cours.ebenus.utils.Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static com.cours.ebenus.dao.DriverManagerSingleton.getConnectionInstance;

/**
 *
 * @author ElHadji
 */
public class UtilisateurDao /*extends AbstractDao<Utilisateur>*/ implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(UtilisateurDao.class);
    private PreparedStatement preparedStatement;
    private Connection connection = null;

    //public UtilisateurDao() {
    //    super(Utilisateur.class);
    //}

    private Utilisateur getUserFromResult(ResultSet rs, Connection connection) {
        Utilisateur newUser = new Utilisateur();
        try {
            newUser.setIdUtilisateur(rs.getInt("idUtilisateur"));
            newUser.setCivilite((rs.getString("civilite")));
            newUser.setPrenom(rs.getString("prenom"));
            newUser.setNom(rs.getString("nom"));
            newUser.setIdentifiant(rs.getString("identifiant"));
            newUser.setMotPasse(rs.getString("motPasse"));
            newUser.setDateNaissance(rs.getDate("dateNaissance"));
            newUser.setDateCreation(rs.getDate("dateCreation"));
            newUser.setDateModification(rs.getDate("dateModification"));
            newUser.setActif(rs.getBoolean("actif"));
            newUser.setMarquerEffacer(rs.getBoolean("marquerEffacer"));
            newUser.setVersion(rs.getInt("version"));

            /** a propos du role du user **/
            Integer idRole = rs.getInt("idRole");

            /** requete dans les roles pour avoir le role du user **/
            try {
                String getRoleSQL = "SELECT * FROM role WHERE idRole = " + idRole + ";";
                PreparedStatement rolepreparedStatement = connection.prepareStatement(getRoleSQL);
                //rolepreparedStatement.setInt(1, idRole);
                ResultSet rsRole = rolepreparedStatement.executeQuery(getRoleSQL);

                Role newRole = new Role();
                if (rsRole.next()) {
                    newRole.setIdRole(rsRole.getInt("idRole"));
                    newRole.setIdentifiant(rsRole.getString("identifiant"));
                    newRole.setDescription(rsRole.getString("description"));
                    newRole.setVersion(rsRole.getInt("version"));
                    /** set du role dans l'utilisateur **/
                    newUser.setRole(newRole);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        connection = getConnectionInstance();
        List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();
        String selectSQL = "SELECT * FROM utilisateur";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Utilisateur newUser = getUserFromResult(rs, connection);
                utilisateurList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurList;
    }

    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
        connection = getConnectionInstance();

        Utilisateur newUser = new Utilisateur();

        String selectSQL = "SELECT * FROM utilisateur WHERE idUtilisateur = " + idUtilisateur + ";";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            if (rs.next()) {
                newUser = getUserFromResult(rs, connection);
                if (newUser == null) {
                    return null;
                } else {
                    return newUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
        connection = getConnectionInstance();

        List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();

        String selectSQL = "SELECT * FROM utilisateur WHERE prenom = '" + prenom + "';";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Utilisateur newUser = getUserFromResult(rs, connection);
                utilisateurList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurList;
    }

    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
        connection = getConnectionInstance();

        List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();

        String selectSQL = "SELECT * FROM utilisateur WHERE nom = '" + nom + "';";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Utilisateur newUser = getUserFromResult(rs, connection);
                utilisateurList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurList;
    }

    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
        connection = getConnectionInstance();

        List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();

        String selectSQL = "SELECT * FROM utilisateur WHERE identifiant = '" + identifiant + "';";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Utilisateur newUser = getUserFromResult(rs, connection);
                utilisateurList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurList;
    }

    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {
        connection = getConnectionInstance();

        List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();

        String selectSQL = "SELECT * FROM utilisateur WHERE idRole = " + idRole + ";";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Utilisateur newUser = getUserFromResult(rs, connection);
                utilisateurList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurList;
    }

    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {
        connection = getConnectionInstance();

        Integer idRole = null;

        String selectSQL = "SELECT * FROM role WHERE identifiant = '" + identifiantRole + "';";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                idRole = rs.getInt("idRole");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Utilisateur> userList = new ArrayList<Utilisateur>();
        userList = findUtilisateursByIdRole(idRole);
        return userList;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {

        List<Utilisateur> userList = new ArrayList<Utilisateur>();
        userList = findAllUtilisateurs();

        if (userList.size() > 0) {
            for (Utilisateur userTmp : userList) {
                if (user.getIdUtilisateur() == userTmp.getIdUtilisateur()) {
                    EbenusException.UtilisateurIDAlreadyExist(user.getIdUtilisateur());
                    return null;
                }
                if (user.getIdentifiant() == userTmp.getIdentifiant()) {
                    EbenusException.UserIdentifiantAlreadyExist(user.getIdentifiant());
                    return null;
                }
            }
        }

        List<Utilisateur> userTmp = new ArrayList<Utilisateur>();
        userTmp = findUtilisateurByIdentifiant(user.getIdentifiant());
        if (userTmp.size() > 0) {
            EbenusException.UserIdentifiantAlreadyExist(user.getIdentifiant());
            return null;
        }

        connection = getConnectionInstance();

        String addSQL = "INSERT INTO utilisateur (" +
                "idRole, " +
                "civilite, " +
                "prenom, " +
                "nom, " +
                "identifiant, " +
                "motPasse, " +
                "dateNaissance, " +
                "dateCreation, " +
                "dateModification, " +
                "actif, " +
                "marquerEffacer, " +
                "version) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        user.setDateCreation(new java.util.Date());
        user.setDateModification(new java.util.Date());

        try {

            preparedStatement = connection.prepareStatement(addSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, user.getRole().getIdRole());
            preparedStatement.setString(2, user.getCivilite());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getNom());
            preparedStatement.setString(5, user.getIdentifiant());
            preparedStatement.setString(6, user.getMotPasse());

            preparedStatement.setDate(7, new java.sql.Date(user.getDateNaissance().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(user.getDateCreation().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(user.getDateModification().getTime()));
            preparedStatement.setInt(10, 1);
            preparedStatement.setInt(11, 0);
            preparedStatement.setInt(12, 0);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                user.setIdUtilisateur(rs.getInt(1));
                return user;
            }
            return user;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TODO return l'objet.
        return null;
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {

        Utilisateur newuser = findUtilisateurById(user.getIdUtilisateur());
        newuser = findUtilisateurById(user.getIdUtilisateur());
        if (newuser == null) {
            return null;
        }

        String deleteSQL = "UPDATE  Utilisateur set " +
                "idRole = ?, " +
                "civilite = ?, " +
                "prenom = ?, " +
                "nom = ?, " +
                "identifiant = ?, " +
                "motPasse = ?, " +
                "dateNaissance = ?, " +
                "dateModification = ?, " +
                "actif = ?, " +
                "marquerEffacer = ?, " +
                "version = ? " +
                "WHERE idUtilisateur = ?";
        user.setDateModification(new java.util.Date());

        try {
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, user.getRole().getIdRole());
            preparedStatement.setString(2, user.getCivilite());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getNom());
            preparedStatement.setString(5, user.getIdentifiant());
            preparedStatement.setString(6, user.getMotPasse());
            preparedStatement.setDate(7, new java.sql.Date(user.getDateNaissance().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(user.getDateModification().getTime()));
            preparedStatement.setBoolean(9, true);
            preparedStatement.setBoolean(10, false);
            preparedStatement.setInt(11, user.getVersion());
            preparedStatement.setInt(12, user.getIdUtilisateur());
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
        List<Utilisateur> userList = new ArrayList<Utilisateur>();
        userList = findAllUtilisateurs();

        if (userList.size() > 0) {
            for (Utilisateur userTmp: userList) {
                if (user.getIdUtilisateur() == userTmp.getIdUtilisateur()) {

                    connection = getConnectionInstance();
                    String deleteSQL = "DELETE FROM utilisateur WHERE idutilisateur = ?";
                    try {
                        preparedStatement = connection.prepareStatement(deleteSQL);
                        preparedStatement.setInt(1, user.getIdUtilisateur());
                        preparedStatement.executeUpdate();
                        return true;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    /**
     * Méthode qui vérifie les logs email / password d'un utilisateur dans la
     * base de données
     *
     * @param email L'email de l'utilisateur
     * @param password Le password de l'utilisateur
     * @return L'utilisateur qui tente de se logger si trouvé, null sinon
     */
    @Override
    public Utilisateur authenticate(String email, String password) {

        List<Utilisateur> users = new ArrayList<>();
        users = findUtilisateurByIdentifiant(email);

        if (users.size() > 0) {
            for (Utilisateur user: users) {
                if (user.getIdentifiant().equals(email) && user.getMotPasse().equals(password)) {
                    return user;
                }
            }
        }
        Utilisateur nulluser = null;
        nulluser.setIdUtilisateur(null);
        return nulluser;
    }
}
