package test;

import java.awt.Color;
import java.io.*;

import implementation.Position;
import interpreteur.svg.EllipseSVG;

public class TestDessinEllipse {

	public static void main(String[] args) {
			
		EllipseSVG ellipse = new EllipseSVG(new Position(250,250),50,30,90,false);
		ellipse.getCrayon().setEpaisseur(10);
		try {

			File file = new File("ellipse.svg");

			if (file.createNewFile()){
				System.out.println("File is created!");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(generateCode(ellipse));
				bw.close();


			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String generateCode(EllipseSVG ellipse){
		String code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n\t";
		code += ellipse.generateCode()+ "\n</svg>";
		return code;
	}

}
