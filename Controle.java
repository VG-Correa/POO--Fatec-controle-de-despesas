import java.time.LocalDate;
import java.time.Month;

import javax.lang.model.type.ErrorType;
import javax.swing.JOptionPane;
import javax.swing.text.ComponentView;;

public class Controle {

    protected static int dia;
    protected static int mes;
    protected static int ano;

    protected static String itemDespesa;
    protected static Double valor;

    protected static DespesaPessoal dp;

    public Controle() {
    }

    public static void controleDespesas() {

        int opt = Integer.parseInt(JOptionPane.showInputDialog("1 - Lançamento de despesa;\n"
                + "2 - Total geral de despesas;\n"
                + "3 - Total de despesas mês/ano;\n"
                + "4 - Total de despesas dia/mês/ano;\n"
                + "5 - Imprimir todas as despesas;\n"
                + "6 - Imprimir despesas de um mês/ano;\n"
                + "7 - Imprimir despesas de um dia/mês/ano;\n"
                + "8 - Sair."));

        if (opt == 1) {
            entradaDespesa();
        } else if (opt == 2) { // Total geral de despesas;

            Double total = dp.getTotal();

            JOptionPane.showMessageDialog(null, "Total geral das despesas:\nR$" + total);

        } else if (opt == 3) { // Total de despesas mês/ano;
            entradaMes();
            entradaAno();

            Double total = dp.getTotal(mes, ano);
            JOptionPane.showMessageDialog(null, "Total geral das despesas em " + mes + "/" + ano + "\nR$" + total);

        } else if (opt == 4) { // Total de despesas dia/mês/ano;
            entradaDia();
            entradaMes();
            entradaAno();

            LocalDate data = LocalDate.of(ano, mes, dia);

            Double total = dp.getTotal(data);
            JOptionPane.showMessageDialog(null,
                    "Total geral das despesas em " + dia + "/" + mes + "/" + ano + "\nR$" + total);

        } else if (opt == 5) { // Imprimir todas as despesas;
            dp.imprime();

        } else if (opt == 6) { // Imprimir despesas de um mês/ano;
            entradaMes();
            entradaAno();
            dp.imprime(mes, ano);

        } else if (opt == 7) { // Imprimir despesas de um dia/mês/ano;
            entradaDia();
            entradaMes();
            entradaAno();

            LocalDate data = LocalDate.of(ano, mes, dia);
            dp.imprime(data);

        } else if (opt == 8) { // Sair.
            System.exit(0);
        }

    }

    public static void entradaDespesa() {
        entradaDia();
        entradaMes();
        entradaAno();

        LocalDate data = LocalDate.of(ano, mes, dia);

        String descricao_despesa = JOptionPane.showInputDialog("Digite a descrição da despesa");
        Double valor = Double
                .parseDouble(JOptionPane.showInputDialog("Digite o valor da despesa\nAPENAS NÚMEROS "));

        Despesa despesa = new Despesa(data, descricao_despesa, valor);
        dp.insertDespesas(despesa);
    }

    public static void entradaDia() {
        dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia"));
    }

    public static void entradaMes() {
        mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês: "));
    }

    public static void entradaAno() {
        ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: "));
    }

    public static void main(String[] args) {
        dp = new DespesaPessoal(JOptionPane.showInputDialog("Insira seu CPF"));

        while (true) {
            controleDespesas();
        }

    }

}
