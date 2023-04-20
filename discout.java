public class discout {
    
    double teir1 = 0.02;
    double teir2 = 0.06;
    double teir3 = 0.08;
    
   public double calculatedicout(int teir,double sum) {
    switch (teir) {
        case 1:
            return sum*teir1;
           
        case 2:
        
        return sum*teir2;
        case 3:
            
        return sum*teir3;
    
            default:
            
            return 0;
    }
    
   }
}
