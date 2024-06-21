/****************************************************************
*
* File: UI.java
* By: Claudia Wormley
* Date: 6/21/2024
*
* Description: This class outputs the commmands for the user interface, takes in user input, and calls methods from other 
classes to process given input. The return from the process is outputed along with any error messages.
****************************************************************/
/*
 * Main interface --- print opening , take input , loop while input isnt !q , call step 1, iterate count
 * 
 * Step 1 -- check if !help or proper dictionary search call filter to get array of Entries with Definition enum
 * 
 * Step 2 -- check if another arg , check if part of speech / reverse / distinct , filter accordingly
 * 
 * Step 3 -- check if another arg , check if reverse / distinct , filter accordingly
 * 
 * Step 4 -- check if another arg , check if reverse , filter accordingly
 * 
 * Step 4 -- print filtered array
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class UI {   
    Dictionary dictionary;
    public void start(Dictionary dict){
        dictionary = dict;
        Scanner scn = new Scanner(System.in);
        Boolean check = true;
        int count = 1;
        while(check){
            System.out.print("Search ["+count+"]: ");
            String in = scn.nextLine();
            check = processInput(in);
            count++;
        }
        scn.close();
        System.out.println("-----THANK YOU-----");
    }

     public Boolean processInput(String in){
        if(in.equals("!q")){return false;}
        ArrayList<String> cmds = toArray(in);

        if(cmds.size() == 0 || cmds.size()> 4){
            printInstructions();
            return true;
        }
        ArrayList<Entry> temp = arg1(cmds);
        if(temp == null){return true;}
        if (cmds.size() >= 2){temp = arg2(temp,cmds.get(1));}
        if (cmds.size() >= 3){temp = arg3(temp,cmds.get(2));}
        if (cmds.size() == 4){temp = arg4(temp,cmds.get(3));}
        System.out.println("|");
        dictionary.printEntry(temp,Definition.getDefinition(cmds.get(0)));
        System.out.println("|");
        return true;
    }

    public ArrayList<Entry> arg1(ArrayList<String> cmds){
        String arg = cmds.get(0);
        if(arg.equals("!help")){
            printInstructions();
            return null;
        }else if(!Definition.isDefinition(arg)){
            System.out.println("|");
            System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
            System.out.println("|");
            printInstructions();
            return null;
        }
        ArrayList<Entry> inProgress = dictionary.filter(Definition.getDefinition(arg));
        return inProgress;
    }

    public ArrayList<Entry> arg2(ArrayList<Entry>temp, String cmd){
        PartofSpeech pos = Entry.isPartOfSpeech(cmd);
        if(pos != null){
            temp = dictionary.filterPoS(temp, pos);
        }else{
            switch (cmd) {
                case "reverse":
                    temp = dictionary.filterRev(temp);
                    break;
                case "distinct":
                    temp = dictionary.filterDist(temp);
                    break;
                default:
                    printError(2,cmd);
                    break;
            }
        } 
        return temp;
    }

    public ArrayList<Entry> arg3(ArrayList<Entry>temp, String cmd){
        switch (cmd) {
            case "reverse":
                temp = dictionary.filterRev(temp);
                break;
            case "distinct":
                temp = dictionary.filterDist(temp);
                break;
            default:
                printError(3,cmd);
                break;
        }
        return temp;
    }
    public ArrayList<Entry> arg4(ArrayList<Entry>temp, String cmd){
        if(cmd.equals("reverse")){temp = dictionary.filterRev(temp);}
        else{ printError(3,cmd);}
        return temp;
    }
    public ArrayList<String> toArray (String in){
        in = in.toLowerCase();
        ArrayList<String> cmds = new ArrayList<>();
        String sub = "";
        for(int i = 0; i < in.length(); i++){
            if(in.charAt(i) == ' '){
                cmds.add(sub);
                sub = "";
            }else{
                sub += in.charAt(i);
            }
        }
        cmds.add(sub);
        return cmds;
    }

    public void printInstructions(){
        System.out.println("|");
        System.out.println("PARAMETER HOW-TO, please enter:");
        System.out.println("1. A search key -then 2. An optional part of speech -then");
        System.out.println("3. An optional 'distinct' -then 4. An optional 'reverse'");
        System.out.println("|");
    }

    public void printError(int i, String in){
        System.out.println("|");
        String out="";
        switch (i) {
            case 2:
                out = "<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>";
                System.out.println("<The entered "+i+"nd parameter '"+in+"' is NOT a part of speech.>");
            case 3:
                System.out.println("<The entered "+i+"nd parameter '"+in+"' is NOT 'distinct'.>");
                if(i ==3){out = "<The 3rd parameter should be 'distinct' or 'reverse'.>";}
            case 4:
                System.out.println("<The entered "+i+"nd parameter '"+in+"' is NOT 'reverse'.>");
                if(i ==4){out = "<The 4th parameter should be 'reverse'.>";}
        }
        System.out.println("<The entered "+i+"th parameter '"+in+"' was disregarded.>");
        System.out.println(out);
        System.out.println("|");

    }

 }