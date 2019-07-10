public class NBody{
	public static String imageToDraw = "images/starfield.jpg";

	public static double readRadius(String fileName){
		In in = new In(fileName);
		int number = in.readInt();
		double radius = in.readDouble();	
		return radius;
	}

	public static Body[] readBodies(String fileName){
		In in = new In(fileName);
		int number = in.readInt();
		double radius = in.readDouble();
		Body[] Bodies = new Body[number];
		for(int i = 0; i < number; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			Bodies[i] = new Body(xP, yP, xV, yV, m, img);
		}
 		return Bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		double radius = NBody.readRadius(fileName);
		Body[] Bodies = NBody.readBodies(fileName);

		StdDraw.setScale(-3e11, 3e11);
		StdDraw.picture(0, 0, imageToDraw);
		for(Body i : Bodies){
			Body.draw(i);
		}

		StdDraw.enableDoubleBuffering();
		double currT = 0;
		int num = Bodies.length;
		while(currT <= T){
			StdDraw.picture(0, 0, imageToDraw);
			double[] xForces = new double[num];
			double[] yForces = new double[num];
			for(int i = 0; i < num; i++){
				xForces[i] = Bodies[i].calcNetForceExertedByX(Bodies);
				yForces[i] = Bodies[i].calcNetForceExertedByY(Bodies);
				
			}

			for(int i = 0; i < num; i++){
				Bodies[i].update(dt, xForces[i], yForces[i]);
				Body.draw(Bodies[i]);
			}

			StdDraw.show();
			StdDraw.pause(10);
			currT += dt;
		}

		StdOut.printf("%d\n", Bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < Bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            Bodies[i].xxPos, Bodies[i].yyPos, Bodies[i].xxVel,
            Bodies[i].yyVel, Bodies[i].mass, Bodies[i].imgFileName);   
		}
		
	}

}