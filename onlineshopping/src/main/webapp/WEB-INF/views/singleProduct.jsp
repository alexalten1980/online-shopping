<div class="container">

	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">All Product</a></li>
				<li class="active">${prodotto.name}</li>
			</ol>
		</div>
	</div>

	<div class="row">

		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">
				<img alt="Device" src="${images}/${prodotto.code}.jpg"
					class="img img-responsive" />
			</div>

		</div>

		<div class="col-xs-12 col-sm-8">
			<h3>${prodotto.name}</h3>
			<hr />
			<p>${prodotto.description}</p>
			<hr />
			<h5>
				Prezzo: <strong>${prodotto.unitPrice} &euro;</strong>
			</h5>
			<hr />

			<c:choose>
				<c:when test="${prodotto.quantity < 1}">
					<h6>
						Quantità disponibile: <span style="color: red">Esaurito</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Quantità disponibile: ${prodotto.quantity}</h6>
				</c:otherwise>
			</c:choose>

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Indietro</a>

			<c:choose>
				<c:when test="${prodotto.quantity < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled"> 
					<strike>
						<span class="glyphicon glyphicon-shopping-cart"></span> Aggiungi al carrello
					</strike>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/add/cart/${prodotto.id}/product" class="btn btn-success"> 
					<span class="glyphicon glyphicon-shopping-cart"></span>Aggiungi al carrello</a>
				</c:otherwise>
			</c:choose>
		</div>

	</div>

</div>