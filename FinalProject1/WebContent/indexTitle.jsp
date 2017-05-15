
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.Title"%>
<%@include file="inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/addTitle?type=load" class="button">
			<span>Add Title<img src="<%=request.getContextPath() %>/images/plus-small.gif" alt="Add Title"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
	<%
	if(request.getParameter("msg")!=null){
		String msg = request.getParameter("msg");
		if("del1".equals(msg)){
			out.print("Delete Title complete!");
		}else{
			out.print("Delete Title not complete!");
		}
	}
	%>
		<h2><span>List Title</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID Title</th>
						<th>Title</th>
						<th style="width:20%">Path</th>
						<th style="width:20%">Meaning</th>
					</tr>
				</thead>
				<tbody>
				<%
				Object lst = request.getAttribute("arraylistTitle");
					List<Title> alTitle = lst != null ? (List<Title>) lst : new ArrayList<Title>();
				for(Title title:alTitle){
				%>
					<tr>
						<td><a href=""><%=title.getIDtitle()%></a></td>
						<td><a href="<%=request.getContextPath() %>/indexWord"><%=title.getTitle() %></a></td>
						<td><%=title.getPath() %></td>
						<td><%=title.getMeaning() %></td>
						<td align="center">
							<a href="<%=request.getContextPath() %>/editTitle?ttID=<%=title.getIDtitle()%>">Change<img src="<%=request.getContextPath() %>/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/deleteTitle?ttID=<%= title.getIDtitle()%>">Delete <img src="<%=request.getContextPath() %>/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
					<%
					}
					%>
					
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<span>Page:</span> 
				<span class="current">1</span>  
				<span>|</span> 
				<a href="">2</a> 
				<span>|</span> 
				<a href="">3</a> 
				<span>|</span> 
				<a href="">4</a> 
				<span>|</span> 
				<a href="">5</a> 
				<span>|</span> 
				<a href="">6</a> 
				<span>|</span> 
				<a href="">7</a>
				<span>|</span> 
				<a href="">8</a> 
				<span>|</span> 
				<a href="">9</a>
				<span>|</span> 
				<a href="">10</a>   
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="inc/footer.jsp" %> 