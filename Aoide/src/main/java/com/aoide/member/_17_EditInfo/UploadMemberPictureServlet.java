package com.aoide.member._17_EditInfo;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

@WebServlet("/UploadImage")
@MultipartConfig( location="F:\\Aoide", maxFileSize=1024*1024*2, maxRequestSize=1024*1024*5 )
public class UploadMemberPictureServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public UploadMemberPictureServlet() 
    {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	//upload limit in Tomcat  http://stackoverflow.com/questions/2947683/httprequest-maximum-allowable-size-in-tomcat
	//reference   https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Base64.Encoder encoder = Base64.getEncoder();
		Part file = request.getPart("file");
		String fileName = getFileNameFromPart( file ).trim(); 
		System.out.println( "File Name : " + fileName + "\tMIME : " + getServletContext().getMimeType( fileName ) );
		
		HttpSession session =  request.getSession();
		MemberVO userInfo = ( MemberVO ) session.getAttribute( "member" );
		if ( userInfo != null )
		{
			try( InputStream input = new BufferedInputStream( file.getInputStream() );
				 ByteArrayOutputStream baos = new ByteArrayOutputStream()	)
			{
				MemberService ms = new MemberService();
				
				byte[] buffer = new byte[ 8192 ];
				for ( int length = 0; ( length = input.read( buffer ) ) > 0; )
				{
					baos.write( buffer, 0, length );
				}
				String encodedText = encoder.encodeToString( baos.toByteArray() );
				userInfo.setPicture( encodedText );
				
				session.setAttribute( "member", userInfo );
				ms.updateMemberData( userInfo );
				
				response.getWriter().write( "upload success" );
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect(
					request.getContextPath() + "/_08_login.view/login.html" );
		}
	}
	
	//	Example:
	//	Content-Disposition: form-data; name="file"; filename="sample.txt"
	//	Content-Type: text/plain
	private static String getFileNameFromPart( Part part) 
	{
        for ( String cd : part.getHeader( "content-disposition" ).split( ";" ) )
        {
            if ( cd.trim().startsWith("filename") ) 
            {
            	return cd.substring( cd.indexOf('=') + 1 ).trim().replace( "\"", "" );
                 //filename.substring( filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf( '\\') + 1 ); // MSIE fix.
            }
        }
        return null;
    }
}
