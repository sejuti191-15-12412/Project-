<?php
$con=mysqli_connect("localhost","id18017136_mediplus2798","2o\H%]<}~Vb}5{ML","id18017136_mediplus");
 
 $std_id = $_POST["std_id"];
 $std_password=$_POST["std_password"];
 $sql = "SELECT * FROM register WHERE std_id = '$std_id' AND std_password ='$std_password'";
 $result = mysqli_query($con,$sql);
 if($result->num_rows > 0){
     echo "Logged in successfull";

 }
 else{
     echo"User not found";
 }

?>