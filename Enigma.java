public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
    }


    public String decrypt(String message){    
        String decrypt = "";
        for(int i = 0; i <message.length(); i++){
            char character = message.charAt(i);

            int index = rotors[2].indexOf(character);
            char newchar = rotors[1].charAt(index);
            int nextindex = rotors[2].indexOf(newchar);
            char letter = rotors[0].charAt(nextindex);
            
            rotate();
            decrypt+= letter;
        }

        return decrypt;    



    }


    
    public String encrypt(String message){
        String news = "";
        for(int i = 0; i < message.length(); i++){    
            char character = message.charAt(i);
            int index = rotors[0].indexOf(character);
            char newchar = rotors[2].charAt(index);
            int nextindex = rotors[1].indexOf(newchar);
            char letter = rotors[2].charAt(nextindex);
            rotate();
            news += letter;
        }

        return news;
    }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}