<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<tmp:template-list title="All Students" entity="student">

	<jsp:attribute name="tabs">
	    <!-- Nav tabs -->
        <ul class="nav nav-pills">
            <li class="active"><a href="#basic-details" data-toggle="tab">Basic Details</a>
            </li>
            <li><a href="#school" data-toggle="tab">School</a>
            </li>
            <li><a href="#accomodation" data-toggle="tab">Accomodation</a>
            </li>
            <li><a href="#next-of-kin" data-toggle="tab">Next of Kin</a>
            </li>
             <li><a href="#flight" data-toggle="tab">Flight</a>
            </li>
        </ul>
        
    </jsp:attribute>

	<jsp:attribute name="table">
	
	<div class="tab-content">
		<div class="tab-pane fade in active" id="basic-details">
		<table width="100%" class="table table-striped table-bordered table-hover template-table" cellspacing="0">
            <thead>
                <tr>
                 	<th style="display: none;"></th>
		            <th>Name</th>
                    <th>Surname</th>		
                    <th>D.O.B</th>
                    <th>Gender</th>
                    <th>Mobile</th>                                           
                    <th>Email</th>
                    <th>Address</th> 
                    <th>Post Code</th>  
                </tr>
            </thead>
            <tbody>          
            <c:forEach var="tempStudent" items="${students}">									
				<tr>
					<td style="display: none;">${tempStudent.id}</td>
					<td>${tempStudent.name}</td>
					<td>${tempStudent.surname}</td>
					<td>${tempStudent.dob}</td>
					<td>${tempStudent.gender}</td>
					<td>${tempStudent.mobile}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.address}</td>
					<td>${tempStudent.postCode}</td>															
				</tr>	
				
			</c:forEach>                                                                		
            </tbody>
        </table>
        <!-- /.table-responsive -->
		</div>
         
		<div class="tab-pane fade" id="school">
		<table width="100%" class="table table-striped table-bordered table-hover template-table" cellspacing="0">
            <thead>
                <tr>
                	<th style="display: none;"></th>
					<th>Name</th>
                    <th>Surname</th>	
		            <th>School Name</th>
                    <th>Address</th>		
                    <th>Post Code</th>                 
                </tr>
            </thead>
            <tbody>          
            <c:forEach var="tempStudent" items="${students}">									
				<tr>
					<td style="display: none;">${tempStudent.id}</td>
					<td>${tempStudent.name}</td>
					<td>${tempStudent.surname}</td>
					<td>${tempStudent.studentSchool.name}</td>
					<td>${tempStudent.studentSchool.address}</td>	
					<td>${tempStudent.studentSchool.postCode}</td>
				</tr>					
			</c:forEach>                                                                		
            </tbody>
        </table>
        <!-- /.table-responsive -->
		</div> 
		
		<div class="tab-pane fade" id="accomodation">
		<table width="100%" class="table table-striped table-bordered table-hover template-table" cellspacing="0">
            <thead>
                <tr>
                	<th style="display: none;"></th>
					<th>Name</th>
                    <th>Surname</th>
		            <th>Sky Code</th>
                    <th>Start Date</th>		
                    <th>End Date</th> 
					<th>Price</th>		
                    <th>Comission</th>     
                </tr>
            </thead>
            <tbody>          
            <c:forEach var="tempStudent" items="${students}">
            	<c:forEach var="tempAccomodation" items="${tempStudent.studentAccomodations}">									
				<tr>
					<td style="display: none;">${tempStudent.id}</td>
					<td>${tempStudent.name}</td>
					<td>${tempStudent.surname}</td>
					 <td>SKY-
						<c:if test="${tempAccomodation.property.skyCode < 100}">0</c:if>
						<c:if test="${tempAccomodation.property.skyCode < 10}">0</c:if>
						${tempAccomodation.property.skyCode}</td>
					<td>${tempAccomodation.startDate}</td>	
					<td>${tempAccomodation.endDate}</td>
					<td>${tempAccomodation.price}</td>
					<td>${tempAccomodation.commission}</td>		
				</tr>
				</c:forEach>  					
			</c:forEach>                                                                		
            </tbody>
        </table>      
		</div> 
		
		
		<div class="tab-pane fade" id="flight">
		<table width="100%" class="table table-striped table-bordered table-hover template-table" cellspacing="0">
            <thead>
                <tr>
                	<th style="display: none;"></th>
		            <th>Name</th>
                    <th>Surname</th>		
                    <th>Airport (Pick Up)</th>
                    <th>Flight Numner</th>
                    <th>Airport (Drop Off)</th>                 
                </tr>
            </thead>
            <tbody>          
            <c:forEach var="tempStudent" items="${students}">	
            	<c:forEach var="tempFlight" items="${tempStudent.studentFlight}">					
				<tr>
					<td style="display: none;">${tempStudent.id}</td>
					<td>${tempStudent.name}</td>
					<td>${tempStudent.surname}</td>
					<td>${tempFlight.pickupAirport}</td>
					<td>${tempFlight.pickupFlightNumber}</td>
					
					<td>${tempFlight.dropoffAirport}</td>
				</tr>					
			</c:forEach>        
			</c:forEach>                                                                		                                                        		
            </tbody>
        </table>
		</div> 
		
		<div class="tab-pane fade" id="next-of-kin">
		<table width="100%" class="table table-striped table-bordered table-hover template-table" cellspacing="0">
            <thead>
                <tr>
                	<th style="display: none;"></th>
					<th>Name</th>
                    <th>Surname</th>
		            <th>Kin name</th>
                    <th>Kin surname</th>		
                    <th>Relation</th> 
					<th>Mobile</th>		
                    <th>Email</th>     
                </tr>
            </thead>
            <tbody>          
            <c:forEach var="tempStudent" items="${students}">									
				<tr>
					<td style="display: none;">${tempStudent.id}</td>
					<td>${tempStudent.name}</td>
					<td>${tempStudent.surname}</td>
					<td>${tempStudent.kinName}</td>
					<td>${tempStudent.kinSurname}</td>	
					<td>${tempStudent.kinRelation}</td>
					<td>${tempStudent.kinMobile}</td>
					<td>${tempStudent.kinEmail}</td>		
				</tr>					
			</c:forEach>                                                                		
            </tbody>
        </table>      
		</div> 
			
	</div>			
	</jsp:attribute>

</tmp:template-list>


