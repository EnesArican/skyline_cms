<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<tmp:template-list title="All Students" entity="student">



	<jsp:attribute name="headings">
			 <th style="display: none;"></th>
             <th>Name</th>
             <th>Surname</th>
             <th>D.O.B</th>
             <th>Mobile</th>
             <th>Email</th>
             <th>Address</th> 
             <th>Start Date</th>
             <th>End Date</th> 
             
            
    </jsp:attribute>

	<jsp:attribute name="rows">                               
                                    
            <!-- loop over and print our properties -->
			<c:forEach var="tempStudent" items="${students}">
									
				<tr>
					<td style="display: none;">${tempStudent.id}</td>
					
					<td>${tempStudent.name}</td>
					<td>${tempStudent.surname}</td>
					<td>${tempStudent.dOB}</td>
					<td>${tempStudent.mobile}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.address}</td>
					<td>${tempStudent.startDate}</td>
					<td>${tempStudent.endDate}</td>
											
				</tr>	
				
			</c:forEach>
				
	</jsp:attribute>

</tmp:template-list>


