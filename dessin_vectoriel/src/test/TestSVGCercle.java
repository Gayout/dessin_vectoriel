package test;

import java.awt.Color;

import java.io.*;

import implementation.Position;
import interpreteur.svg.CercleSVG;

public class TestSVGCercle {

	public static void main(String[] args) {
			
		CercleSVG cercle = new CercleSVG(new Position(250,250),90,false);
		cercle.getCrayon().setEpaisseur(6);
		try {

			File file = new File("cercle.svg");

			if (file.createNewFile()){
				System.out.println("File is created!");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(generateCode(cercle));
				bw.close();


			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String generateCode(CercleSVG cercle){
		String code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n\t";
		code += cercle.generateCode()+ "\n</svg>";
		return code;
	}

}
