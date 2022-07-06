<?php $client = new SoapClient('http://localhost:8585/GestionEtudiant?wsdl');?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Liste Etudiant</title>

</head>
<body>
   <form method="post">
   	   <fieldset>
   	   	<legend>Ajout Etudiant</legend>
   	   	<label>Nom</label>
   	   	<input type="text" name="nom">
   	   	<label>Prenom</label>
   	   	<input type="text" name="prenom">login
   	   	<input type="text" name="login">password
   	   	<input type="text" name="password">
   	   	<input type="submit" name="submit">
   	   </fieldset>
   </form>
   <?php
 if (isset($_post['nom'],$post['prenom'],$post['login'],$post['password'])){
 	$parametres=array(
'nom' =>$_post['nom'],
'prenom' =>$_post['prenom'],
'login' =>$_post['login'],
'password' =>$_post['password'],

 	);
 	$client->__soapCall('ajouterEtudiant',array());
 }
   ?>


   <h1>Liste etudiants</h1>
   <?php
$etudiants=$client->__soapCall('lister',array());

if(!empty($etudiants->return))
{
	?>
	<table border="1">
		<tr>
            <th>id</th>
            <th>nom</th>
            <th>prenom</th>
            <th>login</th>
            <th>password</th>
        </tr><?php
        if (!is_array($etudiants->return))
        {?>
          <tr>
          	<td> <?=$etudiants->return->id?></td>
          	<td> <?=$etudiants->return->nom?></td>
          	<td> <?=$etudiants->return->prenom?></td>
          	<td> <?=$etudiants->return->login?></td>
          	<td> <?=$etudiants->return->password?></td>
          </tr><?php
        }
        else
        {
        	foreach ($etudiants->return as $etudiants) {
        		?>
        		<tr>
        			<td><?=$etudiant->id?></td>
        			<td><?=$etudiant->nom?></td>
        			<td><?=$etudiant->prenom?></td>
        			<td><?=$etudiant->login?></td>
        			<td><?=$etudiant->password?></td>
        		</tr><?php
        	}
        }?>
       </table><?php
}

else{
	echo "liste vide";
}

   ?>
</body>
</html>