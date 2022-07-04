<%-- 
    Document   : hellouser
    Created on : 03/07/2022, 22:07:49
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resposta do Servidor</title>
        <!-- CSS only -->
        <style>
            .bola {
                border-radius: 50%;
                display: inline-block;
                height: 100px;
                width: 100px;
                border: 1px solid #000000;
                background-color: ${cor};}
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
        <div class="px-4 py-5 my-5 text-center">
            <h1 class="display-5 fw-bold">${mensagem}</h1>
            <div class="col-lg-6 mx-auto">
                <h2 class="lead mb-4 fw-bold"">Sua cor favorita:</h2>
                <div class="bola"></div>
                
                <div class="row align-items-md-stretch">
                    <div class="col-md-6">
                      <div class="h-100 p-5 text-white bg-dark rounded-3">
                        <h2>Horário Local:</h2>
                        <p id="horariolocal"></p>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="h-100 p-5 bg-light border rounded-3">
                        <h2>Horário ${local}:</h2>
                        <p id="horarioescolhido"></p>
                      </div>
                    </div>
                </div>
            </div>
        </div>
        
        
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <script>
            var horariolocal = document.getElementById("horariolocal");
            var horarioescolhido = document.getElementById("horarioescolhido");
            
            function refreshTime() {
              var dateString = new Date().toLocaleString("pt-BR", {timeZone: "America/Sao_Paulo"});
              var formattedString = dateString.replace(", ", " - ");
              horariolocal.innerHTML = formattedString;
            }
            
            function refreshTimeDois() {
              var dateString = new Date().toLocaleString("pt-BR", {timeZone: "${zona}" });
              var formattedString = dateString.replace(", ", " - ");
              horarioescolhido.innerHTML = formattedString;
            }
            
            setInterval(refreshTime, 1000);
            setInterval(refreshTimeDois, 1000);
        </script>
    </body>
</html>
