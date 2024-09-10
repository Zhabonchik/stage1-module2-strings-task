package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(source);
        for (String delimiter : delimiters){
            List<String> helpArrayList = new ArrayList<>();
            for(String items : arrayList){
                StringTokenizer stringTokenizer = new StringTokenizer(items, delimiter);
                while(stringTokenizer.hasMoreTokens()){
                    helpArrayList.add(stringTokenizer.nextToken());
                }
            }
            arrayList = new ArrayList<>(helpArrayList);
        }
        return arrayList;
    }
}
