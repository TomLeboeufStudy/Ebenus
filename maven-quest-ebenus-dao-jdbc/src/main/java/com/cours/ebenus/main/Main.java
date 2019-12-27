/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.main;

import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.dao.impl.RoleDao;
import com.cours.ebenus.dao.impl.UtilisateurDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author elhad
 */
public class Main {

    private static final Log log = LogFactory.getLog(Main.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

/*        List<Utilisateur> listUser = new ArrayList<Utilisateur>();
        UtilisateurDao dao = new UtilisateurDao();
        listUser = dao.findAllUtilisateurs();
        for (Utilisateur user: listUser) {
            System.out.println(user.toString() + " " + user.getRole().toString());
        }*/


        List<Role> listRoles = new ArrayList<Role>();
        List<Utilisateur> listuser = new ArrayList<Utilisateur>();
        UtilisateurDao daouser = new UtilisateurDao();
        RoleDao daoRole = new RoleDao();
        listRoles = daoRole.findAllRoles();
        for (Role role: listRoles) {
            System.out.println(role.toString());
        }

        Role nr = new Role(null, "boss", "c'est pour lui le café", 0);
        nr = daoRole.createRole(nr);
        log.debug(nr.toString());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        listRoles = daoRole.findRoleByIdentifiant("boss");
        /*System.out.println(nr.toString());*/

        System.out.println("==============================");
        listRoles = daoRole.findAllRoles();
        for (Role role: listRoles) {
            System.out.println(role.toString());
        }

        System.out.println("==============================");

/*        listuser = daouser.findAllUtilisateurs();
        for (Utilisateur tmp: listuser) {
            System.out.println(tmp.toString());
        }*/
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Utilisateur user = new Utilisateur(27, "Mr", "tom", "leboeuf", "tom@tom.tom", "test", new Date(), new Date(), new Date(), true, false, 1, nr);
        user = daouser.createUtilisateur(user);
        log.debug(user.toString());

        user.setPrenom("the boss en fait");
        user = daouser.updateUtilisateur(user);
        log.debug(user.toString());
        log.debug(daouser.findUtilisateurById((user.getIdUtilisateur())).toString());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


/*        listuser = daouser.findAllUtilisateurs();
        for (Utilisateur tmp: listuser) {
            System.out.println(tmp.toString());
        }*/

//        System.out.println("||||||||||||||||||||||||||||||");
//
        daouser.deleteUtilisateur(user);
        /*
        listuser = daouser.findAllUtilisateurs();
        for (Utilisateur tmp: listuser) {
            System.out.println(tmp.toString());
        }*/

        log.debug(nr.toString());
        nr.setDescription("yeah boiiiiii");
        nr = daoRole.updateRole(nr);
        log.debug(nr.toString());

        System.out.println("==============================");
        listRoles = daoRole.findAllRoles();
        for (Role role: listRoles) {
            System.out.println(role.toString());
        }

        daoRole.deleteRole(nr);
        System.out.println("==============================");
        listRoles = daoRole.findAllRoles();
        for (Role role: listRoles) {
            System.out.println(role.toString());
        }


/*        Utilisateur newUser = new Utilisateur();
        newUser = dao.findUtilisateurById(5);
        System.out.println(newUser.toString());*/

    }
}
