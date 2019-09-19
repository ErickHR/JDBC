<%-- 
    Document   : login
    Created on : 18/09/2019, 01:51:19 PM
    Author     : BLANCO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <script>
            $(function(){
                
                $("#usr").on("keyup",function(){
                    $(".msg").text("");
                });
                
                 $("#psw").on("keyup",function(){
                    $(".msg").text("");
                });
                
            });
            
        </script>
        <style>
            .nuser{
                color: red;
                font-family: Arial, Helvetica, sans-serif;
                text-decoration: none; 
            }
             .nuser:hover{
                color: chocolate;
                font-family: Arial, Helvetica, sans-serif;
                text-decoration: underline; 
            }
            body {font-family: Arial, Helvetica, sans-serif;}

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            /* Center the image and position the close button */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: block; /* se cambio de none a block */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 30%; /* ancho de modal */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {-webkit-transform: scale(0)} 
                to {-webkit-transform: scale(1)}
            }

            @keyframes animatezoom {
                from {transform: scale(0)} 
                to {transform: scale(1)}
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body >
        <!--<button onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">xxxxLogin</button>-->
        <%
            String msg = (String) request.getAttribute("msg");

        %>
        <div id="id01" class="modal" >

            <form class="modal-content animate" action="validarUser" method="post">
                <div class="imgcontainer">
                    <img src="icon/user.png" alt="User"  >
                </div>

                <div class="container">
                    <label for="uname"><b>Usuario</b></label>
                    <input type="text" placeholder="Usuario" name="txtus"  id="usr"required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Password" name="txtpas"  id="psw" required>

                    <button type="submit">Entrar</button>
                    <label style="font-size: 12px; color: red">
                        <!--- mensaje  de error-->
                        <span class="msg"><%=msg != null ? msg : ""%></span>
                        
                    </label>
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="reset" class="cancelbtn">Cancel</button>
                    <span class="psw"><a href="#"  class="nuser">Nuevo usuario</a></span>
                </div>
            </form>
        </div>

    </body>
</html>
