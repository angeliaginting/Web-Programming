<?php
$redirect_page = 'add_profile.html';
$redirect = TRUE;

if($redirect==TRUE){
    header('Location: '.$redirect_page);
}
//to read a POST parameter sent by form use the $_POST global array.
//the index of the $_POST is the name of the HTML element we want to read.
$full_name = $_POST['full_name'];
//the above line reads the value in the HTML element named 'full_name'
$email = $_POST['email'];
$action = $_POST['action'];

$host = "localhost";
$port = "5432";
$database = "profile_db";
$username = "pdbuser";
$password = "pdb0000";

$connection_string = "pgsql:host={$host};port={$port};dbname={$database};" . "user={$username};password={$password}";

if($action === "add_profile"){
    $query = "INSERT INTO profile(full_name, email)" . "VALUES (:full_name, :email)";
    echo("You did it.");
  }elseif($action === "edit_profile"){
    $query = "UPDATE profile SET full_name =:full_name WHERE email =:email";
    echo("Data has been changed.");
  }

$query = "INSERT INTO profile(full_name,email)" . "VALUES (:full_name, :email)";

$pdo = null;
try{
    //create a PDO object
    $pdo = new \PDO($connection_string);

    $pdo->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);

    $pstatement = $pdo->prepare($query);
    $pstatement->bindParam(":full_name", $full_name);
    $pstatement->bindParam(":email", $email);

    $success = $pstatement->execute();
}catch(\PDOException $exception){
    echo($exception->getMessage());
}

//disconnecting
$pdo = null;