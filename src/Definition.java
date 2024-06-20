// Create object class for all definitions stored in dictionary
// Store the original data in a set of enum objects.
// also enum for part of speech
//two constructors, one with incomplete definition, one complete with definitoin
// appropriot setters and getters


//this data structure does not allow for multiple instances of definition objects and the structure requires hard coding. 
//Therefore, enums must play a less substaintial role in the data structure design.

public enum Definition{ //enum data structure
    CAT("cat"),
    RUN("run"),
    HAPPY("happy"),
    QUICKLY("quickly"),
    DOG("dog");

    private final String word;
    private Definition def; 

    //CONSTRUCTORS
    Definition (Definition def, String word){ 
        this.def = def;
        if(word.length()==1){
            this.word = word.toUpperCase();
        }else{
            this.word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
        }
    Definition (String word){ 
        if(word.length()==1){
            this.word = word.toUpperCase();
        }else{
            this.word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
    }
    //GETTERS
    public String getWord(){
        return word;
    }
    public Definition getDefinition(){
        return def;
    }
    public static Definition getDefinition(String word){
        for (Definition def : Definition.values()) { 
            if(def.getWord().equals(word)){
                return def;
            }
        }
        return null;
    }

    //Other methods
    public static boolean isDefinition (String word){
        for (Definition def : Definition.values()) { 
            if(def.getWord().equals(word)){
                return true;
            }
        }
        return false;
    }
}

    