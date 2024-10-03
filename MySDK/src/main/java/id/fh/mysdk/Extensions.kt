package id.fh.mysdk

import java.text.SimpleDateFormat
import java.util.Locale


fun String.sdkToFormattedDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) // Adjust input format if necessary
    val outputFormat = SimpleDateFormat("dd-MM-yy", Locale.getDefault())
    val date = inputFormat.parse(this)
    return if (date != null) outputFormat.format(date) else "Invalid date"
}