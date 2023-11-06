public class Investimento{

    private double saldoInicial;
    private String nome;
    private String tipo;
    private int prazo;
    private double aporte;
    private double txmRendimento;
    private double ctmRendimento;


    public Investimento(double saldoInicial, String nome, String tipo, int prazo){
        this.saldoInicial = saldoInicial;
        this.nome = nome;
        this.tipo = tipo;
        this.prazo = prazo;

    }

    public double getSaldoInicial(){
        return this.saldoInicial;
    }

    public void depositar(double valor){
        this.saldoInicial += valor;
    }

    public double sacar(double valor){
        if(valor > this.saldoInicial){
            System.out.println("Saldo insuficiente");
            return 0;
        }else{
            this.saldoInicial -= valor;
            return valor;
        }
    }

    public double preverRentabilidadeAoFinalDoPrazo(int prazo){
        if(this.tipo.equals("Poupança")){
            this.txmRendimento = 0.01;
            this.ctmRendimento = 0.01;
        }else if(this.tipo.equals("Ação")){
            this.txmRendimento = 0.1;
            this.ctmRendimento = 0.15;
        }else if(this.tipo.equals("Tesouro")){
            this.txmRendimento = 0.05;
            this.ctmRendimento = 0.1;
        }

        return this.saldoInicial * Math.pow(1 + this.txmRendimento - this.ctmRendimento, prazo);

        

    }

    public double preverRentabilidadeAposPrazoComAporte(int prazo, double aporte){
        if(this.tipo.equals("Poupança")){
            this.txmRendimento = 0.01;
            this.ctmRendimento = 0.01;
        }else if(this.tipo.equals("Ação")){
            this.txmRendimento = 0.1;
            this.ctmRendimento = 0.15;
        }else if(this.tipo.equals("Tesouro")){
            this.txmRendimento = 0.05;
            this.ctmRendimento = 0.1;
        }

        return this.saldoInicial * Math.pow(1 + this.txmRendimento - this.ctmRendimento, prazo) + aporte * (Math.pow(1 + this.txmRendimento - this.ctmRendimento, prazo) - 1) / (this.txmRendimento - this.ctmRendimento);

    }

    

}