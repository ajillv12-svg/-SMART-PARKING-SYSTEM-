SMART PARKING SYSTEM (PIR + 1 LED)
const int pirSensor = 4;
const int led = 8;

// Parking settings
int totalSlots = 10;
int occupiedSlots = 0;

// Motion control
bool motionState = false;
unsigned long lastTrigger = 0;
const unsigned long delayTime = 3000;

void setup() {

  pinMode(pirSensor, INPUT);
  pinMode(led, OUTPUT);

  Serial.begin(9600);

  Serial.println("SMART PARKING STARTED");
}

void loop() {

  int motion = digitalRead(pirSensor);

  MOTION DETECTED 
  if (motion == HIGH && !motionState) {
    if (millis() - lastTrigger > delayTime) {
      // simulate car entry
      if (occupiedSlots < totalSlots) {
        occupiedSlots++;
      }
      lastTrigger = millis();
sendData();
      Serial.println("MOTION:DETECTED");
    }
    motionState = true;
  }
  if (motion == LOW) {
    motionState = false;
  }
  updateLED();
  delay(300);
}
// ================= LED STATUS =================
void updateLED() {
 int available = totalSlots - occupiedSlots;
  if (available > 0) {
    digitalWrite(led, HIGH);   // AVAILABLE
  } else {
    digitalWrite(led, LOW);    // FULL
  }
}
// ================= SERIAL DATA =================
void sendData() {
  int available = totalSlots - occupiedSlots;
Serial.print("OCCUPIED:");
  Serial.println(occupiedSlots);
  Serial.print("AVAILABLE:");
  Serial.println(available);
  Serial.print("STATUS:");
  Serial.println(available == 0 ? "FULL" : "AVAILABLE");
  Serial.println("----------------");
}
