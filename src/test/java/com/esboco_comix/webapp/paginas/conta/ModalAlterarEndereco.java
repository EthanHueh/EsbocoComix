package com.esboco_comix.webapp.paginas.conta;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esboco_comix.model.entidades.Endereco;

public class ModalAlterarEndereco {

    private WebDriver driver;

    private WebElement form;
    private WebElement botaoAbrirModal;
    private WebElement botaoEnviar;

    public ModalAlterarEndereco(WebDriver webDriver){
        this.driver = webDriver;
        
        this.form = webDriver.findElement(By.id("alterar-endereco"));
        this.botaoAbrirModal = webDriver.findElement(By.id("btn-alterar-endereco"));
        this.botaoEnviar = form.findElement(By.className("botao-salvar"));
    }

    public void abrirModal(){
        this.botaoAbrirModal.click();
    }

    public void preencherInput(String nome, String valorInput){
        this.form.findElement(By.name(nome)).clear();
        this.form.findElement(By.name(nome)).sendKeys(valorInput);
    }

    public void preencher(Endereco e){
        preencherInput("numero", e.getNumero());
    }

    public void enviar(){
        this.botaoEnviar.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
    }
}
