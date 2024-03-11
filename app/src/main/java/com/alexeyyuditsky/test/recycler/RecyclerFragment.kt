package com.alexeyyuditsky.test.recycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.R
import com.alexeyyuditsky.test.databinding.RecyclerFragmentBinding
import com.alexeyyuditsky.test.core.AbstractFragment
import com.alexeyyuditsky.test.recycler.adapter.CarAdapter
import com.alexeyyuditsky.test.recycler.animator.CustomAnimator
import com.alexeyyuditsky.test.recycler.model.CarUi

class RecyclerFragment : AbstractFragment<RecyclerFragmentBinding>(R.layout.recycler_fragment) {

    override fun bind(view: View): RecyclerFragmentBinding = RecyclerFragmentBinding.bind(view)

    private val viewModel by viewModels<FpsViewModel>()

    private val adapter = CarAdapter()

    private var isHasData = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.adapter = adapter
            adapter.update(carList)
            val itemDecoration = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
            recyclerView.addItemDecoration(itemDecoration)
            recyclerView.itemAnimator = CustomAnimator()
            recyclerView.setHasFixedSize(true)

            clearListButton.setOnClickListener { onClearListButtonPressed() }
            deleteButton.setOnClickListener { onDeleteButtonPressed() }

            viewModel.fpsLiveData.observe(viewLifecycleOwner) {
                fpsTextView.text = it
            }
        }
    }

    private fun onDeleteButtonPressed() = adapter.removeSecondItem()

    private fun onClearListButtonPressed() {
        adapter.update(if (isHasData) carList else emptyList)
        isHasData = !isHasData
    }

    companion object {
        val carList = listOf(
            CarUi.Base(name = "Mitsubishi Lancer", "250speed", "300hp"),
            CarUi.Base(name = "Mitsubishi Outlander", "150speed", "400hp"),
            CarUi.Base(name = "Mitsubishi ASX", "230speed", "350hp"),
            CarUi.Base(name = "Mitsubishi Pajero", "150speed", "600hp"),
            CarUi.Base(name = "Mitsubishi Galant", "650speed", "200hp"),
            CarUi.Base(name = "Mitsubishi Carisma", "250speed", "300hp"),
            CarUi.Base(name = "Mitsubishi Colr", "270speed", "340hp"),
            CarUi.Base(name = "Mitsubishi Montero", "290speed", "706hp"),
            CarUi.Base(name = "Mitsubishi Grandis", "210speed", "304hp"),
            CarUi.Base(name = "Mitsubishi RVR", "850speed", "307hp"),
            CarUi.Base(name = "Mitsubishi Pinin", "450speed", "301hp"),
            CarUi.Base(name = "Mitsubishi Airtrek", "210speed", "380hp"),
            CarUi.Base(name = "Mitsubishi EVO", "280speed", "370hp"),
            CarUi.Base(name = "Mitsubishi Wagon", "252speed", "900hp"),
            CarUi.Base(name = "Mitsubishi Out New", "256speed", "800hp")
        )
        val emptyList = listOf(CarUi.Empty)
    }
}

