<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<tmp:template-detail title="Student-Add" entity="student" saved="${saved}">
	<jsp:attribute name="formDetails">
    <form:form role="form" action="saveStudent" modelAttribute="student" method="POST" novalidate="true">
      
    
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
			<div class="row">
		        <div class="col-md-6">
                    <h3>Flight</h3>
                    <!--  need to associate this data with property id -->
			    	<form:hidden path="id" />
			    </div>
			</div>
			<div class="row">
			    <div class="col-md-6">		 
			        <div class="form-group">
						<button id="toggle-pick-up"><i class="fa fa-plus"></i></button>
                        <label>Pick Up</label>                       
                    </div>
                </div>
			</div>			
      	    <div class="row">
				<div class="col-md-12 pickUpFormContainer"> 
					<div id="pickUpForm">	
				        <div class="row">
				            <div class="col-md-6">                                 	                                   
                                <div class="form-group">
                                    <label>Airport * (Pick Up)</label>
                                    <form:select path="" required="true" class="form-control">
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
                                    <label>Flight Number *</label>
                                    <form:input path="" required="true" class="form-control" />
                                    <form:errors path="" cssClass="serverSideError" />                                       
                                </div>                                                                                                                                              
                            </div>    	
				        </div>
					    <div class="row">
				            <div class="col-md-6">                                 	                                   
                                <div class="form-group">
                                    <label>Date *</label>
                                        <div class="input-group input-append date datePicker">                                             	 
                  	    		        	<form:input path="" type="custom_date" required="true" class="form-control" name="date"/>
                	    		            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                	    		            <form:errors path="" cssClass="serverSideError" />
              		    		        </div>                                        
                                </div>                                                                                                                                              
                            </div>    	
				            <div class="col-md-6">                                 	                                   
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
			<div class="row">
                <div class="col-md-6">
                    <div class="form-group">
						<button id="toggle-drop-off"><i class="fa fa-plus"></i></button>
                        <label>Drop Off</label>                    
                    </div>
                </div>    
			</div>
			<div class="row">
			    <div class="col-md-12 dropOffFormContainer">
				    <div id="dropOffForm">			    	
							<div class="row">
				    		    <div class="col-md-6">                                 	                                   
                                    <div class="form-group">
                                        <label>Airport * (Drop Off) </label>
                                        <form:select path="studentFlights[0].airport" required="true" class="form-control">
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
                                        <label>Flight Number *</label>
                                        <form:input path="studentFlights[0].flightNumber" required="true" class="form-control" />                                                                               
                                    </div>                                                                                                                                              
                                </div>    	
				    		</div>
							<div class="row">
				    		    <div class="col-md-6">                                 	                                   
                                    <div class="form-group">
                                        <label>Date *</label>
                                            <div class="input-group input-append date datePicker">                                             	 
                  					           	<form:input path="" type="custom_date" required="true" class="form-control" name="date"/>
                					           	<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>               					           
              						        </div>                                        
                                    </div>                                                                                                                                              
                                </div>    	
				    		    <div class="col-md-6">                                 	                                   
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
			<div class="row">
                <div class="col-md-2 col-md-offset-10 top-margin">
                    <button type="submit" class="btn btn-outline btn-primary pull-right" id="btnFormSubmit">Save</button>                                    
                </div>
            </div>        
        </div>
		
                                                                   
    </form:form>
    <!-- /form -->
                                  
	</jsp:attribute>
</tmp:template-detail>



