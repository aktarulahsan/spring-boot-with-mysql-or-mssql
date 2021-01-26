package com.aktarulahsan.erp.util;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Md. Aktarul Ahsan
 *
 */
public class Def {

	static String dateFormat;
	
	
	public final static String stringType = "String";
	public final static String longType   = "Long";
	public final static String floatType  = "Float";
    public final static String booleanType = "Boolean";
	public final static String doubleType = "Double";
	public final static String intType    = "int";
	public final static String integerType    = "Integer";
	public final static String stringTypeArray    = "StringArray";
	public final static String longTypeArray      = "LongArray";
	public final static String floatTypeArray     = "FloatArray";
	public final static String doubleTypeArray    = "DoubleArray";
	public final static String integerTypeArray   = "IntegerArray";
	public final static String intTypeArray       = "intArray";
	

	public static JSONObject getJSONObject(String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		return json;
	}


	/**
	 * 
	 * @param json
	 * @param key
	 * @return String
	 */
	public static String getString(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.get(key).toString();
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static Object getObjcect(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.get(key);
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static String getArrayString(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.getJSONArray(key).toString();
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static Object getArrayObj(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.getJSONArray(key);
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static  JSONArray getJSONArray(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return json.getJSONArray(key);
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @retur Long
	 */
	public static Long getLong(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" &&  !json.isNull(key)) {
				return Long.parseLong(json.get(key).toString());
			} else {
				return null;
			}
		}
		return null;
	}

    /**
     * @param json
     * @param key
     * @retur Boolean
     */
    public static Boolean getBoolean(JSONObject json, String key) {
        if (json.has(key)) {
            if (json.get(key) != "" && !json.isNull(key)) {
                return Boolean.parseBoolean(json.get(key).toString());
            } else {
                return null;
            }
        }
        return null;
    }
	
	/**
	 * @param json
	 * @param key
	 * @return
	 */
	public static Long[] getArrayLong(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != null) {
				return jsonArryToLongtArry(getJSONArray(json,key));
			} else {
				return null;
			}
		}
		return null;
	}
	

    public static Long[] jsonArryToLongtArry(JSONArray arr) {
        Long[] item = new Long[arr.length()];
        for (int i = 0; i < arr.length(); ++i) {
            item[i] = arr.optLong(i);
        }
        return item;
    }
	
	/**
	 * 
	 * @param json
	 * @param key
	 * @retur Double
	 */
	public static Double getDouble(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {				
				return Double.parseDouble(json.get(key).toString());
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @return Integer
	 */
	public static Integer getInteger(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && json.get(key) != null) {
				return Integer.parseInt(json.get(key).toString());
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @return date
	 */
	public static Date getDate(JSONObject json, String key) {
		SimpleDateFormat formatter = null;
		if (Def.dateFormat == null) {
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			formatter = new SimpleDateFormat(Def.dateFormat);
		}

		if (json.has(key)) {

			if (!json.get(key).equals("") && json.get(key) != null) {
				try {
					return formatter.parse(json.get(key).toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param json
	 * @param key
	 * @param dateFromat
	 * @return date
	 */
	public static Date getDate(JSONObject json, String key, String dateFromat) {
		Def.dateFormat = dateFromat;
		return Def.getDate(json, key);
	}

	/**
	 * @param dateStr
	 * @return
	 */
	public static Date DateParse(String dateStr) {
		Date date = null;
		SimpleDateFormat formatter = null;
		if (Def.dateFormat == null) {
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			formatter = new SimpleDateFormat(Def.dateFormat);
		}
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date DateParse(String dateStr, String format) {
		Def.dateFormat = format;
		Date date = null;
		SimpleDateFormat formatter = null;
		if (Def.dateFormat == null) {
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			formatter = new SimpleDateFormat(Def.dateFormat);
		}
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return date;
		}

		return date;
	}

		/**
	 * 
	 * @param json
	 * @param key
	 * @retur Float
	 */
	public static Float getFloat(JSONObject json, String key) {
		if (json.has(key)) {
			if (json.get(key) != "" && !json.get(key).toString().isEmpty() && json.get(key) != null ) {	

					return Float.parseFloat(json.get(key).toString());
				
			} else {
				return null;
			}
		}
		return null;
	}
	

	public static  Long[] jsonArryToLongArry(JSONArray arr) {
		Long[] item = new Long[arr.length()];
		for (int i = 0; i < arr.length(); ++i) {
			item[i] = arr.getLong(i);
		}
		return item;
	}
	
	public static JSONArray stringToJsonArry(JSONObject jsonObj, String key) {
		Object objBykey = Def.getObjcect(jsonObj, key);
		JSONArray jsonArray = new JSONArray();
		if (objBykey instanceof JSONArray) {
			jsonArray = (JSONArray) objBykey;
		} else if (objBykey instanceof String) {
			jsonArray.put(objBykey);
		}
		return jsonArray;
	}
	
	public static String customFileName(MultipartFile file, String customFileName) {
	     return customFileName+"."+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
	}
	
	
	
}
