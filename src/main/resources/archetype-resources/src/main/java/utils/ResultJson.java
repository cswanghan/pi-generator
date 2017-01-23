#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import java.sql.Timestamp;
import java.util.Map;

public class ResultJson {
    public Timestamp timeStamp;
	public Integer status;
	public String error;
	public String message;
	public Object data;
	
	public ResultJson (int status, Map<String, Object> resultAttributes) {
		this.status = status;
		this.error = (String) resultAttributes.get("error");
		this.message = (String) resultAttributes.get("message");
		this.timeStamp = new Timestamp(System.currentTimeMillis());;
		this.data = (Object) resultAttributes.get("data");
	}
}
