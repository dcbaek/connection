package com.example.connection.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommUtil {
    protected static Logger log = LoggerFactory.getLogger("CommUtil");

    public static JSONObject StrToJSONObject(String str) {
        JSONObject jObj = null;
        JSONParser parser = new JSONParser();

        try {
            if(!"".equals(str) && null != str) {
                jObj = (JSONObject) parser.parse(str);

            } else {
                jObj.put("", "");
            }
        } catch (Exception e) {
            log.error("[util_StringToJSONObject] : " + e.toString());
        }
        return jObj;
    }

    public static String JSONObjectToParse(JSONObject jObj, String value) {
        String rStr = "";

        try {
            if(!"".equals(jObj) && null != jObj) {
                rStr = jObj.get(value).toString();
            }else {
                rStr = "";
            }

        }catch (Exception e) {
            log.error("[util_ToJSONObject] : " + e.toString());
        }
        return rStr;
    }
}
