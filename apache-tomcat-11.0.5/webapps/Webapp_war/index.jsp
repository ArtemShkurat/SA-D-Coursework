<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title> Company Comparator </title>
  </head>
  <body>
    <h1> Enter the companies stock symbols </h1>

    <form action="hello-servlet" method="post">
      <label for="company1"> 1st company: </label>
      <input type="text" id="company1" name="company1" required />
      <br/><br/>

<%--      <label for="company2"> 2nd company: </label>--%>
<%--      <input type="text" id="company2" name="company2" required />--%>
<%--      <br/><br/>--%>

      <button type="submit">Submit</button>
    </form>
  </body>
</html>