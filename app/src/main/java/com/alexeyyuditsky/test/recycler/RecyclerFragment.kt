package com.alexeyyuditsky.test.recycler

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.ItemCarBinding
import com.alexeyyuditsky.test.databinding.RecyclerFragmentBinding

class RecyclerFragment : Fragment(R.layout.recycler_fragment) {

    private var _binding: RecyclerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = RecyclerFragmentBinding.bind(view)

        val adapter = CarRecyclerView()
        adapter.update(carList)
        binding.recyclerView.adapter = adapter
        val itemDecoration = DividerItemDecoration(requireContext(), LinearLayout.VERTICAL)
        binding.recyclerView.addItemDecoration(itemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val carList = listOf(
            Car(name = "Mitsubishi Lancer", "250speed", "300hp"),
            Car(name = "Mitsubishi Outlander", "150speed", "400hp"),
            Car(name = "Mitsubishi ASX", "230speed", "350hp"),
            Car(name = "Mitsubishi Pajero", "150speed", "600hp"),
            Car(name = "Mitsubishi Galant", "650speed", "200hp"),
            Car(name = "Mitsubishi Carisma", "250speed", "300hp"),
            Car(name = "Mitsubishi Colr", "270speed", "340hp"),
            Car(name = "Mitsubishi Montero", "290speed", "706hp"),
            Car(name = "Mitsubishi Grandis", "210speed", "304hp"),
            Car(name = "Mitsubishi RVR", "850speed", "307hp"),
            Car(name = "Mitsubishi Pinin", "450speed", "301hp"),
            Car(name = "Mitsubishi Airtrek", "210speed", "380hp"),
            Car(name = "Mitsubishi EVO", "280speed", "370hp"),
            Car(name = "Mitsubishi Wagon", "252speed", "900hp"),
            Car(name = "Mitsubishi Out New", "256speed", "800hp")
        )
    }
}

data class Car(
    val name: String,
    val speed: String,
    val hp: String
)

class CarRecyclerView : RecyclerView.Adapter<CarViewHolder>() {

    private val carList = mutableListOf<Car>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int = carList.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newCarList: List<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }
}

class CarViewHolder(private val binding: ItemCarBinding) : ViewHolder(binding.root) {
    fun bind(item: Car) {
        binding.nameTextView.text = item.name
        binding.hpTextView.text = item.hp
        binding.speedTextView.text = item.speed
    }
}