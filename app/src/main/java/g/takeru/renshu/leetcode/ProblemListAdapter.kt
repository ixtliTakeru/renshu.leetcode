package g.takeru.renshu.leetcode;

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import g.takeru.renshu.leetcode.databinding.ListitemProblemBinding
import g.takeru.renshu.leetcode.problems.model.Problem
import splitties.toast.toast
import timber.log.Timber

internal class ProblemListAdapter(private var problemList : MutableList<Problem>) :
        RecyclerView.Adapter<ProblemListAdapter.ProblemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ProblemViewHolder =
        ProblemViewHolder(ListitemProblemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder : ProblemViewHolder, position : Int){
        val problem = problemList[position]

        holder.binding.apply {
            container.setOnClickListener {
                toast("See logs")
                problem.itemClickListener()
            }
            problemIndex.text = "NO." + problem.index.toString()
            problemName.text = problem.name
        }
    }

    override fun getItemCount() : Int = problemList.size

    class ProblemViewHolder (val binding : ListitemProblemBinding):
        RecyclerView.ViewHolder(binding.root)
}
