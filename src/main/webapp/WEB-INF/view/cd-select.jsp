<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import ="java.util.List" %>
                <%@ page import ="java.util.ArrayList" %>
                    <%@ page import ="dto.Cd" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		<th>題名</th>
		<th>作曲者</th>
		<th>購入日</th>
		<th>管理番号</th>
		</tr>
				<%
		List<Cd> all = (ArrayList<Cd>)request.getAttribute("all");
		for(Cd c : all){
		%>
		<table>
		<tr>
				<a href="SelectAllCdServlet?isbn=<%=c.getIsbn()%>"></a>
				<td><%=c.getTitle() %></td>
				<td><%=c.getComposer() %></td>
				<td><%=c.getOnsale() %></td>
				<td><%=c.getIsbn() %></td>

			</tr>
	<%} %>
	</table>
<a href="CdTopServlet">CD管理トップへ</a>
</body>
</html>