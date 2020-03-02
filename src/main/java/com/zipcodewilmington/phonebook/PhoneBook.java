package com.zipcodewilmington.phonebook;

import sun.applet.resources.MsgAppletViewer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    LinkedHashMap<String , ArrayList<String>> group = new LinkedHashMap<String, ArrayList<String>>();

    public PhoneBook(String name){

    }
    public PhoneBook(Map<String, List<String>> map) {

    }

    public PhoneBook() {

    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> holder = new ArrayList<>();
        holder.add(phoneNumber);
        this.group.put(name,holder);
    }

    public void addAll(String name, String... phoneNumbers) {

        ArrayList<String> tempNumbers = new ArrayList<>();

        for(String element : phoneNumbers){
            tempNumbers.add(element);
        }
        this.group.put(name,tempNumbers);
    }

    public void remove(String name) {
       this.group.remove(name);
    }

    public Boolean hasEntry(String phoneNumber) {
        boolean hasEntryNum =  false;

        for(String name : group.keySet()){
            ArrayList<String> numbers = group.get(name);
            for(String number :  numbers){
                if(number.equals(phoneNumber)){
                    hasEntryNum = true;
                    break;
                }
            }
        }
        return hasEntryNum;
    }

    public List<String> lookup(String name) {
        return this.group.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String answer = "";
        for(String element: this.group.keySet()){
            ArrayList<String> num = group.get(element);
            for(String number : num){
                if(number.equals(phoneNumber)){
                    answer = element;
                }
            }
        }
        return answer;
    }

    public ArrayList<String> getAllContactNames() {
        ArrayList<String> names = new ArrayList<>();
        for(String element : this.group.keySet()){
            names.add(element);
        }

        return names;
    }

    public HashMap<String, ArrayList<String>> getMap() {
        return this.group;
    }
}

/*
        void add(String name, String phoneNumber)
        adds an entry to the composite associate data type

        void addAll(String name, String... phoneNumbers)
        adds many phone numbers to a single name entry

        void remove(String name)
        removes an entry to the composite associate data type

        Boolean hasEntry(String name)
        removes an entry to the composite associate data type

        List<String> lookup(String name)
        returns a phone number for the respective input name

        String reverseLookup(String phoneNumber)
        returns a name for the respective input phoneNumber

        String getAllContactNames()
        returns a list of all names in this PhoneBook

 */