/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String msg = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        String zona = "";
        String local = "";
        String trat = "";
        
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat date_format=new SimpleDateFormat("HH");
        date_format.setTimeZone(timeZone);
        Date date=new Date();		
        String current_date_time=date_format.format(date);
        
        String tempo = "";
        int fuso = 0;
        
        /*TRATANDO NOME*/
        String nome = "";
        nome = request.getParameter("nome");
        if(nome==null || nome == ""){
            nome = "Fulano";}
        
        /*TRATANDO PRONOME DE TRATAMENTO*/
        String tratamento = request.getParameter("tratamento");
        
        
        /*TRATANDO TEMPO E IDIOMA E PRONOME*/
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                /*PRONOME*/
                switch(tratamento){
                    case "homem":
                        trat = "Senhor";
                        break;
                    case "mulher":
                        trat = "Senhora";
                        break;
                }
                
                
                /*TEMPO*/
                timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
		date_format.setTimeZone(timeZone);
		current_date_time=date_format.format(date);
                
                tempo = date_format.format(date);
                fuso = Integer.parseInt(tempo);
                
                /*FRASE COMPLETA*/
                if(fuso > 6 && fuso <= 12){msg = "Bom dia, " + trat + " " + nome + "!";}
                else if(fuso > 12 && fuso <= 18 ){msg = "Boa Tarde, " + trat + " " + nome + "!";}
                else{msg = "Boa Noite, " + trat + " " + nome + "!";}
                
                zona = "America/Sao_Paulo";
                local = "no Brasil";
                break;
                
            case "en":
                /*PRONOME*/
                switch(tratamento){
                    case "homem":
                        trat = "Sir";
                        break;
                    case "mulher":
                        trat = "Lady";
                        break;
                }
                
                
                /*TEMPO*/
                timeZone = TimeZone.getTimeZone("America/New_York");
		date_format.setTimeZone(timeZone);
		current_date_time=date_format.format(date);
                
                tempo = date_format.format(date);
                fuso = Integer.parseInt(tempo);
                
                if(fuso > 6 && fuso <= 12){msg = "Good morning, " + trat + " " + nome + "!";}
                else if(fuso > 12 && fuso <= 18 ){msg = "Good afternoon, " + trat + " " + nome + "!";}
                else{msg = "Good evening, " + trat + " " + nome + "!";}
                
                zona = "America/New_York";
                local = "no USA";
                break;
                
            case "fr":
                /*PRONOME*/
                switch(tratamento){
                    case "homem":
                        trat = "Monsieur";
                        break;
                    case "mulher":
                        trat = "Madame";
                        break;
                }
                
                
                /*TEMPO*/
                timeZone = TimeZone.getTimeZone("Europe/Paris");
		date_format.setTimeZone(timeZone);
		current_date_time=date_format.format(date);
                
                tempo = date_format.format(date);
                fuso = Integer.parseInt(tempo);
                
                if(fuso > 6 && fuso <= 12){msg = "Bonjour, " + trat + " " + nome + "!";}
                else if(fuso > 12 && fuso <= 18 ){msg = "Bon après-midi, " + trat + " " + nome + "!";}
                else{msg = "Bonsoir, " + trat + " " + nome + "!";}
                
                zona = "Europe/Paris";
                local = "na França";
                break;
                
            case "de":
                /*PRONOME*/
                switch(tratamento){
                    case "homem":
                        trat = "Herr";
                        break;
                    case "mulher":
                        trat = "Dame";
                        break;
                }
                
                
                /*TEMPO*/
                timeZone = TimeZone.getTimeZone("Europe/Berlin");
		date_format.setTimeZone(timeZone);
		current_date_time=date_format.format(date);
                
                tempo = date_format.format(date);
                fuso = Integer.parseInt(tempo);
                
                if(fuso > 6 && fuso <= 12){msg = "Guten Morgen, " + trat + " " + nome + "!";}
                else if(fuso > 12 && fuso <= 18 ){msg = "Guten Tag, " + trat + " " + nome + "!";}
                else{msg = "Guten Abend, " + trat + " " + nome + "!";}
                
                zona = "Europe/Berlin";
                local = "na Alemanha";
                break;
                
            case "kr":
                /*PRONOME*/
                switch(tratamento){
                    case "homem":
                        trat = "-ssi";
                        break;
                    case "mulher":
                        trat = "-ssi";
                        break;
                }
                
                
                /*TEMPO*/
                timeZone = TimeZone.getTimeZone("Asia/Seoul");
		date_format.setTimeZone(timeZone);
		current_date_time=date_format.format(date);
                
                tempo = date_format.format(date);
                fuso = Integer.parseInt(tempo);
                
                if(fuso > 6 && fuso <= 12){msg = "Annyeonghaseyo, " + nome + trat + "!";}
                else if(fuso > 12 && fuso <= 18 ){msg = "Annyeonghaseyo, " + nome + trat + "!";}
                else{msg = "Annyeonghaseyo, " + nome + trat + "!";}
                
                zona = "Asia/Seoul";
                local = "na Coréia do Sul";
                break;
                
            case "jp":
                /*PRONOME*/
                switch(tratamento){
                    case "homem":
                        trat = "-san";
                        break;
                    case "mulher":
                        trat = "-san";
                        break;
                }
                
                
                /*TEMPO*/
                timeZone = TimeZone.getTimeZone("Asia/Tokyo");
		date_format.setTimeZone(timeZone);
		current_date_time=date_format.format(date);
                
                tempo = date_format.format(date);
                fuso = Integer.parseInt(tempo);
                
                if(fuso > 6 && fuso <= 17){msg = "Ohayô gozaimasu, " + nome + trat + "!";}
                else if(fuso > 17 && fuso <= 20 ){msg = "Konnichiwa, " + nome + trat + "!";}
                else{msg = "Konbanwa, " + nome + trat + "!";}
                
                zona = "Asia/Tokyo";
                local = "no Japão";
                break;
                
        }
        
        /*TRATANDO COR FAVORITA*/
        String cor = request.getParameter("cor");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>"); */
            request.setAttribute("mensagem", msg);
            request.setAttribute("zona", zona);
            request.setAttribute("local", local);
            request.setAttribute("cor", cor);
            request.getRequestDispatcher("hellouser.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
