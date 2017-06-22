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
	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

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
							return '<span style:"color:red">Esaurito</span>';
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
						
						if(row.quantity < 1){
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						} else {
							str += '<a href="'+contextRoot+'/add/cart/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';	
						}
						
						
						return str;
					}
				}
			]
			//data : products,
		})
	}
	

});