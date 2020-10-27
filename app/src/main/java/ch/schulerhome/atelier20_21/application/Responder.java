package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Question;

public interface Responder {
    public Answer answer(Question question);
}
