<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<tmp:template-list title="Properties" entity="property">

	<jsp:attribute name="headings">
			 <th style="display: none;"></th>
             <th>Sky-Code</th>
             <th>Adress</th>
             <th>Post Code</th>
             <th>Tube Zone</th>
             <th>Type</th> 
             <th>Gender</th>
             <th>Capacity</th>
             <th>Available Space</th> 
             <th>Price</th>
             <th>Comission</th> 
    </jsp:attribute>

	<jsp:attribute name="rows">                               
                                    
            <!-- loop over and print our properties -->
			<c:forEach var="tempProperty" items="${properties}">
									
				<tr>
					<td style="display: none;">${tempProperty.id}</td>
					<td>SKY-
						<c:if test="${tempProperty.skyCode < 100}">0</c:if>
						<c:if test="${tempProperty.skyCode < 10}">0</c:if>
					${tempProperty.skyCode}
					</td>
					<td>${tempProperty.address}</td>
					<td>${tempProperty.postCode}</td>
					<td>${tempProperty.tubeZone}</td>
					<td>${tempProperty.propertyType.type}</td>
					<td>${tempProperty.gender}</td>
					<td>${tempProperty.capacity}</td>
					<td>${tempProperty.currentSpace}</td>
					<td>${tempProperty.propertyPrice.price}</td>
					<td>${tempProperty.propertyPrice.comission}</td>							
				</tr>	
				
			</c:forEach>
				
	</jsp:attribute>

</tmp:template-list>





