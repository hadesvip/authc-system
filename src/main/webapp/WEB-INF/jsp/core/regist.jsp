<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include  file="../base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Neon Admin Panel" />
	<meta name="author" content="" />

	<title>Neon | Register</title>

	<link rel="stylesheet" href="${ctx}/resources/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
	<link rel="stylesheet" href="${ctx}/resources/assets/css/font-icons/entypo/css/entypo.css">
	<link rel="stylesheet" href="${ctx}/resources/assets/css/bootstrap.css">
	<link rel="stylesheet" href="${ctx}/resources/assets/css/neon-core.css">
	<link rel="stylesheet" href="${ctx}/resources/assets/css/neon-theme.css">
	<link rel="stylesheet" href="${ctx}/resources/assets/css/neon-forms.css">
	<link rel="stylesheet" href="${ctx}/resources/assets/css/custom.css">

	<script src="${ctx}/resources/assets/js/jquery-1.11.0.min.js"></script>
	<script>$.noConflict();</script>

	<!--[if lt IE 9]><script src="${ctx}/resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="${ctx}/resources/https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="${ctx}/resources/https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->


</head>
<body class="page-body login-page login-form-fall" data-url="http://neon.dev">


<!-- This is needed when you send requests via Ajax -->
<script type="text/javascript">
var baseurl = '';
</script>
	
<div class="login-container">
	
	<div class="login-header login-caret">
		
		<div class="login-content">
			
			<a href="${ctx}/resources/index.html" class="logo">
				<img src="${ctx}/resources/assets/images/logo@2x.png" width="120" alt="" />
			</a>
			
			<p class="description">免费注册,免费使用</p>
			
			<!-- progress bar indicator -->
			<div class="login-progressbar-indicator">
				<h3>43%</h3>
				<span>logging in...</span>
			</div>
		</div>
		
	</div>
	
	<div class="login-progressbar">
		<div></div>
	</div>
	
	<div class="login-form">
		
		<div class="login-content">
			
			<form method="post" role="form" id="form_register">
				
				<div class="form-register-success">
					<i class="entypo-check"></i>
					<h3>You have been successfully registered.</h3>
					<!-- <p>We have emailed you the confirmation link for your account.</p> -->
				</div>
				
				<div class="form-steps">
					
					<div class="step current" id="step-1">
					
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<i class="entypo-user"></i>
								</div>
								
								<input type="text" class="form-control" name="name" id="name" placeholder="Full Name" autocomplete="off" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<i class="entypo-phone"></i>
								</div>
								
								<input type="text" class="form-control" name="phone" id="phone" placeholder="Phone Number" data-mask="phone" autocomplete="off" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<i class="entypo-calendar"></i>
								</div>
								
								<input type="text" class="form-control" name="birthdate" id="birthdate" placeholder="Date of Birth (DD/MM/YYYY)" data-mask="date" autocomplete="off" />
							</div>
						</div>
						
						<div class="form-group">
							<button type="button" data-step="step-2" class="btn btn-primary btn-block btn-login">
								<i class="entypo-right-open-mini"></i>
								Next Step
							</button>
						</div>
						
						<div class="form-group">
							Step 1 of 2
						</div>
					
					</div>
		
					<div class="step" id="step-2">
					
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<i class="entypo-user-add"></i>
								</div>
								
								<input type="text" class="form-control" name="username" id="username" placeholder="Username" data-mask="[a-zA-Z0-1\.]+" data-is-regex="true" autocomplete="off" />
							</div>
						</div>
					
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<i class="entypo-mail"></i>
								</div>
								
								<input type="text" class="form-control" name="email" id="email" data-mask="email" placeholder="E-mail" autocomplete="off" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<i class="entypo-lock"></i>
								</div>
								
								<input type="password" class="form-control" name="password" id="password" placeholder="Choose Password" autocomplete="off" />
							</div>
						</div>
						
						<div class="form-group">
							<button type="submit" class="btn btn-success btn-block btn-login">
								<i class="entypo-right-open-mini"></i>
								Complete Registration
							</button>
						</div>
						
						<div class="form-group">
							Step 2 of 2
						</div>
						
					</div>
					
				</div>
				
			</form>
			
			
			<div class="login-bottom-links">
				
				<a href="${ctx}/user/login_ui" class="link">
					<i class="entypo-lock"></i>
					Return to Login Page
				</a>
				
				<br />
				
				<a href="${ctx}/resources/#">ToS</a>  - <a href="${ctx}/resources/#">Privacy Policy</a>
				
			</div>
			
		</div>
		
	</div>
	
</div>


	<!-- Bottom scripts (common) -->
	<script src="${ctx}/resources/assets/js/gsap/main-gsap.js"></script>
	<script src="${ctx}/resources/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
	<script src="${ctx}/resources/assets/js/bootstrap.js"></script>
	<script src="${ctx}/resources/assets/js/joinable.js"></script>
	<script src="${ctx}/resources/assets/js/resizeable.js"></script>
	<script src="${ctx}/resources/assets/js/neon-api.js"></script>
	<script src="${ctx}/resources/assets/js/jquery.validate.min.js"></script>
	<script src="${ctx}/resources/assets/js/neon-register.js"></script>
	<script src="${ctx}/resources/assets/js/jquery.inputmask.bundle.min.js"></script>


	<!-- JavaScripts initializations and stuff -->
	<script src="${ctx}/resources/assets/js/neon-custom.js"></script>


	<!-- Demo Settings -->
	<script src="${ctx}/resources/assets/js/neon-demo.js"></script>

</body>
</html>