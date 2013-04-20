package zic.hct.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import zit.hct.taglib.html.HTMLElement;

public class ImgTag extends SrcContextSimpleTagSupport {

	public ImgTag() {
		super("img");
	}

	@Override
	protected void doTag(HTMLElement element, PageContext ctx)
			throws JspException {
		element.setSelfClose(true);
		super.doTag(element, ctx);
	}

}
