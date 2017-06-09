<div class="container">
	<div class="row">
	
		<!-- visualizza la sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>		
		</div>
		
		<!-- visualizza gli attuali produttori -->
		
		<div class="col-md-9">
		
			<div class="row">
			
				<div class="col-lg-12">
				
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Categoria</li>
							<li class="active">${categoria.nome}</li>
						</ol>
					</c:if>
				
				</div>
			
			</div>
		
		</div>
	</div>

</div>