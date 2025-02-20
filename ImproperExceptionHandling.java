interface Operacao {
    int divite(int a,int b);
}

class DivisaoInteira implements Operacao{

    @Override
    public int divite(int a, int b) {
        return a / b;
    }

}

class Calculadora{
    private Operacao operacaoDivisao;

    public Calculadora(Operacao operacao){
        this.operacaoDivisao = operacao;
    }

    public int calcular(int a, int b){
        
        return operacaoDivisao.divite(a, b);

    }

}

public class TratamentoExcecoes {
    public void tratarDivisaoPorZero(ArithmeticException e){
        System.err.println("Erro: Divisão por zero não permitida.");
    }
    public void tratarProblemas(Exception e){
        System.err.println("Erro: Ocorreu um erro durante o cálculo: " + e.getMessage());
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Operacao divisao = new DivisaoInteira();
        Calculadora calculo = new Calculadora(divisao);
        TratamentoExcecoes excecoes = new TratamentoExcecoes();


        try {
            int resultado = calculo.calcular(10, 1);
            System.out.println("Resultado  "+resultado);
        } catch (ArithmeticException e) {
            excecoes.tratarDivisaoPorZero(e);
        } catch (Exception e) {
            excecoes.tratarProblemas(e);
        }
        
    }
}
