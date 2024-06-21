/****************************************************************
*
* File: Dictionary.java
* By: Claudia Wormley
* Date: 6/21/2024
*
* Description: Dictonary Object Class creates a hashmap that uses the unique word entries stored in Definiton enum as keys linking
to, an array list of entries associated with that key word. Also included in this class are filter functions that return a revised 
* list of entries based of the given filter command. Appropriate constructors, 
* setters and getters are included along with support functions.
****************************************************************/
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    
    private HashMap<Definition, ArrayList<Entry>> DictionaryHash = new HashMap<>(); // hashmap with keys as word enums and values as list of definitoin entries

    //constructor
    public Dictionary() {
        this.DictionaryHash = new HashMap<>();
    }

    //add to map
    public void addEntryToHashMap( Definition def, Entry entry) {
        this.DictionaryHash.computeIfAbsent(def, k -> new ArrayList<>()).add(entry);
    }

    //getter
    public HashMap<Definition, ArrayList<Entry>> getHashMap(){
        return this.DictionaryHash;
    }


    //filters
    public  ArrayList<Entry> filter(Definition def){ // filter with word
        return this.DictionaryHash.get(def);
    }

    public ArrayList<Entry> filterPoS( ArrayList<Entry> sorted, PartofSpeech partofSpeech){ // filter with POS
        ArrayList<Entry> temp = new ArrayList<>();
        for(int i =0; i < sorted.size(); i ++){
            if(sorted.get(i).getPartofSpeech() == partofSpeech){
                temp.add(sorted.get(i));
            }
        }
        
        return temp;
    }

    public ArrayList<Entry> filterRev( ArrayList<Entry> sorted){ // filter with reverse
        ArrayList<Entry> temp = new ArrayList<>();
        for(int i = sorted.size()-1; i >= 0 ; i --){
            temp.add(sorted.get(i));
        }
        return temp;
    }
    
    public ArrayList<Entry> filterDist( ArrayList<Entry> sorted){ //filter with distinct
        ArrayList<Entry> temp = new ArrayList<>();
        temp.add(sorted.get(0));
        int count = 1;
        for(int i =1; i < sorted.size(); i ++){
            if(!isSame(temp.get(count-1), sorted.get(i))){
                temp.add(sorted.get(i));
                count++;
            }
        }
        return temp;
    }
     
    //check if distinct entries
    private boolean isSame(Entry entry1, Entry  entry2){
        if(entry1.getMeaning().equals(entry2.getMeaning())&& entry1.getPartofSpeech().equals(entry2.getPartofSpeech())){
            return true;
        }
        return false;
    }

    //print
    public void printEntry (ArrayList<Entry> finalFiltered , Definition def){
        for(int i = 0; i < finalFiltered.size(); i++){
            System.out.println(def.getWord() + finalFiltered.get(i).getEntryString());
        }
    }

    //get size of dictionart
    public int getSize(){
        int num =0;
        for (HashMap.Entry<Definition, ArrayList<Entry>> entry : this.DictionaryHash.entrySet()) {
            num += entry.getValue().size();
        }
        return num;
    
    }

}
