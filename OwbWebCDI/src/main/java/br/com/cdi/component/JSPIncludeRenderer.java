package br.com.cdi.component;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

public class JSPIncludeRenderer extends Renderer {

//	private void assertValidInput(FacesContext context, UIComponent component) {
//		if (context == null) {
//			throw new NullPointerException(
//					"context should not be null");
//		} else if (component == null) {
//			throw new NullPointerException(
//					"component should not be null");
//		}
//	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decode(context, component);
		/*assertValidInput(context, component);

		if (component instanceof UIInput) {
			UIInput input = (UIInput) component;
			String clientId = input
					.getClientId(context);

			Map<String,String> requestMap = context
					.getExternalContext()
					.getRequestParameterMap();
			String newValue = (String) requestMap
					.get(clientId);
			
//			context.getAttributes().put("lines", component.getAttributes().get("lines"));
//			context.getAttributes().put("words", component.getAttributes().get("words"));
			if (null != newValue) {
				input.setSubmittedValue(newValue);
			}
		}*/
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}

	@Override
	public void encodeChildren(FacesContext ctx, UIComponent component)
			throws IOException {
//		ResponseWriter writer = ctx.getResponseWriter();
		
//		String id = (String) component.getClientId(ctx);
		
//		writer.startElement("jspinclude", component);
//		writer.writeAttribute("id", id, "id");
//		writer.writeAttribute("lines", component.getAttributes().get("lines"), "lines");
//		writer.writeAttribute("words", component.getAttributes().get("words"), "words");
//		writer.endElement("jspinclude");
		
//		Map<String, Object> param = ctx.getExternalContext().getRequestMap();
		
//		System.out.println ( component.getAttributes().get("lines") ) ;
//		System.out.println ( component.getAttributes().get("words") ) ;
		
		ctx.getAttributes().put("lines", component.getAttributes().get("lines"));
		ctx.getAttributes().put("words", component.getAttributes().get("words"));
		
/*		Iterator<UIComponent> it = component.getFacetsAndChildren();
		while (it.hasNext()) {
			UIParameter p = (UIParameter) it.next();
			param.put(p.getName(), p.getValue().toString());
		
//			writer.startElement("jspinclude", component);
//			writer.writeAttribute(p.getName(), p.getValue(), p.getName());
//			writer.endElement("jspinclude");
			
			System.out.println(p.getName());
			System.out.println(p.getValue().toString());
		}*/

	}
	
	
	
}
