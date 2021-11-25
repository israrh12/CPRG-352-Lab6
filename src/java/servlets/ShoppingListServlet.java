
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        
        if (user != null){
            String val = request.getParameter("action");
            if(val != null && val.equals("logout")){
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String val = request.getParameter("action");
        if (val.equals("register")){
            String username = request.getParameter("userName");
            if (username != null){
                session.setAttribute("username", username);
                response.sendRedirect("ShoppingList");
                return;
            }else{
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }else if (val.equals("add")){
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("items");
            if(list == null){
                list = new ArrayList<>();
            }
            if(!request.getParameter("item").isEmpty()){
                String item = request.getParameter("item");
                list.add(item);
                session.setAttribute("items", list);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }else if (val.equals("delete")){
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("items");
            String dItem = request.getParameter("item");
            if(dItem != null) {
                list.remove(dItem);
            }
            session.setAttribute("items", list);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
    }


}
