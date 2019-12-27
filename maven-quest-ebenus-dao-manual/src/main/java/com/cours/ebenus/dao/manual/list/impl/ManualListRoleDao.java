/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.list.impl;

import com.cours.ebenus.dao.DataSource;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.exception.CustomException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualListRoleDao extends AbstractListDao<Role> implements IRoleDao {

    private static final Log log = LogFactory.getLog(ManualListRoleDao.class);
    private List<Role> rolesListDataSource = new ArrayList<Role>();

    public ManualListRoleDao() {
        super(Role.class, DataSource.getInstance().getRolesListDataSource());
        rolesListDataSource = super.findAll();
    }
    /**
     * Méthode qui retourne la liste de tous les rôles de la database (ici
     * rolesListDataSource)
     *
     * @return La liste de tous les rôles de la database
     */
    @Override
    public List<Role> findAllRoles() {
        return rolesListDataSource;
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
        for (Role role : rolesListDataSource) {
            if (role.getIdRole() == idRole) {
                return role;
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
        List<Role> newList = new ArrayList<Role>();
        for (Role role: rolesListDataSource) {
            if (role.getIdentifiant() == identifiantRole) {
                newList.add(role);
            }
        }
        return newList;
    }
    
//    /**
//     * Méthode qui permet d'ajouter à rôle dans la database (ici
//     * rolesListDataSource)
//     *
//     * @param role Le rôle à ajouter
//     * @return Le rôle ajouté ou null si échec
//     */
//    @Override
//    public Role createRole(Role role) {
//        if (rolesListDataSource.size() > 0) {
//            for (Role tmp: rolesListDataSource) {
//                if (tmp.equals(role)) {
//                    CustomException.RoleIDAlreadyExist(tmp.getIdRole());
//                    return null;
//                }
//            }
//        }
//        rolesListDataSource.add(role);
//        return role;
//    }
    
    @Override
    public Role createRole(Role role) {
        if (rolesListDataSource.size() > 0) {
            for (Role tmp: rolesListDataSource) {
                if (tmp.equals(role)) {
                    CustomException.RoleIDAlreadyExist(tmp.getIdRole());
                    return null;
                }
            }
            if (role.getIdRole() == null) {
                role.setIdRole(rolesListDataSource.get(rolesListDataSource.size() - 1).getIdRole() + 1);
            }
            rolesListDataSource.add(role);
            return role;
        }
        if (role.getIdRole() == null) {
            role.setIdRole(rolesListDataSource.get(rolesListDataSource.size() - 1).getIdRole() + 1);
        }
        rolesListDataSource.add(role);
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
        Collections.replaceAll(rolesListDataSource, tmp, role);

        return findRoleById(role.getIdRole());
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

        if (findRoleById(role.getIdRole()).getIdRole() != role.getIdRole()) {
            return false;
        }
        rolesListDataSource.remove(role);
        return true;
    }
}
