
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._13_ShareSong.model.ShareService;

/**
 * Servlet implementation class SharePointServlet
 */
@WebServlet("/SharePointServlet")
public class SharePointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SharePointServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    
	    SongVO songVO = new SongVO();
	    JdbcSongDAO songDAO = null;
        
//	    
//	    for( int single =1; single > 0 ; single++){
//
//	    
//	     new ShareService().getIntSahre(songVO);
//	    
//	    }
		   
		    }
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
