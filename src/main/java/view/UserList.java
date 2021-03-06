package view;

import ctrl.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/user/list")
public class UserList extends HttpServlet {
 /*   protected void doPost(
            HttpServletRequest r, HttpServletResponse R)
            throws ServletException, IOException {
        final String dbName = "workshop3", dbTable = "users";

        // Rejestracja drivera JDBC przed połączeniem do bazy
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User userFromSQL;
        UserDao uDAO = new UserDao(dbName, dbTable);

        Map<Integer,User> UsersMap = new HashMap<>();

        int recordsFetched=0, i=1;
        while(recordsFetched < uDAO.getRecordsCount()){
            userFromSQL = uDAO.read(i++);
            if(userFromSQL!=null) {
                UsersMap.put(userFromSQL.getID(), userFromSQL);
                recordsFetched++;
            }
        }

        r.setAttribute("UsersMap", UsersMap);

        getServletContext().getRequestDispatcher("/WEB-INF/userlist.jsp")
                .forward(r, R);
    }*/

    protected void doGet(
            HttpServletRequest r, HttpServletResponse R)
            throws ServletException, IOException {

        final String dbName = "workshop3", dbTable = "users";

        // Rejestracja drivera JDBC przed połączeniem do bazy
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User userFromSQL;
        UserDao uDAO = new UserDao(dbName, dbTable);

        Map<Integer,User> UsersMap = new HashMap<>();

        int recordsFetched=0, i=1;
        while(recordsFetched < uDAO.getRecordsCount()){
            userFromSQL = uDAO.read(i++);
            if(userFromSQL!=null) {
                UsersMap.put(userFromSQL.getID(), userFromSQL);
                recordsFetched++;
            }
        }

        r.setAttribute("UsersMap", UsersMap);

        getServletContext().getRequestDispatcher("/WEB-INF/userlist.jsp")
                .forward(r, R);

    }
}