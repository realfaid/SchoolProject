#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>

#define LEDka LED_BUILTIN

#ifdef ESP32
#pragma message(THIS EXAMPLE IS FOR ESP8266 ONLY!)
#error Select ESP8266 board.
#endif

ESP8266WebServer server(80); // 80 je port číslo

const char* nazevWiFi = "PR";   
const char* hesloWiFi = "petrivana7878";


String ledon,ledoff;

void LEDon()
{
  digitalWrite(LEDka, LOW);
  server.send(200, "text/html", ledon);
}

void LEDoff()
{
  digitalWrite(LEDka, HIGH);
  server.send(200, "text/html", ledoff);
}


void setup() {

  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.begin(nazevWiFi, hesloWiFi);

  while (WiFi.status() != WL_CONNECTED)delay(500);

  Serial.print(WiFi.localIP());

  server.on("/led1on", LEDon);
  server.on("/led1off", LEDoff);

  server.begin();

  pinMode(LEDka, OUTPUT);
  digitalWrite(LEDka, LOW);

}

void loop()
{
  server.handleClient();
  delay(1);
}
