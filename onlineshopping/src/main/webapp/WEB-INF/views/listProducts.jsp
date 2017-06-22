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
						<script>
							window.categoryId = '${categoria.id}'
						</script>
					
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${categoria.id}'
						</script>
						
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Categoria</li>
							<li class="active">${categoria.name}</li>
						</ol>
					</c:if>
				
				</div>
			
			</div>
		
			<div class="row">
				
				<div class="col-xs-12">
					
					<table id="productListTable" class="table table-striped table-border">
						
						<thead>
							<tr>
								<th></th>
								<th>Nome</th>
								<th>Brand</th>
								<th>Prezzo a unità</th>
								<th>Quantità</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Nome</th>
								<th>Brand</th>
								<th>Prezzo a unità</th>
								<th>Quantità</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				
				</div>
				
			</div>
		
		</div>
	</div>

</div>