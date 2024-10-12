package com.b15d52nhom4.apptuyendung.ui.xample.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b15d52nhom4.apptuyendung.data.model.UserExample
import com.b15d52nhom4.apptuyendung.databinding.ItemUserBinding

class UserAdapter(private val inter: IUserAdapter) :
    RecyclerView.Adapter<UserAdapter.Companion.UserViewHolder>() {

    companion object {
        class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
    }

    interface IUserAdapter {
        fun count(): Int
        fun getData(position: Int): UserExample
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.user = inter.getData(position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return inter.count()
    }
}