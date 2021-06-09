package Utils;

import java.util.List;

public class JsonListElement {
	private String key;
	private List<List<JsonElement>> nestedJsons;
	
	public JsonListElement(String key, List<List<JsonElement>> nestedJsons)
	{
		this.key = key;
		this.nestedJsons = nestedJsons;
	}

	public String GetKey() {
		return key;
	}

	public void SetKey(String key) {
		this.key = key;
	}

	public List<List<JsonElement>> GetNestedJsons() {
		return nestedJsons;
	}

	public void SetNestedJsons(List<List<JsonElement>> nestedJsons) {
		this.nestedJsons = nestedJsons;
	}
	
	
}
