<?php $client=new SoapClient('http://localhost:8585/GestionEtudiantWs?wsdl');?>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="styles.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>User Data</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="styles.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	

	<title></title>
</head>
<body>
	<?php
     if (isset($_POST["nom"]) && isset($_POST["prenom"]) ) {
     	if($_POST["nom"] != "" && $_POST["prenom"] !=""){
     	if(isset($_GET["update"]) && $_GET["update"] != ""){
            $clientSOAP = new SoapClient("http://localhost:8585/GestionEtudiantWs?wsdl");
            $parameters = new stdClass();
            $parameters->id = $_GET["update"];
            $parameters->nom = $_POST["nom"];
            $parameters->prenom = $_POST["prenom"];
            $parameters->login = $_POST["login"];
            $parameters->password = $_POST["password"];
            $result = $clientSOAP->__soapCall("modifierEtudiant", array($parameters));
            $_GET["update"] = "";
            header("Location: gestion_etudiant.php");
        }

        else{
            
            $clientSOAP = new SoapClient("http://localhost:8585/GestionEtudiantWs?wsdl");
            $parameters = new stdClass();
            $parameters->nom = $_POST["nom"];
            $parameters->prenom = $_POST['prenom'];
            
            $parameters->login = $_POST["login"];
            $parameters->password = $_POST["password"];
            $result = $clientSOAP->__soapCall("ajouterEtudiant", array($parameters));
            
            header("Location: gestion_etudiant.php");
        }
    }
}


	?>

	<h1 align="center">Liste des Etudiants</h1>
	<div class="container">
	<p id="success"></p>
	<div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Gerer <b>Etudiant</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEtudiantModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">add</i> <span>Ajouter nouveau etudiant</span></a>					
					</div>
                </div>
            </div>
	<?php
	$etudiants=$client->__soapCall('lister',array());
	if(!empty($etudiants->return))
	{
	?>
	<table class='table table-borderless table-striped table-earning' border="1" align="center">
		<thead>
		<tr>
			
			<th>ID</th>
			<th>NOM</th>
			<th>PRENOM</th>
			<th>LOGIN</th>
			<th>PASSWORD</th>
			<th>ACTION</th>
		</tr></thead><?php
		if(!is_array($etudiants->return))
		{
			?>
				<tbody>
			<tr>
				<td><?= $etudiants->return->id ?></td>
				<td><?= $etudiants->return->nom ?></td>
				<td><?= $etudiants->return->prenom ?></td>
				<td><?= $etudiants->return->login ?></td>
				<td><?= $etudiants->return->password ?></td>
				<td>
                      <a href="gestion_etudiant.php?id=<?php echo $etudiants->return->id ?>" ><button class="supprime" name="trash" type="button" > Delete</button>
                      </a>
                        <a href="#editEmployeeModal" onclick="window.location.hash='editEmployeeModal'+'?update=<?php echo $etudiants->return->id ?>&prenom=<?php echo $etudiants->return->prenom?>&nom=<?php echo $etudiants->return->nom ?>&login=<?php echo $etudiants->return->login?>&password=<?php echo $etudiants->return->password?>'"class="edit" data-toggle="modal"><button type="button" >Edit </button></a>
                      </td>
				<tbody>
			</tr>
				</tbody>
			<?php
		}
		else
		{
			foreach ($etudiants->return as  $etudiant) {
				?>
				<tbody>
				<tr>
				<td><?= $etudiant->id ?></td>
				<td><?= $etudiant->nom ?></td>
				<td><?= $etudiant->prenom ?></td>
				<td><?= $etudiant->login ?></td>
				<td><?= $etudiant->password ?></td>
				<td>
                      <a href="gestion_etudiant.php?id=<?php echo $etudiant->id ?>" class="delete" data-toggle="modal"><button class="supprime" name="trash" type="button" > Delete</button>
                      </a>
                        <a href="#editEmployeeModal" onclick="window.location.hash='editEmployeeModal'+'?update=<?php echo $etudiant->id ?>&prenom=<?php echo $etudiant->prenom ?>&nom=<?php echo $etudiant->nom ?>&login=<?php echo $etudiant->login ?>&password=<?php echo $etudiant->password ?>'"class="edit" data-toggle="modal"><button type="button" >Edit </button></a>
                      </td>
				</tr>
				 <?php  
                    if(isset($_GET["id"]) && $_GET["id"] != ""){
                        $clientSOAP = new SoapClient("http://localhost:8585/GestionEtudiantWs?wsdl");
                        $parameters = new stdClass();
                        $parameters->id = $_GET["id"];
                        $result = $clientSOAP->__soapCall("supprimerEtudiant", array($parameters));
                        $_GET["id"] = "";
                        $_GET["id"] = null;
                        header("Location: gestion_etudiant.php");
                    }
                    ?>
				</tbody>

				<?php
			}
		}?>
	</table>
</div>
</div>
	<?php
	}
	else
	{
		echo "liste vide";
	}
?>


<div id="addEtudiantModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="gestion_etudiant.php">
					<div class="modal-header">						
						<h4 class="modal-title">Ajouter Etudiant</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>nom</label>
							<input type="text" id="nom" name="nom" class="form-control" required>
						</div>
						<div class="form-group">
							<label>prenom</label>
							<input type="text" id="prenom" name="prenom" class="form-control" required>
						</div>
						<div class="form-group">
							<label>login</label>
							<input type="login" id="login" name="login" class="form-control" required>
						</div>
						<div class="form-group">
							<label>password</label>
							<input type="password" id="password" name="password" class="form-control" required>
						</div>
						
										
					</div>
					<div class="modal-footer">
					    <input type="hidden" value="1" name="type">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<button type="submit" class="btn btn-success" id="btn-add">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>



	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post">
					<div class="modal-header">						
						<h4 class="modal-title">Edit utilisateur</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					</div>
					<div class="modal-body">
						<input type="hidden" id="id" name="id" class="form-control" required>					
						<div class="form-group">
							<label>Nom</label>
							<input type="text" id="nom" name="nom" class="form-control" required>
						</div>
						
						<div class="form-group">
							<label>Prenom</label>
							<input type="prenom" id="prenom" name="prenom" class="form-control" required>
						</div>
						<div class="form-group">
							<label>login</label>
							<input type="login" id="login" name="login" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" id="password" name="password" class="form-control" required>
						</div>	
					</div>
					<div class="modal-footer">
					<input type="hidden" value="2" name="type">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<button type="submit" class="btn btn-info" id="update">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>