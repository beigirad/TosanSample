package noob.tosan.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn).setOnClickListener {
            val intent = packageManager.getLaunchIntentForPackage("com.tech.pay")
            intent!!.putExtra("amount", "800000")
            intent.putExtra("packageName", this.packageName)
            startActivity(intent)
            finish()
        }

        val transaction = intent?.extras?.getString("transaction")
        Log.d("Noob Tosan", "result from on-create: $transaction")
        findViewById<TextView>(R.id.tv).text = transaction
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val bundle = intent.extras
        if (bundle != null) {
            val transaction = bundle.getString("transaction")
            Log.d("Noob Tosan", "result from new-intent: $transaction")
            Toast.makeText(this, "transaction: " + transaction, Toast.LENGTH_LONG).show()
        }
    }
}