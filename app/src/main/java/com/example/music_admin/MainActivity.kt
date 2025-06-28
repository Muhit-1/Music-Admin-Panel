package com.example.music_admin

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var spinnerGenre: Spinner

    private val genres = listOf("Classical", "Country", "Hiphop", "Pop", "R & B", "Rock")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()

        val editSongId = findViewById<EditText>(R.id.editSongId)
        val editTitle = findViewById<EditText>(R.id.editTitle)
        val editArtist = findViewById<EditText>(R.id.editArtist)
        val editCoverUrl = findViewById<EditText>(R.id.editCoverUrl)
        val editUrl = findViewById<EditText>(R.id.editUrl)
        spinnerGenre = findViewById(R.id.spinnerGenre)
        val buttonUpload = findViewById<Button>(R.id.buttonUpload)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGenre.adapter = adapter

        buttonUpload.setOnClickListener {
            val songId = editSongId.text.toString().trim()
            val title = editTitle.text.toString().trim()
            val artist = editArtist.text.toString().trim()
            val coverUrl = editCoverUrl.text.toString().trim()
            val url = editUrl.text.toString().trim()
            val selectedGenre = spinnerGenre.selectedItem.toString()

            if (songId.isEmpty() || title.isEmpty() || artist.isEmpty() || url.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val songData = hashMapOf(
                "id" to songId,
                "title" to title,
                "artist" to artist,
                "coverUrl" to coverUrl,
                "url" to url
            )

            db.collection("songs").document(songId)
                .set(songData)
                .addOnSuccessListener {
                    db.collection("genre").document(selectedGenre)
                        .update("songs", FieldValue.arrayUnion(songId))
                        .addOnSuccessListener {
                            Toast.makeText(this, "Song uploaded and added to genre!", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Upload OK, but genre update failed: ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Upload failed: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
