<?php
//get_data
$con=mysqli_connect("localhost","id18017136_mediplus2798","2o\H%]<}~Vb}5{ML","id18017136_mediplus");
  $sql = "SELECT id,std_name FROM register";
 $result = mysqli_query($con,$sql);
 if ($result->num_rows > 0) {
    $medicine_Type_arr = array();
    $medicine_Type_arr['data'] =array();
  // output data of each row
  while($row = $result->fetch_assoc()) {
    //echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
        $medicine_Type_item = array(
            'id' => $row["id"],
            'std_name' => $row["std_name"]
        );
        //Push to "data"
        array_push($medicine_Type_arr['data'], $medicine_Type_item);
    //Turn to JSON & output
   
  }
  echo json_encode($medicine_Type_arr);
} else {
  echo "0 results";
}
$conn->close();
?>