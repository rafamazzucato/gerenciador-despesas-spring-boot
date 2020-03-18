/**
 * JAVASCRIPT PARA UTILIZAÇÂO NA TELA DE LISTAGEM DE DESPESAS
 */

var codigo = '';

$('.link-exclusao').on('click', function(event){
	
	var button = $(event.currentTarget);
	
	codigo = button.data('codigo');
	
	var modal = $('#confirmaRemocaoModal');
	modal.removeClass('fade');
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a despesa <strong>' + codigo + '</strong>?');
	modal.show();
});

$('#cancelar').on('click', function(event){
	$('#confirmaRemocaoModal').hide();
});

$('#confirmar').on('click', function(event){
	event.preventDefault();
	
	$.ajax({
		url:'/despesas/'+codigo,
        method: 'DELETE',
        success: function(result) {
            window.location =  '/despesas'
        },
    });
});