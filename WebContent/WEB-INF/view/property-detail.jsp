<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tmp:template-detail title="Property-Add" entity="property" saved="${saved}">
	<jsp:attribute name="formDetails">									
         <form:form role="form" action="saveProperty" modelAttribute="property" method="POST" novalidate="true">                        
         	<div class="col-md-6 col-md-offset-3">   
         		<!--  need to associate this data with property id -->
	 	 		<form:hidden path="id" />
	            <form:hidden path="skyCode" />                             			 		                                               	                                                                        
                <h3>Property: Sky- 
                	<c:if test="${property.skyCode < 100}">0</c:if>
					<c:if test="${property.skyCode < 10}">0</c:if>
					${property.skyCode}</h3>                                                                                                                                                           
           </div> 	                       
           <div class="col-md-6 col-md-offset-3">
				<div class="row">
					<div class="col-md-12">
           	            	<div class="form-group">
                                <label>Address</label>
                                <form:input path="address" required="true" type="text" class="form-control" />
                                <form:errors path="address" cssClass="serverSideError" />                                            
                           </div>  
					</div>            
                </div> 							
                <div class="row">
                     <div class="col-md-6">     	
                      		<div class="form-group">
                            	<label>Post Code</label>
                        	    <form:input path="postCode" required="true" class="form-control" /> 
                         		<form:errors path="postCode" cssClass="serverSideError" />                                  
                     		</div>            
                   	</div> 
                   	<!-- col-md-6 -->	
                   	<div class="col-md-6">                      	
                           <div class="form-group">
                                <label>Property Type</label>
                                <form:select path="propertyType.id" required="true" class="form-control">
                                 	<option	style="display: none" disabled selected value=>--</option>                            	
                                    <!-- loop over and print our property types -->                                    	   
								   	<c:forEach var="tempType" items="${propertyTypes}">					
										<form:option value="${tempType.id}">${tempType.type}</form:option>										
									</c:forEach>								                           										                      	
                                </form:select>
                                <form:errors path="propertyType" cssClass="serverSideError" />   
                          </div>	                                      
                      </div> 
                      <!-- col-md-6 -->	
                </div> 
                <!-- /row -->                  
                <div class="row">
                	 <div class="col-md-6">              
                            <div class="form-group">
                                 <label>Tube zone</label>
                                 <form:select path="tubeZone" required="true" class="form-control">
                                     <option style="display: none" disabled selected value=>--</option> 
                                     <form:option value="1">1</form:option>
                                     <form:option value="2">2</form:option>
                                     <form:option value="3">3</form:option>
                                     <form:option value="4">4</form:option>
                                     <form:option value="5">5</form:option>
                                  </form:select>
                                  <form:errors path="tubeZone" cssClass="serverSideError" />   
                            </div>                                        
                     </div> 
                 	 <!-- col-md-6 -->	
                 	 <div class="col-md-6">                                  
                            <div class="form-group">
                                 <label>Capacity</label>
                                 <form:input path="capacity"	type="text" required="true" class="form-control" />
                                 <form:errors path="capacity" cssClass="serverSideError" />                                          
                            </div>                                                                                                                                  
                   	  </div> 
                      <!-- col-md-6 -->	
                </div> 
                <!-- /row -->                                                                                                                                                                                                                                                          
           </div>
           <!-- /.col-lg-6 (nested) -->                               
           <div class="col-md-6 col-md-offset-3">                              	
                <div class="row">
                      <div class="col-md-6">                                        
                             <div class="form-group">
                          		  <label>Gender</label>
                          		  <form:select path="gender" required="true" class="form-control">
                          		  		<option style="display: none" disabled selected value=>--</option>
                              	  		<form:option value="Male">Male</form:option>
                              	   	    <form:option value="Female">Female</form:option>
                              	  		<form:option value="Mixed">Mixed</form:option>
                         	      </form:select>
                         		  <form:errors path="gender" cssClass="serverSideError" />   
                        	</div>                                                 
                      </div> 
                      <!-- col-md-6 -->	
                </div> 
                <!-- /row -->                                                   
                <div class="row">                        	 
                  	 <div class="col-md-6">                               		                                 		     
                            <label>Price</label>
                            <div class="form-group input-group">
                                <span class="input-group-addon">£</span>
                                <form:input path="propertyPrice.price" required="true" type="number" class="form-control" /> 
                                <form:errors path="propertyPrice.price" cssClass="serverSideError" />                                                                                  
                                <span class="input-group-addon">.00</span>                                            
                            </div>                                                                                                                                                   
                     </div> 
                     <!-- col-md-6 -->	                                                                                                                                                              					                                                                                                                                                                                                                                                              			
                     <div class="col-md-6">                           
                             <label>Comission</label>
                             <div class="form-group input-group">
                                   <span class="input-group-addon">£</span>
                                   <form:input path="propertyPrice.comission" required="true" type="number" class="form-control" />
                                   <form:errors path="propertyPrice.comission" cssClass="serverSideError" />            
                                   <span class="input-group-addon">.00</span>                                                                                                                                               
                             </div>                                                                 	
                      </div> 
                      <!-- col-md-6 -->     
                 </div> 
                 <!-- /row -->	                       
                 <div class="row">
                      <div class="col-md-2 col-md-offset-10 top-margin">
                         	<button type="submit" class="btn btn-outline btn-primary pull-right" id="btnFormSubmit">Save</button>                                    
                      </div>
                 </div>                                                    
            </div>
            <!-- /.col-lg-6 (nested) -->                                                
         </form:form>
         <!-- /form -->
                  
	</jsp:attribute>
</tmp:template-detail>





