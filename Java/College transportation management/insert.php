<?php

if($_SERVER['REQUEST_METHOD']="POST" && isset($_POST['submit']))
    $conn=mysqli_connect('localhost:3306','root',' ','student') or die('Connection failed'. mysqli_connect_error());

$regno=$_POST['regno'];

$name=$_POST['name'];

$dob=$_POST['dob'];

$board=$_POST['bpoint'];

$mno1=$_POST['mno1'];

$mno2=$_POST['mno2'];

$flag=1;

$sql1 = "SELECT * FROM `std` ";
$result=mysqli_query($conn, $sql); 
while($res=mysqli_fetch_assoc($result)){
    if(mysqli_num_rows($result) > 0){
        if($res['reg_no']==$regno){
            echo '<center class="h2 text-danger">Registration number already exists!!!</center>';
            echo '<a href="ctm.html" class="btn btn-info my-5"><=Back to login page</a>';
            $flag=0;
            break;
        }
    }
}
if($flag==1){
    $sql='INSERT INTO `std` VALUES("'.$name.'", "'.$mno1.'","'.$mno2.'", "'.$dob.'", "'.$board.'", "'.$regno.'");';
    $query=mysqli_query($conn,$sql);
}
?>