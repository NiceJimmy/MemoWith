package common.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.memowith.R
import com.example.memowith.databinding.ViewholderAlarmListBinding
import com.myapp.memowith.ui.fragment.MyAlarmsFragment
import com.myapp.memowith.ui.viewholder.AlarmListViewHolder

class AlarmListAdapter(val binding: ViewDataBinding) : RecyclerView.Adapter<AlarmListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmListViewHolder {
        val binding = ViewholderAlarmListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlarmListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmListViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
       return 10
    }

}