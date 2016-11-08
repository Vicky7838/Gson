package com.gson.languages.gson;

import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Language> languageList = new ArrayList<>();
    List<Language> languages = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter mAdapter;
    private int bundleVal = 0;
    private final String LOG_TAG = "infovision_log";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void getLanguages() {
        String url = "http://applop.biz/aplp/api/get_languages.php";

        try {
RestClient restClient = new RestClient(this);
            restClient.getLanguage(url, new RequestCallback<LanguageList>() {
                @Override
                public void onResponse(LanguageList response) {
                    languageList = response.getLanguages();
                    Log.d(CONSTANTS.TAG,""+response.getLanguages().size());
                }

                @Override
                public void onSuccessRestResponse(Exception e, LanguageList result) {

                    languageList = result.getLanguages();
                    Log.d(CONSTANTS.TAG,""+result.getLanguages().size());
                    for(int i=0;i<languageList.size();i++)
                    {
                        Language language = languageList.get(i);
                        language.setId(language.getId());
                        Log.d("iiii",language.getId());
                        language.setName(language.getName());
                        Log.d("iiii",language.getName());
                        language.setStatus(language.getStatus());
                        Log.d("iiii",language.getStatus());
                        languages.add(language);
                    }
                    for(int i=0;i<languages.size();i++)
                    {
                        Language l = languages.get(i);
                        Log.d("dddd",l.getName());
                    }

                    recyclerView = (RecyclerView) findViewById(R.id.recycle);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    mAdapter = new Adapter(getApplicationContext(), languages);
                    recyclerView.setAdapter(mAdapter);
                   /* for(int i=0;i<languageList.size();i++)
                    {
                        Log.d(CONSTANTS.TAG,languageList.get(i).getId());
                        Language language = languageList.get(i);
                        language.getId();
                        language.getName();
                        language
                    }*/
                }

                @Override
                public void onErrorRestResponse(VolleyError error) {

                }
            }, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
