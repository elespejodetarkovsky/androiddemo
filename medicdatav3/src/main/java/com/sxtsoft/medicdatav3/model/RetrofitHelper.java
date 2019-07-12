package com.sxtsoft.medicdatav3.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static final JsonPlaceHolderApi JSON_PLACE_HOLDER_API;
    private static final String URL = "https://medikdata.herokuapp.com/api/";

    static {

        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();
        final SimpleDateFormat adf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                Log.d("** getAsJsonPrimitive:", json.getAsJsonPrimitive().toString());
                //long millisecons = json.getAsJsonPrimitive().getAsLong();
                //return new Date(millisecons);
                String fecha = json.getAsString();

                try {
                    return adf.parse(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }

            }

        });

        builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {

                String s = adf.format(src);
                return new JsonPrimitive(s);
            }
        });


        Gson gson = builder.create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        JSON_PLACE_HOLDER_API = retrofit.create(JsonPlaceHolderApi.class);
    }

    public static JsonPlaceHolderApi getJsonPlaceHolderApi(){
        return JSON_PLACE_HOLDER_API;
    }

    private RetrofitHelper(){

    }
}
