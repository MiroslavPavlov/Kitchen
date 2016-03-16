<!DOCTYPE html>
<html>
	<head>	
		<link href="css/style.css" rel="stylesheet" type="text/css" >
	</head>
	<style>
	body{
	background:url(https://d3ui957tjb5bqd.cloudfront.net/images/screenshots/products/10/106/106399/crsrxfllostehmuxwzqfkdarpcg0di40toehyl4mzmgrkmy3dpfzxttukvsmluvp-o.jpg?1399222059)  no-repeat center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
 	background-size: cover;
	font-family: 'Raleway', sans-serif;
}
.main {
	text-align: center;
	margin-top:2% ;
	margin-bottom:3%;
}

.content {
	width:80%;
	margin:0 auto;
}


	
.Regisration {
	width: 34%;
	text-align:center;
	margin: 0 auto;
	background:#20252D;
	border-radius:7px;
	-webkit-border-radius:7px;
	-moz-border-radius:7px;
	-o-border-radius:7px;
	padding-bottom: 3px;
}
.Regisration-head {
	 border-top-left-radius:7px;
	-webkit-border-top-left-radius:7px;
	-moz-border-top-left-radius:7px;
	-o-border-top-left-radius:7px;
	border-top-right-radius:7px;
	-webkit-border-top-right-radius:7px;
	-moz-border-top-right-radius:7px;
	-o-border-top-right-radius:7px;
	text-align: center;
	padding:1.6em 0;
	border: 1px solid rgba(0, 0, 0, 0.37);
	box-shadow: 0px 4px 10px 0px rgba(1, 3, 12, 0.33);
	-webkit-box-shadow: 0px 4px 10px 0px rgba(1, 3, 12, 0.33);
	-o-	box-shadow: 0px 4px 10px 0px rgba(1, 3, 12, 0.33);
	-moz-box-shadow: 0px 4px 10px 0px rgba(1, 3, 12, 0.33);
	position: relative;
}

.Regisration-head h2{
	color: #0C0D10;
	font-size: 33px;
	font-weight: 700;
	margin-left:20px;
	font-family: 'Raleway', sans-serif;
}
.Regisration form {
	text-align: center;
	margin:5% 0%;
	position:relative;
		
}
.Regisration form input[type="text"],.Regisration form input[type="password"]{
	font-size: 15px;
	outline: none;
	font-weight: 600;
	color:#8D8E8F;
	padding: 12px 12px;
	width:76%;
	border-top:1px solid #090B0D;
	border-right:2px solid #424549;
	border-bottom:2px solid #424549;
	border-left:1px solid #090B0D;
	margin: 10px 1em;
	border-radius:7px;
	-webkit-border-radius:7px;
	-moz-border-radius:7px;
	-o-border-radius:7px;
	background: #13161B;
	box-shadow: inset 0px 3px 0px 0px rgba(5, 5, 5, 0.15);
	-webkit-box-shadow: inset 0px 3px 0px 0px rgba(5, 5, 5, 0.15);
	-o-box-shadow: inset 0px 3px 0px 0px rgba(5, 5, 5, 0.15);
	-moz-box-shadow: inset 0px 3px 0px 0px rgba(5, 5, 5, 0.15);
	font-family: 'Raleway', sans-serif;

}


.Regisration form input[type="text"]:hover,.Regisration form input[type="password"]:hover{
	box-shadow: 0 0 1em #56AF00;
	-webkit-box-shadow: 0 0 1em #56AF00;
	-o-box-shadow: 0 0 1em #56AF00;
	-moz-box-shadow: 0 0 1em #56AF00;
}

.submit {
	text-align: center;
	margin: 2px 0;
}
.submit input[type="submit"]{
	color: #203500;
	cursor: pointer;
	border: none;
	font-weight: 900;
	outline: none;
	font-family: 'Raleway', sans-serif;
	padding: 14px 0px;
	width: 35%;
	font-size: 18px;
	transition: border-color 0.3s;
	-o-transition: border-color 0.3s;
	-ms-transition: border-color 0.3s;
	-moz-transition: border-color 0.3s;
	-webkit-transition: border-color 0.3s;
	border-radius: 4px;
    -webkit-border-radius: 4px;
    -o-border-radius: 4px;
    -moz-border-radius: 4px;
	
}
.submit-button input[type="submit"]{
	color: #203500;
	cursor: pointer;
	border: none;
	font-weight: 900;
	outline: none;
	font-family: 'Raleway', sans-serif;
	padding: 14px 0px;
	width: 35%;
	font-size: 18px;
	border-radius: 4px;
    -webkit-border-radius: 4px;
    -o-border-radius: 4px;
    -moz-border-radius: 4px;
    transition: border-color 0.3s;
	-o-transition: border-color 0.3s;
	-ms-transition: border-color 0.3s;
	-moz-transition: border-color 0.3s;
	-webkit-transition: border-color 0.3s;


}
	
	</style>
	<body>	
			
				<div class="main">
			    	
					<div  class="wrap">
						  <div class="Regisration">
						  	<div class="Regisration-head">
						    	<h2><span></span>Register</h2>
						 	 </div>
						  	<form method="post" action="${pageContext.request.contextPath}/RegisterServlet">
						  	<div style="color: #FF0000;">${usernameError}${emptyFieldError}${passConfirmation }</div>
						  	 	<input type="text" value="First Name" name="firstname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'First Name';}" >
						  		<input type="text" value="Last Name" name="lastname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Last Name';}" >
						  		<input type="text" value="Email Address" name="email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email Address';}" >
						  		<input type="text" value="User Name" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}" >
								<input type="password" value="Password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" >
								<input type="password" value="Confirm Password" name="passConf" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = ' Confirm Password';}" >			 
								<div class="submit">
									<input type="submit" value="Sign Me Up >" >
								</div>
									<div class="clear"> </div>
								
											
						  </form>
					      </div>
					
			      </div>
              </div>
	</body>
    
</html>


