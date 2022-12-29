package model;

import java.math.BigDecimal;

public class Venda {

    private Long operacao;
    private Long cliente;
    private Integer QtdIngressos;
    private BigDecimal valorTotal;
    private String Status;

    public Long getOperacao() {
        return operacao;
    }

    public Long getCliente() {
        return cliente;
    }

    public Integer getQtdIngressos() {
        return QtdIngressos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return Status;
    }

    public void setOperacao(Long operacao) {
        this.operacao = operacao;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public void setQtdIngressos(Integer qtdIngressos) {
        QtdIngressos = qtdIngressos;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Venda(Long operacao, Long cliente, Integer qtdIngressos, BigDecimal valorTotal) {
        this.operacao = operacao;
        this.cliente = cliente;
        QtdIngressos = qtdIngressos;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "operacao=" + operacao +
                ", cliente=" + cliente +
                ", QtdIngressos=" + QtdIngressos +
                ", valorTotal=" + valorTotal +
                ", Status='" + Status + '\'' +
                '}';
    }
}
