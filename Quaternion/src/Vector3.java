
public class Vector3 {
	
	
	private double x;
	private double y;
	private double z;
	
	public Vector3(double a, double b, double c) {
		x = a;
		y = b;
		z = c;
	}
	
	public String toString(){
		return "["+x+","+y+","+z+"]";
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}
	
	// p = b1i + c1j + d1k and q = b2i + c2j + d2k
	// the dot product is
	//p¡¤q = b1b2 + c1c2 + d1d2
	public double dotTimes(Vector3 other) {
		double b1 = this.x, c1 = this.y, d1 = this.z; 
		double b2 = other.x, c2 = other.y, d2 = other.z;
		
		return b1*b2 + c1*c2 + d1*d2;
	}
	
	
	//p x q = (b1 + c1 + d1)*(b2 + c2 + d2)
	public Vector3 vecTimes(Vector3 other) {
		double b1 = this.x, c1 = this.y, d1 = this.z; 
		double b2 = other.x, c2 = other.y, d2 = other.z;
		return new Vector3(c1*d2 - d1*c2, d1*b2 - b1*d2, b1*c2 - c1*b2);
	}
	
	public Vector3 scaleTimes(double s) {
		return new Vector3(s*x, s*y, s*z);
	}
	
	//Normalizing Vector
	//|a| = sqrt((ax * ax) + (ay * ay) + (az * az))
	//    x = ax/|a|
    //    y = ay/|a|
    //    z = az/|a|
	public Vector3 unit() {
		double absA = Math.sqrt(x*x + y*y + z*z);
		
		if (absA == 0)return new Vector3(0, 0, 0);
		return new Vector3(x/absA, y/absA, z/absA);
	}
	
}
