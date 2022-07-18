package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz1 {

    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        Map<String, Integer> result = csvLines.stream()
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));

//        for (String s : result.keySet()) {
//            System.out.println(s+":"+ result.get(s));
//        }

        return result;
    }

    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .filter(line->line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s",""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby->hobby, hobby->1, (oldValue,newValue)-> oldValue += newValue));
    }

    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();

        String findWord = "좋아";

        return csvLines.stream()
                .map(line -> countContains(line[2],0,findWord))
                .reduce(0, Integer::sum);
    }

    private int countContains(String str, int fromIndex , String findWord ){
        int findWordLength = findWord.length();
        int index = str.indexOf(findWord, fromIndex);

        if( index >= 0){
            return 1 + countContains(str, index + findWordLength , findWord);
        }

        return 0;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
