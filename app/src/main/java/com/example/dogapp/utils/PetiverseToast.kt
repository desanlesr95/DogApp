import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.dogapp.R

class PetiverseToast private constructor() {

    companion object {
        private var currentToast: Toast? = null

        fun showMessage(
            context: Context,
            message: String,
            icon: Int? = null,
            isProgress: Boolean = false,
            duration: Int = Toast.LENGTH_SHORT
        ) {
            val inflater = LayoutInflater.from(context)
            val layout = inflater.inflate(R.layout.petiverse_toast, null)

            val textView: TextView = layout.findViewById(R.id.message)
            val imageView: ImageView = layout.findViewById(R.id.icon)
            val progressBar: ProgressBar = layout.findViewById(R.id.progress_bar)

            textView.text = message

            if (isProgress) {
                progressBar.visibility = View.VISIBLE
                imageView.visibility = View.GONE
            } else {
                progressBar.visibility = View.GONE
                icon?.let {
                    imageView.setImageResource(it)
                    imageView.visibility = View.VISIBLE
                }
            }

            currentToast?.cancel() // Cancel any previous toast to avoid overlaps
            currentToast = Toast(context).apply {
                setGravity(Gravity.BOTTOM, 0, 100)
                this.duration = duration
                view = layout
                show()
            }
        }


        fun dismiss() {
            currentToast?.cancel()
            currentToast = null
        }
    }
}
