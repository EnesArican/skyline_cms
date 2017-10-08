<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      



<tmp:template-table title="Students-All">
	
	<jsp:attribute name="headings">
	  
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
			<c:forEach var="tempProperty" items="${properties}">
									
				<tr>
					<td>${tempProperty.skyCode}</td>
					<td>${tempProperty.address}</td>
					<td>${tempProperty.postCode}</td>
					<td>${tempProperty.tubeZone}</td>
					<td>${tempProperty.propertyType.type}</td>
					<td>${tempProperty.gender}</td>
					<td>${tempProperty.capacity}</td>
					<td>${tempProperty.availability}</td>
					<td>${tempProperty.price}</td>
					<td>${tempProperty.comission}</td>							
				</tr>	
				
			</c:forEach>
				
	</jsp:attribute>
                                                                       	                                                                                       
</tmp:template-table>





