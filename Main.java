import java.io.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int numCelulas = 0;
        int numRegra = 0;

        do {
            System.out.println("Digite o número de células do automato:");
            numCelulas = teclado.nextInt();
        } while (numCelulas <= 0);
        
        do {
            System.out.println("Digite o número da regra de Wolfram: \n [Deve ser um númetro entre 0 e 256]");
            numRegra = teclado.nextInt();
        } while(numRegra < 0 && numRegra > 255);

        System.out.println("c:" +numCelulas + "r:" + numRegra);
        Automato aut = new Automato(numCelulas, numRegra); //numero de células, regra de Wolfram
        aut.executar();
        export(aut.historico);
    }

    public static void export (boolean[][] data) {
        int height = data.length;
        int width = data[0].length;
        BufferedImage outImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (data[i][j]) {
                    outImage.setRGB (j, i, 0x00000000);
                } else {
                    outImage.setRGB (j, i, 0xffffffff);
                }
            }
        }
        try {
            // Save as PNG
            File file = new File("outimage.png");
            ImageIO.write(outImage, "png", file);
        } catch (IOException e) {
    
        }

    }
}
