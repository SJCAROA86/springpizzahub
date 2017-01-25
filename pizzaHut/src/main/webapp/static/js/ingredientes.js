	$(document).ready(function(){
		
		$('.btn-borrar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			
			$.ajax({
				url : "ingredientes/"+id,
				type: 'DELETE',
			    success: function(result) {
			    	$('tr[data-id="'+id+'"]').remove();
					var ingredientes = parseInt( $('#cantidad-ingredientes').text() );
			    	$('#cantidad-ingredientes').text(ingredientes - 1);
			    }
			});				
		});
		
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = 'ingredientes/'+id;
			
			$.get(url)
				.done(function(ingrediente){
					$('#id').val(ingrediente.id);
					$('#nombre').val(ingrediente.nombre);
					$('#categoria').val(ingrediente.categoria);
					$('#form-ingrediente.modal-tittle').text("Editando...");
					
					$('#modal-ingrediente').modal('show');
				});
		});
		
	});
	