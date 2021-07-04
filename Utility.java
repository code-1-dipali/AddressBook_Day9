package com.bridgelabz.program.AddressBookManagementProject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class Utility {
   // Scanner scanner;
    Scanner scanner = new Scanner(System.in);

    public Utility() {

        Scanner scanner = new Scanner(System.in);
    }
    public int getIntValue() {
        return scanner.nextInt();
    }

    public String getStringValue() {
        return scanner.next();
    }

    public long getLongValue() {
        return scanner.nextLong();
    }

    JSONArray jsonArray = new JSONArray();

    @SuppressWarnings("unchecked")
    public void addContactDetails(File file) {

        System.out.println("Enter first name");
        String firstName = getStringValue();
        System.out.println("Enter last name");
        String lastName = getStringValue();
        System.out.println("Enter address");
        String address = getStringValue();
        System.out.println("Enter city");
        String city = getStringValue();
        System.out.println("Enter state");
        String state = getStringValue();
        System.out.println("Enter zip");
        int zip = getIntValue();
        System.out.println("Enter phone number");
        long phone = getLongValue();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("address", address);
        jsonObject.put("city", city);
        jsonObject.put("state", state);
        jsonObject.put("zip", zip);
        jsonObject.put("phone", phone);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("contact", jsonObject);

        jsonArray.add(jsonObject1);

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("done");

        JSONParser jsonParser = new JSONParser();

        try {
            FileReader fileReader = new FileReader(file);
            try {
                Object obj = jsonParser.parse(fileReader);
                jsonArray = (JSONArray) obj;
                System.out.println(jsonArray);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void editContactDetails(File file) {
        // TODO Auto-generated method stub
        System.out.println("Enter the first name ");
        String firstname = getStringValue();
        System.out.println("Enter the last name");
        String lastname = getStringValue();

        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(file);
            try {
                Object obj = jsonParser.parse(fileReader);
                jsonArray = (JSONArray) obj;
                for(Object element : jsonArray) {
                    JSONObject jsonObject = (JSONObject) element;
                    JSONObject jsonObject1 = (JSONObject) jsonObject.get("contact");
                    if(jsonObject1.get("firstName").equals(firstname) && jsonObject1.get("lastName").equals(lastname)) {
                        System.out.println("Enter address");
                        String address = getStringValue();
                        jsonObject1.put("address", address);
                        System.out.println("Enter city");
                        String city = getStringValue();
                        jsonObject1.put("city", city);
                        System.out.println("Enter state");
                        String state = getStringValue();
                        jsonObject1.put("state", state);
                        System.out.println("Enter zip");
                        int zip = getIntValue();
                        jsonObject1.put("zip", zip);
                        System.out.println("Enter phone number");
                        int phone = getIntValue();
                        jsonObject1.put("phone", phone);
                    }
                }
                System.out.println(jsonArray);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteContactDetails(File file) {
        // TODO Auto-generated method stub
        System.out.println("Enter the first name ");
        String firstname = getStringValue();
        System.out.println("Enter the last name");
        String lastname = getStringValue();

        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(file);
            try {
                Object obj = jsonParser.parse(fileReader);
                jsonArray = (JSONArray) obj;
                for (Object element : jsonArray) {
                    JSONObject jsonObject = (JSONObject) element;
                    JSONObject jsonObject1 = (JSONObject) jsonObject.get("contact");
                    if(jsonObject1.get("firstName").equals(firstname) && jsonObject1.get("lastName").equals(lastname)) {
                        jsonArray.remove(jsonObject);
                    }
                }
                System.out.println(jsonArray);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
