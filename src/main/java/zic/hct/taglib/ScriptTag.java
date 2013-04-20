package zic.hct.taglib;

/**
 * The {@code <script>} tag with context path support.
 * 
 * Supported extra attributes are:
 * <ul>
 * 	<li>src: the relative path to the context path.</li>
 *  <li>context: the context path other than the current.</li>
 * </ul>
 * 
 * @author yfwz100
 *
 */
public class ScriptTag extends SrcContextSimpleTagSupport {

	public ScriptTag() {
		super("script");
	}

}
