package test;


import java.awt.Font;
import java.io.*;

import implementation.Position;
import interpreteur.svg.TexteSVG;

public class TestSVGTexte {

	public static void main(String[] args) {
			
		TexteSVG Texte = new TexteSVG(20, "Hello !", Font.SANS_SERIF, new Position(100,100));
		try {

			File file = new File("Texte.svg");

			if (file.createNewFile()){
				System.out.println("File is created!");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(generateCode(Texte));
				bw.close();


			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String generateCode(TexteSVG Texte){
		String code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n\t";
		code += Texte.generateCode()+ "\n</svg>";
		return code;
	}

}
