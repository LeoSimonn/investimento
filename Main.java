public class Main{

    public static void main(String[] args){

        Investimento investimento = new Investimento(1000, "Investimento 1", "Poupança", 12);

        investimento.depositar(1000);
        investimento.sacar(500);
        investimento.sacar(1000);

        System.out.println(investimento.getSaldoInicial());


     
    }



}