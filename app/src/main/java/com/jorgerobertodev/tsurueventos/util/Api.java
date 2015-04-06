package com.jorgerobertodev.tsurueventos.util;

/**
 * Created by jorge on 04/04/2015.
 */
public class Api {
    private static String BASE_URL = "http://192.168.0.101:5200/";
    private static String BASE_URL_API = BASE_URL + "api/";

    public static String urlBase(String url){ return BASE_URL + url;}
    public static String url(String url){
        return BASE_URL_API + url;
    }
    public static String uploadFolder(String url){ return BASE_URL +"uploads/"+url;}

}
