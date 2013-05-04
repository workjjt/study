<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<!-- top -->
		<div class="top">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner ">
					<a class="brand" href="${contextRoot}">Project name</a>
					<ul class="nav">
						<li class="divider-vertical"></li>
						<li id="menu"><a href="<spring:url value="/" htmlEscape="true" />">Home</a></li>
						<li><a href="${contextRoot}/about">About</a></li>
						<li><a href="${contextRoot}/programming">Programming</a></li>
						<!-- Read about Bootstrap dropdowns at http://twitter.github.com/bootstrap/javascript.html#dropdowns -->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Photo<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-search pull-right">
						<input type="text" class="search-query" placeholder="Search">
					</form>
				</div>
			</div>
		</div>