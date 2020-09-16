client: main.o soapC.o soapClient.o
	cc -o client main.o soapC.o soapClient.o /usr/local/lib/libgsoap.a

main.o: main.c
	cc -c main.c

soapC.o: soapC.c
	cc -c soapC.c
	
soapClient.o: soapClient.c
	cc -c soapClient.c

clean:
	rm -f *.o client

wsdl2h:
	/usr/local/bin/wsdl2h -c -o country.h http://localhost:8080/ws/countries.wsdl

soapcpp2:
	/usr/local/bin/soapcpp2 -cCL country.h
