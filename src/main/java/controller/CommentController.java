package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.youtube.CommentYT;
import aiss.model.youtube.Snippet;
import aiss.model.youtube.Snippet_;
import aiss.model.youtube.TopLevelComment;
import aiss.resources.YoutubeResource;

/**
 * Servlet implementation class CommentController
 */
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CommentController.class.getName());
	
	
	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        String accessToken = (String) req.getSession().getAttribute("YouTube-token");
	       
	        
	        String sid = (String) req.getSession().getAttribute("movieId");
	        String id = req.getParameter("id");
	        String vid = "";
	    	if(id!=null ) {
				vid = id;
				req.getSession().setAttribute("movieId", id);
				log.log(Level.FINE, "ComentarioController: ID con valor, en sesion hay: "+ (String) req.getSession().getAttribute("movieId"));
			}else if(id == null && sid != null && vid=="") {
				vid = sid;
				log.log(Level.FINE, "ComentarioController: ID sin valor, sid con valor, en sesion hay: "+ (String) req.getSession().getAttribute("movieId"));
			}else {
				log.log(Level.FINE, "ComentarioController: ID sin valor, sid sin valor, en sesion hay: "+ (String) req.getSession().getAttribute("movieId"));
			}
	        
	        
	        
	        
	        String videoId = req.getParameter("videoId");
	        String channelId = req.getParameter("channelId");
	        String content = req.getParameter("comentarios");
	        if (accessToken != null && !"".equals(accessToken)) {
	            
	                YoutubeResource ytResource = new YoutubeResource(accessToken);
	               
	                CommentYT comment = new CommentYT();
	                
	                Snippet snp = new Snippet();
	                TopLevelComment tlc = new TopLevelComment();
	                Snippet_ snp_ = new Snippet_();
	                
	                snp_.setTextOriginal(content);

	                tlc.setSnippet_(snp_);
	                

	                snp.setTopLevelComment(tlc);
	                
	 
	                snp.setChannelId(channelId);
	               
	                snp.setVideoId(videoId);
	                
	                snp.setIsPublic(true);
	                
	                comment.setSnippet(snp);
	               
	              
	                CommentYT a = ytResource.insertComment(comment);
	                
	          
	                log.log(Level.FINE, "EL ID DEL VIDEO ES "+videoId+" EL channelID ES "+channelId+" EL COMENTARIO ES "+content);
	                log.log(Level.FINE, "EL SNIPPET ES "+snp.toString());
	                log.log(Level.FINE, "EL SNIPPET ES "+accessToken);
	                //log.log(Level.FINE, "RESPUESTA DE YOUTUBE", a.getId());
	                /*Log de exito en el post del comentario*/
	                req.setAttribute("message",   content + " added to the video!");
	                req.getRequestDispatcher("/commentsuccess.jsp").forward(req, resp);
	    
	        } else {
	            log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
	            req.getRequestDispatcher("/AuthController/YouTube").forward(req, resp);
	        }
	    }

	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        doGet(req, resp);
	    }

}
