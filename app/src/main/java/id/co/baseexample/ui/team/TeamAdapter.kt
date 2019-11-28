package id.co.baseexample.ui.team

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.co.baseexample.R
import id.co.baseexample.data.entity.TeamEntity
import id.co.baseexample.databinding.ItemTeamBinding

class TeamAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    private var dataTeam = emptyList<TeamEntity>()

    class TeamViewHolder(val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TeamEntity) {
            binding.tvTeamName.text = item.teamName
            binding.tvTeamDesc.text = item.teamStadium
            binding.tvTeamInfo.text = item.teamSport
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.TeamViewHolder {
        val binding = DataBindingUtil
            .inflate<ItemTeamBinding>(
                LayoutInflater.from(parent.context), R.layout.item_team,
                parent, false
            )
        return TeamViewHolder(binding)
    }

    override fun getItemCount() = dataTeam.size

    override fun onBindViewHolder(holder: TeamAdapter.TeamViewHolder, position: Int) {
        val current = dataTeam[position]
        holder.bind(current)
    }

    internal fun setData(team: List<TeamEntity>) {
        this.dataTeam = team
        notifyDataSetChanged()
    }

}