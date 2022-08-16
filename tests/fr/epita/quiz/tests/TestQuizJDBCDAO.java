package fr.epita.quiz.tests;

import java.util.List;

import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.services.ConfigurationService;
import fr.epita.quiz.services.data.QuizJDBCDAO;

public class TestQuizJDBCDAO {
	
	public static void main(String[] args) throws Exception {
		//Given
		ConfigurationService conf = ConfigurationService.getInstance();
		boolean confInit = conf.isInit();
		if (!confInit) {
			System.out.println("Problem while initializing the configuration");
			return;
		}
		
		QuizJDBCDAO dao = QuizJDBCDAO.getInstance();
		
		//when
		dao.create(new Quiz("Why is Java so cool?"));
		
		//then
		List<Quiz> list = dao.search(new Quiz("Java"));
		if (list.isEmpty()) {
			throw new NullPointerException("The list was empty");
		}
		
		System.out.println(list);
		
	}

}
