
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ attribute name="rows" fragment="true" %>
<%@ attribute name="headings" fragment="true" %> 

<%@ attribute name="title"  required="true" rtexprvalue="true" %>
<%@ attribute name="entity" required="true" rtexprvalue="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    




<tmp:template-general>

	<jsp:attribute name="header">
		<link href ="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">  
    	<link href="${pageContext.request.contextPath}/resources/vendor/datatables/css/dataTables.bootstrap.min.css" rel="stylesheet">  
	</jsp:attribute>
	

	<jsp:attribute name="content">
	
	 
	 	
	
	
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-9">
                    <h1 class="page-header">${title}</h1>
                </div>
                
                <input type="hidden" id="entity" value="${entity}">
            
                <div class="col-lg-3 inner" id="editButtons">    
                    			<a href="${entity}-detail" class="btn btn-primary">Add</a>
                    			<a class="btn btn-outline btn-success" id="update">Update</a>
        						<a class="btn btn-outline btn-warning" data-target="#myModal" id="delete">Delete</a>
                            			                   
                </div>
                
                
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                           <div class="panel-heading">
                           
                        </div>  
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                            <table width="100%" class="table table-striped table-bordered table-hover" cellspacing="0" id="template-table">
                                <thead>
                                    <tr>
                                     	 <jsp:invoke fragment="headings"></jsp:invoke>
                                    </tr>
                                </thead>
                                <tbody>
                                  
                                 		 <jsp:invoke fragment="rows"></jsp:invoke>
                                     
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
        </div>
        <!-- /#page-wrapper -->
        
        
              
                          
                  	<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
  				<div class="modal-dialog">
   					<!-- Modal content-->
   					<div class="modal-content">
    						<div class="modal-header alert alert-warning">
    							<h4 class="modal-title">Delete ${entity}</h4>
    						</div>
    						<div class="modal-body">
    							<p>Are you sure you want to delete the highlighted ${entity}?</p>
    						</div>
    					<div class="modal-footer">
    						<a type="button" class="btn btn-default" id="deleteModalButton">Ok</a>  
    						<a type="button" class="btn btn-default" data-dismiss="modal" id="modalButton">Cancel</a>
    					</div>
   				</div>
  		 	</div>
		</div>
                                                                        
               
	
	
	</jsp:attribute>
	
	<jsp:attribute name="footer">
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>  
    	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/template-list.js"></script>
    </jsp:attribute>

</tmp:template-general>
