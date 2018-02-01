package lv.tsi.javawev.seabattle.controller;

import lv.tsi.javawev.seabattle.model.Game;
import lv.tsi.javawev.seabattle.model.GameManager;
import lv.tsi.javawev.seabattle.model.Player;
import lv.tsi.javawev.seabattle.model.PlayerGameContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    private PlayerGameContext playerGameContext;
    @Inject
    private GameManager gameManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter( "player-name");
        Player player = new Player();
        player.setName(name);

        playerGameContext.setPlayer(player);

        Game game = gameManager.register(player);

        playerGameContext.setGame(game);

        response.sendRedirect("waitEnemyRegister");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/WEB-INF/register.jsp")
                .include(request, response);
    }
}
