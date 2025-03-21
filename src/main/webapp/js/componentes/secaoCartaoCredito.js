import { criarElemento } from "../script.js";
import { FormularioCartaoCredito } from "./forms/formCartaoCredito.js";

export class SecaoFormsCartaoCredito extends HTMLElement {
    constructor(){
        super();

        this.append(criarElemento("p", "Cartões de crédito"));

        this.container = document.createElement('div');
        this.container.id = 'container-cartao-credito';
        this.append(this.container);

        const footer = document.createElement('div');
        footer.id = 'footer-secao-cartao-credito';
        this.append(footer);

        this.buttonAddCartao = criarElemento('button', '+ Novo Cartão de Crédito');
        this.buttonAddCartao.type = 'button';
        this.buttonAddCartao.onclick = () => this.adicionarCartaoCredito();
        footer.append(this.buttonAddCartao);
    }

    adicionarCartaoCredito(){
        const nCartoesCreditoNaTela = document.querySelectorAll('.cartao-credito').length + 1;
        const form = new FormularioCartaoCredito();
        form.setNumeroTitulo(nCartoesCreditoNaTela);
        this.container.append(form);
        return form;
    }
}

customElements.define('secao-form-cartao-credito', SecaoFormsCartaoCredito, {extends:"section"});