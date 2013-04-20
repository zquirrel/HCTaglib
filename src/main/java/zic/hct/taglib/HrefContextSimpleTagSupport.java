package zic.hct.taglib;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import zit.hct.taglib.html.HTMLElement;


abstract class HrefContextSimpleTagSupport extends AbstractHTMLBaseSimpleTagSupport {

	private String href;
	
	public HrefContextSimpleTagSupport(String tagName) {
		super(tagName);
	}

	@Override
	protected void doTag(HTMLElement element, PageContext ctx) throws JspException {
		String url = UrlSupport.resolveUrl(href, getContext(), ctx);
		element.setAttribute("href", url);
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
