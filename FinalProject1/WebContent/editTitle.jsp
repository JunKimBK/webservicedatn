<%@page import="bean.Title"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
	<%
		Title tit = (Title)request.getAttribute("editTitle");
	
	%>
		 <h2><span>Edit Title</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/editTitle?ttID=<%=tit.getIDtitle() %>" method="post"> <!-- id 3 -->
				<p>
					<label>Title</label>
					<input type="text" name="Title" value="<%=tit.getTitle() %>" class="input-medium" />
				</p>
				<p>
					<label>Path</label>
					<input type="text" name="Path" value="<%=tit.getPath() %>" class="input-medium" />
				</p>
				<p>
					<label>Meaning</label>
					<input type="text"  name="Meaning" value="<%=tit.getMeaning() %>" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="edit" type="submit" value="Edit" /> 
					<input class="submit-gray" name="reset" type="reset" value="Reset" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="inc/footer.jsp" %> 