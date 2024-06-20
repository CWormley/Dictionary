
public class Run {
    public static Dictionary init(){

        PartofSpeech noun = PartofSpeech.NOUN;
        PartofSpeech adverb = PartofSpeech.ADVERB;
        Definition cat = Definition.CAT;
        Definition dog = Definition.DOG;

        Entry entry1 = new Entry(noun, "a furry animal");
        Entry entry2 = new Entry(noun, "an adult kitten");
        Entry entry3 = new Entry(adverb, "kittenlike");
        Entry entry4 = new Entry(noun, "a fury animal");

        Dictionary dictionary = new Dictionary();
        dictionary.addEntryToHashMap(cat, entry1);
        dictionary.addEntryToHashMap(cat, entry2);
        dictionary.addEntryToHashMap(cat, entry3);
        dictionary.addEntryToHashMap(dog, entry4);
        return dictionary;
    }
    public static void main(String[] args) {
        System.out.println("! Loading data...");
        Dictionary dict = init();
        System.out.println("! Loading completed...");
        System.out.println("");
        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + Definition.values().length);
        System.out.println("----- Definitions: " + dict.getHashMap().size());
        UI ui = new UI();
        ui.start(dict);
       
    }
    
}
