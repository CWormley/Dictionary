/****************************************************************
*
* File: Entry.java
* By: Claudia Wormley
* Date: 6/21/2024
*
* Description: Enrty Object Class creates entries for all definitions provided, uniquee and otherwise. The two values stored in this class
* are the part of speech enum, and the string meaning.  Appropriate constructors, 
setters and getters are included along with support functions.
****************************************************************/

//using hash map structure, use dictionary definition as pointer to linked list of entries

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

public class Entry {
    private PartofSpeech partofSpeech;
    private String meaning;

    Entry(PartofSpeech partofSpeech, String meaning){
        this.partofSpeech = partofSpeech;
        this.meaning =meaning;
    }
    Entry(PartofSpeech partofSpeech){
        this.partofSpeech = partofSpeech;
        this.meaning ="To be updated...";
    }
    //getters
    public PartofSpeech getPartofSpeech(){
        return this.partofSpeech;
    }
    public String getMeaning(){
        return this.meaning;
    }
    //setter
    public void  setMeaning (String meaning){
        this.meaning = meaning;
    }

    public String getEntryString(){
        return " [" + getPartofSpeech() + "]: " + getMeaning() + ".";
    }

    public static PartofSpeech isPartOfSpeech(String input) {
        for (PartofSpeech pos : PartofSpeech.values()) {
            if (pos.name().equalsIgnoreCase(input)) {
                return pos;
            }
        }
        return null;
    }


    
}
