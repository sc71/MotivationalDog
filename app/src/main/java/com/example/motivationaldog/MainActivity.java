package com.example.motivationaldog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button buttonGenerate;
    private TextView textViewQuote;
    private ImageView imageViewDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
    }

    private void wireWidgets() {
        buttonGenerate = findViewById(R.id.button_main_generate);
        textViewQuote = findViewById(R.id.textview_main_quote);
        imageViewDog = findViewById(R.id.imageview_main_dog);
        textViewQuote.setMovementMethod(new ScrollingMovementMethod());
    }

    private void setListeners() {
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateNewQuote();
                generateNewDog();
            }
        });
    }

    private void generateNewQuote() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.quotesondesign.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuotesOnDesignService service = retrofit.create(QuotesOnDesignService.class);

        Call<List<QuotesOnDesignResults>> quotesOnDesignResultsCall = service.findQuote("rand", 1);

        quotesOnDesignResultsCall.enqueue(new Callback<List<QuotesOnDesignResults>>() {
            @Override
            public void onResponse(Call<List<QuotesOnDesignResults>> call, Response<List<QuotesOnDesignResults>> response) {
                String textToShow = response.body().toString().substring(4,response.body().toString().length() - 6);
                textViewQuote.setText(filterOutText(textToShow));
            }

            @Override
            public void onFailure(Call<List<QuotesOnDesignResults>> call, Throwable t) {

            }
        });
    }

    private String filterOutText(String textToShow) {
        if(textToShow.contains("&#8217;")){
            textToShow = textToShow.replace("&#8217;", "'");
        }
        if(textToShow.contains("&#8211;")){
            textToShow = textToShow.replace("&#8211;", ";");
        }
        if(textToShow.contains("&#8212;")){
            textToShow = textToShow.replace("&#8212;", "–");
        }
        if((textToShow.contains("[&#8230;]")) || (textToShow.contains("&#8230;"))){
            textToShow = textToShow.replace("[&#8230;]", "...");
            textToShow = textToShow.replace("&#8230;", "...");

        }
        if((textToShow.contains("&#8220;") || (textToShow.contains("&#8221;")))){
            textToShow = textToShow.replace("&#8221;", "\"");
            textToShow = textToShow.replace("&#8220;", "\"");
        }
        if((textToShow.contains("&#8216;") || (textToShow.contains("&#8217;")))){
            textToShow = textToShow.replace("&#8216;", "\'");
            textToShow = textToShow.replace("&#8217;", "\'");
        }
        if((textToShow.contains("<em>") || (textToShow.contains("</em>")))){
            textToShow = textToShow.replace("<em>", "");
            textToShow = textToShow.replace("</em>", "");
        }
        if((textToShow.contains("<p>") || (textToShow.contains("</p>")))){
            textToShow = textToShow.replace("<p>", "");
            textToShow = textToShow.replace("</p>", "");
        }
        if((textToShow.contains("<sip>") || (textToShow.contains("</sup>")))){
            textToShow = textToShow.replace("<sup>", "");
            textToShow = textToShow.replace("</sup>", "");
        }
        if((textToShow.contains("<br>") || (textToShow.contains("</br>")))){
            textToShow = textToShow.replace("<br>", "");
            textToShow = textToShow.replace("</br>", "");
        }
        if((textToShow.contains("<br >") || (textToShow.contains("<br />")))){
            textToShow = textToShow.replace("<br />", "");
        }
        if((textToShow.contains("<ul>") || (textToShow.contains("</ul>")))){
            textToShow = textToShow.replace("<ul>", "");
            textToShow = textToShow.replace("</ul>", "");
        }
        if((textToShow.contains("<li>") || (textToShow.contains("</li>")))){
            textToShow = textToShow.replace("<li>", "");
            textToShow = textToShow.replace("</li>", "");
        }
        if(textToShow.contains("&#8243;")){
            textToShow = textToShow.replace("&#8243;", "\"");
        }
        return textToShow;

    }

    private void generateNewDog() {
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://shibe.online/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        ShibeService service = retrofit.create(ShibeService.class);

        Call<String> shibeResponseCall =  service.findDog(1);

        shibeResponseCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String dogUrls = response.body();
                dogUrls = dogUrls.substring(2,dogUrls.length()-2);
                Picasso.get()
                        .load(dogUrls)
                        .fit()
                        .centerInside()
                        .into(imageViewDog);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
