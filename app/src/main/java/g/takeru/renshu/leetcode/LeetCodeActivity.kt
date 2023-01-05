package g.takeru.renshu.leetcode

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.BuildConfig
import g.takeru.renshu.leetcode.databinding.ActivityLeetcodeBinding
import g.takeru.renshu.leetcode.problems.*
import g.takeru.renshu.leetcode.problems.model.Problem
import timber.log.Timber


/**
 * Created by takeru on 2018/3/13.
 */
class LeetCodeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLeetcodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeetcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        listProblems()
    }

    private fun listProblems() {
        // create problem list
        val problemList : MutableList<Problem> = ArrayList()
        problemList.add(Problem(1, "Two Sum") { TwoSum().testing() })
        problemList.add(Problem(2, "Add Two Numbers") { AddTwoNumbers().testing() })
        problemList.add(Problem(7, "Reverse Integer") { ReverseInteger().testing() })
        problemList.add(Problem(9, "Palindrome Number") { PalindromeNumber().testing() })
        problemList.add(Problem(206, "Reverse Linked List") { ReverseLinkedList().testing() })
        problemList.add(Problem(334, "Reverse String") { ReverseString().testing() })

        // not belong to LeetCode
        problemList.add(Problem(99999, "Minimum Depth of a Binary Tree") {
            MinimumDepthOfBinaryTree().testing()
        })


        // initial adapter
        val listAdapter = ProblemListAdapter(problemList)
        binding.recyclerViewProblemList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProblemList.adapter = listAdapter
    }
}