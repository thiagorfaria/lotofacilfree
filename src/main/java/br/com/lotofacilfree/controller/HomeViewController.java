package br.com.lotofacilfree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Está classe é do tipo controller, ela segue o padrão MVC e é responsável por renderizar a página principal da
 * aplicação. Além disso ela administra e manipula as exeções, renderizando elas amigavelmente para os usuários.
 */
@Controller
public class HomeViewController {

    private final static Logger logger = Logger.getLogger(HomeViewController.class.getName());

    /**
     * Renderizar a página principal da da aplicação
     *
     * @return página principal
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String renderHome(final HttpServletRequest request) {
        logger.info(String.format("Render home pager by %s.", request.getRemoteAddr()));

        return "home";
    }

}
