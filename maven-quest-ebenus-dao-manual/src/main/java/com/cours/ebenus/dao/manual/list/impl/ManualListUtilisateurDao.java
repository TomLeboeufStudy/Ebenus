/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.list.impl;

import com.cours.ebenus.dao.DataSource;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;

import java.time.LocalDateTime;
import java.util.*;

import com.cours.ebenus.dao.exception.CustomException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualListUtilisateurDao extends AbstractListDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(ManualListUtilisateurDao.class);
    private List<Utilisateur> utilisateursListDataSource = new ArrayList<Utilisateur>();

    public ManualListUtilisateurDao() {
        super(Utilisateur.class, DataSource.getInstance().getUtilisateursListDataSource());
        utilisateursListDataSource = super.findAll();
    }

    /**
     * Méthode qui retourne la liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource)
     *
     * @return La liste de tous les utilisateurs de la database
     */
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateursListDataSource;
    }

    /**
     * Méthode qui retourne l'utilisateur d'id passé en paramètre de la database
     * (ici utilisateursListDataSource)
     *
     * @param idUtilisateur L'id de l'user à récupérer
     * @return L'utilisateur d'id passé en paramètre, null si non trouvé
     */
    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
        for (Utilisateur utilisateur : utilisateursListDataSource) {
            if (utilisateur.getIdUtilisateur() == idUtilisateur) {
                return utilisateur;
            }
        }
        return null;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le prénom est égal au paramètre
     * passé
     *
     * @param prenom Le prénom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le prénom est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
        List<Utilisateur> newList = new ArrayList<Utilisateur>();
        for (Utilisateur user: utilisateursListDataSource) {
            if (user.getPrenom() == prenom) {
                newList.add(user);
            }
        }
        return newList;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le nom est égal au paramètre passé
     *
     * @param nom Le nom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le nom est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
        List<Utilisateur> newList = new ArrayList<Utilisateur>();
        for (Utilisateur user: utilisateursListDataSource) {
            if (user.getNom() == nom) {
                newList.add(user);
            }
        }
        return newList;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont l'identifiant est égal au paramètre
     * passé
     *
     * @param identifiant Le nom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont l'identifiant est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
        List<Utilisateur> newList = new ArrayList<Utilisateur>();
        for (Utilisateur user: utilisateursListDataSource) {
            if (user.getIdentifiant() == identifiant) {
                newList.add(user);
            }
        }
        return newList;
    }

    /**
     * Méthode qui permet d'ajouter un utilisateur dans la database (ici
     * utilisateursListDataSource)
     *
     * @param user L'utilisateur à ajouter
     * @return L'utilisateur ajouté ou null si échec
     */
    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
        if (utilisateursListDataSource.size() > 0) {
            for (Utilisateur tmp: utilisateursListDataSource) {
                if (tmp.equals(user)) {
                    CustomException.UtilisateurIDAlreadyExist(tmp.getIdUtilisateur());
                    return null;
                }
                if (tmp.getIdentifiant() == user.getIdentifiant()) {
                    CustomException.UtilisateurIdentifiantAlreadyExist(tmp.getIdentifiant());
                    return null;
                }
            }
            if (user.getIdUtilisateur() == null) {
                user.setIdUtilisateur(utilisateursListDataSource.get(utilisateursListDataSource.size() - 1).getIdUtilisateur() + 1);
            }
            user.setDateCreation(new Date());
            user.setDateModification(new Date());
            utilisateursListDataSource.add(user);
            return user;
        }
        if (user.getIdUtilisateur() == null) {
            user.setIdUtilisateur(utilisateursListDataSource.size() + 1);
        }
        user.setDateCreation(new Date());
        user.setDateModification(new Date());
        utilisateursListDataSource.add(user);
        return user;
    }

    /**
     * Méthode qui permet d'update un utilisateur existant dans la database (ici
     * utilisateursListDataSource)
     *
     * @param user L'utilisateur à modifier
     * @return L'utilisateur modifié ou null si ce dernier n'existe pas dans la
     * database
     */
    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
        // TODO gerer si le mail exist deja
        Utilisateur tmp = findUtilisateurById(user.getIdUtilisateur());

        if (tmp == null) {
            return null;
        }
        user.setDateModification(new Date());
        Collections.replaceAll(utilisateursListDataSource, tmp, user);

        return findUtilisateurById(user.getIdUtilisateur());
    }

    /**
     * Méthode qui permet de supprimer un utilisateur existant dans la database
     * (ici utilisateursListDataSource)
     *
     * @param user L'utilisateur à supprimer
     * @return True si suppression effectuée, false sinon
     */
    @Override
    public boolean deleteUtilisateur(Utilisateur user) {

        if (findUtilisateurById(user.getIdUtilisateur()).getIdUtilisateur() != user.getIdUtilisateur()) {
            return false;
        }

        utilisateursListDataSource.remove(user);
        return true;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le rôle a comme id celui passé en
     * paramètre
     *
     * @param idRole L'id du rôle des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le rôle a comme id celui
     * passé en paramètre
     */
    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {
        List<Utilisateur> newList = new ArrayList<Utilisateur>();
        for (Utilisateur user: utilisateursListDataSource) {
            if (user.getRole().getIdRole() == idRole) {
                newList.add(user);
            }
        }
        return newList;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le rôle a comme identifiant celui
     * passé en paramètre
     *
     * @param identifiantRole L'identifiant du rôle des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le rôle a comme
     * identifiant celui passé en paramètre
     */
    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {
        List<Utilisateur> newList = new ArrayList<Utilisateur>();
        for (Utilisateur user: utilisateursListDataSource) {
            if (user.getRole().getIdentifiant() == identifiantRole) {
                newList.add(user);
            }
        }
        return newList;
    }
}
