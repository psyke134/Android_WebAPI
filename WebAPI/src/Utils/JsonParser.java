package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
	private String jsonString;
	
	public JsonParser(String jsonString)
	{
		this.jsonString = jsonString;
	}
	
	public static JsonParser FromReader(BufferedReader reader)
	{
		StringBuilder builder = new StringBuilder();
		try
		{
			String line;
			line = reader.readLine();
			while(line != null)
			{
				builder.append(line);
				line = reader.readLine();
			}
		}
		catch(IOException e)
		{
			System.out.print(e.getMessage());
		}
		
		return new JsonParser(builder.toString());
	}
	
	public List<JsonElement> Parse()
	{
		List<JsonElement> results = new ArrayList<JsonElement>();
		
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(jsonString);
		
		int count = 1;	//odd numbers mean keys, even numbers mean values for json
		
		String key = "";
		String value = "";
		
		while (matcher.find()) {
			
			if (count % 2 != 0)
			{
				//odd number
				key = matcher.group(1);
			}
			else
			{
				//even number
				value = matcher.group(1);
				results.add(new JsonElement(key, value, true));
				
			}
			
			count ++;
        }
		
		return results;
	}
}
