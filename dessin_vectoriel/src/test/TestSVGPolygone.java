package test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import implementation.Position;
import interpreteur.svg.PolygoneSVG;

public class TestSVGPolygone {

	public static void main(String[] args) {
			
		List<Position> sommets = new ArrayList<Position>();
		
		sommets.add(new Position(100,100));
		sommets.add(new Position(200,200));
		sommets.add(new Position(300,100));
		
		PolygoneSVG Polygone = new PolygoneSVG(sommets, false, true);
		Polygone.getCrayon().setEpaisseur(6);
		try {

			File file = new File("polygone.svg");

			if (file.createNewFile()){
				System.out.println("File is created!");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(generateCode(Polygone));
				bw.close();


			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String generateCode(PolygoneSVG polygone){
		String code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n\t";
		code += polygone.generateCode()+ "\n</svg>";
		return code;
	}

}
