/****************************************************************
*
* File: Run.java
* By: Claudia Wormley
* Date: 6/21/2024
*
* Description: This class builds a test dictionary to be used in test runs.
****************************************************************/
public class Run {
    public static Dictionary init(){
        // create instances of each POS enum
        PartofSpeech noun = PartofSpeech.NOUN;
        PartofSpeech verb = PartofSpeech.VERB;
        PartofSpeech adjective = PartofSpeech.ADJECTIVE;
        PartofSpeech adverb = PartofSpeech.ADVERB;
        PartofSpeech conjunction = PartofSpeech.CONJUNCTION;
        PartofSpeech interjection = PartofSpeech.INTERJECTOIN;
        PartofSpeech pronoun = PartofSpeech.PRONOUN;
        PartofSpeech preposition = PartofSpeech.PREPOSITION;

        // create instance of each Definition enum
        Definition arrow = Definition.ARROW;
        Definition placeholder = Definition.PLACEHOLDER;
        Definition book = Definition.BOOK;
        Definition distinct = Definition.DISTINCT;
        Definition reverse = Definition.REVERSE;

        // create entries for each definition
        Entry entry1 = new Entry(noun, "Here is one arrow: <IMG> -=>> </IMG>");

        Entry entry2 = new Entry(noun, "A set of pages.");
        Entry entry3 = new Entry(noun, "A written work published in printed or electronic form.");
        Entry entry4 = new Entry(verb, "To arrange for someone to have a seat on a plane.");
        Entry entry5 = new Entry(verb, "To arrange something on a particular date.");


        Entry entry6 = new Entry(adjective, "Familiar. Worked in Java.");
        Entry entryX = new Entry(adjective, "Unique. No duplicates. Clearly different or of a different kind.");
        Entry entry7 = new Entry(noun, "A keyword in this assignment.");
        Entry entry8 = new Entry(noun, "A keyword in this assignment.");
        Entry entry9 = new Entry(noun, "A keyword in this assignment.");
        Entry entry10 = new Entry(noun, "An advanced search option..");
        Entry entry11 = new Entry(noun, "Distinct is a parameter in this assignment");

        Entry entry12 = new Entry(adjective);
        Entry entry13 = new Entry(adjective);
        Entry entry14 = new Entry(adverb);
        Entry entry15 = new Entry(conjunction);
        Entry entry16 = new Entry(interjection);
        Entry entry17 = new Entry(noun);
        Entry entry18 = new Entry(noun);
        Entry entry19 = new Entry(noun);
        Entry entry20 = new Entry(preposition);
        Entry entry21 = new Entry(pronoun);
        Entry entry22 = new Entry(verb);

        Entry entry23 = new Entry(adjective, "On back side.");
        Entry entry24 = new Entry(adjective, "Opposite to usual or previous arrangement.");
        Entry entry25 = new Entry(noun, "A dictionary program's parameter.");
        Entry entry26 = new Entry(noun, "Change to opposite direction.");
        Entry entry27 = new Entry(noun, "The opposite.");
        Entry entry28 = new Entry(noun);
        Entry entry29 = new Entry(noun);
        Entry entry30 = new Entry(noun);
        Entry entry31 = new Entry(noun);
        Entry entry32 = new Entry(verb, "Change something to opposite.");
        Entry entry33 = new Entry(verb, "Go back");
        Entry entry34 = new Entry(verb, "Revoke ruling.");
        Entry entry35 = new Entry(verb);
        Entry entry36 = new Entry(verb);
        Entry entry37 = new Entry(verb, "Turn something inside out.");

        Dictionary dictionary = new Dictionary();
        // add entries to hash map with Dictionary key.
        dictionary.addEntryToHashMap(arrow, entry1);

        dictionary.addEntryToHashMap(book, entry2);
        dictionary.addEntryToHashMap(book, entry3);
        dictionary.addEntryToHashMap(book, entry3);
        dictionary.addEntryToHashMap(book, entry4);
        dictionary.addEntryToHashMap(book, entry5);

        dictionary.addEntryToHashMap(distinct, entry6);
        dictionary.addEntryToHashMap(distinct, entryX);
        dictionary.addEntryToHashMap(distinct, entry7);
        dictionary.addEntryToHashMap(distinct, entry8);
        dictionary.addEntryToHashMap(distinct, entry9);
        dictionary.addEntryToHashMap(distinct, entry10);
        dictionary.addEntryToHashMap(distinct, entry11);


        dictionary.addEntryToHashMap(placeholder, entry12);
        dictionary.addEntryToHashMap(placeholder, entry13);
        dictionary.addEntryToHashMap(placeholder, entry14);
        dictionary.addEntryToHashMap(placeholder, entry15);
        dictionary.addEntryToHashMap(placeholder, entry16);
        dictionary.addEntryToHashMap(placeholder, entry17);
        dictionary.addEntryToHashMap(placeholder, entry18);
        dictionary.addEntryToHashMap(placeholder, entry19);
        dictionary.addEntryToHashMap(placeholder, entry20);
        dictionary.addEntryToHashMap(placeholder, entry21);
        dictionary.addEntryToHashMap(placeholder, entry22);

        dictionary.addEntryToHashMap(reverse, entry23);
        dictionary.addEntryToHashMap(reverse, entry24);
        dictionary.addEntryToHashMap(reverse, entry25);
        dictionary.addEntryToHashMap(reverse, entry26);
        dictionary.addEntryToHashMap(reverse, entry27);
        dictionary.addEntryToHashMap(reverse, entry28);
        dictionary.addEntryToHashMap(reverse, entry29);
        dictionary.addEntryToHashMap(reverse, entry30);
        dictionary.addEntryToHashMap(reverse, entry31);
        dictionary.addEntryToHashMap(reverse, entry32);
        dictionary.addEntryToHashMap(reverse, entry33);
        dictionary.addEntryToHashMap(reverse, entry34);
        dictionary.addEntryToHashMap(reverse, entry35);
        dictionary.addEntryToHashMap(reverse, entry36);
        dictionary.addEntryToHashMap(reverse, entry37);

        return dictionary;
    }
    public static void main(String[] args) {
        System.out.println("! Loading data...");
        Dictionary dict = init();
        System.out.println("! Loading completed...");
        System.out.println("");
        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + Definition.values().length);
        System.out.println("----- Definitions: " + dict.getSize());
        System.out.println();
        UI ui = new UI();
        ui.start(dict);
       
    }
    
}
