package cybersoft.javabackend.java18.gamedoanso.servlet;

import cybersoft.javabackend.java18.gamedoanso.service.RankService;
import cybersoft.javabackend.java18.gamedoanso.utils.JspUtils;
import cybersoft.javabackend.java18.gamedoanso.utils.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ranking", urlPatterns = {
        UrlUtils.XEP_HANG
})
public class RankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(RankService.getInstance().getAllRankList());
        req.setAttribute("listRank", RankService.getInstance().getAllRankList());
        req.getRequestDispatcher(JspUtils.XEP_HANG).forward(req, resp);
    }
}
