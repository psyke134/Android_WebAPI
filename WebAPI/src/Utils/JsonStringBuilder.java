package Utils;

import java.util.List;

public class JsonStringBuilder 
{
	private List<JsonElement> elements;
	private JsonListElement listElement;
	
	public JsonStringBuilder(List<JsonElement> elements)
	{
		this.elements = elements;
	}
	
	public JsonStringBuilder(List<JsonElement> elements, JsonListElement listElement)
	{
		this.elements = elements;
		this.listElement = listElement;
	}
	
	public String BuildString()
	{
		String jsonString = "{";
		
		for(int i = 0; i < elements.size(); i++)
		{
			JsonElement element = elements.get(i);
			jsonString += "\"" + element.GetKey() + "\"";
			jsonString += ":";
			if(element.IsQuote() == true)
				jsonString += "\"" + element.GetValue() + "\"";
			else
				jsonString += element.GetValue();
			
			if(i != elements.size() - 1)
			{
				jsonString += ",";
			}
		}
		
		jsonString += "}";
		return jsonString;
	}
	
	public String BuildString2()
	{
		//build string with list element
		String jsonString = "{";
		
		if(elements == null) {
			jsonString += "\"" + listElement.GetKey() + "\"";
			jsonString += ":[";
			
			List<List<JsonElement>> jsons = listElement.GetNestedJsons();
			for (int i = 0; i < jsons.size(); i++)
			{
				List<JsonElement> nestedElements = jsons.get(i);
				JsonStringBuilder builder = new JsonStringBuilder(nestedElements);
				jsonString += builder.BuildString();
				
				if(i != jsons.size() - 1)
				{
					jsonString += ",";
				}
			}
			
			jsonString += "]}";
			return jsonString;
			
		}
		
		else {
			
			for(int i = 0; i < elements.size(); i++)
			{
				JsonElement element = elements.get(i);
				jsonString += "\"" + element.GetKey() + "\"";
				jsonString += ":";
				if(element.IsQuote() == true)
					jsonString += "\"" + element.GetValue() + "\"";
				else
					jsonString += element.GetValue();
				jsonString += ",";
			}
			
			jsonString += "\"" + listElement.GetKey() + "\"";
			jsonString += ":[";
			
			List<List<JsonElement>> jsons = listElement.GetNestedJsons();
			for (int i = 0; i < jsons.size(); i++)
			{
				List<JsonElement> nestedElements = jsons.get(i);
				JsonStringBuilder builder = new JsonStringBuilder(nestedElements);
				jsonString += builder.BuildString();
				
				if(i != jsons.size() - 1)
				{
					jsonString += ",";
				}
			}
			
			jsonString += "]}";
			return jsonString;
		}
		}
		
		
}
