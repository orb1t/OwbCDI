package br.com.cdi.component;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class JSPIncludeTag extends UIComponentELTag {
	private ValueExpression pageVE;
	
	@Override
	public String getComponentType() {
		return "components.jsp.includeComponentType";
	}

	@Override
	public String getRendererType() {
		return "components.jsp.includeRenderer";
	}

	@Override
	protected void setProperties(UIComponent comp) {
		super.setProperties(comp);
		
		comp.setValueExpression("page", pageVE);
	}

	@Override
	public void release() {
		super.release();
		
		pageVE = null;
	}

	public void setPage(ValueExpression pageVE) {
		this.pageVE = pageVE;
	}
	
}
