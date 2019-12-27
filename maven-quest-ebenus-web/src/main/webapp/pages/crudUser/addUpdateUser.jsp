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
        <link rel="stylesheet" href="assets/css/master.css"> 
    </head>
    <body>
        <div class="outer">
            <div class="header-outer" id="header-outer">
                <!-- Header -->
                <header id="header"  class="header">
                    <div class="header padd-top">
                        <a href="index.html" title="Ebenus" class="logo"> 
                            <img src="./assets/images/logo/logo.png" alt="Ebenus"> 
                        </a>
                    </div>
                </header>
            </div>
            <!-- Section -->
            <section>
                    <div class="content">
                        <div class="User quest">
                            <h1>Créer un utilisateur</h1>
                            <form  method="post" action="allUsers.html" id="customer-info-form" class="no-gutters">
                                <div class="account-container row">
                                    <fieldset class=" common-form-controls col-md-3">
                                        <div >
                                            <p>Informations Personnelles</p>
    
                                            <div class="input-wrapper">
                                                <label for="firstname">Prénom<em>*</em></label>
                                                <input  autocomplete="off"  name="firstname" id="firstname" type="text">
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="lastname">Nom<em>*</em></label>
                                                <input  autocomplete="off"  name="lastname" id="lastname" type="text">
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="email">Identifiant<em>*</em></label>
                                                <input  autocomplete="off" name="email" id="email" type="email">
                                            </div>
                                            <div class="input-wrapper">
                                                    <label for="pass" class="required">Mot de passe<em>*</em></label>
                                                    <div class="input-box">
                                                        <input type="password" name="password" class="input-text" id="password" title="Password">
                                                    </div>
                                            </div>
                                            <div class="input-wrapper">
                                                    <label for="pass" class="required">Confirmer le mot de passe<em>*</em></label>
                                                    <div class="input-box">
                                                        <input type="password" name="password_confirm" class="input-text" id="pass" title="Password">
                                                    </div>
                                            </div>
                                            
    
                                    </fieldset>
                                    <div class="offset-md-2"></div>   
                                    <fieldset class="col-md-3">
                                        
                                        <div class="input-wrapper">
                                           <label for="">
                                                Selectionner le rôle<em>*</em>
                                           </label>
                                        </div>
                                        <div class="sel-container">
                                                <div class="sel">
                                                    <select  class="required" name="select_city" id="select_city"> 
                                                        <option value="rôle" selected disabled>Rôle</option>
                                                <option value="Administrateur ">Administrateur </option>
                                                <option value="Directeur ">Directeur </option>
                                                <option value="Standard ">Standard </option>
                                                <option value="Vendeur ">Vendeur </option>
                                                <option value="Acheteur ">Acheteur </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="input-wrapper">
                                                <label>Civilité</label>
                                                <div class="gender">
                                                    <input  autocomplete="off" type="radio" id="male" name="sex" checked="checked"/>
                                                    <label for="male">
                                                        <i class="fa fa-male" aria-hidden="true"></i>
                                                    </label>
                                                    <input  autocomplete="off" type="radio" id="female" name="sex"/>
                                                    <label for="female">
                                                        <i class="fa fa-female" aria-hidden="true"></i>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="input-wrapper">
                                                <label style="display: block;"> Date de naissance<em>*</em></label>
                                                <input  autocomplete="off" id="dteNaiss" name="dteNaiss" style="width:auto;" data-toggle="datepicker" type="text" value="" name="naissance">
                                            </div>
                                    </fieldset>
                                </div>
                                <div class="row">
                                    <div class="col-md-5"><p class="obligatoire">les champs avec la signe "*" sont obligatoire</p></div>
                                    <div class="actions col-md-4">
                                        <button type="submit">Ajouter</button>
                                    </div>
                                </div>
                            </form>
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
        </div>
        <!-- JS files -->
        <script src="assets/js/bower.js" type="text/javascript"></script>
        <script src="assets/js/application.js" type="text/javascript"></script>
    </body>
</html>
