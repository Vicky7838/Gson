package com.gson.languages.gson;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Sunny on 8/10/2016.
 */
public class LanguageList implements Parcelable
{
    @SerializedName("Languages")
    @Expose


    private ArrayList<Language> languages = new ArrayList<Language>();

    /**
     *
     * @return
     *     The languages
     */
    public ArrayList<Language> getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     *     The Languages
     */
    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {


        Bundle data = new Bundle();
        data.putParcelableArrayList(CONSTANTS.INTENT_DATA, languages);
        dest.writeBundle(data);

    }

    public LanguageList() {
        languages = new ArrayList<Language>();
    }
    public static final Parcelable.Creator<LanguageList> CREATOR = new Parcelable.Creator<LanguageList>() {
        public LanguageList createFromParcel(Parcel in) {
            return new LanguageList(in);
        }

        public LanguageList[] newArray(int size)
        {

            return new LanguageList[size];
        }

    };

    public LanguageList(Parcel source) {

        Bundle data = source.readBundle();


        languages = data.getParcelableArrayList(CONSTANTS.INTENT_DATA);

    }




}
