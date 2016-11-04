function removeLinha(){
    event.preventDefault();
    $(this).parent().parent().remove();
};

var novaLinha = function(usuario,numPalavras){
    var linha = $("<tr>");
    var colUser = $("<td>").text(usuario);
    var colPalavras = $("<td>").text(numPalavras);
    var colRemover = $("<td>");

    var link = $("<a>").addClass("botao-remover").attr("href","#");
    var icone = $("<i>").addClass("small").addClass("material-icons").text("delete");

    link.append(icone);
    colRemover.append(link);
    linha.append(colUser).append(colPalavras).append(colRemover);

    return linha;
};

var inserePlacar = function(){
    var bodyTable = $(".placar").find("tbody");
    var usuario = "Valber";
    var numPalavras = $("#contador-palavras").text();

    var linha = $(novaLinha(usuario,numPalavras));
    linha.find(".botao-remover").click(removeLinha);

    bodyTable.prepend(linha);
};
