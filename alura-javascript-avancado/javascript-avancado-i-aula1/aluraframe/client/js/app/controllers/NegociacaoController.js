class NegociacaoController {

    constructor(){
        let $ = document.querySelector.bind(document);
        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        
        this._listaNegociacoes = new Bind(new ListaNegociacoes(), new NegociacoesView($('#negociacoesView')), 'adiciona','esvazia');
        
        this._mensagem = new Bind(new Mensagem(), new MensagemView($('#mensagemView')), 'texto');
    }

    adiciona(event){
        event.preventDefault();
        let negociacao = this._criaNegociacao();        
        this._listaNegociacoes.adiciona(negociacao);
        this._mensagem.texto = 'Negociação adicionada com sucesso.';
        this._limpaFormulario();        
    }

    _criaNegociacao() {
        return new Negociacao(
                            DataHelper.textoParaData(this._inputData.value), 
                            this._inputQuantidade.value, 
                            this._inputValor.value
                        );
    }

    _limpaFormulario() {
        this._inputData.value = '';
        this._inputQuantidade.value = 1;
        this._inputValor.value = 0.0;
        this._inputData.focus();
    }

    apaga() {
        this._listaNegociacoes.esvazia();
        this._mensagem.texto = 'Lista de Negociações apagadas com sucesso';
    }

    importaNegociacoes() {
        let service = new NegociacaoService();
        service.obterNegociacoesDaSemana((err, negociacoes) => {
            if(err){
                this._mensagem.texto = err;
                return;
            }

            negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
            this._mensagem.texto = 'Negociações importadas com sucesso';
        });
    }
}