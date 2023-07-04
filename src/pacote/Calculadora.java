package pacote;

public class Calculadora {
    public enum OPERACAO {
        ADICAO, SUBTRACAO, DIVISAO, MULTIPLICACAO
    }

    private Double operador1;
    private Double operador2;
    private OPERACAO operacao;
    public String numero;

    public Calculadora() {
        numero="";
        operador2 = null;
        operador1 = null;
        operacao  = null;
    }

    public void setOperacao(OPERACAO operacao) {
        if(getOperador1()==null) {setOperador1(Double.parseDouble(getNumero()));};
        setNumero("");
        this.operacao = operacao;
    }

    public void setOperador1(Double operador1) {
        this.operador1 = operador1;
    }

    public void setOperador2(Double operador2) {
        this.operador2 = operador2;
    }

    public String getNumero(){ 
        return this.numero.trim();
    }
    public void setNumero(String numero){ 
        this.numero=numero;
    }

    public void limpaCalculadora(){
        this.setNumero("");
        this.operacao = null;
        this.setOperador1(null);
        this.setOperador2(null);
    }

    public Double getOperador1() {
        return operador1;
    }

    public Double getOperador2() {
        return operador2;
    }

    public OPERACAO getOperacao() {
        return operacao;
    }

    public Double calcular() {
        setOperador2(Double.parseDouble(getNumero()));
        double resposta = 0.0;
        switch(getOperacao()) {
            case ADICAO:
                resposta = operador1+operador2;
                break;
            case SUBTRACAO:
                resposta = operador1-operador2;
                break;
            case MULTIPLICACAO:
                resposta = operador1*operador2;
                break;
            case DIVISAO:
                resposta = operador1/operador2;
                break;
        }
        this.setNumero("");
        this.operacao = null;
        this.setOperador1(resposta);
        this.setOperador2(null);
        return resposta;
    }
}
