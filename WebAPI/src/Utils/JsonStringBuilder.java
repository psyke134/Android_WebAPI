package Utils;

import java.util.List;

public class JsonStringBuilder 
{
	private List<JsonElement> elements;
	
	public JsonStringBuilder(List<JsonElement> elements)
	{
		this.elements = elements;
	}
	
	public String BuildString()
	{
		String jsonString = "{";
		
		for(int i = 0; i < elements.size(); i++)
		{
			JsonElement element = elements.get(i);
			jsonString += "\"" + element.GetKey() + "\"";
			jsonString += ":";
			jsonString += "\"" + element.GetValue() + "\"";
			
			if(i != elements.size() - 1)
			{
				jsonString += ",";
			}
		}
		
		jsonString += "}";
		return jsonString;
	}
}
