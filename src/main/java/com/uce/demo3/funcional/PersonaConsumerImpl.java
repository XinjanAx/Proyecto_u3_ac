package com.uce.demo3.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonaConsumerImpl implements IPersonaConsumer<String>{

	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Override
	public void accept(String arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg1);
	}

}
