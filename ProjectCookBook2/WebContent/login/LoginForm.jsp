<!doctype html>
<html>
<head>
<meta charset="utf-8">

<link href="LoginStyles.css" rel="stylesheet" type="text/css">
</head>
<style>
* {
  box-sizing: border-box;
}
body {
  font-family: 'open sans', helvetica, arial, sans;
  background: url(http://images.huffingtonpost.com/2015-03-27-1427496203-1352796-bigstockWoodenspoonandingredientso76325474.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
.log-form {
  width: 40%;
  min-width: 320px;
  max-width: 475px;
  background: #fff;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.25);
}
@media (max-width: 40em) {
  .log-form {
    width: 95%;
    position: relative;
    margin: 2.5% auto 0 auto;
    left: 0%;
    -webkit-transform: translate(0%, 0%);
    -moz-transform: translate(0%, 0%);
    -o-transform: translate(0%, 0%);
    -ms-transform: translate(0%, 0%);
    transform: translate(0%, 0%);
  }
}
.log-form form {
  display: block;
  width: 100%;
  padding: 2em;
}
.log-form h2 {
  color: #5d5d5d;
  font-family: 'open sans condensed';
  font-size: 1.35em;
  display: block;
  background: #2a2a2a;
  width: 100%;
  text-transform: uppercase;
  padding: .75em 1em .75em 1.5em;
  box-shadow: inset 0px 1px 1px rgba(255, 255, 255, 0.05);
  border: 1px solid #1d1d1d;
  margin: 0;
  font-weight: 200;
}
.log-form input {
  display: block;
  margin: auto auto;
  width: 100%;
  margin-bottom: 2em;
  padding: .5em 0;
  border: none;
  border-bottom: 1px solid #eaeaea;
  padding-bottom: 1.25em;
  color: #757575;
}
.log-form input:focus {
  outline: none;
}
.log-form .btn {
  display: inline-block;
  background: #1fb5bf;
  border: 1px solid #1ba0a9;
  padding: .5em 2em;
  color: white;
  margin-right: .5em;
  box-shadow: inset 0px 1px 0px rgba(255, 255, 255, 0.2);
}
.log-form .btn:hover {
  background: #23cad5;
}
.log-form .btn:active {
  background: #1fb5bf;
  box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.1);
}
.log-form .btn:focus {
  outline: none;
}
.log-form .forgot {
  color: #33d3de;
  line-height: .5em;
  position: relative;
  top: 2.5em;
  text-decoration: none;
  font-size: .75em;
  margin: 0;
  padding: 0;
  float: right;
}
.log-form .forgot:hover {
  color: #1ba0a9;
}

</style>
<body>


<div class="log-form">
  <h2>Login to your account</h2>
  <form method ="post" action="${pageContext.request.contextPath}/LoginServlet">
  <div style="color: #FF0000;">${dataError}</div>
    <input type="text" title="username" placeholder="username" name="username" />
    <input type="password" title="username" placeholder="password" name="password" />
    <button type="submit" class="btn">Login</button>
  </form>
  <form method="get" action="RegisterForm.jsp">
  <input type="submit" value="You dont have a profile yet?">
  </form>
</div><!--end log form -->
</body>
</html>