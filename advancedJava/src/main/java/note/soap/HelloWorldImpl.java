package note.soap;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.chandler.note.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

}
