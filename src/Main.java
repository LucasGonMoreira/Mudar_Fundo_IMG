import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String img = "src\\ImagePath\\img.png";
        String imgFundo = "src\\ImagePath\\pixel.jpeg";

        BufferedImage imagem = ImageIO.read(new File(img));
        BufferedImage imagemFundo = ImageIO.read(new File(imgFundo));

        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imagemNova = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

        for (int largura=0; largura<width; largura++){
            for (int altura=0; altura<height; altura++){

                int rgb = imagem.getRGB(largura,altura);

                Color cor = new Color(rgb, true);

                int green = cor.getGreen();
                int blue = cor.getBlue();
                int red = cor.getRed();

                //(1,255,2)
                if (red <= 80 && green >= 180 && blue <= 80){

                    imagemNova.setRGB(largura,altura,new Color(0,0,0,0).getRGB());

                }else {
                    imagemNova.setRGB(largura,altura,rgb);
                }
            }
        }
        for (int largura=0; largura<width; largura++){
            for (int altura=0; altura<height; altura++){

                int rgb = imagemNova.getRGB(largura,altura);

                Color cor = new Color(rgb, true);

                if (cor.getAlpha() == 0){

                    imagemNova.setRGB(largura,altura,imagemFundo.getRGB(largura,altura));

                }else {
                    imagemNova.setRGB(largura,altura,rgb);
                }
            }
        }

        ImageIO.write(imagemNova, "png", new File("src\\ImagePath\\nova_imagem.png"));

    }
}

