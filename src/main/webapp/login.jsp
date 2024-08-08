<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href=AdminSignIn.css>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>


	<div class="container" id="container">
    <div class="form-container sign-in-container">
<form action="Validate" method="post">
            <h1>Sign In</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fa fa-facebook"></i></a>
                <a href="#" class="social"><i class="fa fa-google"></i></a>
                <a href="#" class="social"><i class="fa fa-linkedin"></i></a>
            </div>
            <span>or use your account</span>
             <input type="text" name="username" placeholder="Username" required>
    		<input type="password" name="password" placeholder="Password" required>	
            
           		   <div class="checkbox-container">
            <input type="checkbox" name="chkSave" value="yes" id="chkSave"> 
            <label for="chkSave">Remember</label>
        			</div>
   			 <button type="submit">Sign In</button>
   			 
        			
        </form>
    </div>
    
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-right">
            <h2>Admin</h2>
                <img src="admin.png" alt="Overlay Image" class="overlay-image">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                 <a href="index.html">Home</a>
                
            </div>            
        </div>
    </div>
</div>

</body>
</html>
