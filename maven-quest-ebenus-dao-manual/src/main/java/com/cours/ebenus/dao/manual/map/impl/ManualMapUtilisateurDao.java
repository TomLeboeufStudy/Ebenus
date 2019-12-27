/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.map.impl;

import com.cours.ebenus.dao.DataSource;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Utilisateur;

import java.util.*;
import java.util.Map.Entry;

import com.cours.ebenus.dao.exception.CustomException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualMapUtilisateurDao extends AbstractMapDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(ManualMapUtilisateurDao.class);
    private Map<Integer, Utilisateur> utilisateursMapDataSource = null;

    public ManualMapUtilisateurDao() {
        super(Utilisateur.class, DataSource.getInstance().getUtilisateursMapDataSource());
        utilisateursMapDataSource = DataSource.getInstance().getUtilisateursMapDataSource();
    }

    /**
     * Méthode qui retourne la liste de tous les utilisateurs de la database
     * (ici utilisateursMapDataSource)
     *
     * @return La liste de tous les utilisateurs de la database
     */
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        List<Utilisateur> newList = new ArrayList<Utilisateur>();
        for (Map.Entry<Integer, Utilisateur> entry: utilisateursMapDataSource.entrySet()) {
            newList.add(entry.getValue());
        }
        return newList;
    }

    /**
     * Méthode qui retourne l'utilisateur d'id passé en paramètre de la database
     * (ici utilisateursMapDataSource)
     *
     * @param idUtilisateur L'id de l'user à récupérer
     * @return L'utilisateur d'id passé en paramètre, null si non trouvé
     */
    @Override
	public Utilisateur findUtilisateurById(int idUtilisateur) {
		for (Entry<Integer, Utilisateur> mapentry : utilisateursMapDataSource.entrySet()) {
			if (mapentry.getValue().getIdUtilisateur() == idUtilisateur) {
				return mapentry.getValue();
			}
		}
		return null;
	}

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursMapDataSource) dont le prénom est égal au paramètre
     * passé
     *
     * @param prenom Le prénom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le prénom est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {

        List<Utilisateur> users = new ArrayList<Utilisateur>();
        for (Map.Entry<Integer, Utilisateur> entry: utilisateursMapDataSource.entrySet()) {
            if (entry.getValue().getPrenom() == prenom) {
                users.add(entry.getValue());
            }
        }
        return users;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursMapDataSource) dont le nom est égal au paramètre passé
     *
     * @param nom Le nom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le nom est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {

        List<Utilisateur> users = new ArrayList<Utilisateur>();
        for (Map.Entry<Integer, Utilisateur> entry: utilisateursMapDataSource.entrySet()) {
            if (entry.getValue().getNom() == nom) {
                users.add(entry.getValue());
            }
        }
        return users;
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

        List<Utilisateur> users = new ArrayList<Utilisateur>();
        for (Map.Entry<Integer, Utilisateur> entry: utilisateursMapDataSource.entrySet()) {
            if (entry.getValue().getIdentifiant() == identifiant) {
                users.add(entry.getValue());
            }
        }
        return users;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursMapDataSource) dont le rôle a comme id celui passé en
     * paramètre
     *
     * @param idRole L'id du rôle des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le rôle a comme id celui
     * passé en paramètre
     */
    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {

        List<Utilisateur> users = new ArrayList<Utilisateur>();
        for (Map.Entry<Integer, Utilisateur> entry: utilisateursMapDataSource.entrySet()) {
            if (entry.getValue().getRole().getIdRole() == idRole) {
                users.add(entry.getValue());
            }
        }
        return users;
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursMapDataSource) dont le rôle a comme identifiant celui
     * passé en paramètre
     *
     * @param identifiantRole L'identifiant du rôle des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le rôle a comme
     * identifiant celui passé en paramètre
     */
    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {

        List<Utilisateur> users = new ArrayList<Utilisateur>();
        for (Map.Entry<Integer, Utilisateur> entry: utilisateursMapDataSource.entrySet()) {
            if (entry.getValue().getRole().getIdentifiant() == identifiantRole) {
                users.add(entry.getValue());
            }
        }
        return users;
    }

    /**
     * Méthode qui permet d'ajouter un utilisateur dans la database (ici
     * utilisateursMapDataSource)
     *
     * @param user L'utilisateur à ajouter
     * @return L'utilisateur ajouté ou null si échec
     */
    @Override
	public Utilisateur createUtilisateur(Utilisateur user) {
		
		user.setIdUtilisateur(utilisateursMapDataSource.size() + 1);
		List<Utilisateur> isEmpty = findUtilisateurByIdentifiant(user.getIdentifiant());
		
		if (!isEmpty.isEmpty() && (isEmpty != null)) {
			throw new CustomException(-1);
		}

		user.setDateCreation(new Date(System.currentTimeMillis()));
		user.setDateModification(new Date(System.currentTimeMillis()));
		utilisateursMapDataSource.put(utilisateursMapDataSource.size() + 1, user);

		return user;
	}

    /**
     * Méthode qui permet d'update un utilisateur existant dans la database (ici
     * utilisateursMapDataSource)
     *
     * @param user L'utilisateur à modifier
     * @return L'utilisateur modifié ou null si ce dernier n'existe pas dans la
     * database
     */
    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {

        Utilisateur tmp = findUtilisateurById(user.getIdUtilisateur());

        if (tmp == null) {
            return null;
        }

        tmp.setIdUtilisateur(user.getIdUtilisateur());
        tmp.setPrenom(user.getPrenom());
        tmp.setNom(user.getNom());
        tmp.setCivilite(user.getCivilite());
        tmp.setIdentifiant(user.getIdentifiant());
        tmp.setMotPasse(user.getMotPasse());
        tmp.setDateNaissance(user.getDateNaissance());
        tmp.setDateModification(new Date());
        tmp.setRole(user.getRole());

        return user;
    }

    /**
     * Méthode qui permet de supprimer un utilisateur existant dans la database
     * (ici utilisateursMapDataSource)
     *
     * @param user L'utilisateur à supprimer
     * @return True si suppression effectuée, false sinon
     */
    @Override
	public boolean deleteUtilisateur(Utilisateur user) {
		Utilisateur tmp = findUtilisateurById(user.getIdUtilisateur());
		if (tmp == null) {
			return false;
		}
		try {
			utilisateursMapDataSource.remove(tmp.getIdUtilisateur(), tmp);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
