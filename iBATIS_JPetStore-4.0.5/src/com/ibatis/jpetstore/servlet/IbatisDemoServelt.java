package com.ibatis.jpetstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by zjg on 2021/2/27
 */
public class IbatisDemoServelt extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, "失败");
        } else {
            resp.sendError(400, "失败");
        }

    }
}
