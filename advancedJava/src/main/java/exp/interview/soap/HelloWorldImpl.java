package com.chandler.exp.interview.soap;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.chandler.exp.interview.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

}
