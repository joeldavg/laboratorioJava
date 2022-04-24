package com.sofkau.menu;

import com.sofkau.dao.AnswerDao;
import com.sofkau.dao.CategoryDao;
import com.sofkau.dao.PrizeDao;
import com.sofkau.dao.QuestionDao;
import com.sofkau.dao.impl.AnswerDaoImpl;
import com.sofkau.dao.impl.CategoryDaoImpl;
import com.sofkau.dao.impl.PrizeDaoImpl;
import com.sofkau.dao.impl.QuestionDaoImpl;
import com.sofkau.domain.*;
import com.sofkau.exception.GenericException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoundMenu {

    private static CategoryDao categoryDao = new CategoryDaoImpl();
    private static QuestionDao questionDao = new QuestionDaoImpl();
    private static AnswerDao answerDao = new AnswerDaoImpl();
    private static PrizeDao prizeDao = new PrizeDaoImpl();

    public static int newRound(Level level) throws GenericException {
        Scanner sc = new Scanner(System.in);
        Category category = categoryDao.getByLevel(level);
        Question question = randomQuestion(category.getId());
        List<Answer> answerList = answerDao.getByQuestionId(question.getId());
        showQuestion(level, question, answerList);

        return validateAnswer(sc, category, answerList);
    }

    private static void showQuestion(Level level, Question question, List<Answer> answerList) {
        System.out.println("\n:: RONDA NIVEL: " + level.toString());
        System.out.println("\n" + question.getQuestion());
        for (int i = 0; i < answerList.size(); i++) {
            System.out.println((i+1)+ ". " + answerList.get(i).getAnswer());
        }
        System.out.println();
    }

    private static int validateAnswer(Scanner sc, Category category, List<Answer> answerList)
            throws GenericException {
        int option;
        int points = 0;
        do {
            System.out.println("Ingrese su respuesta:");
            option = sc.nextInt();
        } while (option<1 || option>4);
        Answer answer = answerList.get(option-1);
        System.out.println("Su respuesta es: " + answer.getAnswer());
        if (answer.getCorrect()) {
            Prize prize = prizeDao.getById(category.getScoreId());
            points = prize.getPoints();
            System.out.println("Respuesta correcta, has ganado " + prize.getPoints() + " puntos.");
        } else {
            System.out.println("Respuesta incorrecta, gracias por participar.");
        }
        return points;
    }

    private static Question randomQuestion(Long categoryId) throws GenericException {
        List<Question> questionList = questionDao.getByCategory(categoryId);
        Random r = new Random();
        int a = (int) (r.nextDouble() * questionList.size());

        return questionList.get(a);
    }
}
