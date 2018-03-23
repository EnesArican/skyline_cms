<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<tmp:template-detail title="Student-Add" entity="student" saved="${saved}">


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


	<jsp:attribute name="formDetails">
    <form:form role="form" action="saveStudent" modelAttribute="student" method="POST" novalidate="true">
      
    <div class="tab-content">
	
		
		
		<div class="tab-pane fade in active" id="basic-details">
		<div class="col-md-6 col-md-offset-3">
	        <div class="row">
	            <div class="col-md-12">
                    <h3>Student Details</h3>
                    <!--  need to associate this data with property id -->
	      	        <form:hidden path="id" />
	            </div>            
            </div>				    			    			   	    				                                                                                                                      	                                            
            <div class="row">
                <div class="col-md-6">                                       	
                    <div class="form-group">
                        <label>Name *</label>
                        <form:input path="name" required="true" class="form-control" /> 
                        <form:errors path="name" cssClass="serverSideError" />                                  
                    </div>                                      
                </div> 
                <div class="col-md-6">                                       	
           	        <div class="form-group">
                        <label>Surname *</label>
                        <form:input path="surname" required="true" class="form-control" /> 
                        <form:errors path="surname" cssClass="serverSideError" />          
                    </div>	                                       
                </div> 	
            </div> 
            <!-- /row -->                                   
            <div class="row">
                <div class="col-md-6">                                        
                    <div class="form-group">
                        <label>Date of Birth *</label>
                        <div class="input-group input-append date datePicker">                                             	 
           		      	<form:input path="dob" type="custom_date" required="true" class="form-control" name="date"/>
           		        <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
           	            <form:errors path="dob" cssClass="serverSideError" />
                        </div>                                 
                    </div>
                </div> 	
                <div class="col-md-6">                                     	                                   
                    <div class="form-group">
                        <label>Gender *</label>
                        <form:select path="gender" required="true" class="form-control">
                        <option style="display: none" disabled selected value=>--</option>
 	       				<form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>                                         
                        </form:select>
                        <form:errors path="gender" cssClass="serverSideError" />                                       
                    </div>                                                                                                                                              
                </div> 	
            </div> 
            <!-- /row -->                                         	
            <div class="row">
                <div class="col-md-6">                                        
                    <div class="form-group">
                           <label>Mobile *</label>
                           <form:input path="mobile" required="true" class="form-control" /> 
                           <form:errors path="mobile" cssClass="serverSideError" />                                  
                    </div>
                </div> 	
                <div class="col-md-6">                                     	                                   
                    <div class="form-group">
                          <label>Email *</label>
                          <form:input path="email" type="email" required="true" class="form-control" />
                          <form:errors path="email" cssClass="serverSideError" />                                          
                    </div>                                                                                                                                              
                </div> 	
            </div> 
            <!-- /row -->                                                                                
            <div class="row">  
                <div class="col-md-6">                                       	
                    <div class="form-group">
                            <label>Address *</label>
                            <form:input path="address" required="true" class="form-control" /> 
                            <form:errors path="address" cssClass="serverSideError" />                                  
                    </div>                                      
                </div> 
                <!-- col-md-6 -->	                      	              		   
               <div class='col-md-6'>
                    <div class="form-group">
                    	    <label>Post Code *</label>	
                            <form:input path="postCode" required="true" class="form-control" /> 
                            <form:errors path="postCode" cssClass="serverSideError" /> 
                    </div>
                </div>                                                                                                                              					                                                                                                                                                                                                                                                              			                                                                    
            </div> 
		</div>
		</div>
		<div class="tab-pane fade in" id="school">
		<div class="col-md-6 col-md-offset-3">
      	    <div class="row">
      	        <div class="col-md-6">
                    <h3>School</h3>
                    <!--  need to associate this data with property id 
					<form:hidden path="id" />-->
           	    </div>    
            </div>            	                                                                                                       	                                            
            <div class="row">
                <div class="col-md-6">                                       	
                    <div class="form-group">
                        <label>School Name *</label>
                        <form:input path="studentSchool.name" required="true" class="form-control" /> 
                        <form:errors path="studentSchool.name" cssClass="serverSideError" />                                  
                    </div>                                      
                </div>                            
                <div class="col-md-6">                                       	
                    <div class="form-group">
                        <label>Address</label>
                        <form:input path="studentSchool.address" class="form-control" /> 
                        <form:errors path="studentSchool.address" cssClass="serverSideError" />          
                    </div>	                                       
                </div>                                 	
            </div> 
            <!-- /row -->
            <div class="row">
                <div class="col-md-6">                                       	
                    <div class="form-group">
                        <label>Post Code</label>
                        <form:input path="studentSchool.postCode" class="form-control" /> 
                        <form:errors path="studentSchool.postCode" cssClass="serverSideError" />          
                    </div>	                                       
                </div>                           
            </div> 
            <!-- /row --> 
		</div>
		</div>
		<div class="tab-pane fade in" id="accomodation">
		<div class="col-md-12 col-md-offset-0">
			<div class="row">
		        <div class="col-md-4">
                    <h3>Accomodation</h3>
			    </div>
			</div>
			<div  style="display:none;">
				<c:forEach var="tempProperty" items="${properties}">	
				<div id="property-price-${tempProperty.id}">${tempProperty.price}/${tempProperty.commission}</div>
				</c:forEach>
			</div>
			<c:set var = "propertiesCount" scope = "session" value = "${0}"/>
			<c:forEach items="${student.studentAccomodations}" varStatus="loop">
			<form:hidden path="studentAccomodations[${loop.index}].id" id="student-accomodation-id-${loop.index}"/>
			<div class="row" id="property-row-${loop.index}">
				<div class="col-md-3">
					<div class="form-group">
						<label>Property</label>
						<form:select path="studentAccomodations[${loop.index}].property.id" required="true" class="form-control accomodation-select" id="selected-accomodation-${loop.index}" disabled="true">
							<option	style="display: none" disabled selected value=>--</option>                            	
							<!-- loop over and print properties -->                                 	   
							<c:forEach var="tempProperty" items="${properties}">					
								<form:option value="${tempProperty.id}">SKY-
													<c:if test="${tempProperty.skyCode < 100}">0</c:if>
													<c:if test="${tempProperty.skyCode < 10}">0</c:if>
																${tempProperty.skyCode}:      ${tempProperty.address}
							   </form:option>										
							</c:forEach>												
						</form:select>
					</div>
				</div>	
				<div class="col-md-2">                               		                                 		     
                    <label>Price</label>
                    <div class="form-group input-group">
                        <span class="input-group-addon">£</span>
                        <form:input id="price-${loop.index}" path="studentAccomodations[${loop.index}].price" required="true" type="number" class="form-control" step="0.01" readonly="true" /> 
                        <form:errors path="" cssClass="serverSideError" />                                                                                                                           
                    </div>                                                                                                                                                   
                </div>                                                                                                                                                               					                                                                                                                                                                                                                                                              			
                <div class="col-md-2">                           
                    <label>Comission</label>
                    <div class="form-group input-group">
                          <span class="input-group-addon">£</span>
                          <form:input id="comission-${loop.index}" path="studentAccomodations[${loop.index}].commission" required="true" type="number" class="form-control" step="0.01"  readonly="true"/>
                          <form:errors path="" cssClass="serverSideError" />                                                                                                                                                       
                    </div>                                                                 	
                </div>
				<div class="col-md-2">                                       	
					<div class="form-group">
						<label>Start date *</label>
						<form:input id="start-date-${loop.index}" path="studentAccomodations[${loop.index}].startDate" type="custom_date" required="true" class="form-control" readonly="true"/> 
						<form:errors path="" cssClass="serverSideError" />                                  
					</div>                                      
				</div> 
				<div class="col-md-2">                                       	
					<div class="form-group">
						<label>End date *</label>
						<form:input id="end-date-${loop.index}" path="studentAccomodations[${loop.index}].endDate" type="custom_date" required="true" class="form-control" readonly="true"/> 
						<form:errors path="" cssClass="serverSideError" /> 					         
					</div>	                                       
				</div>
				<div class="col-md-1 top-buffer" style="height:37px;">                                      	
					<span>
					      <a class="btn btn-primary" href="#" id="edit-accomodation-${loop.index}"><i class="fa fa-pencil-square-o fa-lg"></i></a>   
                    </span>   
                    <span>
						 <a class="btn btn-danger" href="#" id="delete-accomodation-${loop.index}"><i class="fa fa-trash-o fa-lg"></i></a>                   
                    </span>                                       
				</div> 
			</div>
			<c:set var = "propertiesCount" scope = "session" value = "${loop.index + 1}"/>	
			</c:forEach>
			<script>
  				var propertiesCount = '<c:out value="${propertiesCount}" />';
			</script>
			<div class="row">
			    <div class="col-md-6">		 
			        <div class="form-group">
						<button id="toggle-accomodation"><i class="fa fa-plus"></i></button>
                        <label>Add Accomodation / Price</label>                       
                    </div>
                </div>
			</div>	
			<div class="accomodationFormContainer">		
			<div class="row" id="accomodationForm">
				<div class="col-md-3">
					<div class="form-group">
						<label>Property</label>
						<form:select path="studentAccomodations[${propertiesCount}].property.id" required="true" class="form-control accomodation-select" id="selected-accomodation-${propertiesCount}">
							<option	style="display: none" disabled selected value=>--</option>                            	
							<!-- loop over and print properties -->                                 	   
							<c:forEach var="tempProperty" items="${properties}">					
								<form:option value="${tempProperty.id}">SKY-
													<c:if test="${tempProperty.skyCode < 100}">0</c:if>
													<c:if test="${tempProperty.skyCode < 10}">0</c:if>
																${tempProperty.skyCode}:      ${tempProperty.address}
							   </form:option>										
							</c:forEach>												
						</form:select>
						<form:errors path="" cssClass="serverSideError" />   
					</div>
				</div>	
				<div class="col-md-2">                               		                                 		     
                    <label>Price</label>
                    <div class="form-group input-group">
                        <span class="input-group-addon">£</span>
                        <form:input id="price-${propertiesCount}" path="studentAccomodations[${propertiesCount}].price" required="true" type="number" class="form-control" step="0.01" /> 
                        <form:errors path="" cssClass="serverSideError" />                                                                                                                           
                    </div>                                                                                                                                                   
                </div>                                                                                                                                                               					                                                                                                                                                                                                                                                              			
                <div class="col-md-2">                           
                    <label>Comission</label>
                    <div class="form-group input-group">
                          <span class="input-group-addon">£</span>
                          <form:input id="comission-${propertiesCount}" path="studentAccomodations[${propertiesCount}].commission" required="true" type="number" class="form-control" step="0.01" />
                          <form:errors path="" cssClass="serverSideError" />                                                                                                                                                       
                    </div>                                                                 	
                </div>
				<div class="col-md-2">                                       	
					<div class="form-group">
						<label>Start date *</label>
						<form:input id="start-date-${propertiesCount}" path="studentAccomodations[${propertiesCount}].startDate" type="custom_date" required="true" class="form-control" readonly="true" /> 
						<form:errors path="" cssClass="serverSideError" />                                  
					</div>                                      
				</div> 
				<div class="col-md-2">                                       	
					<div class="form-group">
						<label>End date *</label>
						<form:input id="end-date-${propertiesCount}" path="studentAccomodations[${propertiesCount}].endDate"  type="custom_date" required="true" class="form-control" readonly="true" /> 
						<form:errors path="" cssClass="serverSideError" /> 					         
					</div>	                                       
				</div> 	
				<!-- 	
				<div class="col-md-1">  
					<span class="input-group-btn">
						<button class="btn btn-default top-buffer" type="button" id="reset-dates">Reset</button>
					</span>
				</div> 
				 -->   
			 
			</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div id="year-calendar"></div>
			    </div>
            </div>   
		</div>
		</div>
		<div class="tab-pane fade in" id="next-of-kin">
		<div class="col-md-6 col-md-offset-3">
            <div class="row">
      	        <div class="col-md-6">
                    <h3>Next of Kin</h3>
                </div>    
            </div>
			<div class="row">
				<div class="col-md-12">					                                                                                                                	                                            
					<div class="row">
						<div class="col-md-6">                                       	
							<div class="form-group">
								<label>Name *</label>
								<form:input path="kinName" required="true" class="form-control" /> 
								<form:errors path="kinName" cssClass="serverSideError" />                                  
							</div>                                      
						</div> 										
						<div class="col-md-6">                                        
							<div class="form-group">
								<label>Surname *</label>
								<form:input path="kinSurname" required="true" class="form-control" /> 
								<form:errors path="kinSurname" cssClass="serverSideError" />                       
							</div>
						</div> 																						
					</div> 
					<!-- /row -->                                              	        	  
					<div class="row">
						<div class="col-md-6">                                       	
							<div class="form-group">
								<label>Mobile *</label>
								<form:input path="kinMobile" required="true" class="form-control" /> 
								<form:errors path="kinMobile" cssClass="serverSideError" />                                  
							</div>                                      
						</div> 
						<div class="col-md-6">                                       	
							<div class="form-group">
								<label>Email</label>
								<form:input path="kinEmail" class="form-control" /> 
								<form:errors path="kinEmail" cssClass="serverSideError" />          
							</div>	                                       
						</div> 											
					</div> 
					<!-- /row -->
					<div class="row">
						<div class="col-md-6">                                     	                                   
							<div class="form-group">
								<label>Relation To You *</label>
                                <form:input path="kinRelation" required="true" class="form-control" /> 
								<form:errors path="kinRelation" cssClass="serverSideError" />                                 
							</div>                                                                                                                                              
						</div> 										
                    </div>						
				</div>
			</div>
			 <!-- /row -->
		</div>
		</div>
		<div class="tab-pane fade in" id="flight">
		<div class="col-md-6 col-md-offset-3">
			<div class="row">
		        <div class="col-md-6">
                    <h3>Flight</h3>
                    <!--  need to associate this data with property id -->
			    	<form:hidden path="studentFlight[0].id" />
			    </div>
			</div>
			<div class="row">
			    <div class="col-md-6">		 
                    <h4>Pick Up</h4>                       
                </div>
			</div>		
      	    <div class="row">
				<div class="col-md-12"> 
				    <div class="row">
				        <div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Airport</label> 
                                <form:select path="studentFlight[0].pickupAirport" class="form-control">
                                    <option style="display: none" disabled selected value=>--</option>
 	    		    		   	    <form:option value="Heathrow">Heathrow</form:option>
                                    <form:option value="Luton">Luton</form:option>  
                                     <form:option value="Stanstead">Stanstead</form:option>
                                    <form:option value="Gatwick">Gatwick</form:option>                                         
                                </form:select>
                                <form:errors path="" cssClass="serverSideError" />                    
                            </div>                                                                                                                                              
                        </div>    					    
				        <div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Flight Number</label>
                                <form:input path="studentFlight[0].pickupFlightNumber" class="form-control" />
                                <form:errors path="" cssClass="serverSideError" />                                       
                            </div>                                                                                                                                              
                        </div>    	
				    </div>
					<div class="row">
				        <div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Date </label>
                                    <div class="input-group input-append date datePicker">                                             	 
                  	    	        	<form:input path="studentFlight[0].pickupDate" type="custom_date" class="form-control" name="date"/>
                	    	            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                	    	            <form:errors path="" cssClass="serverSideError" />
              		    	        </div>                                        
                            </div>                                                                                                                                              
                        </div>    	
				        <div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Time </label>
                                    <div class="input-group clockpicker">
	                            		<form:input type="text" path="studentFlight[0].pickupTime" class="form-control"/>
	                            		<span class="input-group-addon">
	                            	    <span class="glyphicon glyphicon-time"></span>
	                            		</span>
	                            	</div>                                        
                            </div>                                                                                                                                              
                        </div>    	
					</div>
				</div>
			</div>
			<div class="row">
                <div class="col-md-6">
                        <h4>Drop Off</h4>                    
                </div>    
			</div>
			<div class="row">
			    <div class="col-md-12">	    	
					<div class="row">
				        <div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Airport </label>
                                <form:select path="studentFlight[0].dropoffAirport" class="form-control">
                                      <option style="display: none" disabled selected value=>--</option>
 	    		    		   	      <form:option value="Heathrow">Heathrow</form:option>
                                	  <form:option value="Luton">Luton</form:option>  
                                      <form:option value="Stanstead">Stanstead</form:option>
                                      <form:option value="Gatwick">Gatwick</form:option>                                            
                                </form:select>                                                                             
                            </div>                                                                                                                                              
                        </div>    				    		
				        <div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Flight Number </label>
                                <form:input path="studentFlight[0].dropoffFlightNumber" class="form-control" />                                                                               
                            </div>                                                                                                                                              
                        </div>    	
				    </div>
					<div class="row">
				    	<div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Date </label>
                                    <div class="input-group input-append date datePicker">                                             	 
                  			           	<form:input path="studentFlight[0].dropoffDate" type="custom_date" class="form-control" name="date"/>
                			           	<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>               					           
              				        </div>                                        
                            </div>                                                                                                                                              
                        </div>    	
				    	<div class="col-md-6">                                 	                                   
                            <div class="form-group">
                                <label>Time </label>
                                    <div class="input-group clockpicker">
	                                    <form:input type="text" path="studentFlight[0].dropoffTime" class="form-control"/>
	                                    <span class="input-group-addon">
	                                    <span class="glyphicon glyphicon-time"></span>
	                                    </span>
	                                </div>                                        
                            </div>                                                                                                                                              
                        </div>    														
      	            </div>
				</div>
      	    </div>
		</div>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<div class="row">
                <div class="col-md-2 col-md-offset-10 top-margin">
                    <button type="submit" class="btn btn-outline btn-primary pull-right" id="btnFormSubmit">Save</button>                                    
                </div>
            </div>
		</div>
        </div>
	                                                               
    </form:form>
    <!-- /form -->
                                  
	</jsp:attribute>
</tmp:template-detail>



