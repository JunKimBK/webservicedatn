<%@page import="java.util.ArrayList"%>
<%@page import="bean.Word"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
	<%
		Word word = (Word) request.getAttribute("editWord");
	%>
		 <h2><span>Edit Word</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/editWord?wID=<%=word.getIDWord() %>" method="post"> <!-- id 3 -->
				<p>
					<label>ID Title</label>
					<input type="text" name="IDTitle" value="<%=word.getIDTitle() %>" class="input-medium" />
				</p>
				<p>
					<label>Word</label>
					<input type="text" name="Word" value="<%=word.getWord()%>" class="input-medium" />
				</p>
				<p>
					<label>Meaning</label>
					<input type="text"  name="Meaning" value="<%=word.getMeaning() %>" class="input-medium" />
				</p>
				<p>
					<label>Picture</label>
					<input type="text"  name="Picture" value="<%=word.getPicture() %>" class="input-medium" />
				</p>
				<p>
					<label>Sound</label>
					<input type="text"  name="Sound" value="<%=word.getSound() %>" class="input-medium" />
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