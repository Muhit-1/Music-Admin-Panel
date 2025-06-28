# Music Admin Panel (Android App)

This is the **Admin Upload Panel** for the [Music Player App](https://github.com/Muhit-1/Music-Player-App).

This panel allows the admin to upload new songs to the Firebase Firestore database used by the main music player app. Songs are added to both the `songs` collection and the selected `genre` document.

---

## Features

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

##  Related Project

🎧 [Main Music Player App Repository](https://github.com/Muhit-1/Music-Player-App)

---

## Firebase Schema

- **Collection: `songs`**
  - Fields: `id`, `title`, `artist`, `coverUrl`, `url`
- **Collection: `genre`**
  - Each document has: `name`, `coverUrl`, `songs: []` (array of song IDs)

---

## Setup Instructions

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

---

## 🛠️ Tech Stack

- **Kotlin**
- **Firebase Firestore**
- **Android Studio**

---

## 👤 Author

### [Muhit Rahman](https://github.com/muhit-1)


License
This project is open source and free to use under the MIT License.


---

### Changes I Made:
- Fixed `bash`/`xml` formatting
- Closed any open code blocks (backticks)
- Added proper line breaks for sections
- Cleaned up the list under "Setup Instructions"

---

Let me know if you want:
- A sample `LICENSE` file (MIT)
- A `preview.gif` showing the UI in the README
- Instructions for publishing the `.apk` to the GitHub Releases tab

You're 100% ready to push 

