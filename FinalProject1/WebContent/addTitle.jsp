<%@page import="bean.Title"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">

		 <h2><span>Add Title</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/addTitle" method="post" enctype="multipart/form-data"> <!-- id 3 -->
				<p>
					<label>Title</label>
					<input type="text" name="Title" value="" class="input-medium" />
				</p>
				<p>
					<label>Path</label>
					<input type="file" name="Path" id="uploaded_file">
				</p>
				<p>
					<label>Meaning</label>
					<input type="text"  name="Meaning" value="" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập Lại" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="inc/footer.jsp" %> 