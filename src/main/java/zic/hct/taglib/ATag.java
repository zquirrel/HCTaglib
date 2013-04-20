package zic.hct.taglib;

/**
 * The {@code <a>} tag compendix with support for context.
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
public class ATag extends HrefContextSimpleTagSupport {

	public ATag() {
		super("a");
	}

}
