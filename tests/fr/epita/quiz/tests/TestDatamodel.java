package fr.epita.quiz.tests;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Difficulty;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Quiz;
/**
 *
 * @author Swati Khandare
 *
 */
public class TestDatamodel {

	public static void main(String[] args) {
		Quiz quiz = new Quiz("Java Fundamentals - 2022");
		String topics = "Java";
		Question question = new Question(1, 1, "What is a class in Java?", topics , Difficulty.EASY.getDifficulty()) ;
		
		Answer answer = new Answer("It is a general structure that represents common characteristics of a set of individuals (or instances)"
				+ ". It is defined by 3 main descriptions : Name, State, Behavior");
		
		
		answer.setQuestion(question);
		answer.setQuiz(quiz);
		
		
		System.out.println(answer);
	
	}

}
