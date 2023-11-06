public class Main{

    public static void main(String[] args){

        Investimento investimento = new Investimento(1000, "Investimento 1", "Poupança", 12);
        investimento.depositar(1000);
        investimento.sacar(100);
        investimento.escolherTipoInvestimento("Poupança");
        investimento.preverRentabilidadeAoFinalDoPrazo();
        investimento.preverRentabilidadeAoFinalDoPrazoComAporteMensal(500);

        



     
    }



}