import java.time.LocalDate;

public class Despesa {

    private LocalDate data;
    private String descDespesa;
    private Double valor;

    public Despesa(LocalDate data, String descDespesa, Double valor) {

        this.data = data;
        this.descDespesa = descDespesa;
        this.valor = valor;

    }

    public String toString() {

        return "Data: " + data + "\nDescrição: " + descDespesa + "\nValor: R$" + valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescDespesa() {
        return descDespesa;
    }

    public void setDescDespesa(String descDespesa) {
        this.descDespesa = descDespesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}