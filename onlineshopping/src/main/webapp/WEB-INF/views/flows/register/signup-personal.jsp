<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

		<!-- Page Content -->

		<div class="container">
			
			<div class="row">
				
				<div class="col-md-6 col-md-offset-3">
				
					<div class="panel panel-primary">
					
						<div class="panel-heading">
							<h4>Registrazione - dati personali</h4>						
						</div>
						
						<div class="panel-body">
							
							<sf:form method="POST" class="form-horizontal" 
							id="registerForm" modelAttribute="user">
							
								<div class="form-group">
									<label class="control-label col-md-4">Nome</label>
									<div class="col-md-8">
										<sf:input type="text" path="firstName" id="firstName" class="form-control" placeholder="Inserisci Nome" />
										<sf:errors path="firstName" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Cognome</label>
									<div class="col-md-8">
										<sf:input type="text" path="lastName" id="lastName" class="form-control" placeholder="Inserisci Cognome" />
										<sf:errors path="lastName" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Email</label>
									<div class="col-md-8">
										<sf:input type="text" path="email" id="email" class="form-control" placeholder="Inserisci Email" />
										<sf:errors path="email" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Numero ricontatto</label>
									<div class="col-md-8">
										<sf:input type="text" path="contactNumber" id="contactNumber" class="form-control" 
										placeholder="Inserisci Num. ricontatto" maxlength="10" />
										<sf:errors path="contactNumber" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Seleziona Ruolo</label>
									<div class="col-md-8">
										<label class="radio-inline">
											<sf:radiobutton path="role" value="USER" checked="checked" /> Utente
										</label>
										<label class="radio-inline">
											<sf:radiobutton path="role" value="SUPPLIER" /> Fornitore
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Password</label>
									<div class="col-md-8">
										<sf:input type="password" path="password" id="password" class="form-control" placeholder="Inserisci Password" />
										<sf:errors path="password" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-4">Conferma Password</label>
									<div class="col-md-8">
										<sf:input type="password" path="confirmPassword" id="confirmPassword" class="form-control" placeholder="Reinserisci Password" />
										<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<!-- l'attributo name deve essere lo stesso riportato in signup-flow
										su transition on -->
										<button type="submit" class="btn btn-primary" name="_eventId_bill">
											Avanti - Fatturazione <span class="glyphicon glyphicon-chevron-right"></span>
										</button>
									</div>
								</div>
							</sf:form>						
						
						</div>
					
					</div>
				
				</div>	
			
			</div>
		</div>
		
<%@include file="../shared/flows-footer.jsp" %>