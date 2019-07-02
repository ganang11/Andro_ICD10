<?php
include_once "koneksi.php";

$Index_kode = $_GET['Index_kode'];

$sql = "select * from icd_10 where Index_kode = '$Index_kode'";
 
$result = mysqli_query($con, $sql);
 
while(($row = mysqli_fetch_assoc($result)) == true){
 
 $data[]=$row;
}
echo json_encode($data);
 
?>