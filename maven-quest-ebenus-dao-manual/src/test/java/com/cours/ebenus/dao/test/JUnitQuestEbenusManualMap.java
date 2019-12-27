package com.cours.ebenus.dao.test;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.factory.AbstractDaoFactory;
import com.cours.ebenus.service.ServiceFacade;


public class JUnitQuestEbenusManualMap extends JUnitQuestEbenus {

    private static final Log log = LogFactory.getLog(JUnitQuestEbenusManualMap.class);


    @BeforeClass
    public static void init() throws Exception {
    	serviceFacade = new ServiceFacade(AbstractDaoFactory.FactoryDaoType.MANUAL_MAP_DAO_FACTORY);
    	roles         = serviceFacade.getRoleDao().findAllRoles();
    	utilisateurs  = serviceFacade.getUtilisateurDao().findAllUtilisateurs();
    }
}
