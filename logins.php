<?php

	define('HOST','localhost');
	define('USER','root');
	define('PASS','');
	define('DB','pbbi_db');

	$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
	
	class usr{}
	
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	if ((empty($username)) || (empty($password))) { 
	$response = new usr();
	$response->success = 0;
	$response->message = "Kolom tidak boleh kosong"; 
	die(json_encode($response));
	}
	
	$query = mysqli_query($con, "SELECT * FROM user WHERE email='$username' AND password='$password'");
	
	$row = mysqli_fetch_array($query);
	
	if (!empty($row)){
		$response = new usr();
		$response->success = 1;
		$response->message = "Selamat datang ".$row['email'];
		$response->id = $row['id'];
		$response->username = $row['email'];
		die(json_encode($response));
		
	} else { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Username atau password salah";
		die(json_encode($response));
	}
	
	mysqli_close($con);

?>