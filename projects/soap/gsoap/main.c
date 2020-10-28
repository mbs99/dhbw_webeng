#include "CountriesPortSoap11.nsmap" // XML namespace mapping table (only needed once at the global level)
#include "soapH.h"                   // client stubs, serializers, etc.

int main(int argc, char **argv)
{
  struct soap *soap = soap_new1(SOAP_C_UTFSTRING); // allocate and initialize a context
  struct _ns1__getCountryRequest request;
  request.name = argv[1];
  struct _ns1__getCountryResponse response;
  if (soap_call___ns1__getCountry(soap, "http://localhost:8080/ws", NULL, &request, &response) == SOAP_OK)
  {
    printf("%s\n", response.country->name);
    printf("%i\n", response.country->population);
    printf("%s\n", response.country->capital);
    int currency = response.country->currency;
    switch (currency)
    {
    case ns1__currency__EUR:
    {
      printf("%s\n", "EUR");
    }
    break;
    case ns1__currency__GBP:
    {
      printf("%s\n", "GBP");
    }
    break;
    case ns1__currency__PLN:
    {
      printf("%s\n", "PLN");
    }
    break;

    default:
    {
      printf("%s\n", "Unknown currency");
    }
    }
  }
  else
  {
    soap_print_fault(soap, stderr);
  }

  soap_destroy(soap); // delete managed deserialized C++ instances
  soap_end(soap);     // delete other managed data
  soap_free(soap);    // free the soap struct context data
}