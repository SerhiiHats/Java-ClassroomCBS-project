package project.dao;

import project.models.Bet;

import java.util.List;

public interface BetDao {
    void add(Bet bet);     // добавляем в ArrayList Bet
    List <Bet> get();       // получаем ArrayList Bet
    Bet getBet (int index);  // взять по индексу вставку

}
