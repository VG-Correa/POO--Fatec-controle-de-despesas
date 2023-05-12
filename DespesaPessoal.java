import java.security.cert.PKIXRevocationChecker.Option;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DespesaPessoal {

    private String cpf;
    private ArrayList<Despesa> despesas = new ArrayList<Despesa>();

    public DespesaPessoal(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void insertDespesas(Despesa despesa) {
        this.despesas.add(despesa);
    }

    public String toString() {

        String texto = "";

        for (Despesa despesa : despesas) {

            texto = texto + "\n================\n" + despesa;

        }

        texto = texto + "\n================\n";

        return "CPF: " + cpf + "\nDespesas: " + texto;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (Despesa despesa : despesas) {
            total += despesa.getValor();
        }
        return total;
    }

    public Double getTotal(int mes, int ano) {

        Double total = 0.0;

        for (Despesa despesa : despesas) {
            if (despesa.getData().getMonth().getValue() == mes & despesa.getData().getYear() == ano) {
                total += despesa.getValor();
            }
        }

        return total;
    }

    public Double getTotal(LocalDate data) {
        Double total = 0.00;
        for (Despesa despesa : despesas) {
            if (despesa.getData() == data) {
                total += despesa.getValor();
            }
        }
        return total;
    }

    public void imprime() {
        String texto = "!Despesas!";

        for (Despesa despesa : despesas) {

            texto = texto + "\n================\n" + despesa;

        }
        texto = texto + "\n================\nValor Total: R$";

        texto = texto + getTotal() + "\n================";

        JOptionPane.showMessageDialog(null, texto);
    }

    public void imprime(int mes, int ano) {

        String texto = "!Despesas!";

        for (Despesa despesa : despesas) {
            if (despesa.getData().getMonthValue() == mes & despesa.getData().getYear() == ano) {
                texto = texto + "\n================\n" + despesa;
            }
        }

        texto = texto + "\n================";
        JOptionPane.showMessageDialog(null, texto);
    }

    public void imprime(LocalDate data) {
        String texto = "!Despesas!";

        for (Despesa despesa : despesas) {
            if (despesa.getData() == data) {
                texto = texto + "\n================\n" + despesa;
            }
        }

        texto = texto + "\n================";
        JOptionPane.showMessageDialog(null, texto);
    }

}
