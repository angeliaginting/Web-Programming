<?php
//to read a POST parameter sent by form use the $_POST global array.
//the index of the $_POST is the name of the HTML element we want to read.
$full_name = $_POST['full_name'];
$email = $_POST['email'];
//the above line reads the value in the HTML element named 'full_name'.

//let's print the value of $full_name variable using echo() function.
echo("your full name is <b>{$full_name}</b>");
if ($email == '')
{
    echo("(no email is provided)");
}
else
{
    echo("your email is <b>{$email}</b>");
}