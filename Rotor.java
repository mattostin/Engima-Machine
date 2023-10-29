public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
    }
    
    public boolean rotate(){
        String rotor1 =rotorValues.substring(0,rotorValues.length()-1);
        char character = rotorValues.charAt(rotorValues.length()-1);
        String rotor2 = character + rotor1;
        rotorValues = rotor2;

        if(startChar == rotorValues.charAt(0)){
            return true;
        }

        return false; 
    }
    

    public int indexOf(char c){
        

        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        return rotorValues.charAt(idx);
    }
}