package com.nc.Bloggify.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nc.Bloggify.dao.CommentDAO;
import com.nc.Bloggify.dao.CommentList;
import com.nc.Bloggify.dao.INewPost;
import com.nc.Bloggify.dao.LoginValidate;
import com.nc.Bloggify.dao.NewPost;
import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.service.ArticleService;
import com.nc.Bloggify.service.IArticleService;
import com.nc.Bloggify.service.IUserDataService;
import com.nc.Bloggify.service.IViewArticleService;
import com.nc.Bloggify.service.UserDataService;
import com.nc.Bloggify.service.ViewArticleService;

@WebServlet({ "/FrontController", "*.html" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user = new User();
	private static IUserDataService UDservice;
	private static IArticleService Aservice;
	private static IViewArticleService VAservice;

	public FrontController() {
	}

	public void init(ServletConfig config) throws ServletException {
		UDservice = new UserDataService();
		Aservice = new ArticleService();
		VAservice = new ViewArticleService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "index.html";
		String requestPage = request.getRequestURL().toString();

		if (requestPage.contains("index.html")) {
			target = "WEB-INF/index.jsp";
		} 
		else if (requestPage.contains("home.html")) {

			try {
				HttpSession session = request.getSession(false);
				String username = (String) session.getAttribute("username");
				List<User> articleTitle = Aservice.getArticleTitle();
				request.setAttribute("getArticleTitle", articleTitle);
			} catch (Exception e) {
				// TODO: handle exception
			}

			target = "WEB-INF/home.jsp";
		} 
		else if (requestPage.contains("about.html")) {
			try {
				HttpSession session = request.getSession(false);
				String username = (String) session.getAttribute("username");
				List<User> articleTitle = Aservice.getArticleTitle1(username);
				request.setAttribute("getArticleTitle", articleTitle);
				if (username != null) {
					request.setAttribute("user", UDservice.userInfo(username));
					request.setAttribute("claps", UDservice.totalClaps(username));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			target = "WEB-INF/about.jsp";

		} 
		else if (requestPage.contains("newpost.html")) {
			target = "WEB-INF/newPost.jsp";
		} 
		else if (requestPage.contains("newpost-success.html")) {
			HttpSession session = request.getSession(false);
			String username = (String) session.getAttribute("username");
			String pdata = request.getParameter("postArea");
			String title = request.getParameter("title");
			User current = new User();
			current.setData(pdata);
			current.setEmail(username);
			current.setTitle(title);
			INewPost post = new NewPost();
			post.newPost(current);

			target = "WEB-INF/newpost-success.jsp";
			// request.setAttribute("postdata", pdata);
		} 
		else if (requestPage.contains("logout.html")) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			target = "WEB-INF/logout.jsp";
		} 
		else if (requestPage.contains("articleDisplay.html")) {

			try {
				HttpSession session = request.getSession(false);
				String username = (String) session.getAttribute("username");
				User current = VAservice.viewArticle(request.getParameter("articletitle"));

				request.setAttribute("data", current.getData());
			} catch (Exception e) {
				// TODO: handle exception
			}
			target = "WEB-INF/articleDisplay.jsp";
		} 
		else if (requestPage.contains("Comment.html")) {
			target = "WEB-INF/Comment.jsp";
			
		} 
		else if (requestPage.contains("displayComments.html")) {
			HttpSession session = request.getSession(false);
			String commentdata = request.getParameter("commentdata");
			User commentbean = new User();
			commentbean.setEmail((String) session.getAttribute("username"));
			commentbean.setCommentdata(commentdata);
			CommentDAO commentdao = new CommentDAO();
			commentdao.addComment(commentbean);
			CommentList commentlist = new CommentList();
			List<User> comments = commentlist.getCommentList();
			request.setAttribute("comments123", comments);

			target = "WEB-INF/displayComments.jsp";

		}
		else if (requestPage.contains("signup.html")) {
			target = "WEB-INF/signup.jsp";
		}

		javax.servlet.RequestDispatcher dispatch = request.getRequestDispatcher(target);
		dispatch.forward(request, response);

		response.getWriter().println("Path:" + request.getRequestURI());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "WEB-INF/home.jsp";
		String requestPage = request.getRequestURI().toString();

		if (requestPage.contains("FrontController")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (LoginValidate.loginValidate(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				target = "WEB-INF/home.jsp";
			} else {
				target = "WEB-INF/error-login.jsp";
			}
		} else if (requestPage.contains("signup.html")) {
			User newUser = new User();
			newUser.setFirstName(request.getParameter("fName"));
			newUser.setLastName(request.getParameter("lName"));
			newUser.setEmail(request.getParameter("email"));
			newUser.setPassword(request.getParameter("password"));
			newUser.setRePassword(request.getParameter("repassword"));
		}

		javax.servlet.RequestDispatcher dispatch = request.getRequestDispatcher(target);
		dispatch.forward(request, response);

		response.getWriter().println("Path:" + request.getRequestURI());
	}

}
