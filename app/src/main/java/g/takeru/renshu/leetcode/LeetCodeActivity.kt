package g.takeru.renshu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

        val problems = listProblems()
        initialAdapter(problems)
    }

    private fun initialAdapter(problems: MutableList<Problem>) {
        val listAdapter = ProblemListAdapter(problems)
        binding.recyclerViewProblemList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProblemList.adapter = listAdapter
    }

    private fun listProblems(): MutableList<Problem> {
        // create problem list
        val problemList =  mutableListOf<Problem>()
        problemList.add(Problem(1, "Two Sum") { No1TwoSum().testing() })
        problemList.add(Problem(2, "Add Two Numbers") { No2AddTwoNumbers().testing() })
        problemList.add(Problem(7, "Reverse Integer") { No7ReverseInteger().testing() })
        problemList.add(Problem(9, "Palindrome Number") { No9PalindromeNumber().testing() })
        problemList.add(Problem(20, "Valid Parentheses") { No20ValidParentheses().testing() })
        problemList.add(Problem(21, "Merge Two Sorted Lists") { No21MergeTwoSortedLists().testing() })
        problemList.add(Problem(206, "Reverse Linked List") { No206ReverseLinkedList().testing() })
        problemList.add(Problem(334, "Reverse String") { No344ReverseString().testing() })

        // not belong to LeetCode
        problemList.add(Problem(99999, "Minimum Depth of a Binary Tree") {
            MinimumDepthOfBinaryTree().testing()
        })

        return problemList
    }
}