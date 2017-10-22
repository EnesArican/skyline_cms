
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tmp" tagdir="/WEB-INF/tags"%>

<%@ attribute name="formDetails" fragment="true"%>
 
<%@ attribute name="title"  required="true" rtexprvalue="true" %>
<%@ attribute name="entity" required="true" rtexprvalue="true"%>



<tmp:template-general>

	<jsp:attribute name="header">
		
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
                           </div>
                           <!-- /panel heading -->
                            <div class="panel-body">
                            <div class="row">
                              
                               <jsp:invoke fragment="formDetails"></jsp:invoke>
                              
                            </div>
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
    </jsp:attribute>

</tmp:template-general>
