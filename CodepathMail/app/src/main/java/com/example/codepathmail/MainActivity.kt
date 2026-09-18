    package com.example.codepathmail

    import android.os.Bundle
    import android.widget.Button
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView

    class MainActivity : AppCompatActivity() {

        lateinit var emails: MutableList<Email>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
            emails = EmailFetcher.getEmails()
            val adapter = EmailAdapter(emails)
            emailsRv.adapter = adapter
            emailsRv.layoutManager = LinearLayoutManager(this)

            findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
                val newEmails = EmailFetcher.getNext5Emails()
                emails.addAll(newEmails)
                adapter.notifyDataSetChanged()
            }


        }
    }