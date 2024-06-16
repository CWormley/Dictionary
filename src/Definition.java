// Create object class for all definitions stored in dictionary
// Store the original data in a set of enum objects.
// also enum for part of speech
//two constructors, one with incomplete definition, one complete with definitoin
// appropriot setters and getters

import java.util.ArrayList;
import java.util.List;

enum PartofSpeech{
    NOUN,
    ADJECTIVE,
    ADVERB,
    VERB,
    CONJUNCTION,
    INTERJECTOIN,
    PRONOUN,
    PREPOSITION
}

//this data structure does not allow for multiple instances of definition objects and the structure requires hard coding. 
//Therefore, enums must play a less substaintial role in the data structure design.

public enum Definition{ //enum data structure
    CAT("cat", PartofSpeech.NOUN, "a small domesticated carnivorous mammal"),
    RUN("run", PartofSpeech.VERB, "move at a speed faster than a walk"),
    HAPPY("happy", PartofSpeech.ADJECTIVE, "feeling or showing pleasure or contentment"),
    QUICKLY("quickly", PartofSpeech.ADVERB, "at a fast speed"),
    AND("and", PartofSpeech.CONJUNCTION, "used to connect words of the same part of speech");

    private final String word;
    private final PartofSpeech partofSpeech;
    private String meaning;

    //CONSTRUCTORS
    Definition (String word, PartofSpeech partofSpeech){ 
        if(word.length()==1){
            this.word = word.toUpperCase();
        }else{
            this.word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
        this.partofSpeech = partofSpeech;
        this.meaning = "To be updated...";
    }
    Definition (String word, PartofSpeech partofSpeech, String meaning){ 
        if(word.length()==1){
            this.word = word.toUpperCase();
        }else{
            this.word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
        this.partofSpeech = partofSpeech;
        this.meaning = meaning;
    }
    //GETTERS
    public String getWord(){
        return word;
    }
    public PartofSpeech getPartofSpeech(){
        return partofSpeech;
    }
    public String getMeaning(){
        return meaning;
    }
    //setter 
    public void setMeaning (String meaning){
        this.meaning = meaning;
    }

    //find dictionary entries
    public static List<Definition> getEntryByKeyWord(String key){
        List<Definition> temp = new ArrayList<>();
        for(Definition entries : Definition.values()){
            if(entries.getWord().equalsIgnoreCase(key)){
                temp.add(entries);
            }
        }
        return temp;
    }

    public static void printWord(Definition def){
        System.out.println(def.getWord() + " [" + def.getPartofSpeech() + "]: " + def.getMeaning() + ".");
    }
    /* 
     public static Definition newDefinition (String word, PartofSpeech partofSpeech, String meaning){
        return new Definition(word, partofSpeech, meaning);    }
    }
    */
    

    public static void main(String[] args) {
        // Print all definitions
        for (Definition def : Definition.values()) {
            printWord(def);
        }
        
        /* Definition test = Definition.CAT;
        test("cat", PartofSpeech.NOUN, "meow");*/
        


        // Update a meaning
        Definition.CAT.setMeaning("a domesticated feline animal");
        System.out.println("\nUpdated Meaning for CAT:");
        System.out.println(Definition.CAT.getWord() + " (" + Definition.CAT.getPartofSpeech() + "): " + Definition.CAT.getMeaning());

        // Get entry by keyword
        System.out.println("\nSearching for 'run':");
        List<Definition> results = Definition.getEntryByKeyWord("run");
        for (Definition result : results) {
            System.out.println(result.getWord() + " (" + result.getPartofSpeech() + "): " + result.getMeaning());
        }

        // Test with keyword not present
        System.out.println("\nSearching for 'fly':");
        results = Definition.getEntryByKeyWord("fly");
        if (results.isEmpty()) {
            System.out.println("No entries found for 'fly'.");
        } else {
            for (Definition result : results) {
                System.out.println(result.getWord() + " (" + result.getPartofSpeech() + "): " + result.getMeaning());
            }
        }
    }



}