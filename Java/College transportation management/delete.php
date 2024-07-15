<?php

include "update.php";
$conn=mysqli_connect('localhost:3306', 'root',' ', 'student') or die('Connection failed'.mysqli_connect_error());

$regno=$_GET['reg'];

$sql1='DELETE FROM std WHERE reg_no="'.$regno.'";';
$sql2='DELETE FROM clg_bus WHERE reg_no='.$regno.'";';

$result1=mysqli_query($conn,$sql2);

$result=mysqli_query($conn,$sql1); 
if($result && $result1)
    header("location:update.php");

?>