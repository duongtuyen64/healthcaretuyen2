import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.healthcare2.data.api.RetrofitInstance
import com.example.healthcare2.data.model.Medicine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicineRepository (application: Application){
    private var medicineMutableLiveData = MutableLiveData<Medicine>()


    fun getMedicine(idMedicine:Int) : MutableLiveData<Medicine>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<Medicine> = apiService.getMedicine(idMedicine)
        call.enqueue(object : Callback<Medicine?> {
            override fun onResponse(call: Call<Medicine?>, response: Response<Medicine?>) {
                if (response.body() != null) {
                    val medicine : Medicine = response.body()!!
                    medicineMutableLiveData.setValue(medicine)
                    Log.d("SUCCESS", medicine.toString())
                }
            }

            override fun onFailure(call: Call<Medicine?>, t: Throwable) {
                Log.d("ERROR", "msg: " + t.message)
                println("Lỗi: " + t.message)
            }
        })
        return medicineMutableLiveData
    }
}