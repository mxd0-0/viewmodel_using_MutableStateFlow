import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class testViewModel : ViewModel() {

    // MutableStateFlow to hold the current color with ARGB format
    private val _color = MutableStateFlow(0xFFFFFFFF.toInt())  // White color initially
    val color: StateFlow<Int> = _color

    // Function to generate a random color with alpha channel set to full opacity (FF)
    fun changeColor() {
        val randomColor = (0xFF shl 24) or Random.nextInt(0xFFFFFF)
        _color.value = randomColor
    }
}
