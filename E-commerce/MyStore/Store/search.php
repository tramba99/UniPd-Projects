<?php
	session_start();
?>
<html>
<head> 
	<title>Search</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- latest compiled and minified CSS -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css">
	<!-- jquery library -->
	<script type="text/javascript" src="bootstrap/js/jquery-3.2.1.min.js"></script>
	<!-- Latest compiled and minified javascript -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<!-- External CSS -->
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<?php
	require 'header.php';
?>
		<center>
		<br><br><br> <h1> <b> SEARCH </b></h1> <br>
		<h4> The result of your search is: </h4> <br>
		
		<?php
			require 'connection.php';
			global $name;
			
			/*$host = 'localhost'; // HOST = IP server Mysql
			$user = 'root'; // USER = Nome utente databse
			$password = ''; // PASSWORD = Password utente databse
			$nome_database = 'mystore';

			$connessione = mysqli_connect($host, $user, $password) or die ("Impossibile connettersi al server"); //Server connection

			mysqli_select_db($connessione, $nome_database) or die ("Impossibile connettersi al database"); //Database connection*/
			
			if (isset($_POST['search'])) 
			{
				$name = $_POST['search'];
			}
			
			$query = "SELECT id, name, price FROM items WHERE name='$name'";
			$result = mysqli_query($con, $query);
			$res = mysqli_query($con, $query);
			if (mysqli_fetch_array($result) == null)
			{
				echo "Please, insert a valid item!";
			}
			else
			{
				while($dati = mysqli_fetch_array($res))
				{
					echo "<br> ID: ", $dati['id'], "<br>";
					echo "Product: ", $dati['name'], "<br>";
					echo "Price: ", $dati['price'], "<br>";
				}
			}
		?>
			
		</center>
</body>
</html>