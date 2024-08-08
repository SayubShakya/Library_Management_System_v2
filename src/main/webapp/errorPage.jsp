<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4; 
        }

        .error-message {
            text-align: center;
            padding: 50px;
            background-color: #f8d7da; 
            color: #721c24; 
            border: 1px solid #f5c6cb; 
            border-radius: 5px;
            margin: 20px;
            max-width: 600px;
            margin-left: auto;
            margin-right: auto;
        }

        .error-message h1 {
            font-size: 2em;
            margin-bottom: 20px;
        }

        .error-message p {
            font-size: 1.2em;
            margin-bottom: 30px;
        }

        .error-message .btn-home {
            display: inline-block;
            padding: 10px 20px;
            font-size: 1em;
            color: #fff;
            background-color: #007bff; 
            border: none;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .error-message .btn-home:hover {
            background-color: #0056b3; 
        }
    </style>
</head>
<body>
    <div class="error-message">
        <h1>Oops! Something went wrong.</h1>
        <p>We couldn't change your password. Please enter correct password to change new password.</p>
        <a href="StudentDash.jsp" class="btn-home">Go to Dashboard</a>
    </div>
</body>
</html>
