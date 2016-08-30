package com.aoide.global.dataBaseManipulationObjects.suggestion;

import java.util.List;


public class TestSuggestionDAO {

	public static void main(String[] args) {
			SuggestionDAO dao = new SuggestionDAOInstance();
			
			
			// �s�W
			SuggestionVO suggestionVO1 = new SuggestionVO();
			suggestionVO1.setSuggestionContentFile("test insert path1");
			suggestionVO1.setReplyContentFile("test insert path1");
			suggestionVO1.setReplyState(0);
			dao.insert(suggestionVO1);
			
			// �ק�
			SuggestionVO suggestionVO2 = new SuggestionVO();
			suggestionVO2.setSuggestionId(1);
			suggestionVO2.setSuggestionContentFile("test update path");
			suggestionVO2.setReplyContentFile("test update path");
			suggestionVO2.setReplyState(1);
			dao.update(suggestionVO2);
             
			// �R��
			dao.delete(3);

			
			// �d��
			SuggestionVO suggestionVO3 = dao.findByPrimaryKey(1);
			System.out.print(suggestionVO3.getSuggestionId() + ",");
			System.out.print(suggestionVO3.getSuggestDate() + ",");
			System.out.print(suggestionVO3.getSuggestionContentFile() + ",");
			System.out.print(suggestionVO3.getReplyContentFile() + ",");
			System.out.print(suggestionVO3.getReplyState() + ",");
			System.out.print(suggestionVO3.getReplyDate() + ",\n");
			System.out.println("---------------------");
			
			
			// �d��
			List<SuggestionVO> list = dao.getAll();
			for (SuggestionVO aSuggestionVO3 : list) {
				System.out.print(aSuggestionVO3.getSuggestionId() + ",");
				System.out.print(aSuggestionVO3.getSuggestDate() + ",");
				System.out.print(aSuggestionVO3.getSuggestionContentFile() + ",");
				System.out.print(aSuggestionVO3.getReplyContentFile() + ",");
				System.out.print(aSuggestionVO3.getReplyState() + ",");
				System.out.print(aSuggestionVO3.getReplyDate() + ",");
				System.out.println();
			}

	}

}
