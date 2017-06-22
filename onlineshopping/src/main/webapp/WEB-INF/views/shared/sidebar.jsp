<p class="lead">Shop Name</p>
<div class="list-group">

	<c:forEach items="${categorie}" var="categoria">
		<a href="${contextRoot}/show/category/${categoria.id}/products" class="list-group-item" id="a_${categoria.name}">${categoria.name}</a>
	</c:forEach>
	
</div>