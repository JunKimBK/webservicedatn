<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.Word"%>
<%@include file="inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/addWord?type=load" class="button">
			<span>Add Word<img src="<%=request.getContextPath() %>/images/plus-small.gif" alt="Add Word"></span>
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
			out.print("Delete Word complete!");
		}else{
			out.print("Delete Word not complete!");
		}
	}
	%>
		<h2><span>List Word</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID Word</th>
						<th>ID Title</th>
						<th style="width:20%">Word</th>
						<th style="width:20%">Meaning</th>
						<th style="width:20%">Picture</th>
						<th style="width:20%">Sound</th>
					</tr>
				</thead>
				<tbody>
				<%
				Object lst = request.getAttribute("arraylistWord");
					List<Word> alWord = lst != null ? (List<Word>) lst : new ArrayList<Word>();
				for(Word word:alWord){
				%>
					<tr>
						<td><a href=""><%=word.getIDWord()%></a></td>
						<td><%=word.getIDTitle() %></td>
						<td><%=word.getWord() %></td>
						<td><%=word.getMeaning() %></td>
						<td><%=word.getPicture() %></td>
						<td><%=word.getSound()%></td>
						<td align="center">
							<a href="<%=request.getContextPath() %>/editWord?wID=<%=word.getIDWord()%>">Change<img src="<%=request.getContextPath() %>/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/deleteWord?wID=<%= word.getIDWord()%>">Delete <img src="<%=request.getContextPath() %>/images/bin.gif" width="16" height="16" alt="delete" /></a>
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
				<a href="">1</a> 
				<span>|</span> 
				<a href="">2</a> 
				<span>|</span> 
				<span class="current">3</span> 
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