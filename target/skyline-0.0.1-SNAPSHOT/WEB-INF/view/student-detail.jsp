<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<tmp:template-detail title="Student-Add" entity="student">
	<jsp:attribute name="formDetails">
    <form:form role="form" action="saveStudent" modelAttribute="student" method="POST" novalidate="true">
      
    <div class="row">
		<div class="col-lg-6">
	        <div class="row">
	            <div class="col-lg-12">
                    <h3>Student Details</h3>
                    <!--  need to associate this data with property id -->
	      	        <form:hidden path="id" />
	            </div>            
            </div>
			<!--/.row -->
	    	<div class="row">
	    		<div class="col-lg-12">
	    			<div class="panel panel-primary">    		
	    				<div class="panel-body">                                                                                                                       	                                            
                            <div class="row">
                                <div class="col-md-6">                                       	
                                         <div class="form-group">
                                                <label>Name *</label>
                                                <form:input path="name" required="true" class="form-control" /> 
                                                <form:errors path="name" cssClass="serverSideError" />                                  
                                         </div>                                      
                                </div> 
                                <!-- col-md-6 -->	
                                <div class="col-md-6">                                       	
                        		         <div class="form-group">
                                                <label>Surname *</label>
                                                <form:input path="surname" required="true" class="form-control" /> 
                                                <form:errors path="surname" cssClass="serverSideError" />          
                                         </div>	                                       
                                </div> 
                                <!-- col-md-6 -->	
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
                               	<!-- col-md-6 -->	
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
                                <!-- col-md-6 -->	
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
                               	<!-- col-md-6 -->	
                                <div class="col-md-6">                                     	                                   
                                          <div class="form-group">
                                                <label>Email *</label>
                                                <form:input path="email" type="email" required="true" class="form-control" />
                                                <form:errors path="email" cssClass="serverSideError" />                                          
                                           </div>                                                                                                                                              
                                </div> 
                                <!-- col-md-6 -->	
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
                            <!-- /row -->	                                    
	    				<!-- /.panel-body --> 
	    				</div>
	    			</div>  
                </div>
            </div>
	    	<!-- /.row -->    
	    </div>
        <div class="col-lg-6">
			<div class="row">
		        <div class="col-md-4">
                    <h3>Flight</h3>
                    <!--  need to associate this data with property id -->
			    	<form:hidden path="id" />
			    </div>
			    <div class="col-md-4">		 
			        <div class="form-group top-margin">
                        <label>Pick Up</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="pickUpBox"/>.
                        </label>    
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group top-margin">
                        <label>Drop Off</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="dropOffBox"/>.
                        </label>  
                    </div>
                </div>    
			</div>
      	    <div class="row">
				<div class="col-md-6 pickUpFormContainer">
      		        <div class="panel panel-primary" id="pickUpForm">
				    	<div class="panel-body">
				    		<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Airport * (Pick Up)</label>
                                        <form:select path="" required="true" class="form-control">
                                            <option style="display: none" disabled selected value=>--</option>
 	    		    				   	    <form:option value="Male">Male</form:option>
                                            <form:option value="Female">Female</form:option>                                         
                                        </form:select>
                                        <form:errors path="" cssClass="serverSideError" />                                       
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Flight Number *</label>
                                        <form:input path="" required="true" class="form-control" />
                                        <form:errors path="" cssClass="serverSideError" />                                       
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Date *</label>
                                            <div class="input-group input-append date datePicker">                                             	 
                  					        	<form:input path="" type="custom_date" required="true" class="form-control" name="date"/>
                					            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                					            <form:errors path="" cssClass="serverSideError" />
              						        </div>                                        
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Time *</label>
                                            <div class="input-group clockpicker">
	                                    		<input type="text" class="form-control" value="00:00">
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
			    <div class="col-md-6 dropOffFormContainer">
				    <div class="panel panel-primary" id="dropOffForm">
				    	<div class="panel-body">
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Airport * (Drop Off) </label>
                                        <form:select path="StudentFlight.airport" required="true" class="form-control">
                                              <option style="display: none" disabled selected value=>--</option>
 	    		    				   	      <form:option value="Male">Male</form:option>
                                              <form:option value="Female">Female</form:option>                                         
                                        </form:select>
                                        <form:errors path="" cssClass="serverSideError" />                                       
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Flight Number *</label>
                                        <form:input path="" required="true" class="form-control" />
                                        <form:errors path="" cssClass="serverSideError" />                                       
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Date *</label>
                                            <div class="input-group input-append date datePicker">                                             	 
                  					           	<form:input path="" type="custom_date" required="true" class="form-control" name="date"/>
                					           	<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                					           	<form:errors path="" cssClass="serverSideError" />
              						        </div>                                        
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-12">                                 	                                   
                                    <div class="form-group">
                                        <label>Time *</label>
                                            <div class="input-group clockpicker">
	                                            <input type="text" class="form-control" value="00:00">
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
      	</div>
    </div>  	    
    <div class="row">
    	<div class="col-lg-3">
      	    <div class="row">
      	        <div class="col-md-3">
                    <h3>School</h3>
                    <!--  need to associate this data with property id 
					<form:hidden path="id" />-->
           	    </div>    
            </div>
            <div class="row">
                <div class="col-md-12">
      	            <div class="panel panel-default">
      		            <div class="panel-body">                                                                                               	                                            
                            <div class="row">
                                <div class="col-md-12">                                       	
                                    <div class="form-group">
                                        <label>School Name *</label>
                                        <form:input path="studentSchool.name" required="true" class="form-control" /> 
                                        <form:errors path="studentSchool.name" cssClass="serverSideError" />                                  
                                    </div>                                      
                                </div>
                            </div> 
                   	        <!-- /row --> 
                            <div class="row"> 
                                <div class="col-md-12">                                       	
                    		        <div class="form-group">
                                        <label>Address</label>
                                        <form:input path="studentSchool.address" class="form-control" /> 
                                        <form:errors path="studentSchool.address" cssClass="serverSideError" />          
                                    </div>	                                       
                                </div>                                 	
                            </div> 
                            <!-- /row -->
                            <div class="row">
                                <div class="col-md-12">                                       	
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
                </div>
            </div>
        </div>
        <div class="col-lg-6">
           <div class="row">
      	        <div class="col-md-5">
                    <h3>Next of Kin</h3>
                </div>    
            </div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">                                                                                                                  	                                            
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
				</div>
			</div>
        </div>
		<div class="col-lg-3">
            <div class="row top-buffer">
                <div class="col-md-12 top-buffer">
                </div>
			</div>	
			<div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-outline btn-danger" id="btnFormSubmit">Save</button>                                    
                </div>				
            </div> 
        </div>               
    </div>                                                                  
    </form:form>
    <!-- /form -->
    
       <!-- Modal -->                   
      <c:if test="${saved == true}">                                                             	
			<div id="myModal" class="modal fade" role="dialog">
  				<div class="modal-dialog">
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
   			       <!-- Modal content-->
  		 	   </div>
		    </div>                                                            
      </c:if>				                               
	</jsp:attribute>
</tmp:template-detail>



