$(document).ready(function(){
		
		$('.btn-borrar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			
			$.ajax({
				url : "pizzas/"+id,
				type: 'DELETE',
			    success: function(result) {
			    	$('tr[data-id="'+id+'"]').remove();
					var pizzas = parseInt( $('#cantidad-pizzas').text() );
			    	$('#cantidad-pizzas').text(pizzas - 1);
			    }
			});				
		});
		
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = 'pizzas/'+id;
			
			$.get(url)
				.done(function(pizza){
					$('#id').val(pizza.id);
					$('#nombre').val(pizza.nombre);
					$('#categoria').val(pizza.categoria);
					$('#precio').val(precio.categoria);
					$('#form-pizza.modal-tittle').text("Editando...");
					
					$('#modal-pizza').modal('show');
				});
		});
		
	});