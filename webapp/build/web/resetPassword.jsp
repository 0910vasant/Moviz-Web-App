<%-- 
    Document   : resetPassword
    Created on : Mar 11, 2024, 9:44:45 PM
    Author     : AMD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Reset Page</title>
        
        <style>
            center{
              position: absolute;
              top: 50%;
              left: 50%;
              transform: translate(-50%, -50%);
              width: 400px;
              background: white;
              border-radius: 10px;
              box-shadow: 10px 10px 15px rgba(0,0,0,0.05);
            }
            
            .center form{
              padding: 0 40px;
              box-sizing: border-box;z
            }
        </style>
        
    </head>
    <body class="d-flex align-items-center py-4 bg-body-tertiary">
        
        <div class="center">
            <main class="form-signin w-100 m-auto">
            <form action="resetPassword" method="post" >
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Old</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3 form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            </main>
        </div>
        
    </body>
</html>
