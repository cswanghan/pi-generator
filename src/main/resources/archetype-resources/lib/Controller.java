#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.aliexpress.spring.boot.demo.controller;  import org.springframework.web.bind.annotation.*;  @RestController public class Controller {      @RequestMapping(value = "/userFunc/{name}", method = RequestMethod.GET) public String testRun(@PathVariable String name) throws Exception{ 		 	return ${package}.demo.App.testRun(name); }   } 