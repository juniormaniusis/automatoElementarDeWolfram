import java.lang.Math;


import java.util.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Regra {
    
    private final int numeroDaRegra;
    /*
     o número da regra em binário possui 8 dígitos
     o dígito 7 que em binário é 111
     significa o que acontece com a celula central quando tem a vizinhança 111
     que pode ser verdadeiro ou falso
    */
    
    private boolean[] digitos = new boolean[8]; //são 7 dígitos
    
    public Regra(int numeroDaRegra) {
        this.numeroDaRegra = numeroDaRegra;
        carregarDigitos();
    }

    public int getNumeroDaRegra() {
        return numeroDaRegra;
    }

    private String getNumeroDaRegraBinario() {
        String numRegra =  Integer.toString(getNumeroDaRegra(), 2); //binário
        while (numRegra.length() < 7) {
            numRegra = "0" + numRegra;
        }
        return numRegra;
    }
    
    private String booleanToString(boolean bol) {
        if (bol) {
            return "1";
        } else {
            return "0";
        }
    }

    private boolean stringToBoolean(String string) {
        if (string.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * retorna o resultado de uma celula bom base na vizinhança
     * @param cel1 estado da celula 1 
     * @param cel2 estado da celula 2
     * @param cel3 estado da celula 3
     */
    public boolean phi(boolean cel1, boolean cel2, boolean cel3) {
        String digito = "";
        digito += booleanToString(cel1);
        digito += booleanToString(cel2);
        digito += booleanToString(cel3);

        //aqui eu tenho o dígito na forma binario
        //ex: 111, 101, 001, 000 ...
        //com base nisso, sabemos o índice do vetor que devemos acessar
        int indice = Integer.parseInt(digito, 2);
        //System.out.print("\n Dig: "+digito +"Indice:"+indice);
        return this.digitos[indice];
    }

    private void carregarDigitos() {
        String numRegra = this.getNumeroDaRegraBinario();
        //System.out.println("Digitos:");
        for (int i = 0; i < numRegra.length(); i++) {
            this.digitos[i] = this.stringToBoolean( "" + numRegra.charAt(i));
           // System.out.print(this.digitos[i]);
        }
       // System.out.println();
    }


}