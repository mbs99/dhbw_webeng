client: main.o soapC.o soapClient.o
	cc -O3 -o dist/client obj/main.o obj/soapC.o obj/soapClient.o /usr/local/lib/libgsoap.a

main.o: main.c
	cc -c main.c -o obj/main.o

soapC.o: soapC.c
	cc -c soapC.c -o obj/soapC.o
	
soapClient.o: soapClient.c
	cc -c soapClient.c -o obj/soapClient.o

clean:
	rm -rf dist/ obj/

wsdl2h:
	/usr/local/bin/wsdl2h -c -o country.h http://localhost:8080/ws/countries.wsdl

soapcpp2:
	/usr/local/bin/soapcpp2 -cCL country.h

setup:
	mkdir -p dist
	mkdir -p obj

