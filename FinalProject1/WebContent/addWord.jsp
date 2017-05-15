<%@page import="bean.Title"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">

		 <h2><span>Add Word</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/addWord" enctype="multipart/form-data" method="post"> <!-- id 3 -->
				<p>
					<label>ID Title</label>
					<input type="text" name="IDTitle" value="" class="input-medium" />
				</p>
				<p>
					<label>Word</label>
					<input type="text" name="Word" value="" class="input-medium" />
				</p>
				<p>
					<label>Meaning</label>
					<input type="text"  name="Meaning" value="" class="input-medium" />
				</p>
				<p>
					<label>Picture</label>
					<input type="file" name="Picture" id="uploaded_file1">
					
				</p>
				<p>
					<label>Sound</label>
					<input type="file"  name="Sound" value="" id="uploaded_file"/>
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Add" /> 
					<input class="submit-gray" name="reset" type="reset" value="Reset" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="inc/footer.jsp" %> 