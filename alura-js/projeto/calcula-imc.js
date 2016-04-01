var peso = 63;
var altura = 1.7;

if(altura > 0){
  var imc = peso / (altura * altura);
  console.log(peso);
  console.log(altura);
  console.log(imc);
} else {
  console.log("O valor da altura deve ser maior que zero.");
}
