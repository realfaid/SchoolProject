#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#include <Adafruit_NeoPixel.h> // knihovna LED

#define LEDka LED_BUILTIN
#define pinDIN 15 // port, kde jsou připojeny LED
#define pocetLED 60 // celkový počet LED Diod

#ifdef ESP32
#pragma message(THIS EXAMPLE IS FOR ESP8266 ONLY!)
#error Select ESP8266 board.
#endif

Adafruit_NeoPixel rgbWS = Adafruit_NeoPixel(pocetLED, pinDIN, NEO_RGB + NEO_KHZ800); // inicializace LED modulu z knihovny

ESP8266WebServer server(80); // 80 je port číslo

byte blik=0;
byte barva=7;

const char* nazevWiFi = "PR"; // Název vaší používáné WiFi  
const char* hesloWiFi = "petrivana7878"; // Heslo od vaší WiFi


String ledon, ledoff, ledcervena, ledmodra, ledzelena, ledruzova, ledazurova, ledzluta, ledbila;

void LEDon() //sviceni
{
  blik = 1;
  server.send(200, "text/html", ledon);
}

void LEDoff() 
{
  blik = 2;
  vypniLed();  
  server.send(200, "text/html", ledoff);
}

void LEDblikani() //blikani
{
  blik = 3;
  server.send(200, "text/html", ledon);
}

void LEDcervena()
{
  barva = 1;
  server.send(200, "text/html", ledcervena);
}

void LEDzelena()
{
  barva = 2;
  server.send(200, "text/html", ledmodra);
}

void LEDmodra()
{
  barva = 3;
  server.send(200, "text/html", ledzelena);
}

void LEDruzova()
{
  barva = 4;
  server.send(200, "text/html", ledruzova);
}

void LEDazurova()
{
  barva = 5;
  server.send(200, "text/html", ledazurova);
}

void LEDzluta()
{
  barva = 6;
  server.send(200, "text/html", ledzluta);
}

void LEDbila()
{
  barva = 7;
  server.send(200, "text/html", ledbila);
}


void setup() 
{
  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.begin(nazevWiFi, hesloWiFi);

  while (WiFi.status() != WL_CONNECTED)delay(500);

  Serial.print(WiFi.localIP());

  server.on("/led1on", LEDon);
  server.on("/led1off", LEDoff);
  server.on("/led1flash", LEDblikani);
  server.on("/led1cervena", LEDcervena);
  server.on("/led1zelena", LEDzelena);
  server.on("/led1modra", LEDmodra);
  server.on("/led1ruzova", LEDruzova);
  server.on("/led1azurova", LEDazurova);
  server.on("/led1zluta", LEDzluta);
  server.on("/led1bila", LEDbila);

  server.begin();
  
  pinMode(LEDka, OUTPUT);
  digitalWrite(LEDka, LOW);
  rgbWS.begin();
  vypniLed();
}

void loop()
{
server.handleClient();
delay(1);
if(blik ==1)
{
    if(barva==1) //cervena
    {
      still(255,0,0, pocetLED, 500);
    }
    
    if(barva==2) // zelena
    {
      still(0,255,0, pocetLED, 500);
    }
    
    if(barva==3) // modra
    {
      still(0,0,255, pocetLED, 500);
    }
    
    if(barva==4) //ruzova
    {
      still(255,0,255, pocetLED, 500);
    }
    
    if(barva==5) //azurova
    {
      still(0,255,255, pocetLED, 500);
    }
    
    if(barva==6) //zluta
    {
      still(255,255,0, pocetLED, 500);
    }
    
    if(barva==7) //bila
    {
       still(150,150,150, pocetLED, 500);
    }    
}

if(blik ==3)
{ 
    if(barva==1) //cervena
    {
      flash(255,0,0,pocetLED, 500, 100);
    }
    
    if(barva==2) //zelena
    {
      flash(0,255,0,pocetLED, 500, 100);
    }
    
    if(barva==3) //modra
    {
     flash(0,0,255,pocetLED, 500, 100);
      }
    
    if(barva==4) //ruzova
    {
      flash(255,0,255,pocetLED, 500, 100);
    }
   
    if(barva==5) //azurova
    {
      flash(0,255,255,pocetLED, 500, 100);
    }
    
    if(barva==6) //zluta
    {
      flash(255,255,0,pocetLED, 500, 100);
    }
    
    if(barva==7) //bila
    {
      flash(150,150,150, pocetLED, 500, 100);
    }
}

}

//____________________________________LEDKY____________________________________________________________________________

void nastavRGB (byte r, byte g, byte b, int cislo) // procedura pro nastavení zadané barvy na zvolenou Diodu
{
  uint32_t barva; // definice proměnné, datový typ
  barva = rgbWS.Color(r, g, b); // načtení barvy do proměnné
  rgbWS.setPixelColor(cislo, barva); 
}

void vypniLed()
{
byte i=0; // vytvoření pomocné proměnné, i = jednotlivá LED Dioda
    
    while(i<pocetLED) // cyklus, který nastaví hodnotu RGB na 0, postupně u všech LED
    {
      rgbWS.setPixelColor(i, 0);
      i++;
    }
rgbWS.show(); // aktualizace barev na všech LED

}

void flash(byte r, byte g, byte b, byte pocet,int zpozdeni, byte jas) // funkce, která nastaví barvu LED Diod, frekvenci blikání a jas
{  
  for (int i =0;i<pocet;i++)
  {
  nastavRGB(r,g,b, i);
  }
rgbWS.show(); //aktualizace barev na všech LED
delay(zpozdeni);
vypniLed();
delay(zpozdeni);
rgbWS.setBrightness(jas);  
}

void still(byte r, byte g, byte b, byte pocet, byte jas) // funkce, které nastaví barvu LED Diod a svícení
{
  for (int i=0; i <pocet; i++)
  {
    nastavRGB(r,g,b,i);  
  }
  rgbWS.show();
  rgbWS.setBrightness(jas);
    
}
