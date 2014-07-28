package br.com.cdi.component;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.MetaRuleset;
import javax.faces.view.facelets.TagAttribute;

public class JSPIncludeTagHandler extends ComponentHandler {

	public JSPIncludeTagHandler(ComponentConfig  config) {
		super(config);
    }
	
	 /* https://issues.apache.org/jira/browse/MYFACES-3874
	  * java.lang.IllegalArgumentException: Component property class is not writable
	  * Destivar esta classe em jspInclude.taglib.xml 
	 * @see javax.faces.view.facelets.DelegatingMetaTagHandler#createMetaRuleset(java.lang.Class)
	 **/
	@Override 
	 protected MetaRuleset createMetaRuleset(@SuppressWarnings("rawtypes") Class cls) {
		 MetaRuleset meta = super.createMetaRuleset(cls);
		 meta.alias("class", "styleClass");
		 return meta;
	 }

	 @Override
	 public void onComponentCreated(FaceletContext ctx,
			 UIComponent c,
			 UIComponent parent) {
		 TagAttribute[] allAttrs = this.tag.getAttributes().getAll();

		 // we are passing thru all attributes except tag, var and value.
		 String[] attrs = new String[allAttrs.length];
		 int j = 0;
		 for (int i = 0; i < allAttrs.length; i++) {
			 String localName = allAttrs[i].getLocalName();
			 if ("tag".equals(localName) ||
					 "var".equals(localName) ||
					 "value".equals(localName)) {
				 continue;
			 }

			 if ("class".equals(localName)) {
				 attrs[j++] = "styleClass";
			 }
			 else {
				 attrs[j++] = localName;
			 }
		 }

		 Map<String,Object> compAttrs = c.getAttributes();
		 compAttrs.put("alias.attributes", attrs);
	 }
}

