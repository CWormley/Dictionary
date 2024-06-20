import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    
    private HashMap<Definition, ArrayList<Entry>> DictionaryHash = new HashMap<>();

    public Dictionary() {
        this.DictionaryHash = new HashMap<>();
    }

    public void addEntryToHashMap( Definition def, Entry entry) {
        this.DictionaryHash.computeIfAbsent(def, k -> new ArrayList<>()).add(entry);
    }
    public HashMap<Definition, ArrayList<Entry>> getHashMap(){
        return this.DictionaryHash;
    }


    //filters
    public  ArrayList<Entry> filter(Definition def){
        return this.DictionaryHash.get(def);
    }

    public ArrayList<Entry> filterPoS( ArrayList<Entry> sorted, PartofSpeech partofSpeech){
        ArrayList<Entry> temp = new ArrayList<>();
        for(int i =0; i < sorted.size(); i ++){
            if(sorted.get(i).getPartofSpeech() == partofSpeech){
                temp.add(sorted.get(i));
            }
        }
        
        return temp;
    }
    public ArrayList<Entry> filterRev( ArrayList<Entry> sorted){
        ArrayList<Entry> temp = new ArrayList<>();
        for(int i = sorted.size()-1; i >= 0 ; i --){
            temp.add(sorted.get(i));
        }
        return temp;
    }
    
    public ArrayList<Entry> filterDist( ArrayList<Entry> sorted){
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

    public void printEntry (ArrayList<Entry> finalFiltered , Definition def){
        for(int i = 0; i < finalFiltered.size(); i++){
            System.out.println(def.getWord() + finalFiltered.get(i).getEntryString());
        }
    }

}
