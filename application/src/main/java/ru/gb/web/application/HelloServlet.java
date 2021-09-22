package ru.gb.web.application;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String product_1, product_2, product_3, product_4, product_5, product_6, product_7, product_8, product_9, product_10;

    @Override
    public void init() {

        message = "List of randomly generated abstract products:";
        product_1 = Product.start();
        product_2 = Product.start();
        product_3 = Product.start();
        product_4 = Product.start();
        product_5 = Product.start();
        product_6 = Product.start();
        product_7 = Product.start();
        product_8 = Product.start();
        product_9 = Product.start();
        product_10 = Product.start();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>" + product_1 + "</p>");
        out.println("<p>" + product_2 + "</p>");
        out.println("<p>" + product_3 + "</p>");
        out.println("<p>" + product_4 + "</p>");
        out.println("<p>" + product_5 + "</p>");
        out.println("<p>" + product_6 + "</p>");
        out.println("<p>" + product_7 + "</p>");
        out.println("<p>" + product_8 + "</p>");
        out.println("<p>" + product_9 + "</p>");
        out.println("<p>" + product_10 + "</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}