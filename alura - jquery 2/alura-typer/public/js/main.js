var campo = $(".campo-digitacao");

$(function(){
    $(contadorDePalavras);
    $(inicializaContatodes);
    $(inicializaCronometro);
    $("#botao-reiniciar").click(reiniciaJogo);
    $(inicializaMarcadores);
});

var contadorDePalavras = function(){
    var paragrafo = $(".frase").text();

    $("#tamanho-frase").text(paragrafo.split(" ").length);
};

var inicializaContatodes = function(){
    campo.on("input", function(){
        $("#contador-caracteres").text(campo.val().length);

        $("#contador-palavras").text(campo.val().split(/\S+/).length - 1);
    });
};

var inicializaCronometro = function(){
    var tempoRestante = $("#tempo-digitacao").text();
    campo.one("focus", function(){
        $("#botao-reiniciar").attr("disabled",true);
        var cronometroID = setInterval(function(){
            tempoRestante--;
            $("#tempo-digitacao").text(tempoRestante);
            if(tempoRestante < 1){
                campo.attr("disabled", true);
                clearInterval(cronometroID);
                $("#botao-reiniciar").attr("disabled", false);
                campo.toggleClass("campo-desativado");
            }
        },1000);
    });
};

var inicializaMarcadores = function(){
    var frase = $(".frase").text();
    campo.on("input", function(){
        var digitado = campo.val();
        var comparavel = frase.substr(0, digitado.length);

        if(digitado == comparavel){
            campo.removeClass("borda-vermelha");
            campo.addClass("borda-verde");
        } else {
            campo.removeClass("borda-verde");
            campo.addClass("borda-vermelha");
        }
    });
}

var reiniciaJogo = function(){
    campo.attr("disabled", false);
    campo.val("");
    $("#contador-palavras").text("0");
    $("#contador-caracteres").text("0");
    $("#tempo-digitacao").text("10");
    campo.toggleClass("campo-desativado");
    $(inicializaCronometro);
    campo.removeClass("borda-vermelha");
    campo.removeClass("borda-verde");
};
