package zic.hct.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import zit.hct.taglib.html.HTMLElement;

/**
 * The {@code <link />} tag with context support. 
 * 
 * Supported extra attributes are:
 * <ul>
 * 	<li>href: the relative path to the context path.</li>
 *  <li>context: the context path other than the current.</li>
 * </ul>
 * 
 * @author yfwz100
 *
 */
public class LinkTag extends HrefContextSimpleTagSupport {

	/**
	 * Construct a simple {@ <link />} tag.
	 */
	public LinkTag() {
		super("link");
	}

	@Override
	protected void doTag(HTMLElement element, PageContext ctx)
			throws JspException {
		element.setSelfClose(true);
		super.doTag(element, ctx);
	}

}
