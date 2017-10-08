<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
    

<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>  

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      



<tmp:template-form title="Property-Add">

	<jsp:attribute name="formDetails">
										
                              <form:form role="form"  action="saveProperty" modelAttribute="property" method="POST" novalidate="true">
                              
                            
                               			<div class="col-lg-12">   
                               			
                               				 <!--  need to associate this data with property id -->
							  				 <form:hidden path="id"/>
			                           			                             			 		                                               	                                                                        
                                            <h3>Property: Sky- 
                                            <c:if test="${skyCode < 99}">0</c:if>
											<c:if test="${skyCode < 9}">0</c:if>
														${skyCode}</h3>
                                                                                                                                                                                           
                                       </div> 
                                       <!-- col-md-6 -->	
                                   
                              
                             
                                <div class="col-lg-6">
                                                                	                                                                            
                                         <div class="form-group">
                                            <label>Address</label>
                                            <form:input path="address" required="true" type="text" class="form-control"/>
                                            <form:errors path="address" cssClass="serverSideError"/>                                            
                                        </div>
                                        
                                        <div class="row">
                                        	<div class="col-md-6">
                                        	
                                         <div class="form-group">
                                            <label>Post Code</label>
                                            <form:input path="postCode" required="true" class="form-control"/> 
                                            <form:errors path="postCode" cssClass="serverSideError"/>                                  
                                        </div>
                                        
                                        	</div> 
                                        	<!-- col-md-6 -->	
                                        	<div class="col-md-6">
                                        	
                                          <div class="form-group">
                                            <label>Property Type</label>
                                            <form:select path="propertyType.id" required="true" class="form-control">
                                            	<option style="display:none" disabled selected>--</option>
                                            	 	
                                               	 <!-- loop over and print our property types -->
                                               	   
												 <c:forEach var="tempType" items="${propertyTypes}">
									
													<form:option value="${tempType.id}">${tempType.type}</form:option>
													
												</c:forEach>								                           	
												                      	
                                            </form:select>
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
                                            	<option style="display:none" disabled selected >--</option> 
                                                <form:option value="1">1</form:option>
                                                <form:option value="2">2</form:option>
                                                <form:option value="3">3</form:option>
                                                <form:option value="4">4</form:option>
                                                <form:option value="5">5</form:option>
                                            </form:select>
                                            <form:errors path="tubeZone" cssClass="serverSideError"/>   
                                        </div>
                                        
                                        </div> 
                                        	<!-- col-md-6 -->	
                                        	<div class="col-md-6">
                                        	                                   
                                       <div class="form-group">
                                            <label>Capacity</label>
                                            <form:input path="capacity" type="text" required="true" class="form-control"/>
                                            <form:errors path="capacity" cssClass="serverSideError"/>                                          
                                        </div>
                                                                                                                                               
                                        	</div> 
                                        	<!-- col-md-6 -->	
                                       </div> 
                                       <!-- /row -->
                                       
                                                                                                                                                                                                                                                                                                            
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                 
                                <div class="col-lg-6">
                                	
                                	<div class="row">
                                	 	 <div class="col-md-6">
                                        
                                          <div class="form-group">
                                            <label>Gender</label>
                                            <form:select path="gender" required="true" class="form-control">
                                            	<option style="display:none" disabled selected>--</option>
                                                <form:option value="Male">Male</form:option>
                                                <form:option value="Female">Female</form:option>
                                                <form:option value="Mixed">Mixed</form:option>
                                           </form:select>
                                           <form:errors path="gender" cssClass="serverSideError"/>   
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
                                            <form:input path="propertyPrice.price" required="true" type="number" class="form-control"/> 
                                            <form:errors path="propertyPrice.price" cssClass="serverSideError"/>                                                                                  
                                            <span class="input-group-addon">.00</span>                                            
                                        </div>
                                                                                                                                                               
                                     </div> 
                                     <!-- col-md-6 -->	
                                     
                                      </div> 
                                      <!-- /row -->
                                      
                                      
                                       <div class="row">                                                                                                                       					                                                                                                                                                                                                                                                              			
                                      <div class="col-md-6">
                                        
                                         <label>Comission</label>
                                        <div class="form-group input-group">
                                            <span class="input-group-addon">£</span>
                                            <form:input path="propertyPrice.comission" required="true" type="number" class="form-control"/>
                                            <form:errors path="propertyPrice.comission" cssClass="serverSideError"/>            
                                            <span class="input-group-addon">.00</span>                                                                                                                                               
                                        </div> 
                                                                
                                                                             	
                                       </div> 
                                       <!-- col-md-6 -->
                                       
                                       </div> 
                                      <!-- /row -->	
                                    
                                     
                               <div class="row">
                                    	<div class="col-md-6"></div>
                                     	<div class="col-md-6">
                                     		<button type="submit" class="btn btn-outline btn-primary" id="btnFormSubmit">Save</button>                                    
                                     	</div>
                                </div>    
                                                            
                             </div>
                             <!-- /.col-lg-6 (nested) -->
                                                                        
                           </form:form>
                           <!-- /form -->
                           
                           <c:if test="${saved == true}">                   
                          
                           	<!-- Modal -->
							<div id="myModal" class="modal fade" role="dialog">
  								<div class="modal-dialog">
    								<!-- Modal content-->
    								<div class="modal-content">
      									<div class="modal-header alert alert-success">
        									<h4 class="modal-title">Property Added</h4>
      									</div>
      									<div class="modal-body">
        									<p>The property has been successfully added to the database.</p>
      									</div>
      								<div class="modal-footer">
        								<button type="button" class="btn btn-default" data-dismiss="modal" id="modalButton">Close</button>
      								</div>
    							</div>
  						 	</div>
						</div>
                                                                          
                       </c:if>
	 						
                            
   
	</jsp:attribute>
	
	
</tmp:template-form>




