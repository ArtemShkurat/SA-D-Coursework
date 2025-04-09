<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Company Comparator</title>
        <style>
          .top-right-buttons {
            position: absolute;
            top: 20px;
            right: 20px;
          }

          .top-right-buttons form {
            display: inline;
            margin-left: 10px;
          }

          button {
            padding: 6px 12px;
            font-size: 14px;
          }
        </style>
    </head>
    <body>

        <!-- Login and Sign Up buttons -->
        <div class="top-right-buttons">
          <form action="login.jsp" method="get">
            <button type="submit">Login</button>
          </form>
          <form action="signup.jsp" method="get">
            <button type="submit">Sign Up</button>
          </form>
        </div>

        <h1>Enter the companies stock symbols</h1>

        <form action="display-graph" method="post">
          <label for="company1">1st company:</label>
          <input type="text" id="company1" name="company1" required />
          <br/><br/>

          <label for="company2">2nd company:</label>
          <input type="text" id="company2" name="company2" required />
          <br/><br/>

          <button type="submit">Submit</button>
        </form>
    </body>
</html>