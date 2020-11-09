#include <Adafruit_NeoPixel.h> // knihovna LED
#define pinDIN 12 // port, kde jsou připojeny LED
#define pocetLED 60 // celkový počet LED Diod
Adafruit_NeoPixel rgbWS = Adafruit_NeoPixel(pocetLED, pinDIN, NEO_RGB + NEO_KHZ800); // inicializace LED modulu z knihovny

void setup() 
{
  rgbWS.begin();
  vypniLed();
  Serial.begin(9600);
}
void loop() 
{
//blikani(200,255,255,15,150,100);
sviti(0,100, 50, 10, 50);
}

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

void blikani(byte r,byte g,byte b, byte pocet,int zpozdeni, byte jas) // funkce, která nastaví barvu LED Diod, frekvenci blikání a jas
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

void sviti(byte r, byte g, byte b, byte pocet, byte jas)
{
  for (int i=0; i <pocet; i++)
  {
    nastavRGB(r,g,b,i);  
  }
  rgbWS.show();
  rgbWS.setBrightness(jas);
    
}
