package com.cours.ebenus.dao.exception;

@SuppressWarnings("serial")
public class EbenusException extends RuntimeException {

    // code d'erreur
    private int code;

    public EbenusException(int code) {
        super();
        this.code = code;
    }

    public EbenusException(String message, int code) {
        super(message);
        this.code = code;
    }

    public EbenusException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public EbenusException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

  // getter et setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void RoleIDAlreadyExist(int id) throws EbenusException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new EbenusException("Une erreur s’est produite, il existe déjà un Role avec l’id ' "
                    + id
                    + " ' dans l’application", -1);
        }
    }

    public static void UtilisateurIDAlreadyExist(int id) throws EbenusException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new EbenusException("Une erreur s’est produite, il existe déjà un Utilisateur avec l’id ' "
                    + id
                    + " ' dans l’application", -1);
        }
    }

    public static void RoleIdentifiantAlreadyExist(String identifiant) throws EbenusException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new EbenusException("Une erreur s’est produite, il existe déjà un Role avec l’identifiant ' "
                    + identifiant
                    + " ' dans l’application", -1);
        }
    }
    public static void UserIdentifiantAlreadyExist(String identifiant) throws EbenusException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new EbenusException("Une erreur s’est produite, il existe déjà un Utilisateur avec l’identifiant ' "
                    + identifiant
                    + " ' dans l’application", -1);
        }
    }

    public static void OneUserGetThisRole(Integer idRole) throws EbenusException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new EbenusException("Il y a au moin un Utilisateur avec un Role d'id `"
                    + idRole
                    + "` dans l'application", -1);
        }
    }

}
