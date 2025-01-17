package com.mangkyu.stream.Quiz4;


import java.util.*;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        init();
    }

    private void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }

    public List<Transaction> quiz1() {
        return  transactions.stream()
                .filter(t -> t.getYear() == 2020)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> quiz2() {

        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> quiz3() {

        return transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity() == "Seoul")
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    public String quiz4() {
        return transactions.stream()
                .map(t->t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }

    public boolean quiz5() {
        return transactions.stream()
                .map(t->t.getTrader().getCity())
                .anyMatch(c->c.equals("Busan"));
    }

    public List<Integer> quiz6() {

        return transactions.stream()
                .filter(t->t.getTrader().getCity().equals("Seoul"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

    }

    public Integer[] quiz7() {

        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(-1);

        Integer min = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElseThrow(RuntimeException::new).getValue();

        return new Integer[]{max, min};
    }

}
