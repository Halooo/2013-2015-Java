
public class SpecialPythagoreanTriplet {

    public static void main (String args[]){
        final int LIMIT = 1000;
        for(int x = 1; x<LIMIT; x++){
            for(int y = 1; y<LIMIT; y++){
                for(int z = 1; z<LIMIT; z++){
                    if(((x+y+z)==1000) && ((x*x+y*y)==z*z)){
                        System.out.println(x*y*z);
                        x=LIMIT; 
                        y=LIMIT; 
                        z=LIMIT;
                    }
                }   
            }   
        }
    }
    
}
