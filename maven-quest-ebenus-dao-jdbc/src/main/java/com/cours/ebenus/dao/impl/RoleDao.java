/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.DriverManagerSingleton;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.dao.exception.EbenusException;
import com.cours.ebenus.utils.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class RoleDao /*extends AbstractDao<Role>*/ implements IRoleDao {

    private static final Log log = LogFactory.getLog(RoleDao.class);
    private PreparedStatement preparedStatement;
    private Connection connection = null;

    //public RoleDao() {
    //    super(Role.class);
    //}

    private Role getRoleFromResult(ResultSet rs) {
        Role newRole = new Role();
        try {
            newRole.setIdRole(rs.getInt("idRole"));
            newRole.setIdentifiant(rs.getString("identifiant"));
            newRole.setDescription(rs.getString("description"));
            newRole.setVersion(rs.getInt("version"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newRole;
    }

    @Override
    public List<Role> findAllRoles() {
        connection = DriverManagerSingleton.getConnectionInstance();

        List<Role> roleList = new ArrayList<Role>();
        String selectSQL = "SELECT * FROM role";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Role newRole = getRoleFromResult(rs);
                roleList.add(newRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleList;
    }

    @Override
    public Role findRoleById(int idRole) {
        connection = DriverManagerSingleton.getConnectionInstance();
        Role newRole = new Role();
        String selectSQL = "SELECT * FROM role WHERE idRole = " + idRole + ";";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            if (rs.next()) {
                newRole = getRoleFromResult(rs);
                return newRole;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Role> findRoleByIdentifiant(String identifiantRole) {
        connection = DriverManagerSingleton.getConnectionInstance();

        List<Role> roleList = new ArrayList<Role>();

        String selectSQL = "SELECT * FROM role WHERE identifiant = '" + identifiantRole + "';";
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            while (rs.next()) {
                Role newRole = getRoleFromResult(rs);
                roleList.add(newRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleList;
    }

    @Override
    public Role createRole(Role role) {

        List<Role> roleList = new ArrayList<Role>();
        roleList = findAllRoles();

        if (roleList.size() > 0) {
            for (Role roleTmp: roleList) {
                if (role.getIdRole() == roleTmp.getIdRole()) {
                    EbenusException.RoleIDAlreadyExist(role.getIdRole());
                    return null;
                }
            }
        }

        connection = DriverManagerSingleton.getConnectionInstance();

        String addSQL = "INSERT INTO `role` (identifiant, description, version) VALUES (?, ?, ?);";
        try {
            preparedStatement = connection.prepareStatement(addSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, role.getIdentifiant());
            preparedStatement.setString(2, role.getDescription());
            preparedStatement.setInt(3, 0);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                role.setIdRole(rs.getInt(1));
                return role;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public Role updateRole(Role role) {

        Role newrole = new Role();
        newrole = findRoleById(role.getIdRole());
        log.debug(newrole.toString());
        if (newrole == null) {
            return null;
        }

        connection = DriverManagerSingleton.getConnectionInstance();
        String deleteSQL = "UPDATE role SET " +
                "identifiant = ?, " +
                "description = ?, " +
                "version = ? " +
                "WHERE idRole = ?";
        try {
            preparedStatement = connection.prepareStatement(deleteSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, role.getIdentifiant());
            preparedStatement.setString(2, role.getDescription());
            preparedStatement.setInt(3, role.getVersion());
            preparedStatement.setInt(4, role.getIdRole());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            return role;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteRole(Role role) {
        List<Role> roleList = new ArrayList<Role>();
        roleList = findAllRoles();

        /** verifie si un user n'as pas ce role **/
        UtilisateurDao userdao = new UtilisateurDao();
        List<Utilisateur> userList = userdao.findUtilisateursByIdRole(role.getIdRole());
        if (userList.size() > 0) {
            EbenusException.OneUserGetThisRole(role.getIdRole());
            return false;
        }


        if (roleList.size() > 0) {
            for (Role roleTmp : roleList) {
                if (role.getIdRole() == roleTmp.getIdRole()) {

                    connection = DriverManagerSingleton.getConnectionInstance();

                    String deleteSQL = "DELETE FROM role WHERE idRole = ?";
                    try {
                        preparedStatement = connection.prepareStatement(deleteSQL);
                        preparedStatement.setInt(1, role.getIdRole());
                        preparedStatement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
