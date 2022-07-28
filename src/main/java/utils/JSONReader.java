package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	/**
	 * Using this method, the value stored in the JSON file gets returned..
	 * 
	 * @param filePath
	 * @return
	 * 
	 */

	public static JSONObject getJSONData(String filePath) {

		JSONParser parser = new JSONParser();

		Object object = null;
		try {
			object = parser.parse(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return (JSONObject) object;
	}

	/**
	 * Using this method, nested JSON values can be counted based on the flag set If
	 * the flag is set to true, it returns the matching count and the false returns
	 * the unmatched count.
	 * 
	 * @param filePath
	 * @param jsonArraykey
	 * @param nestedJSONKey
	 * @param expectedValue
	 * @param flag
	 * @return
	 *
	 */
	public static int getNestedJSONDataCount(String filePath, String jsonArraykey, String nestedJSONKey,
			String expectedValue, Boolean flag) {
		int count = 0;
		JSONObject jsonObjectData = null;
		try {
			jsonObjectData = getJSONData(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jsonArrayData = (JSONArray) jsonObjectData.get(jsonArraykey);
		for (int i = 0; i < jsonArrayData.size(); i++) {

			JSONObject jsonObjec1t = (JSONObject) jsonArrayData.get(i);
			String country = (String) jsonObjec1t.get(nestedJSONKey);
			if (flag == true) {
				if (country.equals(expectedValue)) {
					count++;
				}
			} else if (flag == false) {
				if (!country.equals(expectedValue)) {
					count++;
				}
			}
		}
		return count;
	}

}
