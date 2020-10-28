/* soapClient.c
   Generated by gSOAP 2.8.108 for country.h

gSOAP XML Web services tools
Copyright (C) 2000-2020, Robert van Engelen, Genivia Inc. All Rights Reserved.
The soapcpp2 tool and its generated software are released under the GPL.
This program is released under the GPL with the additional exemption that
compiling, linking, and/or using OpenSSL is allowed.
--------------------------------------------------------------------------------
A commercial use license is available from Genivia Inc., contact@genivia.com
--------------------------------------------------------------------------------
*/

#if defined(__BORLANDC__)
#pragma option push -w-8060
#pragma option push -w-8004
#endif
#include "soapH.h"

SOAP_SOURCE_STAMP("@(#) soapClient.c ver 2.8.108 2020-10-23 12:59:54 GMT")


SOAP_FMAC5 int SOAP_FMAC6 soap_call___ns1__getCountry(struct soap *soap, const char *soap_endpoint, const char *soap_action, struct _ns1__getCountryRequest *ns1__getCountryRequest, struct _ns1__getCountryResponse *ns1__getCountryResponse)
{	if (soap_send___ns1__getCountry(soap, soap_endpoint, soap_action, ns1__getCountryRequest) || soap_recv___ns1__getCountry(soap, ns1__getCountryResponse))
		return soap->error;
	return SOAP_OK;
}

SOAP_FMAC5 int SOAP_FMAC6 soap_send___ns1__getCountry(struct soap *soap, const char *soap_endpoint, const char *soap_action, struct _ns1__getCountryRequest *ns1__getCountryRequest)
{	struct __ns1__getCountry soap_tmp___ns1__getCountry;
	if (soap_endpoint == NULL)
		soap_endpoint = "http://localhost:8080/ws";
	if (soap_action == NULL)
		soap_action = "";
	soap_tmp___ns1__getCountry.ns1__getCountryRequest = ns1__getCountryRequest;
	soap_begin(soap);
	soap->encodingStyle = NULL; /* use SOAP literal style */
	soap_serializeheader(soap);
	soap_serialize___ns1__getCountry(soap, &soap_tmp___ns1__getCountry);
	if (soap_begin_count(soap))
		return soap->error;
	if ((soap->mode & SOAP_IO_LENGTH))
	{	if (soap_envelope_begin_out(soap)
		 || soap_putheader(soap)
		 || soap_body_begin_out(soap)
		 || soap_put___ns1__getCountry(soap, &soap_tmp___ns1__getCountry, "-ns1:getCountry", "")
		 || soap_body_end_out(soap)
		 || soap_envelope_end_out(soap))
			 return soap->error;
	}
	if (soap_end_count(soap))
		return soap->error;
	if (soap_connect(soap, soap_endpoint, soap_action)
	 || soap_envelope_begin_out(soap)
	 || soap_putheader(soap)
	 || soap_body_begin_out(soap)
	 || soap_put___ns1__getCountry(soap, &soap_tmp___ns1__getCountry, "-ns1:getCountry", "")
	 || soap_body_end_out(soap)
	 || soap_envelope_end_out(soap)
	 || soap_end_send(soap))
		return soap_closesock(soap);
	return SOAP_OK;
}

SOAP_FMAC5 int SOAP_FMAC6 soap_recv___ns1__getCountry(struct soap *soap, struct _ns1__getCountryResponse *ns1__getCountryResponse)
{
	if (!ns1__getCountryResponse)
		return soap_closesock(soap);
	soap_default__ns1__getCountryResponse(soap, ns1__getCountryResponse);
	if (soap_begin_recv(soap)
	 || soap_envelope_begin_in(soap)
	 || soap_recv_header(soap)
	 || soap_body_begin_in(soap))
		return soap_closesock(soap);
	soap_get__ns1__getCountryResponse(soap, ns1__getCountryResponse, "ns1:getCountryResponse", NULL);
	if (soap->error)
		return soap_recv_fault(soap, 0);
	if (soap_body_end_in(soap)
	 || soap_envelope_end_in(soap)
	 || soap_end_recv(soap))
		return soap_closesock(soap);
	return soap_closesock(soap);
}

#if defined(__BORLANDC__)
#pragma option pop
#pragma option pop
#endif

/* End of soapClient.c */
