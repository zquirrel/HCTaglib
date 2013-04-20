package zit.hct.taglib.html;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HTMLElement implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Object> elements = new ArrayList<Object>();
	private HashMap<String, Object> attributes = new HashMap<String, Object>();
	private String tagName;
	private boolean selfClose = false;

	/**
	 * Construct an empty HTML element with tag name as null.
	 */
	public HTMLElement() {
	}

	/**
	 * Construct a HTML element with tag name.
	 * 
	 * @param tagName
	 *            the tag name of the element.
	 */
	public HTMLElement(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * Get the specific tag name.
	 * 
	 * @return the tag name.
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Set the tag name.
	 * 
	 * @param tagName
	 *            the tag name.
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * Check if the tag is self close. 'Self close' means that the tag don't have
	 * any children element and no end tag.
	 * 
	 * @return true if the tag is self close.
	 */
	public boolean isSelfClose() {
		return selfClose;
	}

	/**
	 * Set the tag if it's self close. 'Self close' means that the tag don't have
	 * any children element and no end tag.
	 * 
	 * @param selfClose
	 */
	public void setSelfClose(boolean selfClose) {
		this.selfClose = selfClose;
	}

	/**
	 * Set the attribute of the element. 
	 * 
	 * @param key
	 *            the attribute name.
	 * @param value
	 *            the value.
	 */
	public void setAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	/**
	 * Get the attribute of the element.
	 * 
	 * @param key
	 *            the attribute name.
	 * @return the value.
	 */
	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	/**
	 * Add a child element to the element.
	 * 
	 * @param elem
	 *            the child element.
	 */
	public void addChild(HTMLElement elem) {
		elements.add(elem);
	}

	/**
	 * Add text element as a child element.
	 * 
	 * @param content
	 *            the content of the text child element.
	 */
	public void addChild(String content) {
		elements.add(content);
	}

	/**
	 * Get the specific child element of this element.
	 * 
	 * @param index
	 *            the index of the element.
	 * @return the HTML element.
	 */
	public Object getChildAt(int index) {
		return elements.get(index);
	}

	/**
	 * Remove the child element by equals.
	 * 
	 * @param elem
	 *            the element to remove.
	 */
	public void removeChild(HTMLElement elem) {
		elements.remove(elem);
	}

	/**
	 * Remove the child element according to the given index.
	 * 
	 * @param index
	 *            the index of the child element.
	 */
	public void removeChildAt(int index) {
		elements.remove(index);
	}

	/**
	 * Output the HTML form of the element.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<");
		builder.append(tagName);

		// Add attributes.
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			builder.append(" ").append(entry.getKey()).append("=\"")
					.append(entry.getValue()).append("\"");
		}

		if (selfClose) {
			builder.append(" />");
		} else {
			builder.append(">");

			// Add elements.
			for (Object elem : elements) {
				builder.append(elem);
			}

			builder.append("</");
			builder.append(tagName);
			builder.append(">");
		}

		return builder.toString();
	}

}
