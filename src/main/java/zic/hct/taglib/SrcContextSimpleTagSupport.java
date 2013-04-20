package zic.hct.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import zit.hct.taglib.html.HTMLElement;

/**
 * The context path support class for those element with {@ src} attribute.
 * 
 * @author yfwz100
 *
 */
abstract class SrcContextSimpleTagSupport extends AbstractHTMLBaseSimpleTagSupport {
	
	private String src;
	
	public SrcContextSimpleTagSupport(String tagName) {
		super(tagName);
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	protected void doTag(HTMLElement element, PageContext ctx) throws JspException {
		String url = UrlSupport.resolveUrl(src, getContext(), ctx);
		element.setAttribute("src", url);
	}

}
