import java.util.Scanner;

public class Investimento {
    // Atributos da classe Investimento
    private double saldo;
    private String nome;
    private String tipo; // acao, tesouro, poupanca
    private int prazo; // em meses
    private double taxaRendimentoMensal; // em porcentagem
    private double custoManutencao; // em porcentagem do lucro obtido

    // Construtor
    public Investimento(double saldo, String nome, String tipo, int prazo) {
        this.saldo = saldo;
        this.nome = nome;
        this.tipo = tipo;
        this.prazo = prazo;
    }

    // Métodos Getters e Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public double getTaxaRendimentoMensal() {
        return taxaRendimentoMensal;
    }

    public double getCustoManutencao() {
        return custoManutencao;
    }

    // Método para depositar um valor no saldo
    public void depositar(double valor) {
        this.saldo += valor;
    }

    // Método para sacar um valor do saldo
    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true; // Saque realizado com sucesso
        } else {
            System.out.println("Operação não realizada: Saldo insuficiente.");
            return false; // Saque não realizado
        }
    }

    // Método para escolher o tipo de investimento
    public void escolherTipoInvestimento(String tipo) {
        System.out.println("Os tipos de investimento disponíveis são: Ação, Tesouro e Poupança.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tipo de investimento: ");
        tipo = scanner.nextLine();
        if (tipo.equals("Ação")){
            this.taxaRendimentoMensal = 10;
            this.custoManutencao = 15;
        } else if (tipo.equals("Tesouro")) {
            this.taxaRendimentoMensal = 5;
            this.custoManutencao = 10;
        } else if (tipo.equals("Poupança")) {
            this.taxaRendimentoMensal = 1;
            this.custoManutencao = 1;
        } else {
            System.out.println("Tipo de investimento inválido.");
        }
    }

    // Método para prever a rentabilidade ao final do prazo
    public double preverRentabilidadeAoFinalDoPrazo() {
        double saldoPrevisto = this.saldo;
        for (int i = 0; i < this.prazo; i++) {
            double rendimento = saldoPrevisto * (this.taxaRendimentoMensal / 100);
            double custo = rendimento * (this.custoManutencao / 100);
            saldoPrevisto += (rendimento - custo);
        }
        return saldoPrevisto - this.saldo; // Retorna apenas o rendimento
    }

    // Método para prever a rentabilidade ao final do prazo considerando aporte mensal
    public double preverRentabilidadeAoFinalDoPrazoComAporteMensal(double aporteMensal) {
        double saldoPrevisto = this.saldo;
        for (int i = 0; i < this.prazo; i++) {
            saldoPrevisto += aporteMensal;
            double rendimento = saldoPrevisto * (this.taxaRendimentoMensal / 100);
            double custo = rendimento * (this.custoManutencao / 100);
            saldoPrevisto += (rendimento - custo);
        }
        return saldoPrevisto - this.saldo; // Retorna apenas o rendimento
    }
}
