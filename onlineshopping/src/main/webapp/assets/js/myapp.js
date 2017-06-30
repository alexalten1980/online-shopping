$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;	
		
	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	var token= $('meta[name="_csrf"]').attr('content');
	var header= $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0){
		//setta il token e l'header per le richieste ajax
		$(document).ajaxSend(function(e, xhr, option){
			xhr.setRequestHeader(header,token);
		});
	}

//	var products = [ [ '1', 'ABC' ], [ '2', 'DEF' ], [ '3', 'GHI' ],
//			[ '4', 'LMN' ], [ '5', 'OPQ' ], [ '6', 'RST' ], [ '7', 'UVZ' ],
//			[ '8', 'WYJ' ], [ '9', 'XXX' ], ];
	
	var lingua = {
		    "sEmptyTable":     "Nessun dato presente nella tabella",
		    "sInfo":           "Vista da _START_ a _END_ di _TOTAL_ elementi",
		    "sInfoEmpty":      "Vista da 0 a 0 di 0 elementi",
		    "sInfoFiltered":   "(filtrati da _MAX_ elementi totali)",
		    "sInfoPostFix":    "",
		    "sInfoThousands":  ".",
		    "sLengthMenu":     "Visualizza _MENU_ elementi",
		    "sLoadingRecords": "Caricamento...",
		    "sProcessing":     "Elaborazione...",
		    "sSearch":         "Cerca:",
		    "sZeroRecords":    "La ricerca non ha portato alcun risultato.",
		    "oPaginate": {
		        "sFirst":      "Inizio",
		        "sPrevious":   "Precedente",
		        "sNext":       "Successivo",
		        "sLast":       "Fine"
		    },
		    "oAria": {
		        "sSortAscending":  ": attiva per ordinare la colonna in ordine crescente",
		        "sSortDescending": ": attiva per ordinare la colonna in ordine decrescente"
		    }
		}

	var $table = $('#productListTable');

	if ($table.length) {
		// console.log('sei dentro la tabella');
		
		var jsonUrl = '';
		
		if(categoryId == ''){
			jsonUrl = contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl = contextRoot + '/json/data/category/'+ categoryId +'/products';
		}

		$table.DataTable({
			lengthMenu: [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'Tutti' ] ],
			pageLength: 5,
			language: lingua,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			}, 
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row) {
						return '<img src="' + contextRoot + '/resources/images/' + data + '.jpg" class="dataTablesImg" />';
					}	
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return data + ' &euro;'
					}
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if(data < 1){
							return '<span style="color:red">Esaurito</span>';
						}
						return data;
					}	
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<a href="'+contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if(role == 'ADMIN'){
							str += '<a href="'+contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';	
						} else {
							if(row.quantity < 1){
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							} else {
								str += '<a href="'+contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
						}
						
						return str;
					}
				}
			]
			//data : products,
		})
	}
	
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow')
		},3000)
	}
	
	
	
	
	//datatable admin
	
	var $adminProductTable = $('#adminProductTable');

	if ($adminProductTable.length) {
		// console.log('sei dentro la tabella');
		
		var jsonUrl = contextRoot + '/json/data/admin/all/products';
		
		$adminProductTable.DataTable({
			lengthMenu: [ [ 10, 30, 50, -1 ],
					[ '10 Records', '30 Records', '50 Records', 'Tutti' ] ],
			pageLength: 30,
			language: lingua,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			}, 
			columns: [
				{
					data: 'id'	
				},
				{
					data: 'code',
					mRender: function(data, type, row) {
						return '<img src="' + contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg" />';
					}	
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if(data < 1){
							return '<span style="color:red">Esaurito</span>';
						}
						return data;
					}	
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return data + ' &euro;'
					}
				},
				{
					data: 'active',
					bSortable: 'false',
					mRender: function(data, type, row) {
						
						var str='';
						str+='<label class="switch">';
						
						if(data){
							str+='<input type="checkbox" checked="checked" value="'+row.id+'" />';
						} else {
							str+='<input type="checkbox" value="'+row.id+'" />';
						}
						str+='<div class="slider"></div></label>';
						
						return str;
					}
				},
				{
					data: 'id',
					bSortable: 'false',
					mRender: function(data, type, row) {
						
						var str='';
						
						str+='<a href="' + contextRoot +'/manage/' + data + '/product" class="btn btn-warning">';
						str+='<span class="glyphicon glyphicon-pencil"></span></a>';
						
						return str;
					}
				}
			],
			
			initComplete: function() {
				
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', function(){
					
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked) ? 'Sei sicuro di attivare il prodotto?' 
							: 'Sei sicuro di disattivare il prodotto?';
					var value = checkbox.prop('value');
					console.log("inside switch");
					bootbox.confirm({
						size: 'medium',
						title: 'Attivare/Deattivare Prodotto',
						message: dMsg,
						callback: function(confirmed){
							if(confirmed) {
									console.log(value);
									
									var urlState = contextRoot + "/manage/product/" + value + "/state";
									
									$.post(urlState, function(data){
										bootbox.alert({
										size:'medium',
										title:'Info',
										message: data
									});
								});
							} else{
								checkbox.prop('checked',!checked);
							}
						}
					});
					
				});
				
			}
			//data : products,
		});
	}
	
	// category validation
	
	var $categoryForm = $("#categoryForm");
	
	if($categoryForm.length) {
		
		$categoryForm.validate({
			
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				description: {
					required: true,
				}
			},
			messages: {
				name: {
					required: "Campo nome obbligatorio",
					minlength: "Il nome deve essere almeno due caratteri"
				},
				description: {
					required: "campo descrizione obbligatorio",
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element){
				//aggiunge la classe
				error.addClass('help-block');
				//aggiunge l'error element dopo l'input element
				error.insertAfter(element);
				
			}
			
		});
		
	}
	
	
	// login validation
	
	var $loginForm = $("#loginForm");
	
	if($loginForm.length) {
		
		$loginForm.validate({
			
			rules: {
				username: {
					required: true,
					email: true
				},
				password: {
					required: true
				}
			},
			messages: {
				username: {
					required: "Campo username obbligatorio",
					email: "Inserire un indirizzo mail valido"
				},
				password: {
					required: "Campo password obbligatorio",
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element){
				//aggiunge la classe
				error.addClass('help-block');
				//aggiunge l'error element dopo l'input element
				error.insertAfter(element);
				
			}
			
		});
		
	}	
	

});