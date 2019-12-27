/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.map.impl;

import com.cours.ebenus.dao.DataSource;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.entities.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cours.ebenus.dao.exception.CustomException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;

/**
 *
 * @author ElHadji
 */
public class ManualMapRoleDao extends AbstractMapDao<Role> implements IRoleDao {
    private static final Log log = LogFactory.getLog(ManualMapRoleDao.class);
    private Map<Integer, Role> rolesListDataSource = new HashMap<>();


    public ManualMapRoleDao() {
        super(Role.class, DataSource.getInstance().getRolesMapDataSource());
        rolesListDataSource = DataSource.getInstance().getRolesMapDataSource();
    }
    /**
     * Méthode qui retourne la liste de tous les rôles de la database (ici
     * rolesListDataSource)
     *
     * @return La liste de tous les rôles de la database
     */
    @Override
    public List<Role> findAllRoles() {
        List<Role> newList = new ArrayList<Role>();
        for (Map.Entry<Integer, Role> entry: rolesListDataSource.entrySet()) {
            newList.add(entry.getValue());
        }

        return newList;
    }

    /**
     * Méthode qui retourne le rôle d'id passé en paramètre de la database (ici
     * rolesListDataSource)
     *
     * @param idRole L'id du rôle à récupérer
     * @return Le rôle d'id passé en paramètre, null si non trouvé
     */
    @Override
    public Role findRoleById(int idRole) {
	    for (Map.Entry<Integer, Role> entry: rolesListDataSource.entrySet()) {
	        if (entry.getValue().getIdRole() == idRole) {
	           return entry.getValue();
	        }
	    }
	
	    return null;
    }

    /**
     * Méthode qui retourne une liste de tous les rôles de la database (ici
     * rolesListDataSource) dont l'identifiant est égal au paramètre passé
     *
     * @param identifiantRole L'identifiant des rôles à récupérer
     * @return Une liste de tous les rôles dont l'identifiant est égal au
     * paramètre passé
     */
    @Override
    public List<Role> findRoleByIdentifiant(String identifiantRole) {

    	List<Role> roles = new ArrayList<Role>();
        for (Map.Entry<Integer, Role> entry: rolesListDataSource.entrySet()) {
            if (entry.getValue().getIdentifiant() == identifiantRole) {
                roles.add(entry.getValue());
            }
        }

        return roles;
    }

    /**
     * Méthode qui permet d'ajouter à rôle dans la database (ici
     * rolesListDataSource)
     *
     * @param role Le rôle à ajouter
     * @return Le rôle ajouté ou null si échec
     */
    @Override
    public Role createRole(Role role) {

    	role.setIdRole(rolesListDataSource.size() + 1);
    	List<Role> isEmpty = findRoleByIdentifiant(role.getIdentifiant());

    	if (!isEmpty.isEmpty() && (isEmpty != null)) {
    		System.out.println(role.getIdentifiant() + " existe déjà");

    		return null;
    	}
    	rolesListDataSource.put(rolesListDataSource.size() + 1, role);

        return role;
    }

    /**
     * Méthode qui permet d'update un rôle existant dans la database (ici
     * rolesListDataSource)
     *
     * @param role Le rôle à modifier
     * @return Le rôle modifié ou null si ce dernier n'existe pas dans la
     * database
     */
    @Override
    public Role updateRole(Role role) {
        Role tmp = findRoleById(role.getIdRole());

        if (tmp == null) {
            return null;
        }

        rolesListDataSource.replace(tmp.getIdRole(), tmp, role);

        return role;
    }

    /**
     * Méthode qui permet de supprimer un rôle existant dans la database (ici
     * rolesListDataSource)
     *
     * @param role Le rôle à supprimer
     * @return True si suppression effectuée, false sinon
     */
    @Override
    public boolean deleteRole(Role role) {
    	Role tmp = findRoleById(role.getIdRole());
    	if (tmp == null) {
    		return false;
    	}
    	try {
    		rolesListDataSource.remove(tmp.getIdRole(),tmp);
    	}
    	catch (Exception e) {
    		return false;
    	}
    	return true;
    }
}