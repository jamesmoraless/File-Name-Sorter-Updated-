package Q1BL5;

import java.util.ArrayList;

public class IntegerAndArrayList {
    private int numOfPeople;
    private ArrayList <String> names = new ArrayList<String>();


    public IntegerAndArrayList(String fullName){
        numOfPeople = 1;
        names.add(fullName);
    }

    public void addName(String name){
        names.add(name);
        numOfPeople ++;
    }

    public boolean moreThanOnce()
    {
        if (numOfPeople > 1)
        {
            return true;
        }
        else
            {
            return false;
        }
    }

    public String toString(){
        String finalPrint = numOfPeople + " Students\t\t\t" + names.toString() + "\n";
        return finalPrint;
    }
}
