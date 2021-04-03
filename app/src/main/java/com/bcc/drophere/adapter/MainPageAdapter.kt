package com.bcc.drophere.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bcc.drophere.R
import com.bcc.drophere.databinding.CardTaskListBinding
import com.bcc.drophere.model.TaskList
import com.bcc.drophere.ui.fragment.main.MainFragmentDirections

class MainPageAdapter(private val list: List<TaskList>) :
    RecyclerView.Adapter<MainPageAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardTaskListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CardTaskListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.tvDate.text = date
                binding.tvCode.text = code
                binding.tvCardTitle.text = title

                binding.icCopy.setOnClickListener {
                    val clipboard =
                        holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val string = binding.tvCode.text.toString()
                    val clip = ClipData.newPlainText("Copied Text", string)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(holder.itemView.context, "Code Copied", Toast.LENGTH_SHORT)
                        .show()
                }
                //TODO: change logic if backend ready
                binding.imgMore.setOnClickListener {
                    val popup = PopupMenu(holder.itemView.context, holder.binding.imgMore)
                    popup.inflate(R.menu.task_list_item_menu)
                    popup.setOnMenuItemClickListener {
                        when (it.itemId) {
                            R.id.nav_info -> {
                                Toast.makeText(
                                    holder.itemView.context,
                                    "Coming Soon",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@setOnMenuItemClickListener true
                            }
                            R.id.nav_unenroll -> {
                                Toast.makeText(
                                    holder.itemView.context,
                                    "Coming Soon",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@setOnMenuItemClickListener true
                            }
                            else ->
                                return@setOnMenuItemClickListener false
                        }
                    }
                    popup.show()
                }
                //TODO: change logic if backend ready
                holder.itemView.setOnClickListener { view ->
                    view.findNavController()
                        .navigate(MainFragmentDirections.actionMainFragmentToDetailPageFragment(code))
                    Toast.makeText(holder.itemView.context, code, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = list.size
}