var contadorDePalavras = function(){
    var paragrafo = $(".frase").text();

    $("#tamanho-frase").text(paragrafo.split(" ").length);
};
$(contadorDePalavras);
