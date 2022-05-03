package project.dao;

import project.models.Bet;

import java.util.List;

public interface BetDao {
    void add(Bet bet);
    List <Bet> get();
    // взять по индексу вставку
    Bet bet (int index);

}
