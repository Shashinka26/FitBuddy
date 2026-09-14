# FitBuddy 💪

A Java-based Android fitness application designed to provide a simple and user-friendly fitness experience.

FitBuddy includes authentication-related screens, a fitness-focused home dashboard, BMI calculation, user profile management, and navigation between different application screens. The project was developed using Android Studio with Java and XML layouts.

---

## 📱 Overview

FitBuddy is an Android mobile application developed as a fitness-focused academic project.

The application provides a structured user experience with:

- User Sign Up
- User Login
- Fitness Home Dashboard
- BMI Calculation
- BMI Result Display
- User Profile
- Navigation between application screens
- Fitness-focused user interface

The project demonstrates Android application development using Java, XML layouts, Android Activities, and Android Studio.

---

## ✨ Features

### 🔐 User Authentication

- Sign Up screen for new users
- Login screen for existing users
- Navigation between Login and Sign Up screens
- Basic authentication screen flow

### 🏠 Home Dashboard

- Fitness-focused home screen
- Navigation from authentication screens to the main application
- Fitness-related visual elements and resources

### ⚖️ BMI Calculator

- Allows users to calculate their Body Mass Index (BMI)
- Displays the calculated BMI result
- Dedicated BMI result screen

### 👤 User Profile

- User profile screen
- Profile-related information management
- Navigation to the user profile section

### 🧭 Application Navigation

- Activity-based navigation
- Navigation between authentication, dashboard, BMI, and profile screens
- Logout/navigation flow back to the Login screen

---

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java | Application development |
| XML | User interface layouts |
| Android Studio | Android development environment |
| Gradle | Project build and dependency management |
| Android SDK | Android application development |

---

## 🏗️ Project Structure

```text
FitBuddy/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/
│           │       └── chumme/
│           │           └── fitbuddy/
│           │               ├── HomeActivity.java
│           │               ├── LoginActivity.java
│           │               ├── SignupActivity.java
│           │               ├── BmiResultActivity.java
│           │               └── ProfileActivity.java
│           │
│           ├── res/
│           │   ├── drawable/
│           │   ├── layout/
│           │   │   ├── activity_login.xml
│           │   │   ├── activity_signup.xml
│           │   │   ├── home.xml
│           │   │   ├── activity_dashboard.xml
│           │   │   └── activity_userprofile.xml
│           │   │
│           │   ├── mipmap/
│           │   ├── values/
│           │   └── values-night/
│           │
│           └── AndroidManifest.xml
│
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts


🔄 Application Flow
             ┌───────────────┐
             │   FitBuddy    │
             │     App       │
             └───────┬───────┘
                     │
                     ▼
             ┌───────────────┐
             │ Login Screen  │
             └───────┬───────┘
                     │
              ┌──────┴──────┐
              │             │
              ▼             ▼
       ┌────────────┐  ┌─────────────┐
       │   Sign Up  │  │ Home /      │
       │   Screen   │  │ Dashboard   │
       └─────┬──────┘  └──────┬──────┘
             │                 │
             └────────┐   ┌────┴─────────┐
                      │   │              │
                      ▼   ▼              ▼
                ┌───────────┐     ┌────────────┐
                │ BMI Result│     │   Profile  │
                │   Screen  │     │   Screen   │
                └───────────┘     └────────────┘
📱 Main Screens
🔐 Login Screen

Provides the initial login interface and navigation to the Sign Up screen.

📝 Sign Up Screen

Allows new users to access the registration flow and continue into the application.

🏠 Home / Dashboard

Provides the main fitness-focused application interface and access to different sections.

⚖️ BMI Result

Displays the result of the BMI calculation.

👤 User Profile

Provides a dedicated screen for user profile information.

🎨 User Interface

The application uses XML-based Android layouts and drawable resources to create the user interface.

The project includes:

Custom backgrounds
Fitness-related images
Custom drawable resources
XML layouts
Android navigation components
Different screen designs for authentication and fitness features
🚀 Getting Started
Prerequisites

Before running the project, make sure you have:

Android Studio
Android SDK
Java Development Kit (JDK)
Android emulator or physical Android device
Clone the Repository
git clone https://github.com/Shashinka26/FitBuddy.git
Open in Android Studio
Open Android Studio.
Select Open.
Select the cloned FitBuddy project.
Allow Gradle to sync.
Connect an Android device or start an emulator.
Run the application.
📦 Build the Application

Using the Gradle wrapper:

Windows
gradlew.bat assembleDebug
macOS / Linux
./gradlew assembleDebug
🎯 Project Objectives

The main objectives of FitBuddy are to:

Develop an Android application using Java
Design mobile interfaces using XML
Implement Android Activity navigation
Create a fitness-oriented application experience
Implement BMI calculation functionality
Practice Android Studio and Gradle-based development
Understand the structure of an Android application
🔮 Future Improvements

Potential improvements for future versions include:

Persistent user authentication
Firebase or database integration
Workout planning and tracking
Calorie tracking
Fitness progress tracking
BMI history
Personalized fitness recommendations
Push notifications
Improved user profile management
📌 Project Status

Status: Completed Academic Project

The current repository contains the Android application source code, layouts, resources, and Gradle project configuration.

👨‍💻 Author

Chamidu Shashinka

Software Developer | Information Technology Undergraduate

GitHub: Shashinka26
LinkedIn: Chamidu Shashinka
