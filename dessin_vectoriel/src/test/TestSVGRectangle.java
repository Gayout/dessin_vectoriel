package test;


import java.io.*;

import implementation.Position;
import interpreteur.svg.RectangleSVG;

public class TestSVGRectangle {

	public static void main(String[] args) {
			
		RectangleSVG Rectangle = new RectangleSVG(new Position(10,10), 190,90,false);
		Rectangle.getCrayon().setEpaisseur(6);
		try {

			File file = new File("rectangle.svg");

			if (file.createNewFile()){
				System.out.println("File is created!");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(generateCode(Rectangle));
				bw.close();


			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String generateCode(RectangleSVG rectangle){
		String code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n\t";
		code += rectangle.generateCode()+ "\n</svg>";
		return code;
	}

}
