# 🚗 Smart Parking System

A Smart Parking System developed using Arduino UNO, PIR Motion Sensor, and Java Swing GUI with Serial Communication.

The system detects parking activity using a PIR sensor and displays real-time parking information through a desktop application.

---

# 📌 Introduction

Parking management is an important part of modern smart systems. This project provides a simple and efficient smart parking solution using embedded systems and desktop application technology.

The Arduino detects motion using a PIR sensor and sends parking information to the Java Swing application through serial communication.

The Java GUI displays:
- Occupied slots
- Available slots
- Parking status
- Motion detection alerts

---

# ✨ Features

- Smart parking monitoring
- PIR motion detection
- Real-time slot availability
- Java Swing graphical interface
- Live serial communication
- Parking status display
- Easy hardware setup
- User-friendly system

---

# ⚙️ Components Used

## Hardware
- Arduino UNO
- PIR Motion Sensor
- LED Module
- Breadboard
- Jumper Wires
- USB Cable

## Software
- Arduino IDE
- IntelliJ IDEA
- Java Swing
- jSerialComm Library
- Wokwi Simulator

---

# 🔌 Hardware Connections

## PIR Sensor Connections

| PIR Sensor | Arduino UNO |
|------------|--------------|
| VCC | 5V |
| GND | GND |
| OUT | D4 |

---

## LED Module Connections

| LED Module | Arduino UNO |
|-------------|--------------|
| G | GND |
| V | 5V |
| S | D8 |

---

# 📡 Serial Communication

The Arduino sends parking data to the Java GUI using Serial Communication.

Example data format:

```text
OCCUPIED:3
AVAILABLE:7
STATUS:AVAILABLE
MOTION:DETECTED
