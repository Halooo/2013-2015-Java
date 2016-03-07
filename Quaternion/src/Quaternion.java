
public class Quaternion {
	private double w;
	private double x;
	private double y;
	private double z;
	
	//constructor 
	public Quaternion(double w, double x, double y, double z) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Quaternion(double w, Vector3 v){
		this(w, v.getX(), v.getY(), v.getZ());
	}
	
	public Quaternion(){
		this(1, 0, 0, 0);
	}
	
	//get methods
	public double getW() {
		return w;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public Vector3 getVector(){
		return new Vector3(x, y, z);
	}
	
	//toString method
	public String toString() {
		return "s: " + this.w + " v: " + getVector().toString();
	}
	
	//conjugation q = w + xi + yi + zi 
				  //= w - xi - yi - zi
	public Quaternion conjugate() {
		return new Quaternion(w, -x, -y, -z);
	}
	
	//mangnitude sqrt(w^2+x^2+y^2+z^2)
	public double mangnitude() {
		return Math.sqrt(w*w + x*x + y*y + z*z);
	}
	
	//times method
	public Quaternion times(Quaternion other) {
		double w1 = this.w; double w2 = other.getW();
	    double x1 = this.x; double x2 = other.getX();
	    double y1 = this.y; double y2 = other.getY();
	    double z1 = this.z; double z2 = other.getZ();
	    return new Quaternion(w1*w2 - (x1*x2 + y1*y2 + z1*z2),
	                          w1*x2 + x1*w2 + y1*z2 - z1*y2,
	                          w1*y2 - x1*z2 + y1*w2 + z1*x2,
	                          w1*z2 + x1*y2 - y1*x2 + z1*w2);
	}
	
	//scale times
	public Quaternion scale(double s){
		return new Quaternion(s*w, s*x, s*y, s*z);
	}
	
	//inverse method
	public Quaternion inverse() {
		return conjugate().scale(1/Math.pow(mangnitude(),2));
	}
	
	//image method
	public static Vector3 image(Vector3 pt, Vector3 u, double theta){
		//quaternion = (0, vector p)
		Quaternion p = new Quaternion(0, pt);
		//s = cos(¦È/2)
		double s = Math.cos(theta / 2);
		//vecotr v = scale u * sin(¦È/2)
		Vector3 vecV = u.scaleTimes(Math.sin(theta/2));
		//q = (s, vector v)
		Quaternion q = new Quaternion(s, vecV);
		//p' = q*p*(q^-1)
		Quaternion p2 = q.times(p).times(q.inverse());
		//return vector part of p'
		return p2.getVector();
	}
	
	public static void main(String[] args) {
		
	}
	
}
