# Music Admin Panel (Android App)

This is the **Admin Upload Panel** for the [Music Player App](https://github.com/Muhit-1/Music-Player-App).

This panel allows the admin to upload new songs to the Firebase Firestore database used by the main music player app. Songs are added to both the `songs` collection and the selected `genre` document.

---

## 📱 Features

- Upload new song metadata to Firebase:
  - Song ID
  - Title
  - Artist
  - Cover Image URL
  - Audio URL (from [JukeHost](https://jukehost.co.uk))
  - Genre selection (e.g., Pop, Rock, HipHop)
- Automatically updates:
  - `songs` collection with full song details
  - `genre/{genre_name}` document with song ID reference
- Lightweight, single-page admin UI

---

## 🔗 Related Project

🎧 [Main Music Player App Repository](https://github.com/Muhit-1/Music-Player-App)

---

## 🔥 Firebase Schema

- **Collection: `songs`**
  - Fields: `id`, `title`, `artist`, `coverUrl`, `url`
- **Collection: `genre`**
  - Each document has: `name`, `coverUrl`, `songs: []` (array of song IDs)

---

## ⚙️ Setup Instructions

1. Clone this repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/Music-Admin-Panel.git

2. Open the project in Android Studio
3. - **Connect Firebase:**
     - Add your google-services.json to the app/ directory
     - Enable Firestore in Firebase console
     - Add Internet permission to AndroidManifest.xml:
    ```bash
   <uses-permission android:name="android.permission.INTERNET" />
    
4. Run the app on an emulator or device.
