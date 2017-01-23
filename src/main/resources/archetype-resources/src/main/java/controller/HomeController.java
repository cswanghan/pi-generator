#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


@RestController
public class HomeController {

	@Autowired
	public Environment env;

	@RequestMapping(value="/userFunc/{input}")
	public String callUserFunc (@PathVariable String input) {
		
		return ${package}.demo.App.testRun(input);
	}

    public static final String HELLO_WEB = "Hello World!";

    @RequestMapping("/")
    public String home() {
        return HELLO_WEB + " from " + env.getProperty("env");
    }
    
    @RequestMapping("/readDB")
    public String readDB() {
    	return ${package}.demo.App.readDB();
    }
    
	@RequestMapping(value="/testPost", method = RequestMethod.POST)
	public JSONObject testPost (@RequestBody JSONObject info){
		System.out.println(info);
		JSONObject resObject = new JSONObject();
		resObject.put("status", HttpStatus.OK);
		resObject.put("data", info);
		resObject.put("message", "");
		return resObject;
	}
}

