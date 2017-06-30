<%@include file="../shared/flows-header.jsp" %>

		<!-- Page Content -->

		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Dati Personali</h4>
							</div>
							<div class="panel-body">
								<div class="text-center">
									<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
									<h5>Email: ${registerModel.user.email}</h5>
									<h5>Numero Contatto: ${registerModel.user.contactNumber}</h5>
									<h5>Ruolo: ${registerModel.user.role}</h5>
								</div>
							</div>
							<div class="panel-footer">
								<a href="${flowExecutionUrl}&_eventId_pers" class="btn btn-primary">Modifica</a>
							</div>						
						</div>					
					</div>
					<div class="col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Dati Fatturazione</h4>
							</div>
							<div class="panel-body">
								<div class="text-center">
									<h4>${registerModel.address.addressLineOne}</h4>
									<h4>${registerModel.address.addressLineTwo}</h4> 
									<h5>Città: ${registerModel.address.city} - CAP: ${registerModel.address.postalCode}</h5>
									<h5>Regione: ${registerModel.address.state} - Nazione: ${registerModel.address.country}</h5>
								</div>
							</div>
							<div class="panel-footer">
								<a href="${flowExecutionUrl}&_eventId_bill" class="btn btn-primary">Modifica</a>
							</div>						
						</div>					
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<div class="text-center">
							<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Conferma Dati</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
<%@include file="../shared/flows-footer.jsp" %>