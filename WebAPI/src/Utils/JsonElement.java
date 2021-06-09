package Utils;

public class JsonElement {
	private String key;
	private String value;
	private boolean isQuote;
	
	public JsonElement(String key, String value, boolean isQuote)
	{
		this.key = key;
		this.value = value;
		this.isQuote = isQuote;
	}

	public boolean IsQuote() {
		return isQuote;
	}

	public void SetQuote(boolean isQuote) {
		this.isQuote = isQuote;
	}

	public String GetKey() {
		return key;
	}

	public void SetKey(String key) {
		this.key = key;
	}

	public String GetValue() {
		return value;
	}

	public void SetValue(String value) {
		this.value = value;
	}
	
	
}
