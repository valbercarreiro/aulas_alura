var atualizaDados = function(){
    var items = $(".item-total:visible");
    var total = 0;
    for(i=0; i<items.length; i++){
        var item = $(items[i]);
        var valor = parseFloat(item.text());
        total = total + valor;
    }
    console.log("valor total "+total);
    $("#valorTotal").text(total);
    $("#quantidade-de-itens").text(items.length);
};

var removeItem = function(event){
    var self = $(this);
    self.closest("tr").hide();
    event.preventDefault();
    var atual = parseInt($("#quantidade-de-itens").text());
    var novaQuantidade = atual - 1;
    $("#quantidade-de-itens").text(novaQuantidade);

    /*var precoAtual = parseFloat($("#valorTotal").text());
    var preco = parseFloat(self.closest("tr").find(".item-total").text());
    var precoFinal = precoAtual - preco;
    $("#valorTotal").text(precoFinal);*/
    atualizaDados();
};

var undo = function(){
    $("tr:visible").removeClass("recuperado");

    var trs = $("tr:hidden");
    trs.addClass("recuperado");
    trs.show();
    atualizaDados();
};

var aposInicializado = function(){
    atualizaDados();
    $("#undo").click(undo);
    $(".remove-item").click(removeItem);
}
$(aposInicializado);
