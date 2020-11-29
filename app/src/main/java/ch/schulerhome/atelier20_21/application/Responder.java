package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.List;

public interface Responder {

    void answer(Question question, List<Item> candidates, ResponderCallback responderCallback);

    interface ResponderCallback {
        void select(Answer answer);
    }
}
