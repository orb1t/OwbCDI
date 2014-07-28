package br.com.cdi.component;

import java.io.IOException;

import javax.faces.component.UIComponentBase;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSPIncludeComponent extends UIComponentBase {

    @Override
	public String getFamily() {
       return "components.jsp.includeFamily";
    }

    @Override
	public void encodeBegin(FacesContext context) throws IOException {
       try {
          ExternalContext externalContext = context.getExternalContext();
          HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
          HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

          // Create dispatcher for the resource given by the componen's page attribute.
          RequestDispatcher requestDispatcher = request.getRequestDispatcher((String) getAttributes().get("page"));

          // Catch the resource's output.
          CharResponseWrapper responseWrapper = new CharResponseWrapper(response);
          requestDispatcher.include(request, responseWrapper);

          // Write the output from the resource to the JSF response writer.
          context.getResponseWriter().write(responseWrapper.toString());
       }
       catch (ServletException e) {
          throw new IOException();
       }
    }

	@Override
	public void encodeChildren(FacesContext ctx) throws IOException {
/*		Iterator<UIComponent> it = getFacetsAndChildren();
		while (it.hasNext()) {
			UIParameter p = (UIParameter) it.next();
//			Object p = it.next();
			System.out.println(p.getName());
			System.out.println(p.getValue().toString());
		}
		System.out.println(getChildCount());*/
 		super.encodeChildren(ctx);
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}
	
	
    
    

}