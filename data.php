<?php 
	/* ===== www.dedykuncoro.com ===== */
	include_once "koneksi.php";

	$query = mysqli_query($con, "SELECT * FROM icd_10 ORDER BY Kode ASC");
	
	$json = array();	
	
	while($row = mysqli_fetch_assoc($query)){
		$json[] = $row;
	}
	
	echo json_encode($json);
	
	mysqli_close($con);
?>