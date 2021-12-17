<?php
$con=mysqli_connect("localhost","id18017136_mediplus2798","2o\H%]<}~Vb}5{ML","id18017136_mediplus");
    $std_id = $_POST["std_id"];
    $std_name = $_POST["std_name"];
    $batch = $_POST["batch"];
    $section = $_POST["section"];
    $std_password = $_POST["std_password"];
    $sql = "INSERT INTO register(std_id,std_name,batch,section,std_password)VALUES ('$std_id','$std_name','$batch','$section','$std_password')";

  $result = mysqli_query($con,$sql);
  if($result){
     echo "register successfull";

 }
 else{
     echo"some error occured";
 }





?>