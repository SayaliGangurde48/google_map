# 📍 Android Map Redirect App

An Android app that allows users to **redirect to Google Maps** and get directions from their **current location** to a **destination** with a single tap! 🚗🗺️

---

## 🌟 Features

✅ Simple and clean UI  
✅ Enter source and destination locations  
✅ Opens directions directly in **Google Maps**  
✅ Handles missing input with helpful messages  
✅ Fallback to browser if Google Maps is not installed  

---

## 🛠️ Tech Stack

| Tool | Description |
|------|-------------|
| 🧰 Android Studio | IDE used for development |
| 💻 Java | Programming language |
| 📱 Android API 35 | Target SDK version |
| 🔧 Emulator / Device | For testing the application |

---

## 🖼️ UI Layout (`activity_main.xml`)

- ✏️ Two `EditText` fields: `From Location`, `To Location`  
- 📍 One `Button`: `Get Direction`  
- Built using **ConstraintLayout**

---

## 🧠 Logic Overview (`MainActivity.java`)

```java
Uri uri = Uri.parse("https://www.google.com/maps/dir/" + from + "/" + to);
Intent intent = new Intent(Intent.ACTION_VIEW, uri);
intent.setPackage("com.google.android.apps.maps");
startActivity(intent);
