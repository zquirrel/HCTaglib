package zic.hct.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import zit.hct.taglib.html.HTMLElement;

/**
 * The {@code <form>} tag compendix with support for context.
 * 
 * Supported extra attributes are:
 * <ul>
 * <li>href: the relative path to the context path.</li>
 * <li>context: the context path other than the current.</li>
 * </ul>
 * 
 * @author yfwz100
 * 
 */
public class FormTag extends AbstractHTMLBaseSimpleTagSupport {

	private String action;

	public FormTag() {
		super("form");
	}

	/**
	 * Set the action attribute.
	 * 
	 * @return the action attribute.
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Get the action attribute.
	 * 
	 * @param action
	 *            the action attribute to set.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	protected void doTag(HTMLElement element, PageContext ctx)
			throws JspException {
		String url = UrlSupport.resolveUrl(action, getContext(), ctx);
		element.setAttribute("action", url);
	}

}
