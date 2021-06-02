package Utils;

public class JsonElement {
	private String key;
	private String value;
	
	public JsonElement(String key, String value)
	{
		this.key = key;
		this.value = value;
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
