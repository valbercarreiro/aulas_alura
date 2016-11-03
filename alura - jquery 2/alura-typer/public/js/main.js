var contadorDePalavras = function(){
    var paragrafo = $(".frase").text();

    $("#tamanho-frase").text(paragrafo.split(" ").length);
};
$(contadorDePalavras);

var campo = $(".campo-digitacao");
campo.on("input", function(){
    $("#contador-caracteres").text(campo.val().length);

    $("#contador-palavras").text(campo.val().split(/\S+/).length - 1);
});

var tempoRestante = $("#tempo-digitacao").text();
campo.one("focus", function(){
    var cronometroID = setInterval(function(){
        tempoRestante--;
        $("#tempo-digitacao").text(tempoRestante);
        if(tempoRestante < 1){
            campo.attr("disabled", true);
            clearInterval(cronometroID);
        }
    },1000);
});
