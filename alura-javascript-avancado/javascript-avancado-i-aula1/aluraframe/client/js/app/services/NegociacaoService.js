class NegociacaoService {

    obterNegociacoesDaSemana(cb){
        let xhr = new XMLHttpRequest();

        xhr.open('GET','negociacoes/semana');
        xhr.onreadystatechange = () => {
            if(xhr.readyState == 4){
                if(xhr.status == 200) {

                    let dados = JSON.parse(xhr.responseText);
                    cb(null, dados
                    .map(dado => new Negociacao(new Date(dado.data), dado.quantidade, dado.valor)));
                       
                } else {
                    console.log(xhr.responseText);
                    cb('Não foi possível recuperar as negociações da semana', null); 
                }
            }
        };
        xhr.send();
    }

    obterNegociacoesDaSemanaRetrasada(){
        let xhr = new XMLHttpRequest();

        xhr.open('GET','negociacoes/retrasada');
        xhr.onreadystatechange = () => {
            if(xhr.readyState == 4){
                if(xhr.status == 200) {

                    let dados = JSON.parse(xhr.responseText);
                    cb(null, dados
                    .map(dado => new Negociacao(new Date(dado.data), dado.quantidade, dado.valor)));
                    
                    this._mensagem.texto = 'Negociações importadas com sucesso';
                } else {
                    console.log(xhr.responseText);
                    cb('Não foi possível recuperar as negociações da semana', null); 
                }
            }
        };
        xhr.send();
    }
    
    obterNegociacoesDaSemanaAnterior(){
        let xhr = new XMLHttpRequest();

        xhr.open('GET','negociacoes/anterior');
        xhr.onreadystatechange = () => {
            if(xhr.readyState == 4){
                if(xhr.status == 200) {

                    let dados = JSON.parse(xhr.responseText);
                    cb(null, dados
                    .map(dado => new Negociacao(new Date(dado.data), dado.quantidade, dado.valor)));
                    
                    this._mensagem.texto = 'Negociações importadas com sucesso';
                } else {
                    console.log(xhr.responseText);
                    cb('Não foi possível recuperar as negociações da semana', null); 
                }
            }
        };
        xhr.send();
    }
}