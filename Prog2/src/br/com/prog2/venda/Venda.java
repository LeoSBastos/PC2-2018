package br.com.prog2.venda;

import java.util.Date;
import br.com.prog2.util.Util;

public class Venda{
    Integer codigo;
    Double valor;
    Date dataDeVenda;
    Double valorComDesconto;

    public Venda(Integer codigo, Double valor){
        this.codigo = codigo;
        this.valor = valor;
        this.dataDeVenda = new Date();
    }
    public void calculaDesconto(Double taxa){
        this.valorComDesconto = this.valor*(1-(taxa/100));
    }
    public String toString(){
       return "Codigo do produto: "+this.codigo+
              "\nValor total: "+this.valor+
              "\nValor com desconto: "+this.valorComDesconto+
              "\nData da compra: "+Util.formataData(dataDeVenda);
    }
}
