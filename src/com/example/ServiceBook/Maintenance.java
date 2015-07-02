package com.example.ServiceBook;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 01.07.2015.
 */
public class Maintenance implements Serializable{
    long date;
    long mileage;
    String commentary;
    ArrayList<Replacement> replacements;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public void addReplacement(String title, float coast){
        Replacement replacement = new Replacement();
        replacement.setTitle(title);
        replacement.setCoast(coast);
    }

    public ArrayList getReplacements(){
        return replacements;
    }

    public Replacement getReplacement(int pos){
        return replacements.get(pos);
    }
}
