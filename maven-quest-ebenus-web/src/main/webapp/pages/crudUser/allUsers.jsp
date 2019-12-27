<%@ page import="com.cours.ebenus.dao.entities.Utilisateur" %>
<%@ page import="com.cours.ebenus.servlets.LoginServlet" %>
<%@ page import="com.mysql.jdbc.Util" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Ebenus</title>
        <!-- CSS files -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/master.css"> 
    </head>
    <body>
        <div class="outer">
            <div class="header-outer" id="header-outer">
                <!-- Header -->
                <header id="header"  class="header">
                    <div class="header padd-top">
                        <a href="${pageContext.request.contextPath}" title="Ebenus" class="logo"> 
                            <img src="./assets/images/logo/logo.png" alt="Ebenus"> 
                        </a>
                    </div>
                </header>
            </div>
            <!-- Section -->
            <section>
                <div class="content">
                    <div class="User export">
                        <h2 style="margin-top: 20px;display: inline-block;"> Bonjour Mr <strong>
                            <% Utilisateur user = (Utilisateur) request.getSession().getAttribute("user"); %>
                            <%= user.getNom()%> <%= user.getPrenom()%>
                        </strong> avec le rôle
                            <%= user.getRole().getIdentifiant()%>.
                        </h2>

                        <form id="user-desconnect-CrudUserServlet" action="${pageContext.request.contextPath}/CrudUserServlet" method="post">
                            <h1 class="logout"> <a href="#" role="button">Se Deconnecter</a></h1>
                        </form>

                        <ul class="User f-left">
                            <li>
                                <a href="#" role="button">Export des Utilisateurs au format Csv</a>
                            </li>
                            <li>
                                <a href="#" role="button">Export des Utilisateurs au format XML</a>
                            </li>
                            <li>
                                <a href="#" role="button">Export des Utilisateurs au format Json</a>
                            </li>
                        </ul>
                        <h1 class="clearfix">liste des utilisateurs</h1>


                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Civilite</th>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Identifiant</th>
                                        <th>Date naissance</th>
                                        <th>Date création</th>
                                        <th>Date modification</th>
                                        <th>Identifiant rôle</th>
                                        <th>Description rôle</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr> 
                                        <td>Mr</td>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@mail.com</td>
                                        <td> 20/10/1990</td>
                                        <td>15/10/2017</td>
                                        <td>20/11/2017</td>
                                        <td>Administrateur</td>
                                        <td>Le rôle administrateur</td>
                                        <td><a href="#"><i class="fa fa-edit"></i></a>
                                            <a href="#" class="no-style-btn"><i class="fa fa-trash-o"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>Mr</td>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@mail.com</td>
                                        <td> 20/10/1990</td>
                                        <td>15/10/2017</td>
                                        <td>20/11/2017</td>
                                        <td>Directeur</td>
                                        <td>Le rôle de directeur de magasin</td>
                                        <td>
                                            <a href="#"><i class="fa fa-edit"></i></a>

                                            <a href="#" class="no-style-btn"><i class="fa fa-trash-o"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>Mr</td>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@mail.com</td>
                                        <td> 20/10/1990</td>
                                        <td>15/10/2017</td>
                                        <td>20/11/2017</td>
                                        <td>Standard</td>
                                        <td>Le rôle standard</td>
                                        <td><a href="#"><i class="fa fa-edit"></i></a>
                                            <a href="#" class="no-style-btn"><i class="fa fa-trash-o"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>Mr</td>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@mail.com</td>
                                        <td> 20/10/1990</td>
                                        <td>15/10/2017</td>
                                        <td>20/11/2017</td>
                                        <td>Vendeur</td>
                                        <td>Le rôle Vendeur</td>
                                        <td><a href="#"><i class="fa fa-edit"></i></a>
                                            <a href="#" class="no-style-btn"><i class="fa fa-trash-o"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>Mr</td>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@mail.com</td>
                                        <td> 20/10/1990</td>
                                        <td>15/10/2017</td>
                                        <td>20/11/2017</td>
                                        <td>Acheteur</td>
                                        <td>Le rôle Acheteur</td>
                                        <td><a href="#"><i class="fa fa-edit"></i></a>
                                            <a href="#" class="no-style-btn"><i class="fa fa-trash-o"></i></a></td>
                                    </tr>

                                </tbody>
                            </table>
                            <ul class="User">

                                <li>
                                    <!-- <a href="#" role="button">Import d'utilisateurs à partir d'un fichier CSV</a> -->
                                    <div class="col-lg-12 no-padding">
                                        <a href="#" role="button">Ajouter Utilisateur</a>
                                        <!-- Select Basic -->
                                        <div class="form-group selectexport-box">
                                            <div class="input-file-box"> 
                                                <input type="file" name="file-2[]" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple />
                                                <label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Import d'utilisateurs à partir d'un fichier CSV</span></label>
                                            </div>
                                            <!-- <button type="button" class="btn btn-default">Import d'utilisateurs à partir d'un fichier CSV</button> -->
                                        </div>

                                    </div>
                                </li>
                            </ul>
                        </div>

                    </div> 
                </div>
            </section>
            <!-- Footer -->
            <footer>
                <div class="footer-container ">
                    <div class="footer">
                        <div class="footer-middle">
                            <div class="footer-container_">
                                <div class="row no-gutters"> 
                                    <div class="col-sm-6 col-md-3">
                                        <div class="block">
                                            <div class="block-title"><strong><span>Contactez Nous</span></strong></div>
                                            <div class="block-content">
                                                <ul class="contact-info">
                                                    <li><i class="icon-location">&nbsp;</i><p><b>Addresse:</b><br>123 Rue la victoire, 75000 Paris, France</p></li>
                                                    <li><i class="icon-phone">&nbsp;</i><p><b>Tél:</b><br>(+33) 00 11 00 11 00</p></li>
                                                    <li><i class="icon-mail">&nbsp;</i><p><b>Email:</b><br><a href="mailto:mail@example.com">mail@example.com</a></p></li>
                                                    <li><i class="icon-clock">&nbsp;</i><p><b>Horaire : </b><br>Lundi au Samedi</p></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3"><div class="block">
                                            <div class="block-title"><strong><span>Mon compte</span></strong></div>
                                            <div class="block-content">
                                                <ul class="links">
                                                    <li><i class="icon-right-dir theme-color"></i><a href="#" title="A propos de nous">Mon compte</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>                
                                    <div class="col-sm-6 col-md-3"><div class="block">
                                            <div class="block-title"><strong><span>Information</span></strong></div>
                                            <div class="block-content">
                                                <ul class="features">
                                                    <li><i class="icon-ok theme-color"></i><a href="#">Les informations</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="block">
                                            <div class="block-title"><strong><span>Nos Services</span></strong></div>
                                            <div class="block-content">
                                                <ul class="features">
                                                    <li><i class="icon-ok  theme-color"></i><a href="#">Service Client</a></li>
                                                    <li><i class="icon-ok  theme-color"></i><a href="#">Politique d'Utilisation</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>              
                                </div>
                            </div>
                        </div>
                        <div class="footer-bottom">
                            <div class="footer-container_">                
                                <address>© Ebenus. 2019. Tous droit réservé</address>
                            </div>
                        </div>
                    </div>
                </div>   
            </footer>
            <!-- JS files -->
            <script src="./assets/js/bower.js" type="text/javascript"></script>
            <script src="./assets/js/application.js" type="text/javascript"></script>
        </div>   
    </body>
</html>
