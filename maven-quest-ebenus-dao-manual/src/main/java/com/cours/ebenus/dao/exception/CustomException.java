package com.cours.ebenus.dao.exception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException
{
    /**
     * Le code d'erreur
     */
    private int code;

    public CustomException(int code)
    {
        super();
        this.code = code;
    }

    public CustomException(String message, int code)
    {
        super(message);
        this.code = code;
    }

    public CustomException(Throwable cause, int code)
    {
        super(cause);
        this.code = code;
    }

    public CustomException(String message, Throwable cause, int code)
    {
        super(message, cause);
        this.code = code;
    }

  // getter et setter
    public int getCode() {
        return (this.code);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void RoleIDAlreadyExist(int id) throws CustomException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new CustomException("Une erreur s’est produite, il existe déjà un Role avec l’id ' "
                    + id
                    + " ' dans l’application", -1);
        }
    }

    public static void UtilisateurIdentifiantAlreadyExist(String str) throws CustomException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new CustomException("Une erreur s’est produite, il existe déjà un Utilisateur avec l’identifiant ' "
                    + str
                    + " ' dans l’application", -1);
        }
    }

    public static void UtilisateurIDAlreadyExist(int id) throws CustomException {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new CustomException("Une erreur s’est produite, il existe déjà un Utilisateur avec l’id ' "
                    + id
                    + " ' dans l’application", -1);
        }
    }
}
