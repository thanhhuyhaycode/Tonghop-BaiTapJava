package model;

public class XmlElement {

	private String tagName;
    private String value;

    public XmlElement(String tagName, String value) {
        this.tagName = tagName;
        this.value = value;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
