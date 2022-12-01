




      package edu.fateclins.ws.relatorio;
      import java.time.LocalDateTime;
      import java.time.format.DateTimeFormatter;
      import java.time.format.FormatStyle;
      import java.util.Calendar;
      import javax.jws.WebMethod;
      import javax.jws.WebService;
      import javax.xml.ws.Endpoint;
      @WebService
      public class RelatorioWS { 
	  @WebMethod  
		public String Data() {
	    	
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		LocalDateTime DataHora = LocalDateTime.now();
		String format = formatter.format(DataHora);
		System.out.println(format);
		
		Calendar j1 = Calendar.getInstance();
		int periodo = j1.get(Calendar.HOUR_OF_DAY);
		if(periodo > 6 && periodo < 12) {
			return " Bom dia " + format;
		}else if(periodo > 12 && periodo < 18) {
			return " Boa tarde " + format;	
		}else {
			return " Boa noite " + format;
		}		
		}	
		public static void main(String[] args) {
			//Instancia a classe do Webservice
			RelatorioWS relatoriows = new RelatorioWS(); 
			//URL de acesso ao serviço
			String urlservico = "http://192.168.101.3/relatoriows";
			//Mostra no console mensagem que o serviço foi iniciado
			System.out.println("Serviço RelatorioWS executando na URL: " + urlservico);
			//Publica o Serviço
			Endpoint.publish(urlservico, relatoriows); 

		}
}
















