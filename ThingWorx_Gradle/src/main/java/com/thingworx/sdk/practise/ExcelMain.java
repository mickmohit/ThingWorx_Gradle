package com.thingworx.sdk.practise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.thingworx.communications.client.ClientConfigurator;
import com.thingworx.communications.client.ConnectedThingClient;

public class ExcelMain {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExcelMain.class);
	
	public static void main(String[] args) throws Exception
	{
		//ExcelThing et=new ExcelThing();
		//et.readBooksFromExcelFile();
		

		
		
String serverUri= "ws://10.196.110.141:80/Thingworx/WS";
		
		
		//String appkey= "558b1f52-6fde-432a-853c-276ceff2da0f";
		ClientConfigurator config = new ClientConfigurator();
		config.setUri(serverUri);
		//config.getSecurityClaims().addClaim("appkey",appkey);
		
		config.setAppKey("ce22e9e4-2834-419c-9656-ef9f844c784c");
		
		
	
		config.ignoreSSLErrors(true);
		
		
		//config.fileTransferEnabled(true);
		//config.addVirtualDirectory("in", Paths.get("/Users","abc"));
		
		ConnectedThingClient client = new ConnectedThingClient(config, null);
		client.start();
		
		LOG.debug("Connecting to" + serverUri + "using appkey" );
		
		while(!client.getEndpoint().isConnected())
		{Thread.sleep(5000);}
		LOG.debug("Connected to" + serverUri + "using appkey" );
		
		
		
		//EcgThing ecg = new EcgThing("EcgThing", "A heart rate Monitor", client);
		
	//	FileTransferThing Fth= new FileTransferThing("FileTransferThing","File Transfer Thing", client);
		
		ExcelThing et1 = new ExcelThing("ExcelThing", "A Excel reader",client);
		
		//LOG.debug("Binding To" + serverUri + "using key to register Thing" + et1.getName()  );
		
		client.bindThing(et1);
		//client.bindThing(Fth);
		while(!et1.isBound())
		{
			Thread.sleep(5000);
		}
		//LOG.debug("Binded To" + serverUri + "using key to register Thing" + ecg.getName()  );
				
		while(true)
		{
			if(client.getEndpoint().isConnected())
			{et1.readBooksFromExcelFile();}
			//double currentHeartrate= ecg.getHeartRate();
			
			
		Thread.sleep(5000);
		}
		
	}

}
