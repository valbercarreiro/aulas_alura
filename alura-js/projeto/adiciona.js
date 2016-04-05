var botao = document.querySelector("#adicionar-paciente");

botao.addEventListener("click", function(){

  event.preventDefault();

  var campoNome = document.querySelector("#campo-nome");
  var campoPeso = document.querySelector("#campo-peso");
  var campoAltura = document.querySelector("#campo-altura");

  var pacienteNovo = "<tr class='paciente'>"+
                        "<td class='info-nome'>"+campoNome.value+"</td>"+
                        "<td class='info-peso'>"+campoPeso.value+"</td>"+
                        "<td class='info-altura'>"+campoAltura.value+"</td>"+
                        "<td class='info-imc'>"+campoPeso.value/(campoAltura.value*campoAltura.value)+"</td>"+
                      "</tr>";

  //var table = document.getElementsByTagName("table")[0];
  var table = document.querySelector("table"); //retorna a primeira tag table que encontrar
  //var table = document.querySelectorAll("table"); //retorna um array com todas as tables da tela.

  table.innerHTML = table.innerHTML + pacienteNovo;

  campoNome.value = "";
  campoPeso.value = "";
  campoAltura.value = "";
});
