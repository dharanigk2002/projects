<?php

$conn=mysqli_connect('localhost:3306', 'root',' ','student') or die('Connection failed'.mysqli_connect_error());

$regno=$_GET['reg'];

$sql1='SELECT * FROM std WHERE `reg_no`=" '.$regno. ' "; ';

$result=mysqli_query($conn,$sql1); 

if(isset($_POST['upd'])){
    $regno=$_POST['regno'];

    $name=$_POST['name'];

    $dob=$_POST['dob'];

    $board=$_POST['bp'];

    $mno1=$_POST['mno1'];

    $mno2=$_POST['mno2'];

    $sql1='SELECT * FROM std where reg_no=" '.$regno. ' " ;';

    $result=mysqli_query($conn, $sql1);


    if(mysqli_num_rows($result)==0){
        $sql2="INSERT INTO std VALUES('$name', '$mno1', '$mno2','$dob', '$board', '$regno')";
        $result=mysqli_query($conn,$sql2);
    }
else{

    if($mno1 && $mno2)
        $sql2="UPDATE `std` set
        name=".$name.",mobile_no1=". $mno1.",mobile_no2=" .$mno2.", Date_of_birth=".$dob.",reg_no=".$regno.", Board_point=".$board." where reg_no=".$regno.";"; 
    else if($mno1)
        $sql2="UPDATE std set name=".$name.",mobile_no1=". $mno1.", Date_of_birth=".$dob.",reg_no=".$regno.", Board_point=".$board." where reg_no=".$regno.";";
    else if($mno2)
        $sql2="UPDATE std set name=".$name.",mobile_no2=".$mno2.",Date_of_birth=".$dob.",reg_no=".$regno.", Board_points=".$board." where reg_no=".$regno.";"; 
    $result=mysqli_query($conn,$sql2);
}
if($result){ 
    header("location:update.php" );
    echo "<script>alert('Updated successfully');</script>";
}
}
?>