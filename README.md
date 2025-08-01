AR Placement App (Android)
==========================

An Android AR app that allows users to select a drill and place a realistic 3D drill model on a detected surface using ARCore and Sceneform.

--------------------------
Features
--------------------------
- Drill selection from UI (Drill 1, Drill 2, Drill 3)
- Drill details screen with image, description, and tips
- Tap on floor to place a 3D `.glb` drill model in AR
- One drill placement per session
- Built with Kotlin + ARCore + Sceneform

--------------------------
Tech Stack
--------------------------
- Android Studio
- Kotlin
- ARCore
- Sceneform Maintained (v1.20.0)

--------------------------
Folder Structure
--------------------------
app/
├── assets/drill1.glb               # 3D model file
├── java/com/example/arplacement/
│   ├── MainActivity.kt             # Drill selector
│   ├── DrillDetailsActivity.kt     # Drill info screen
│   └── ARActivity.kt               # AR logic + model placement
├── res/layout/*.xml                # UI screens

--------------------------
Setup Instructions
--------------------------
1. Clone or Download this project
2. Open in Android Studio
3. Ensure your device supports ARCore
4. Place your 3D model in:
   app/src/main/assets/drill1.glb
5. Connect your Android device and Run the app

--------------------------
Requirements
--------------------------
- Android 7.0+ (API 24+)
- ARCore-supported Android phone
- .glb 3D model file (low-poly recommended)

--------------------------
Credits
--------------------------
Sample 3D drill model from Sketchfab or similar sources
