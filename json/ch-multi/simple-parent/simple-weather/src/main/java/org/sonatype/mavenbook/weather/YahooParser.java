package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import javax.json.*;
import javax.json.Json;
import javax.json.JsonReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {

	private static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(InputStream inputStream) throws Exception {
		Weather weather = new Weather();
		JsonReader rdr = Json.createReader(inputStream);
		JsonObject obj = rdr.readObject();
		JsonObject Location = obj.getJsonObject("observation_location");
		//JsonArray results = obj.getJsonArray("current_observation");
		//Array Climate = results["observation_location"];
		
		weather.setCity(Location.getString("city"));
		weather.setRegion(Location.getString("state") );
		weather.setCountry(Location.getString("country") );
		weather.setCondition(obj.getString("weather"));
		weather.setTemp(obj.getString("temp_f") );
		weather.setChill(obj.getString("feelslike_f") );
		weather.setHumidity( obj.getString("relative_humidity") );
		
		return weather;
	}

}
