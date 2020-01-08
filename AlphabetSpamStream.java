import java.lang.Exception;
class AlphabetSpamStream {
    private static int[] lut = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    
                                 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 3,
                                 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                                 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0};    
    private static int[] type = new int[4];
    public static void main(String[] args) throws Exception {
        byte[] in = System.in.readAllBytes();
        double all = (double) in.length;   
        for(byte b : in) {            
            type[lut[b]] += 1;        
        }             
        System.out.print(String.format("%f\n%f\n%f\n%f\n",                    
        type[3]/all, type[2]/all, type[1]/all, (type[0]-1)/all));
    }
}
