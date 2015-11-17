package test;

import java.awt.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import implementation.Position;
import interpreteur.svg.CourbeBezierSVG;

public class TestSVGBezier {

	public static void main(String[] args) {
			
		List<Position> sommets = new ArrayList<Position>();
		
		sommets.add(new Position(100,100));
		sommets.add(new Position(200,200));
		sommets.add(new Position(300,100));
		sommets.add(new Position(300,200));
		
		CourbeBezierSVG courbeBezier = new CourbeBezierSVG(true, sommets, false);
		courbeBezier.getCrayon().setEpaisseur(6);
		try {

			File file = new File("courbeBezier.svg");

			if (file.createNewFile()){
				System.out.println("File is created!");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(generateCode(courbeBezier));
				bw.close();


			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String generateCode(CourbeBezierSVG CourbeBezier){
		String code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n\t";
		code += CourbeBezier.generateCode()+ "\n</svg>";
		return code;
	}

}
