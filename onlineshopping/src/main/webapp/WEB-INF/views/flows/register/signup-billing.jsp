<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

		<!-- Page Content -->

		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Inserisci Dati Fatturazione</h4>
							</div>
							<div class="panel-body">
								<sf:form class="form-horizontal" id="billingForm"
								method="POST" modelAttribute="billing">
								
								<div class="form-group">
									<label class="control-label col-md-4">Primo Indirizzo</label>
									<div class="col-md-8">
										<sf:input type="text" path="addressLineOne" id="addressLineOne" class="form-control" placeholder="Inserisci Indirizzo" />
										<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Dettagli Indirizzo</label>
									<div class="col-md-8">
										<sf:input type="text" path="addressLineTwo" id="addressLineTwo" class="form-control" placeholder="Dettagli indirizzo" />
										<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Città</label>
									<div class="col-md-8">
										<sf:input type="text" path="city" id="city" class="form-control" placeholder="Inserisci Città" />
										<sf:errors path="city" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Provincia</label>
									<div class="col-md-8">
										<sf:input type="text" path="state" id="state" class="form-control" placeholder="Inserisci Provincia" />
										<sf:errors path="state" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Nazione</label>
									<div class="col-md-8">
										<sf:input type="text" path="country" id="country" class="form-control" placeholder="Inserisci Nazione" />
										<sf:errors path="country" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Codice Postale</label>
									<div class="col-md-8">
										<sf:input type="text" path="postalCode" id="postalCode" class="form-control" placeholder="Inserisci Codice Postale" />
										<sf:errors path="postalCode" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<button type="submit" class="btn btn-primary" name="_eventId_pers">
											<span class="glyphicon glyphicon-chevron-left"></span> Indietro - Dati Personali
										</button>
										<button type="submit" class="btn btn-primary" name="_eventId_conf">
											Avanti - Riepilogo <span class="glyphicon glyphicon-chevron-right"></span>
										</button>
									</div>
								</div>
								
								</sf:form>
							</div>						
						</div>
					</div>
				</div>
			</div>
		</div>
		
<%@include file="../shared/flows-footer.jsp" %>