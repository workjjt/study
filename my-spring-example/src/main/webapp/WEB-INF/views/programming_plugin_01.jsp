<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./common/top.jsp"%>

		<!-- middle -->
		<div class="middle">
			<div class="row-fluid">
				<div class="well span3">
					<%@ include file="./common/programming_sub_menu.jsp"%>
				</div>
				<div class="well span9">
					<h2>Light Box Test!!</h2>
					<!-- -->
					<div class="example">
						<ul class="thumbnails">
							<li class="span4">
								<a data-toggle="lightbox" href="#demoLightbox" class="thumbnail"> 
									<img src="${contextRoot}/resources/bootstrap/img/bootstrap-mdo-sfmoma-01.jpg" alt="Click to view the lightbox">
								</a>
							</li>
							<li class="span4">
								<a data-toggle="lightbox" href="#demoLightbox" class="thumbnail"> 
									<img src="${contextRoot}/resources/bootstrap/img/bootstrap-mdo-sfmoma-01.jpg" alt="Click to view the lightbox">
								</a>
							</li>
							<li class="span4">
								<a data-toggle="lightbox" href="#demoLightbox" class="thumbnail"> 
									<img src="${contextRoot}/resources/bootstrap/img/bootstrap-mdo-sfmoma-01.jpg" alt="Click to view the lightbox">
								</a>
							</li>
						</ul>
						<div id="demoLightbox" class="lightbox hide fade" tabindex="-1" role="dialog" aria-hidden="true">
							<div class='lightbox-header'>
								<button type="button" class="close" data-dismiss="lightbox" aria-hidden="true">&times;</button>
							</div>
							<div class='lightbox-content'>
								<img src="${contextRoot}/resources/bootstrap/img/bootstrap-mdo-sfmoma-01.jpg">
								<div class="lightbox-caption">
									<p>Your caption here</p>
								</div>
							</div>
						</div>
					</div>
					<!-- -->
				</div>
			</div>
		</div>
		
<%@ include file="./common/bottom.jsp"%>
