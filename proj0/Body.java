public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double g = 6.67e-11;


	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		double dis, r_2;
		r_2 = Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2);
		dis = Math.sqrt(r_2);
		return dis;
	}

	public double calcForceExertedBy(Body b){
		double dis = this.calcDistance(b);
		double force = g * this.mass * b.mass / Math.pow(dis, 2);
		return force;
	}

	public double calcForceExertedByX(Body b){
		double dis = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		double force_X = force * (b.xxPos - this.xxPos) /dis;
		return force_X;
	}

	public double calcForceExertedByY(Body b){
		double dis = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		double force_Y = force * (b.yyPos - this.yyPos) /dis;
		return force_Y;
	}

	public double calcNetForceExertedByX(Body[] allBodys){
		int N = allBodys.length;
		double force_X = 0;
		for(int i = 0; i < N; i++){
			if (this.equals(allBodys[i])) continue;
			force_X += this.calcForceExertedByX(allBodys[i]);
		}
		return force_X;
	}

	public double calcNetForceExertedByY(Body[] allBodys){
		int N = allBodys.length;
		double force_Y = 0;
		for(Body i : allBodys){
			if (this.equals(i)) continue;
			force_Y += this.calcForceExertedByY(i);
		}
		return force_Y;
	}

	public void update(double t, double xForce, double yForce){
		double a_x = xForce / this.mass;
		double a_y = yForce / this.mass;
		this.xxVel += t * a_x;
		this.yyVel += t * a_y;
		this.xxPos += t * xxVel;
		this.yyPos += t * yyVel;
	}

	public static void draw(Body b){
		String imageToDraw = "images/" + b.imgFileName;
		StdDraw.picture(b.xxPos, b.yyPos, imageToDraw);
	}

}