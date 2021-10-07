<?php
	session_start();
?>
<html>
<head> 
	<title>Contact Us</title>
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
		<br><br><br> <h1> <b> CONTACT US </b></h1> <br>
		<h4> Fill the following form to send us a message: </h4> <br>

		<table border ="0">
			
			<form method="post" action="contacts.php">
				<tr> 
					<td> Name: </td>
					<td> <input type="text" name="name" style="width:400px"> <br> </td> 
				</tr>
				<tr> <td colspan="2"> <br></td> </tr>
				<tr> 
					<td> Surname: </td>
					<td> <input type="text" name="surname" style="width:400px"> </td>
				</tr>
				<tr> <td colspan="2"> <br></td> </tr>
				<tr>
					<td> E-mail: </td>
					<td> <input type="email" name="email" style="width:400px"> </td>
				</tr>
				<tr> <td colspan="2"> <br></td> </tr>
				<tr>
					<td> Telephone: </td>
					<td> <input type="tel" name="telephone" style="width:400px"> </td>
				</tr> 
				<tr> <td colspan="2"> <br></td> </tr>
				<tr> 
					<td> Message: </td>
					<td> <textarea  name="message" style="width:400px" rows="5"> </textarea> </td>
				</tr> 
				<tr> <td colspan="2"> <br></td> </tr>
				<tr>
					<td> </td> 
					<td align="right"> <input type="submit" class="glyphicon glyphicon-default" value="Submit" id="submit"> </td>
					<td> <input type="reset" class="glyphicon glyphicon-default" value="Reset" id="reset"> </td>
				</tr>
			<?php
				global $name;
				global $surname;
				global $email;
				global $telephone;
				global $message;
		
				require 'connection.php';
				
				/*$host = 'localhost'; // HOST = IP server Mysql
				$user = 'root'; // USER = Nome utente databse
				$password = ''; // PASSWORD = Password utente databse
				$nome_database = 'mystore';

				$connessione = mysqli_connect($host, $user, $password) or die ("Impossibile connettersi al server"); //Server connection

				mysqli_select_db($connessione, $nome_database) or die ("Impossibile connettersi al database"); //Database connection*/
				
				if (isset($_POST['name'])) 
				{
					$name = $_POST['name'];
				}
				if (isset($_POST['surname'])) 
				{
					$surname = $_POST['surname'];
				}
				if (isset($_POST['email'])) 
				{
					$email = $_POST['email'];
				}
				if (isset($_POST['telephone'])) 
				{
					$telephone = $_POST['telephone'];
				}
				if (isset($_POST['message'])) 
				{
					$message = $_POST['message'];
				}
				
				$toinsert = "INSERT INTO contacts
								(Name, Surname, Email, Telephone, Message)
								VALUES
								('$name',
								'$surname',
								'$email',
								'$telephone',
								'$message')";
				
				if ($name != "" && $surname != "" && $email != "" && $telephone != "" && $message != "")
				{
					$result = mysqli_query($con, $toinsert);
					if($result)
					{
						echo "Message sent!";
					}
					else
					{
						echo "Message not sent!";
					}
				}
				else 
				{
					echo "Please, fill all fields!";
				}
			?>
			</form>
		</table>
	
			<div style="display:none;">
				<?php
					$query = "SELECT * FROM contacts";
					$risultato = mysqli_query($con, $query);
					
					while ($dati = mysqli_fetch_array($risultato))
					{
						echo "<br> Name: ", $dati['Name'], "<br>";
						echo "Surname: ", $dati['Surname'], "<br>";
						echo "E-mail: ", $dati['Email'], "<br>";
						echo "Telephone: ", $dati['Telephone'], "<br>";
						echo "<br> The message that you have sent is:", $dati['Message'];
					}
				?> 
			</div>
		</center>
</body>
</html>