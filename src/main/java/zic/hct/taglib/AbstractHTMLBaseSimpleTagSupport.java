package zic.hct.taglib;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import zit.hct.taglib.html.HTMLElement;

abstract class AbstractHTMLBaseSimpleTagSupport extends SimpleTagSupport
		implements DynamicAttributes {

	private HTMLElement element;
	private String context;

	public AbstractHTMLBaseSimpleTagSupport(String tagName) {
		this.element = new HTMLElement(tagName);
	}

	/**
	 * Get the context path.
	 * 
	 * @return the context attribute.
	 */
	public String getContext() {
		return context;
	}

	/**
	 * Set the context path.
	 * 
	 * @param context the context attribute to set.
	 */
	public void setContext(String context) {
		this.context = context;
	}
	protected abstract void doTag(HTMLElement element, PageContext ctx)
			throws JspException;

	@Override
	public void doTag() throws JspException, IOException {
		if (this.getJspContext() instanceof PageContext) {
			PageContext ctx = (PageContext) this.getJspContext();

			doTag(element, ctx);

			StringWriter stringWriter = new StringWriter();
			if (this.getJspBody() != null)
				this.getJspBody().invoke(stringWriter);
			element.addChild(stringWriter.getBuffer().toString());

			JspWriter writer = ctx.getOut();
			writer.print(element);
		}
	}

	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		if (!"".equals(value.toString()))
			element.setAttribute(localName, value);
	}

}
