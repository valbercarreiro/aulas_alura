/*var peso1 = document.getElementById("peso-1").textContent;
var altura1 = document.getElementById("altura-1").textContent;
var paciente1 = {peso : peso1, altura : altura1};

var peso2 = document.getElementById("peso-2").textContent;
var altura2 = document.getElementById("altura-2").textContent;
var paciente2 = {peso : peso2, altura : altura2};

var pacientes = [paciente1, paciente2];*/

var pacientesTr = document.getElementsByClassName("paciente");

for(var i=0; i < pacientesTr.length; i++){

  var pacienteTr = pacientesTr[i];
  var tdNome = pacienteTr.getElementsByClassName("info-nome")[0];
  var tdPeso = pacienteTr.getElementsByClassName("info-peso")[0];
  var tdAltura = pacienteTr.getElementsByClassName("info-altura")[0];

  var paciente = {nome : tdNome.textContent, peso : tdPeso.textContent, altura : tdAltura.textContent};

  if(paciente.altura > 0){
    var imc = paciente.peso / (paciente.altura * paciente.altura);

    var tdImc = pacienteTr.getElementsByClassName("info-imc")[0];
    tdImc.textContent = imc;

    console.log(imc);
  } else {
    console.log("O valor da altura deve ser maior que zero.");
  }
}
