package dev.uni;

import java.util.Date;

public class Alimentos extends Produtos{
    private Date dataVencimento;

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Alimentos(String nome, String descricao, double preco, Date dataVencimento) {
        super(nome, descricao, preco);
        this.dataVencimento = dataVencimento;
    }
}
