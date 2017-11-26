
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ attribute name="formDetails" fragment="true"%>
 
<%@ attribute name="title"  required="true" rtexprvalue="true" %>
<%@ attribute name="entity" required="true" rtexprvalue="true"%>
<%@ attribute name="saved" required="true" rtexprvalue="true"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<tmp:template-general>

	<jsp:attribute name="header">
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/dist/css/bootstrap-clockpicker.min.css">
	</jsp:attribute>
	

	<jsp:attribute name="content">
	
	 <input type="hidden" id="entity" value="${entity}">
	
	 <!-- Page Content -->
        <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">${title}</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
           
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                           <div class="panel-heading">
                            <c:if test="${saved == true}">                                
            				<h1>Saved</h1>
           					</c:if>
                           </div>
                           <!-- /panel heading -->
                            <div class="panel-body">
                           <!--   <div class="row">  -->
                               
                               <jsp:invoke fragment="formDetails"></jsp:invoke>
                              
                           <!--  </div> -->
                            <!-- /.row (nested) -->
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
        
	</jsp:attribute>
	
	<jsp:attribute name="footer">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/template-detail.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/dist/js/bootstrap-clockpicker.min.js"></script>
    </jsp:attribute>

</tmp:template-general>
