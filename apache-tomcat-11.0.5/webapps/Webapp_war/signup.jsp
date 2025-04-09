<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up</title>
    </head>
    <body>
        <h2>Sign Up</h2>

        <form action="signup" method="post">
          <label for="username">Username:</label><br>
          <input type="text" id="username" name="username" required><br><br>

          <label for="email">Email:</label><br>
          <input type="email" id="email" name="email" required><br><br>

          <label for="password">Password:</label><br>
          <input type="password" id="password" name="password" required><br><br>

          <button type="submit">Sign up</button>
        </form>
    </body>
</html>