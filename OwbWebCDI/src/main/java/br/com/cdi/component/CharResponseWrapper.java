package br.com.cdi.component;

import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharResponseWrapper extends HttpServletResponseWrapper {

	private CharArrayWriter output;

	@Override
	public String toString() {
		return output.toString();
	}

	public CharResponseWrapper(HttpServletResponse response) {
		super(response);
		output = new CharArrayWriter();
	}

	public CharArrayWriter getCharWriter() {
		return output;
	}

	@Override
	public PrintWriter getWriter() {
		return new PrintWriter(output);
	}

	@Override
	public ServletOutputStream getOutputStream() {
		return new CharOutputStream(output);
	}

	public InputStream getInputStream() {
		return new ByteArrayInputStream( toString().getBytes() );
	}
}

class CharOutputStream extends ServletOutputStream {

	private Writer output;

	public CharOutputStream( Writer writer ) {
		output = writer;
	}

	@Override
	public void write(int b) throws IOException {
		output.write(b);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletOutputStream#isReady()
	 * para 
	 * @version API 3.1.0 
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}
	 */

	/* (non-Javadoc)
	 * @see javax.servlet.ServletOutputStream#setWriteListener(javax.servlet.WriteListener)
	 * @version API 3.1.0
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}
	 */

}