import java.lang.Math;

public class Automato {
    private  int largura;
    private Regra regra;
    private Celula[] automato;
    public boolean[][] historico;
    public final int NUM_EXECUCOES = 1000;

    public Automato(int largura, int numRegra) {
        this.largura    = largura;
        this.regra = new Regra(numRegra);
        this.automato      = new Celula[this.largura];
        this.historico = new boolean[NUM_EXECUCOES][this.largura];
        //inicializa a automato de forma aleatória
        for (int i = 0; i < this.automato.length; i++) {
                double num = Math.random();
                if (num > 0.5) {
                    this.automato[i] = new Celula(true, i);
                } else {
                    this.automato[i] = new Celula(false, i);
                }
        }
        
        
    }

    //vizinhança
    //dado uma celula, temos que encontrar as suas celulas vizinhas
    //

    public int[] getVizinhanca(Celula cel) {
        int[] vizinhanca = new int[3];
        vizinhanca[1] = cel.getIndice(); //a celula sempre faz parte da sua vizinhança

        //pegar o sucessor
        if (cel.getIndice() == automato.length - 1) {
            vizinhanca[2] = 0;
        } else {
            vizinhanca[2] =  cel.getIndice() + 1;
        }

        //pega o antecessor 
        if (cel.getIndice() == 0) {
            vizinhanca[0] = automato.length - 1;
        } else {
            vizinhanca[0] = cel.getIndice() - 1;
        }

        return vizinhanca;
    }

    public Celula[] novaIteracao() {
        Celula[] proxAutomato = new Celula[this.largura];

        for (int i = 0; i < this.automato.length; i++) {
            //pega a vizinhança da celula atual
            int[] vizinhanca = getVizinhanca(this.automato[i]);
            boolean estado = regra.phi(this.automato[vizinhanca[0]].getEstado(),
                                        this.automato[vizinhanca[1]].getEstado(),
                                        this.automato[vizinhanca[2]].getEstado());

            proxAutomato[i] = new Celula(estado, i);
            //System.out.print(estado);
        }
        //System.out.println();
        return proxAutomato;
    }

    public void imprimir() {
        for (Celula cel : this.automato) {
            System.out.print(cel.toString());
        }
       System.out.println();
    }

    public void executar() {

        for (int i = 0; i < NUM_EXECUCOES; i++) {
           // imprimir();
            for (int j = 0; j < this.automato.length; j++) {
                this.historico[i][j] = automato[j].getEstado();
            }
            this.automato = novaIteracao();
        }
       // imprimir();
    }
}