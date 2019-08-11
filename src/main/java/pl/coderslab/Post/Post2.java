package pl.coderslab.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/post2")
public class Post2 extends HttpServlet {
    final String[] illegalWords = {"dupa","cholera"};
    List<String> illegalWordsList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        illegalWordsList = Arrays.asList(illegalWords);


        String answerStr = request.getParameter("doNotCensor");
        String phrase = request.getParameter("phrase");


        PrintWriter writer = response.getWriter();
        if (answerStr==null){
            String[] words = phrase.split(" ;,\\.");
            for (String word:words){
                if (illegalWordsList.contains(word)){
                    StringBuilder sb = new StringBuilder();
                    for (int i=0;i<word.length();i++){
                        sb.append('*');
                    }
                    phrase=phrase.replaceAll(word,sb.toString());
                }
            }
        }
        writer.append(phrase);
    }
}
