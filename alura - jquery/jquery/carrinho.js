var umaPropaganda = function(){
  var propagandas = ["O que acha de comprar uma motocicleta?",
                    "O que acha de comprar uma lancha?",
                    "O que acha de comprar uma bicicleta?",
                    "O que acha de comprar uma carro?"];
    var posicao = Math.floor(propagandas.length * Math.random());
    var texto = propagandas[posicao];
    var tr = $("<tr>").addClass("propaganda").append($("<td>"));
    tr.find("td").attr("colspan",6).text(texto);
    return tr;
};

var atualizaDados = function(){
    var carrinhos = $(".carrinho");
    carrinhos.each(function(){
        var carrinho = $(this);
        var items = carrinho.find(".item-total:visible");
        var total = 0;
        for(i=0; i<items.length; i++){
            var item = $(items[i]);
            var valor = parseFloat(item.text());
            total = total + valor;
        }
        console.log("valor total "+total);
        carrinho.find(".valorTotal").text(total);
        carrinho.find(".quantidade-de-itens").text(items.length);
    });
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
    var carrinho = $(this).closest(".carrinho");
    carrinho.find("tr:visible").removeClass("recuperado");

    var trs = carrinho.find("tr:hidden");
    trs.addClass("recuperado");
    trs.show();
    atualizaDados();
};

var darDestaque = function(){
    $(this).find(".remove-item").fadeIn();
    $(this).addClass("hovering");
};

var tiraDestaque = function(){
    $(this).find(".remove-item").fadeOut();
    $(this).removeClass("hovering");
};

var escondePropagandas = function(event){
    event.preventDefault();
    $(".propaganda").fadeOut(5000);
};

var mostrarPropagandas = function(event){
    event.preventDefault();
    $(".propaganda").fadeIn(5000);
};

var alternaPropagandas = function(event){
    event.preventDefault();
    $(".propaganda").fadeToggle();
    $(".alterna-propaganda").toggle();
};

var aposInicializado = function(){
    atualizaDados();
    $(".undo").click(undo);
    $(".remove-item").click(removeItem);

    $(".carrinho").each(function(){
        //$(this).find("tr:nth-child(3n), tr:last").each(function(){ //para exibir ao final das tr's
        $(this).find("tr:nth-child(3n)").each(function(){
            umaPropaganda().insertAfter($(this));
        });
    });

    $("tr").on("mouseenter", darDestaque);
    $("tr").on("mouseleave", tiraDestaque);
    //$("tr").hover(darDestaque, tiraDestaque);
    //$(".carrinho tbody tr").hover(daDestaque, tiraDestaque);

    $(".alterna-propaganda").click(alternaPropagandas);
}
$(aposInicializado);
